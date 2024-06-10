package ru.rsreu.VerbickayaStepanova03.servlet.session;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import ru.rsreu.VerbickayaStepanova03.logic.UserLogic;

public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		String user = (String) arg0.getSession().getAttribute("user");
		UserLogic.logout(user);
	}

}
