package ua.nure.tarianyk.SummaryTask4.web.model.entity;

import java.io.Serializable;

/**
 * Used for representation usersban table from database.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class UserbanBean implements Serializable {

	/**
	 * Contains serial number.
	 */
	private static final long serialVersionUID = 8975936706172364476L;

	/**
	 * Id of language. 
	 */
	private Integer id;
	
	/**
	 * Ban.
	 */
	private String ban;

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
			ban = "banned";
			break;
		case 2:
			ban = "not banned";
			break;

		default:
			break;
		}
	}

	public String getBan() {
		return ban;
	}

	public void setBan(String ban) {
		this.ban = ban;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ban == null) ? 0 : ban.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		UserbanBean other = (UserbanBean) obj;
		if (ban == null) {
			if (other.ban != null)
				return false;
		} else if (!ban.equals(other.ban))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserBanBean [id=" + id + ", ban=" + ban + "]";
	}
	
}
