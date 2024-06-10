package ru.rsreu.VerbickayaStepanova03.datalayer.data;

import ru.rsreu.VerbickayaStepanova03.datalayer.data.enums.UserTypeEnum;
/**
 * Class representing a user in the system.
 *
 * @author Verbickaya, Stepanova
 */
public class User {
	
	/** User's login. */
	private String login;
	
	 /** User's password. */
	private String parole;
	
	/** User's type (admin, moder, user). */
	private UserTypeEnum type;
	
	/** User's online status (true if online, false otherwise). */
	private boolean onlineStatus;
	
	/** User's blocking status (true if blocked, false otherwise). */
    private boolean blockingStatus;
	
    /**
     * Default constructor.
     */
    public User() {
		
	}

    /**
     * Constructor with parameters.
     *
     * @param login - user's login.
     * @param parole - user's password.
     * @param type - user's type (admin, moder, user).
     * @param onlineStatus - user's online status (true if online, false otherwise).
     * @param blockingStatus - user's blocking status (true if blocked, false otherwise).
     */
	public User(String login, String parole, UserTypeEnum type, boolean onlineStatus, boolean blockingStatus) {
		setLogin(login);
		setParole(parole);
		setType(type);
		setOnlineStatus(onlineStatus);
		setBlockingStatus(blockingStatus);
	}

	/**
     * Gets the user's login.
     *
     * @return user's login.
     */
	public String getLogin() {
		return login;
	}

	 /**
     * Sets the user's login.
     *
     * @param login - user's login.
     */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
     * Gets the user's type.
     *
     * @return user's type.
     */
	public UserTypeEnum getType() {
		return type;
	}

	/**
     * Sets the user's type.
     *
     * @param type - user's type.
     */
	public void setType(UserTypeEnum type) {
		this.type = type;
	}

	/**
     * Gets the user's online status.
     *
     * @return user's online status.
     */
	public boolean isOnlineStatus() {
		return onlineStatus;
	}

	/**
     * Sets the user's online status.
     *
     * @param onlineStatus - user's online status (true if online, false otherwise).
     */
	public void setOnlineStatus(boolean onlineStatus) {
		this.onlineStatus = onlineStatus;
	}

	/**
     * Gets the user's blocking status.
     *
     * @return user's blocking status.
     */
	public boolean isBlockingStatus() {
		return blockingStatus;
	}

	/**
     * Sets the user's blocking status.
     *
     * @param blockingStatus - user's blocking status (true if blocked, false otherwise).
     */
	public void setBlockingStatus(boolean blockingStatus) {
		this.blockingStatus = blockingStatus;
	}

	/**
     * Gets the user's password.
     *
     * @return user's password.
     */
	public String getParole() {
		return parole;
	}

	/**
     * Sets the user's password.
     *
     * @param parole - user's password.
     */
	public void setParole(String parole) {
		this.parole = parole;
	}
}
