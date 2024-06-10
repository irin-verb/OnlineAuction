package ru.rsreu.VerbickayaStepanova03.datalayer;

import java.util.List;

import ru.rsreu.VerbickayaStepanova03.datalayer.data.User;
/**
 * Interface representing Data Access Object for User entities.
 * Defines methods to retrieve, update, and manage users information in the database.
 * 
 * @author Verbickaya, Stepanova
 */
public interface UserDAO {

	/**
     * Gets user by their login.
     *
     * @param login - user's login.
     * @return user object representing the user with the specified login.
     */
	User getUser(String login);

	/**
     * Gets list of all users.
     *
     * @return list of User objects representing all users in the system.
     */
	List<User> getAllUsers();

	/**
     * Gets list of users with the admin type.
     *
     * @return list of User objects representing users with the admin type.
     */
	List<User> getAdminUsers();

	/**
     * Gets list of users with the moder type.
     *
     * @return list of User objects representing users with the moder type.
     */
	List<User> getModerUsers();

	/**
     * Gets list of users with the user type.
     *
     * @return list of User objects representing users with the user type.
     */
	List<User> getNormalUsers();

	/**
     * Gets list of authorized users.
     *
     * @return list of User objects representing authorized users.
     */
	List<User> getAuthorizedUsers();

	/**
     * Gets list of unauthorized users.
     *
     * @return list of User objects representing unauthorized users.
     */
	List<User> getUnauthorizedUsers();

	/**
     * Gets list of blocked users.
     *
     * @return list of User objects representing blocked users.
     */
	List<User> getBlockedUsers();

	/**
     * Gets list of unblocked users.
     *
     * @return list of User objects representing unblocked users.
     */
	List<User> getNotBlockedUsers();
	
	/**
	 * Blocks the user.
	 *
	 * @param login - user's login.
	 */
	void block(String login);
	
	/**
	 * Unblocks the user.
	 *
	 * @param login - user's login.
	 */
	void unblock(String login);
	
	/**
     * Changes the blocking status of a user.
     *
     * @param login - user's login.
     */
	void changeBlockingStatus(String login);

	/**
     * Adds a new user.
     *
     * @param login - user's login.
     * @param password - user's password.
     * @param type - user's type (admin, moder, user).
     */
	void addUser(String login, String password, String type);

	/**
     * Sets or updates a user's information.
     *
     * @param login - user's login.
     * @param newPassword - new user's password.
     * @param newBlockingStatus - new blocking status for the user.
     */
	void setUser(String login, String newPassword, String newBlockingStatus);

	/**
     * Deletes a user.
     *
     * @param login - user's login.
     */
	void deleteUser(String login);

	/**
     *  logs out the user of the system.
     *
     * @param login - user's login.
     */
	void logout(String login);

	/**
     * Logs user in the system
     *
     * @param login - user's login.
     */
	void login(String login);
}
