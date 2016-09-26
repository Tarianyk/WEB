package ua.nure.tarianyk.SummaryTask4.web.model.entity;

import java.io.Serializable;

/**
 * Used for representation language table from database.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class LanguageBean implements Serializable {

	/**
	 * Contains serial number.
	 */
	private static final long serialVersionUID = -5525525011602711512L;

	/**
	 * Id of language. 
	 */
	private Integer id;
	
	/**
	 * Name of language.
	 */
	private String name;

	/////////////////////////////////
	// BELOW ARE GETTERS AND SETTERS//
	/////////////////////////////////
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		
		switch (id) {
		case 1:	
			this.name = "en";
			break;
		case 2:
			this.name = "ru";
			break;

		default:
			this.name = "en";
			break;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		
		switch (name.trim()) {
		case "en":	
			this.id = 1;
			break;
		case "ru":
			this.id = 2;
			break;

		default:
			this.id = 1;
			break;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		LanguageBean other = (LanguageBean) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Language [id=" + id + ", name=" + name + "]";
	}
	
}
