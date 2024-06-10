package ru.rsreu.VerbickayaStepanova03.command.trade;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ru.rsreu.VerbickayaStepanova03.command.ActionCommand;
import ru.rsreu.VerbickayaStepanova03.datalayer.data.Trade;
import ru.rsreu.VerbickayaStepanova03.logic.TradeLogic;
import ru.rsreu.VerbickayaStepanova03.resource.ConfigurationManager;

public class OpenTradeCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String user = (String) request.getSession(true).getAttribute("user");
		String filter = request.getParameter("filter");
		request.setAttribute("filter", filter);
		List<Trade> tradeList = TradeLogic.getTradeList(filter, user);
		request.setAttribute("trades", tradeList);
		String tradeId = request.getParameter("tradeID");
		Trade trade = TradeLogic.getTrade(tradeId);
		request.setAttribute("trade", trade);

		TradePageTypeEnum tradeType = TradeLogic.getTradePageType(tradeId, user);
		request.setAttribute("tradeType", tradeType);

		String page = ConfigurationManager.getProperty("path.page.trade");
		return page;
	}
}