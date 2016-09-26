package ua.nure.tarianyk.SummaryTask4.support;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.web.model.entity.UserBean;
import ua.nure.tarianyk.SummaryTask4.web.model.transfer.BacketTransferBean;

public class Serilizable {
	
	/**
	 * Logger.
	 */
	private static final Logger LOG = Logger.getLogger(CookieCustom.class);
	
	/**
	 * Used for serializing <tt>List</tt> object.
	 * 
	 * @param backet
	 *            input object that will be serialization
	 * @return serialized object
	 */
	public static String serializationUser(UserBean userBean) {
		String str = "";
		try {
			ByteArrayOutputStream bo = new ByteArrayOutputStream();
			ObjectOutputStream so = new ObjectOutputStream(bo);
			so.writeObject(userBean);
			so.close();
			str = new String(Base64.getEncoder().encodeToString(bo.toByteArray()));
		} catch (Exception e) {
			LOG.log(Level.TRACE, "Exception has occured in serialize method.", e);
		}

		return str;
	}

	/**
	 * Used for serializing <tt>List</tt> object.
	 * 
	 * @param backet
	 *            input object that will be serialization
	 * @return serialized object
	 */
	public static String serializationBacket(List<BacketTransferBean> backet) {
		String str = "";
		try {
			ByteArrayOutputStream bo = new ByteArrayOutputStream();
			ObjectOutputStream so = new ObjectOutputStream(bo);
			so.writeObject(backet);
			so.close();
			str = new String(Base64.getEncoder().encodeToString(bo.toByteArray()));
		} catch (Exception e) {
			LOG.log(Level.TRACE, "Exception has occured in serialize method.", e);
		}

		return str;
	}
	
	/**
	 * Read the object from Base64 string.
	 * 
	 * @param s
	 *            non-serializable object
	 * @return deserialized object
	 * @throws IOException
	 *             input/output problem
	 * @throws ClassNotFoundException
	 *             class does not exists
	 */
	public static Object deserialization(String s) throws IOException, ClassNotFoundException {
		byte[] data = Base64.getDecoder().decode(s);
		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
		Object o = ois.readObject();
		ois.close();
		return o;
	}
}
