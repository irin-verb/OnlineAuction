package ru.rsreu.VerbickayaStepanova03.logic;

import ru.rsreu.VerbickayaStepanova03.datalayer.DAOFactory;
import ru.rsreu.VerbickayaStepanova03.datalayer.DBType;
import ru.rsreu.VerbickayaStepanova03.datalayer.GoodDAO;
import ru.rsreu.VerbickayaStepanova03.datalayer.TradeDAO;
import ru.rsreu.VerbickayaStepanova03.datalayer.UserDAO;

public class DAOLogic {

	private static final DBType DBTYPE = DBType.ORACLE;
//	private static final DAOFactory factoryDAO = DAOFactory.getInstance(DBTYPE);
//	private static final GoodDAO goodDAO = factoryDAO.getGoodDAO();
	private static DAOFactory factoryDAO;
	private static GoodDAO goodDAO;
	private static UserDAO userDAO;
	private static TradeDAO tradeDAO;
	

	static {
		DAOFactory tempFactoryDAO = null;
		GoodDAO tempGoodDAO = null;
		UserDAO tempUserDAO = null;
		TradeDAO tempTradeDAO = null;
		try {
			tempFactoryDAO = DAOFactory.getInstance(DBTYPE);
			tempGoodDAO = tempFactoryDAO.getGoodDAO();
			tempUserDAO = tempFactoryDAO.getUserDAO();
			tempTradeDAO = tempFactoryDAO.getTradeDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
		factoryDAO = tempFactoryDAO;
		goodDAO = tempGoodDAO;
		userDAO = tempUserDAO;
		tradeDAO = tempTradeDAO;
	}

	public static GoodDAO getGoodDAO() {
		return goodDAO;
	}
	
	public static UserDAO getUserDAO() {
		return userDAO;
	}

	public static TradeDAO getTradeDAO() {
		return tradeDAO;
	}

}
