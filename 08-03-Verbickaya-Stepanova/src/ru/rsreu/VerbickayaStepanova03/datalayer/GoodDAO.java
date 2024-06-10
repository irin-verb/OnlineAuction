package ru.rsreu.VerbickayaStepanova03.datalayer;

import java.util.List;

import ru.rsreu.VerbickayaStepanova03.datalayer.data.Good;
/**
 * Interface representing Data Access Object for Good entities.
 * Defines methods to retrieve, update, and manage information about goods in the system.
 * 
 * @author Verbickaya, Stepanova
 */
public interface GoodDAO {

	/**
     * Gets list of all goods available for sale.
     *
     * @return list of Good objects representing all selling goods.
     */
	List<Good> getAllSellingGoods();

	/**
     * Gets list of hot selling goods.
     *
     * @return list of Good objects representing hot selling goods.
     */
	List<Good> getSellingHotGoods();

	/**
     * Gets list of selling goods in a specific category.
     *
     * @param filter - category by which to filter selling goods.
     * @return list of Good objects representing selling goods in the specified category.
     */
	List<Good> getSellingGoodsByCategory(String filter);

	/**
     * Gets list of goods being sold by a specific seller.
     *
     * @param login - login of the seller.
     * @return list of Good objects representing goods being sold by the specified seller.
     */
	List<Good> getMySellingGoods(String login);

	/**
     * Gets list of goods sold by a specific seller.
     *
     * @param login - login of the seller.
     * @return list of Good objects representing goods sold by the specified seller.
     */
	List<Good> getMySoldGoods(String login);

	/**
     * Gets list of goods removed by a specific seller.
     *
     * @param login - login of the seller.
     * @return list of Good objects representing goods removed by the specified seller.
     */
	List<Good> getMyRemovedGoods(String login);

	/**
     * Gets list of available categories for goods.
     *
     * @return list of category names.
     */
	List<String> getCategories();

	/**
     * Gets information about a specific good by its identifier.
     *
     * @param id - identifier of the good.
     * @return good.
     */
	Good getGood(String id);

	/**
     * Increases the price of a specific good by a specific seller.
     *
     * @param id - identifier of the good.
     * @param login - login of the buyer.
     */
	void raiseGoodPrice(String id, String login);

	/**
     * Removes specific good from the system.
     *
     * @param id - identifier of the good.
     */
	void removeGood(String id);

	 /**
      * Sets the description of a specific good.
      *
      * @param id - identifier of the good.
      * @param description - description for the good.
      */
	void setGoodDescription(String id, String description);

	/**
     * Adds a new good.
     *
     * @param name - name of the good.
     * @param description - description of the good.
     * @param category - category of the good.
     * @param price - starting price of the good.
     * @param seller -seller's name for the good.
     */
	void addGood(String name, String description, String category, String price, String seller);

	/**
     * Sets the constant of the price step and the selling interval.
     *
     * @param priceStep - price step for the good.
     * @param sellingInterval - interval for selling the good.
     */
	void setConstants(String priceStep, String sellingInterval);

	/**
     * Gets the current price step setting for goods.
     *
     * @return current price step setting.
     */
	int getPriceStepSetting();

	/**
     * Gets the current selling interval setting for goods.
     *
     * @return current selling interval setting.
     */
	int getSellingIntervalSetting();

	/**
     * Sets the price step for a specific good.
     *
     * @param id - identifier for the good.
     * @param priceStep - price step for the good.
     */
	void setPriceStep(String id, String priceStep);

	/**
     * Sets the selling interval for a specific good.
     *
     * @param id - identifier for the good.
     * @param sellingInterval - interval for selling the good.
     */
	void setSellinInterval(String id, String sellingInterval);
}
