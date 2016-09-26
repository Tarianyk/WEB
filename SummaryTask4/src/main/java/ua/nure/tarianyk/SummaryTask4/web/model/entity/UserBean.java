package ua.nure.tarianyk.SummaryTask4.web.model.entity;

import java.io.Serializable;

/**
 * Used for representation users table from database.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class UserBean implements Serializable {

	/**
	 * Contains serial number.
	 */
	private static final long serialVersionUID = 8989183982362336965L;

	/**
	 * First name of user.
	 */
	private String firstName;

	/**
	 * Last name of user.
	 */
	private String lastName;

	/**
	 * Email of user.
	 */
	private String email;

	/**
	 * Encoded password of user. 
	 */
	private String fpassword;
	
	/**
	 * Encoded password of user. 
	 */
	private String lpassword;

	/**
	 * Role of user.
	 */
	private String role;

	/**
	 * Contains link to another language table. 
	 */
	private LanguageBean language;

	/**
	 * Contains link to another userban table. 
	 */
	private UserbanBean userBanBean;

	/////////////////////////////////
	// BELOW ARE GETTERS AND SETTERS//
	/////////////////////////////////
		
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFpassword() {
		return fpassword;
	}

	public void setFpassword(String fpassword) {
		this.fpassword = fpassword;
	}

	public String getLpassword() {
		return lpassword;
	}

	public void setLpassword(String lpassword) {
		this.lpassword = lpassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LanguageBean getLanguage() {
		return language;
	}

	public void setLanguage(LanguageBean language) {
		this.language = language;
	}

	public UserbanBean getUserBanBean() {
		return userBanBean;
	}

	public void setUserBanBean(UserbanBean userBanBean) {
		this.userBanBean = userBanBean;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((fpassword == null) ? 0 : fpassword.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((lpassword == null) ? 0 : lpassword.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((userBanBean == null) ? 0 : userBanBean.hashCode());
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
		UserBean other = (UserBean) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (fpassword == null) {
			if (other.fpassword != null)
				return false;
		} else if (!fpassword.equals(other.fpassword))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (lpassword == null) {
			if (other.lpassword != null)
				return false;
		} else if (!lpassword.equals(other.lpassword))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (userBanBean == null) {
			if (other.userBanBean != null)
				return false;
		} else if (!userBanBean.equals(other.userBanBean))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserBean [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", fpassword="
				+ fpassword + ", lpassword=" + lpassword + ", role=" + role + ", language=" + language
				+ ", userBanBean=" + userBanBean + "]";
	}
	
}
