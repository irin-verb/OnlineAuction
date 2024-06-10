package ru.rsreu.VerbickayaStepanova03.datalayer;

import java.util.List;

import ru.rsreu.VerbickayaStepanova03.datalayer.data.Trade;
/**
 * Interface representing Data Access Object for Trade entities. 
 * Defines methods for accessing and managing trade-related data in the database.
 * 
 * @author Verbickaya, Stepanova
 */
public interface TradeDAO {

	/**
     * Retrieves the buyer of a specific good identified by its identifier.
     *
     * @param goodId - identifier of the good.
     * @return buyer's name.
     */
	String getBuyerOfGood(String goodId);

	/**
     * Retrieves a list of all trades associated with a specific user login.
     *
     * @param login - user's login.
     * @return list of all trades for the user.
     */
	List<Trade> getAllTrades(String login);

	/**
     * Retrieves a list of successful trades associated with a specific user login.
     *
     * @param login - user's login.
     * @return list of successful trades for the user.
     */
	List<Trade> getSuccessfulTrades(String login);

	/**
     * Retrieves a list of unsuccessful trades associated with a specific user login.
     *
     * @param login - user's login.
     * @return list of unsuccessful trades for the user.
     */
	List<Trade> getUnsuccessfulTrades(String login);

	/**
     * Retrieves a specific trade identified by its identifier.
     *
     * @param id - identifier of the trade.
     * @return trade object.
     */
	Trade getTrade(String id);

	/**
     * Retrieves a list of identifiers for losing trades associated with a specific user login.
     *
     * @param login - user's login.
     * @return list of identifiers for losing trades.
     */
	List<Integer> getLosingTradesId(String login);

	/**
     * Retrieves a list of identifiers for winning trades associated with a specific user login.
     *
     * @param login - user's login.
     * @return list of identifiers for winning trades.
     */
	List<Integer> getWinningTradesId(String login);

	/**
     * Retrieves a list of identifiers for won trades associated with a specific user login.
     *
     * @param login - user's login.
     * @return list of identifiers for won trades.
     */
	List<Integer> getWinnedTradesId(String login);

	/**
     * Retrieves a list of identifiers for lost trades associated with a specific user login.
     *
     * @param login - user's login.
     * @return list of identifiers for lost trades.
     */
	List<Integer> getLosedTradesId(String login);
}

