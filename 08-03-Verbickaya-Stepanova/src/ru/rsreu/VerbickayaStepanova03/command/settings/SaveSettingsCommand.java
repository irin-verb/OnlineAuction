package ru.rsreu.VerbickayaStepanova03.command.settings;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.VerbickayaStepanova03.command.ActionCommand;
import ru.rsreu.VerbickayaStepanova03.command.section.GoodsCommand;
import ru.rsreu.VerbickayaStepanova03.logic.GoodLogic;
import ru.rsreu.VerbickayaStepanova03.resource.MessageManager;

public class SaveSettingsCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		ActionCommand command;
		String page;
		String priceStep = request.getParameter("priceStep");
		String sellingInterval = request.getParameter("sellingInterval");

		if (priceStep.equals("") || priceStep.equals("0") || sellingInterval.equals("")
				|| sellingInterval.equals("0")) {
			command = new SettingsCommand();
			page = command.execute(request);
			request.setAttribute("errorMessage", MessageManager.getProperty("message.emptySettingsError"));
		} else {
			command = new GoodsCommand();
			page = command.execute(request);
			GoodLogic.changeConstants(priceStep, sellingInterval);
		}
		return page;
	}

}