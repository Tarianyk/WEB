package ua.nure.tarianyk.SummaryTask4.web.listener;

import java.util.Set;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.nure.tarianyk.SummaryTask4.support.daemonthread.DeleteTempFiles;

/**
 * Loads ua.nure.tarianyk.SummaryTask4.web.command.impl.CommandContainer class
 * before WEB-application will start.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class PreLoadListener implements ServletContextListener {

	/**
	 * Logger
	 */
	private final static Logger LOG = Logger.getLogger(PreLoadListener.class);

	/**
	 * Contains path to folder with temp files which will be deleted.
	 */
	public final static String PATH = "c:\\Java\\repo\\SummaryTask4\\temp_files\\";

	/*
	 * Receives notification that the ServletContext is about to be shut down.
	 * 
	 * @param sce (as specified by {@link
	 * ServletContextListener#contextDestroyed})
	 * 
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.
	 * ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		LOG.log(Level.DEBUG, "contextDestroyed method starts.");
		interruptThread();
		LOG.log(Level.DEBUG, "contextDestroyed method finished.");
	}

	/*
	 * Receives notification that the web application initialization process is
	 * starting.
	 * 
	 * @param sce (as specified by {@link
	 * ServletContextListener#contextInitialized})
	 * 
	 * @see
	 * javax.servlet.ServletContextListener#contextInitialized(javax.servlet.
	 * ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		LOG.log(Level.DEBUG, "contextInitialized method starts.");

		try { 
			Class.forName("ua.nure.tarianyk.SummaryTask4.web.command.impl.CommandContainer");
		} catch (ClassNotFoundException e) {
			LOG.log(Level.TRACE, "Problem has occured in PreLoadClasses#contextDestroyed() method.", e);
		}

		DeleteTempFiles dFiles = new DeleteTempFiles(PATH);
		dFiles.setDaemon(true);
		dFiles.start();

		LOG.log(Level.DEBUG, "contextInitialized method finished.");
	}

	/**
	 * Interrupts specific thread.
	 */
	private void interruptThread() {
		LOG.log(Level.DEBUG, "interruptThread method starts.");

		Set<Thread> setOfThread = Thread.getAllStackTraces().keySet();

		try {
			for (Thread thread : setOfThread) {
				// thread.interrupt();
				thread.stop();
			}
		} catch (ThreadDeath e) {
			LOG.log(Level.TRACE, "Problem has occured in interruptThread method.", e);
		}
		LOG.log(Level.DEBUG, "interruptThread method finished.");
	}

}
