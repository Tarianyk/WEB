package ua.nure.tarianyk.SummaryTask4.support.daemonthread;

import java.io.File;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class DeleteTempFiles extends Thread {

	/**
	 * Logger.
	 */
	private static final Logger LOG = Logger.getLogger(DeleteTempFiles.class);

	/**
	 * Path to save document
	 */
	public String path = null;

	/**
	 * Delay between deleting.
	 */
	private Integer sleep_time = 600000;

	/** 
	 * Constructor with parameter.
	 * 
	 * @param path
	 *            path to folder with temp files which will be deleted
	 */
	public DeleteTempFiles(String path) {
		this.path = path;
	}

	@Override
	public void run() {
		LOG.log(Level.DEBUG, "run method starts.");

		delete(new File(path));

		try {
			Thread.sleep(sleep_time);
		} catch (InterruptedException e) {
			LOG.log(Level.TRACE, "Exception has occured in run method.", e);
		}

		LOG.log(Level.DEBUG, "run method finished.");
	}

	/**
	 * Deletes each file from folder.
	 * 
	 * @param dir
	 *            path to folder
	 */
	private synchronized static void delete(File dir) {
		if(null != dir.listFiles()) {
			for (File file : dir.listFiles()) {
				if (!file.isDirectory())
					file.delete(); 
			}
		}			
	}

	public void setSleep_time(Integer sleep_time) {
		this.sleep_time = sleep_time;
	}

}
