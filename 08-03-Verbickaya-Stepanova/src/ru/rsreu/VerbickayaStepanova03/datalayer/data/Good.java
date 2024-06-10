package ru.rsreu.VerbickayaStepanova03.datalayer.data;

import java.sql.Date;
import java.util.Objects;

import ru.rsreu.VerbickayaStepanova03.datalayer.data.enums.GoodStatusEnum;

/**
 * Class representing a good.
 *
 * @author Verbickaya, Stepanova
 */
public class Good {

	/** Unique identifier for the good. */
	private int id;
	
	/** Name of the good. */
	private String name;
	
	/** Description of the good. */
	private String description;
	
	/** Category of the good. */
	private String category;
	
	/** Starting price of the good. */
	private int startPrice;
	
	/** Price of the good. */
	private int price;
	
	/** Price step for the good. */
	private int priceStep;
	
	/** Number of bids on the good */
	private int betCount;
	
	/** Creation date of the good */
	private Date creatingDate;
	
	/** Selling date of the good */
	private Date sellingDate;
	
	/** Interval for selling the good. */
	private int sellingInterval;
	
	/** Status of the good (selling, sold, removed). */
	private GoodStatusEnum status;
	
	/** Seller's name for the good. */
	private String seller;

	/**
     * Default constructor.
     */
	public Good() {
	}

	/**
     * Constructor with parameters.
     *
     * @param id - unique identifier for the good.
     * @param name - name of the good.
     * @param description - description of the good.
     * @param category - category of the good.
     * @param startPrice - starting price of the good.
     * @param price - current price of the good.
     * @param priceStep - price step for the good.
     * @param betCount - number of bids on the good.
     * @param creatingDate - creation date of the good.
     * @param sellingDate - selling date of the good.
     * @param sellingInterval - interval for selling the good.
     * @param status - status of the good (selling, sold, removed).
     * @param seller -seller's name for the good.
     */
	public Good(int id, String name, String description, String category, int startPrice, int price, int priceStep,
			int betCount, Date creatingDate, Date sellingDate, int sellingInterval, GoodStatusEnum status,
			String seller) {
		setId(id);
		setName(name);
		setDescription(description);
		setCategory(category);
		setStartPrice(startPrice);
		setPrice(price);
		setPriceStep(priceStep);
		setBetCount(betCount);
		setCreatingDate(creatingDate);
		setSellingDate(sellingDate);
		setSellingInterval(sellingInterval);
		setStatus(status);
		setSeller(seller);
	}

	/**
     * Compares this good to another object for equality.
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
		Good good = (Good) obj;
		return id == good.getId() && name.equals(good.getName()) && description.equals(good.getDescription())
				&& category.equals(good.getCategory()) && startPrice == good.getStartPrice() && price == good.getPrice()
				&& priceStep == good.getPriceStep() && betCount == good.getBetCount()
				&& creatingDate.equals(good.getCreatingDate()) && sellingDate.equals(good.getSellingDate())
				&& sellingInterval == good.getSellingInterval() && status.equals(good.getStatus())
				&& seller.equals(good.getSeller());
	}

	/**
     * Calculates a hash code for this good.
     *
     * @return hash code value.
     */
	@Override
	public int hashCode() {
		return Objects.hash(id, name, description, category, startPrice, price, priceStep, betCount, creatingDate,
				sellingDate, sellingInterval, status, seller);
	}

	/**
     * Gets the unique identifier for the good.
     *
     * @return unique identifier for the good.
     */
	public int getId() {
		return id;
	}

	/**
     * Sets the unique identifier for the good.
     *
     * @param id - unique identifier for the good.
     */
	public void setId(int id) {
		this.id = id;
	}

	/**
     * Gets the name of the good.
     *
     * @return name of the good.
     */
	public String getName() {
		return name;
	}

	/**
     * Sets the name of the good.
     *
     * @param name - name of the good.
     */
	public void setName(String name) {
		this.name = name;
	}

	/**
     * Gets the category of the good.
     *
     * @return category of the good.
     */
	public String getCategory() {
		return category;
	}

	/**
     * Sets the category of the good.
     *
     * @param category - category of the good.
     */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
     * Gets the description of the good.
     *
     * @return description of the good.
     */
	public String getDescription() {
		return description;
	}

	/**
     * Sets the description of the good.
     *
     * @param description - description of the good.
     */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
     * Gets the starting price of the good.
     *
     * @return Starting price of the good.
     */
	public int getStartPrice() {
		return startPrice;
	}

	/**
     * Sets the starting price of the good.
     *
     * @param startPrice - starting price of the good.
     */
	public void setStartPrice(int startPrice) {
		this.startPrice = startPrice;
	}

	/**
     * Gets the price of the good.
     *
     * @return price of the good.
     */
	public int getPrice() {
		return price;
	}

	/**
     * Sets the price of the good.
     *
     * @param price - price of the good.
     */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
     * Gets the price step for the good.
     *
     * @return price step for the good.
     */
	public int getPriceStep() {
		return priceStep;
	}

	/**
     * Sets the price step for the good.
     *
     * @param priceStep - price step for the good.
     */
	public void setPriceStep(int priceStep) {
		this.priceStep = priceStep;
	}

	/**
     * Gets the number of bids on the good.
     *
     * @return number of bids on the good.
     */
	public int getBetCount() {
		return betCount;
	}

	/**
     * Sets the number of bids on the good.
     *
     * @param betCount - number of bids on the good.
     */
	public void setBetCount(int betCount) {
		this.betCount = betCount;
	}

	/**
     * Gets creation date of the good.
     *
     * @return creation date of the good.
     */
	public Date getCreatingDate() {
		return creatingDate;
	}

	 /**
     * Sets creation date of the good.
     *
     * @param creatingDate - creation date of the good.
     */
	public void setCreatingDate(Date creatingDate) {
		this.creatingDate = creatingDate;
	}

	/**
     * Gets selling date of the good.
     *
     * @return selling date of the good.
     */
	public Date getSellingDate() {
		return sellingDate;
	}

	/**
     * Sets selling date of the good.
     *
     * @param sellingDate - selling date of the good.
     */
	public void setSellingDate(Date sellingDate) {
		this.sellingDate = sellingDate;
	}

	/**
     * Gets the interval for selling the good.
     *
     * @return interval for selling the good.
     */
	public int getSellingInterval() {
		return sellingInterval;
	}

	/**
     * Sets the interval for selling the good.
     *
     * @param sellingInterval - interval for selling the good.
     */
	public void setSellingInterval(int sellingInterval) {
		this.sellingInterval = sellingInterval;
	}

	/**
     * Gets the status of the good.
     *
     * @return status of the good.
     */
	public GoodStatusEnum getStatus() {
		return status;
	}

	/**
     * Sets the status of the good.
     *
     * @param status - status of the good.
     */
	public void setStatus(GoodStatusEnum status) {
		this.status = status;
	}

	/**
     * Gets the seller's name for the good.
     *
     * @return seller's name for the good.
     */
	public String getSeller() {
		return seller;
	}

	/**
     * Sets the seller's name for the good.
     *
     * @param seller - seller's name for the good.
     */
	public void setSeller(String seller) {
		this.seller = seller;
	}
}

