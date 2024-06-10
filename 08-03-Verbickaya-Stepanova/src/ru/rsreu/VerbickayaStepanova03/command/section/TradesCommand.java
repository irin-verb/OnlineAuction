package ru.rsreu.VerbickayaStepanova03.command.section;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.VerbickayaStepanova03.command.ActionCommand;
import ru.rsreu.VerbickayaStepanova03.datalayer.data.Trade;
import ru.rsreu.VerbickayaStepanova03.logic.TradeLogic;
import ru.rsreu.VerbickayaStepanova03.resource.ConfigurationManager;

public class TradesCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String user = (String) request.getSession(true).getAttribute("user");
		request.getSession(true).setAttribute("page", request.getParameter("command"));
		String filter = request.getParameter("filter");
		request.setAttribute("filter", filter);
		List<Trade> tradeList = TradeLogic.getTradeList(filter, user);
		request.setAttribute("trades", tradeList);
		String page = ConfigurationManager.getProperty("path.page.trades");
		return page;
	}
}
