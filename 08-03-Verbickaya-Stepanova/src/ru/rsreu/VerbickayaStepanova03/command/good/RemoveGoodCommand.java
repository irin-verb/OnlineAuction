package ru.rsreu.VerbickayaStepanova03.command.good;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.VerbickayaStepanova03.command.ActionCommand;
import ru.rsreu.VerbickayaStepanova03.logic.GoodLogic;

public class RemoveGoodCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {

		ActionCommand command = new OpenGoodCommand();

		String id = request.getParameter("goodID");
		GoodLogic.removeFromSale(id);

		String page = command.execute(request);
		return page;
	}

}