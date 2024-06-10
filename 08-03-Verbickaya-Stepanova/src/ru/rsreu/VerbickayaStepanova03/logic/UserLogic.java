package ru.rsreu.VerbickayaStepanova03.logic;

import java.util.List;

import ru.rsreu.VerbickayaStepanova03.datalayer.data.User;
import ru.rsreu.VerbickayaStepanova03.datalayer.data.enums.UserTypeEnum;

public class UserLogic {

	public static UserTypeEnum getUserType(String login) {
		User user = UserLogic.getUser(login);
		if (user == null) {
			return null;
		} else {
			return user.getType();
		}
	}

	public static List<User> getUserList(String filter) {
		if (filter.equals("All users")) {
			return DAOLogic.getUserDAO().getAllUsers();
		} else if (filter.equals("Admins")) {
			return DAOLogic.getUserDAO().getAdminUsers();
		} else if (filter.equals("Moders")) {
			return DAOLogic.getUserDAO().getModerUsers();
		} else if (filter.equals("Normal users")) {
			return DAOLogic.getUserDAO().getNormalUsers();
		} else if (filter.equals("Authorized")) {
			return DAOLogic.getUserDAO().getAuthorizedUsers();
		} else if (filter.equals("Unauthorized")) {
			return DAOLogic.getUserDAO().getUnauthorizedUsers();
		} else if (filter.equals("Blocked")) {
			return DAOLogic.getUserDAO().getBlockedUsers();
		} else if (filter.equals("Not blocked")) {
			return DAOLogic.getUserDAO().getNotBlockedUsers();
		} else
			return null;
	}

	public static User getUser(String login) {
		return DAOLogic.getUserDAO().getUser(login);
	}

	public static void changeBlockingStatus(String userLogin) {
		DAOLogic.getUserDAO().changeBlockingStatus(userLogin);
	}

	public static void remove(String userLogin) {
		DAOLogic.getUserDAO().deleteUser(userLogin);
	}

	public static void changeUserData(String login, String newPassword, String newBlockingStatus) {
		DAOLogic.getUserDAO().setUser(login, newPassword, newBlockingStatus);
	}

	public static void addUser(String newLogin, String newPassword, String newType) {
		DAOLogic.getUserDAO().addUser(newLogin, newPassword, newType);
	}

	public static void logout(String login) {
		DAOLogic.getUserDAO().logout(login);
	}

	public static void login(String login) {
		DAOLogic.getUserDAO().login(login);
	}
}