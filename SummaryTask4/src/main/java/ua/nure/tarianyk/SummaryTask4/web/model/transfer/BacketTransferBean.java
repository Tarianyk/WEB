package ua.nure.tarianyk.SummaryTask4.web.model.transfer;

import java.io.Serializable;

/**
 * Class is designed for data transfer from shopping cart.
 * 
 * @author Anton
 * @version 1.0
 *
 */
public class BacketTransferBean implements Serializable {

	/**
	 * Serial number.
	 */
	private static final long serialVersionUID = 6081865099235801262L;

	/**
	 * Path to image.
	 */
	private String path;

	/**
	 * Article of thing.
	 */
	private String article;

	/**
	 * The total number of purchases.
	 */
	private Integer count = 0;

	/**
	 * The total cost of purchases bought.
	 */
	private Double totalAmount = 0.;

	/**
	 * Price of one purchase.
	 */
	private Double price;

	/////////////////////////////////
	// BELOW ARE GETTERS AND SETTERS//
	/////////////////////////////////

	public Double getTotalAmount() {
		return count * price;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public Integer getCount() {
		return count;
	}

	public void setCountAdd() {
		++count;
	}

	public void setCountDel() {
		--count;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((article == null) ? 0 : article.hashCode());
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((totalAmount == null) ? 0 : totalAmount.hashCode());
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
		BacketTransferBean other = (BacketTransferBean) obj;
		if (article == null) {
			if (other.article != null)
				return false;
		} else if (!article.equals(other.article))
			return false;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
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
		if (totalAmount == null) {
			if (other.totalAmount != null)
				return false;
		} else if (!totalAmount.equals(other.totalAmount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb = sb.append("BacketTransitBean:").append(System.lineSeparator())
				.append("path= ").append(path).append(System.lineSeparator())
				.append("article= ").append(article).append(System.lineSeparator())
				.append("count= ").append(count).append(System.lineSeparator())
				.append("totalAmount= ").append(totalAmount).append(System.lineSeparator())
				.append("price= ").append(price).append(System.lineSeparator());
		
		return sb.toString();
	}

}
