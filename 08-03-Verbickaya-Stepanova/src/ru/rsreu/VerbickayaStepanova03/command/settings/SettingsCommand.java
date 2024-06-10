package ru.rsreu.VerbickayaStepanova03.command.settings;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.VerbickayaStepanova03.command.ActionCommand;
import ru.rsreu.VerbickayaStepanova03.datalayer.data.Good;
import ru.rsreu.VerbickayaStepanova03.logic.GoodLogic;
import ru.rsreu.VerbickayaStepanova03.resource.ConfigurationManager;

public class SettingsCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String user = (String) request.getSession(true).getAttribute("user");
		List<String> categoryList = GoodLogic.getCategoryList();
		request.setAttribute("categories", categoryList);
		String filter = request.getParameter("filter");
		request.setAttribute("filter", filter);
		List<Good> filteredGoodList = GoodLogic.getGoodList(filter, user);
		request.setAttribute("goods", filteredGoodList);
		request.setAttribute("priceStepSetting", GoodLogic.getPriceStepSetting());
		request.setAttribute("sellingIntervalSetting", GoodLogic.getSellingIntervalSetting());

		String page = ConfigurationManager.getProperty("path.page.settings");
		return page;
	}

}
