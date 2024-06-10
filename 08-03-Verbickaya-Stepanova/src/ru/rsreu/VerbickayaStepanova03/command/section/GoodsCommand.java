package ru.rsreu.VerbickayaStepanova03.command.section;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.VerbickayaStepanova03.command.ActionCommand;
import ru.rsreu.VerbickayaStepanova03.datalayer.data.Good;
import ru.rsreu.VerbickayaStepanova03.logic.GoodLogic;
import ru.rsreu.VerbickayaStepanova03.resource.ConfigurationManager;

public class GoodsCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String user = (String) request.getSession(true).getAttribute("user");
		request.getSession(true).setAttribute("page", request.getParameter("command"));

		List<String> categoryList = GoodLogic.getCategoryList();
		request.setAttribute("categories", categoryList);

		String filter = request.getParameter("filter");
		request.setAttribute("filter", filter);

		List<Good> filteredGoodList = GoodLogic.getGoodList(filter, user);
		request.setAttribute("goods", filteredGoodList);

		String page = ConfigurationManager.getProperty("path.page.goods");
		return page;
	}

}