package ua.nure.tarianyk.SummaryTask4.web.model.transfer;

import java.io.Serializable;

/**
 * Class is designed for data transfer from contact page.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class ContactTransferBean implements Serializable {

	/**
	 * Serial number.
	 */
	private static final long serialVersionUID = -903428735515117202L;

	/**
	 * User's name that has sent a mail.
	 */
	private String name;

	/**
	 * User's email that has sent a mail.
	 */
	private String email;

	/**
	 * Name of problem.
	 */
	private String subject;

	/**
	 * Message.
	 */
	private String message;

	/////////////////////////////////
	// BELOW ARE GETTERS AND SETTERS//
	/////////////////////////////////

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
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
		ContactTransferBean other = (ContactTransferBean) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ContactTransferBean [name=" + name + ", email=" + email + ", subject=" + subject + ", message="
				+ message + "]";
	}

}
