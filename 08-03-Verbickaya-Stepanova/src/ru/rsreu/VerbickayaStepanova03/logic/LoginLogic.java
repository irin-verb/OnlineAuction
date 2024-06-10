package ru.rsreu.VerbickayaStepanova03.logic;

import ru.rsreu.VerbickayaStepanova03.datalayer.data.User;

public class LoginLogic {

	public static boolean checkLogin(String enterLogin, String enterPass) {
		User user = DAOLogic.getUserDAO().getUser(enterLogin);
		if (user == null) {
			return false;
		}
		else {
			String password = user.getParole();
			return password.equals(enterPass);
		}
	}
	
	public static boolean checkBlockingStatus(String enterLogin) {
		User user = DAOLogic.getUserDAO().getUser(enterLogin);
		if (user == null) {
			return false;
		} else return user.isBlockingStatus();
	}
	
}
