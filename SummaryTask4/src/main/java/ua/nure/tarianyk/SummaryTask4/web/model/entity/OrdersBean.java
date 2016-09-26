package ua.nure.tarianyk.SummaryTask4.web.model.entity;

import java.io.Serializable;

/**
 * Used for representation orders table from database.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class OrdersBean implements Serializable {

	/**
	 * Contains serial number.
	 */
	private static final long serialVersionUID = 4653897447389578125L;

	/**
	 * Id of language. 
	 */
	private Integer id;
	
	/**
	 * Article of product.
	 */
	private String article;
	
	/**
	 * Email of user that has ordered product. 
	 */
	private String email;
	
	/**
	 * Total amount of products.
	 */
	private Integer totalAmount;
	
	/**
	 * Price of product.
	 */
	private Double price;
	
	/**
	 * Total price of products.
	 */
	private Double totalPrice;
	
	/**
	 * Status of order.
	 */
	private String status;
	
	/**
	 * Contains link to another language table. 
	 */
	private LanguageBean languageBean;

	/////////////////////////////////
	// BELOW ARE GETTERS AND SETTERS//
	/////////////////////////////////
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) { 
		this.id = id;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LanguageBean getLanguageBean() {
		return languageBean;
	}

	public void setLanguageBean(LanguageBean languageBean) {
		this.languageBean = languageBean;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((article == null) ? 0 : article.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((languageBean == null) ? 0 : languageBean.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((totalAmount == null) ? 0 : totalAmount.hashCode());
		result = prime * result + ((totalPrice == null) ? 0 : totalPrice.hashCode());
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
		OrdersBean other = (OrdersBean) obj;
		if (article == null) {
			if (other.article != null)
				return false;
		} else if (!article.equals(other.article))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (languageBean == null) {
			if (other.languageBean != null)
				return false;
		} else if (!languageBean.equals(other.languageBean))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (totalAmount == null) {
			if (other.totalAmount != null)
				return false;
		} else if (!totalAmount.equals(other.totalAmount))
			return false;
		if (totalPrice == null) {
			if (other.totalPrice != null)
				return false;
		} else if (!totalPrice.equals(other.totalPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrdersBean [id=" + id + ", article=" + article + ", email=" + email + ", totalAmount=" + totalAmount
				+ ", price=" + price + ", totalPrice=" + totalPrice + ", status=" + status + ", languageBean="
				+ languageBean + "]";
	}

}
