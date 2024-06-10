package ru.rsreu.VerbickayaStepanova03.datalayer.data;

import java.sql.Date;
import java.util.Objects;

/**
 * Class representing a trade in the system.
 *
 * @author Verbickaya, Stepanova
 */
public class Trade {

	/** Unique identifier of the trade. */
	private int id;
	
	/** Name of the trade. */
	private String name;
	
	/** Description of the trade. */
	private String description;
	
	/** Date of the trade. */
	private Date date;
	
	/** Price of the trade. */
	private int price;
	
	/** Current price of the trade. */
	private int currentPrice;
	
	/** Unique identifier of the good. */
	private int productId;
	
	/** Buyer's login for the trade. */
	private String buyer;

	/**
	 * Default constructor.
	 */
	public Trade() {

	}

	/**
     * Constructor with parameters.
     *
     * @param id - unique identifier of the trade.
     * @param name - name of the trade.
     * @param description - description of the trade.
     * @param date - date of the trade.
     * @param price - price of the trade.
     * @param currentPrice - current price of the trade.
     * @param product - unique identifier of the good.
     * @param buyer - buyer's login for the trade.
     */
	public Trade(int id, String name, String description, Date date, int price, int currentPrice, int product,
			String buyer) {
		setId(id);
		setName(name);
		setDescription(description);
		setDate(date);
		setPrice(price);
		setCurrentPrice(currentPrice);
		setProductId(product);
		setBuyer(buyer);
	}

	/**
     * Compares this trade to another object for equality.
     *
     * @param obj - object to compare to.
     * @return true if the objects are equal, false otherwise.
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Trade trade = (Trade) obj;
		return id == trade.getId() && name.equals(trade.getName()) && description.equals(trade.getDescription())
				&& date.equals(trade.getDate()) && price == trade.getPrice() && currentPrice == trade.getCurrentPrice()
				&& productId == trade.getProductId() && buyer.equals(trade.getBuyer());
	}

	/**
     * Calculates a hash code for this trade.
     *
     * @return hash code value.
     */
	@Override
	public int hashCode() {
		return Objects.hash(id, name, description, date, price, currentPrice, productId, buyer);
	}

	/**
     * Gets the identifier for the trade.
     *
     * @return identifier for the trade.
     */
	public int getId() {
		return id;
	}

	/**
     * Sets identifier for the trade.
     *
     * @param id - unique identifier of the trade.
     */
	public void setId(int id) {
		this.id = id;
	}

	/**
     * Gets the date of the trade.
     *
     * @return date of the trade.
     */
	public Date getDate() {
		return date;
	}

	/**
     * Sets the date of the trade.
     *
     * @param date - date of the trade.
     */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
     * Gets the price of the trade.
     *
     * @return price of the trade.
     */
	public int getPrice() {
		return price;
	}

	/**
     * Sets the price of the trade.
     *
     * @param price - price of the trade.
     */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
     * Gets the buyer's login for the trade.
     *
     * @return buyer's login for the trade.
     */
	public String getBuyer() {
		return buyer;
	}

	/**
     * Sets the buyer's login for the trade.
     *
     * @param buyer - buyer's login for the trade.
     */
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	/**
     * Gets the name of the trade.
     *
     * @return name of the trade.
     */
	public String getName() {
		return name;
	}

	/**
     * Sets the name of the trade.
     *
     * @param name - name of the trade.
     */
	public void setName(String name) {
		this.name = name;
	}

	/**
     * Gets the current price of the trade.
     *
     * @return current price of the trade.
     */
	public int getCurrentPrice() {
		return currentPrice;
	}

	/**
     * Sets the current price of the trade.
     *
     * @param currentPrice - current price of the trade.
     */
	public void setCurrentPrice(int currentPrice) {
		this.currentPrice = currentPrice;
	}

	/**
     * Gets the identifier of the good.
     *
     * @return identifier of the good.
     */
	public int getProductId() {
		return productId;
	}

	/**
     * Sets the identifier of the good.
     *
     * @param productId - identifier of the good.
     */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
     * Gets the description of the trade.
     *
     * @return description of the trade.
     */
	public String getDescription() {
		return description;
	}

	/**
     * Sets the description of the trade.
     *
     * @param description - description of the trade.
     */
	public void setDescription(String description) {
		this.description = description;
	}
}
