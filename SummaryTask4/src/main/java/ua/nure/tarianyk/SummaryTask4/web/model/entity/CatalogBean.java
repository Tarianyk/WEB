package ua.nure.tarianyk.SummaryTask4.web.model.entity;

import java.io.Serializable;

/**
 * Used for representation catalog table from database.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class CatalogBean implements Serializable {
	
	/**
	 * Contains serial number.
	 */
	private static final long serialVersionUID = -8339906049337470895L;

	/**
	 * Title of product.
	 */
	private String title;
	
	/**
	 * Article of product.
	 */
	private String article;
	
	/**
	 * Desc_1 of product.
	 */
	private String desc_1;
	
	/**
	 * Desct_2 of product.
	 */
	private String desc_2;
	
	/**
	 * Price of product.
	 */
	private Double price;
	
	/**
	 * Contains link to another one language table. 
	 */
	private LanguageBean langId;
	
	/**
	 * Date when product was added.
	 */
	private String date;
	
	/**
	 * Path to image.
	 */
	private String path;
	
	/**
	 * Amount of available products.
	 */
	private Integer amount;

	
	/////////////////////////////////
	// BELOW ARE GETTERS AND SETTERS//
	/////////////////////////////////
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getDesc_1() {
		return desc_1;
	}

	public void setDesc_1(String desc_1) {
		this.desc_1 = desc_1;
	}

	public String getDesc_2() {
		return desc_2;
	}

	public void setDesc_2(String desc_2) {
		this.desc_2 = desc_2;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LanguageBean getLangId() {
		return langId;
	}

	public void setLangId(LanguageBean langId) {
		this.langId = langId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((article == null) ? 0 : article.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((desc_1 == null) ? 0 : desc_1.hashCode());
		result = prime * result + ((desc_2 == null) ? 0 : desc_2.hashCode());
		result = prime * result + ((langId == null) ? 0 : langId.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		CatalogBean other = (CatalogBean) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (article == null) {
			if (other.article != null)
				return false;
		} else if (!article.equals(other.article))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (desc_1 == null) {
			if (other.desc_1 != null)
				return false;
		} else if (!desc_1.equals(other.desc_1))
			return false;
		if (desc_2 == null) {
			if (other.desc_2 != null)
				return false;
		} else if (!desc_2.equals(other.desc_2))
			return false;
		if (langId == null) {
			if (other.langId != null)
				return false;
		} else if (!langId.equals(other.langId))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CatalogBean [title=" + title + ", article=" + article + ", desc_1=" + desc_1 + ", desc_2=" + desc_2
				+ ", price=" + price + ", langId=" + langId + ", date=" + date + ", path=" + path + ", amount=" + amount
				+ "]";
	}
	
	
}
