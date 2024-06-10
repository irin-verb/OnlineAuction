package ru.rsreu.VerbickayaStepanova03.command.good;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.VerbickayaStepanova03.command.ActionCommand;
import ru.rsreu.VerbickayaStepanova03.logic.GoodLogic;

public class RaisePriceCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {

		ActionCommand command = new OpenGoodCommand();

		String user = (String) request.getSession(true).getAttribute("user");
		String id = request.getParameter("goodID");
		GoodLogic.raisePrice(id, user);

		String page = command.execute(request);
		return page;
	}

}
