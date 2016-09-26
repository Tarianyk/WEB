package ua.nure.tarianyk.SummaryTask4.web.model.transfer;

import java.io.Serializable;

public class TaskTransfer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String ordersID;
	
	private String catalogTitle;
	
	private String language;

	

	public String getOrdersID() {
		return ordersID;
	}

	public void setOrdersID(String ordersID) {
		this.ordersID = ordersID;
	}

	public String getCatalogTitle() {
		return catalogTitle;
	}

	public void setCatalogTitle(String catalogTitle) {
		this.catalogTitle = catalogTitle;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((catalogTitle == null) ? 0 : catalogTitle.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((ordersID == null) ? 0 : ordersID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskTransfer other = (TaskTransfer) obj;
		if (catalogTitle == null) {
			if (other.catalogTitle != null)
				return false;
		} else if (!catalogTitle.equals(other.catalogTitle))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (ordersID == null) {
			if (other.ordersID != null)
				return false;
		} else if (!ordersID.equals(other.ordersID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TaskTransfer [ordersID=" + ordersID + ", catalogTitle=" + catalogTitle + ", language=" + language + "]";
	}
	
	

}
