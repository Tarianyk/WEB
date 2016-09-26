package ua.nure.tarianyk.SummaryTask4.web.command.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.exception.ContainerDoesNotContainsCommandException;
import ua.nure.tarianyk.SummaryTask4.service.AuthenticationUserService;
import ua.nure.tarianyk.SummaryTask4.service.CloseSessionService;
import ua.nure.tarianyk.SummaryTask4.service.ContactService;
import ua.nure.tarianyk.SummaryTask4.service.EditCatalogService;
import ua.nure.tarianyk.SummaryTask4.service.ListThingsService;
import ua.nure.tarianyk.SummaryTask4.service.OrdersService;
import ua.nure.tarianyk.SummaryTask4.service.ProcessUserService;
import ua.nure.tarianyk.SummaryTask4.service.ShoppingCartService;
import ua.nure.tarianyk.SummaryTask4.service.SortService;
import ua.nure.tarianyk.SummaryTask4.service.impl.AuthenticationUserServiceImpl;
import ua.nure.tarianyk.SummaryTask4.service.impl.CloseSessionServiceImpl;
import ua.nure.tarianyk.SummaryTask4.service.impl.ContactServiceImpl;
import ua.nure.tarianyk.SummaryTask4.service.impl.EditCatalogServiceImpl;
import ua.nure.tarianyk.SummaryTask4.service.impl.ListThingsServiceimpl;
import ua.nure.tarianyk.SummaryTask4.service.impl.OrdersServiceImpl;
import ua.nure.tarianyk.SummaryTask4.service.impl.ProcessUserServiceImpl;
import ua.nure.tarianyk.SummaryTask4.service.impl.ShoppingCartServiceImpl;
import ua.nure.tarianyk.SummaryTask4.service.impl.SortServiceImpl;
import ua.nure.tarianyk.SummaryTask4.util.consts.URLConst;
import ua.nure.tarianyk.SummaryTask4.web.command.Command;
import ua.nure.tarianyk.SummaryTask4.web.model.entity.UserBean;
import ua.nure.tarianyk.SummaryTask4.web.model.extractor.Extractor_Generic_OneParameter;
import ua.nure.tarianyk.SummaryTask4.web.model.extractor.impl.ExtractorReqContactTransferImpl;
import ua.nure.tarianyk.SummaryTask4.web.model.extractor.impl.ExtractorReqUserBeanImpl;
import ua.nure.tarianyk.SummaryTask4.web.model.transfer.ContactTransferBean;
import ua.nure.tarianyk.SummaryTask4.web.validator.impl.ValidateSortIntervalFormImpl;

/**
 * The class used for storing commands.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class CommandContainer {

	/**
	 * Logger.
	 */
	private final static Logger LOG = Logger.getLogger(CommandContainer.class);

	/**
	 * Holds commands.
	 */
	private static Map<String, Command> COMMANDS = new HashMap<>();

	/////////////////////
	///// Services.//////
	////////////////////
	private static AuthenticationUserService authenticationUserService = new AuthenticationUserServiceImpl();
	private static CloseSessionService closeSessionService = new CloseSessionServiceImpl();
	private static ListThingsService listThingsService = new ListThingsServiceimpl();
	private static ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl();
	private static OrdersService ordersService = new OrdersServiceImpl();
	private static ProcessUserService processUserService = new ProcessUserServiceImpl();
	private static EditCatalogService editCatalogService = new EditCatalogServiceImpl();
	private static SortService sortService = new SortServiceImpl();
	private static ContactService contactService = new ContactServiceImpl();

	///////////////////////
	///// Extractors.//////
	//////////////////////
	private static Extractor_Generic_OneParameter<ContactTransferBean, HttpServletRequest> cExtractorReq = new ExtractorReqContactTransferImpl();
	private static Extractor_Generic_OneParameter<UserBean, HttpServletRequest> extractor = new ExtractorReqUserBeanImpl();

	///////////////////////
	///// Validators.//////
	//////////////////////
	private static ValidateSortIntervalFormImpl validateSortIntervalForm = new ValidateSortIntervalFormImpl();

	/**
	 * Constructor without parameters.
	 */
	private CommandContainer() {
		LOG.log(Level.ERROR, "Attempt to create an instance of CommandContainer class!");
		throw new UnsupportedOperationException("Non instance CommandContainer");
	}

	static {
		COMMANDS.put(URLConst.LANGUAGE, new ChangeLanguageCommandImpl(processUserService));
		COMMANDS.put(URLConst.LOGIN, new LoginCommandImpl(authenticationUserService));
		COMMANDS.put(URLConst.CATALOG, new ListCatalogCommandimpl(listThingsService));
		COMMANDS.put(URLConst.REGISTRATION, new RegistrationCommandImpl(authenticationUserService, extractor));
		COMMANDS.put(URLConst.DETAIL, new ShowDetailCommandImpl());
		COMMANDS.put(URLConst.ADD_SHOP_CART, new AddToCartCommandImpl(shoppingCartService));
		COMMANDS.put(URLConst.DELETE, new DeleteFromCartCommandImpl(shoppingCartService));
		COMMANDS.put(URLConst.BUY_THING, new BuyThingCommandImpl(shoppingCartService, ordersService));
		COMMANDS.put(URLConst.ADMIN, new AdminAreaCommandImpl(processUserService, editCatalogService, ordersService));
		COMMANDS.put(URLConst.PERSONAL_AREA, new PersonalAreaCommandImpl(ordersService));
		COMMANDS.put(URLConst.SORT, new SortCommandImpl(sortService, validateSortIntervalForm));
		COMMANDS.put(URLConst.EXIT, new CloseSessionCommandImpl(closeSessionService));
		COMMANDS.put(URLConst.CONTACT, new ContactCommandImpl(contactService, cExtractorReq));

		LOG.log(Level.DEBUG, "Command container was successfully initialized");
		LOG.log(Level.TRACE, "Number of commands --> " + COMMANDS.size());
	}

	/**
	 * Returns command object with the given name.
	 * 
	 * @param command
	 *            name of the command
	 * @return command object
	 * @throws ContainerDoesNotContainsCommandException
	 *             if container does not contains needed command
	 */
	public static Command getCommand(final String command) throws ContainerDoesNotContainsCommandException {

		if (command == null) {
			LOG.log(Level.ERROR, "Input command string in CommandContainer#getCommand is empty!");
			throw new IllegalArgumentException("Command string is empty!");
		}

		if (!COMMANDS.containsKey(command)) {
			LOG.log(Level.TRACE, "Command not found, name --> " + command);
			throw new ContainerDoesNotContainsCommandException("Doesn't contains needed command.");
		}

		return COMMANDS.get(command);
	}
}
