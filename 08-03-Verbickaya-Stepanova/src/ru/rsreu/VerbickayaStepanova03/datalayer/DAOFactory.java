package ru.rsreu.VerbickayaStepanova03.datalayer;

public abstract class DAOFactory {
	public static DAOFactory getInstance(DBType dbType) {
		DAOFactory result = dbType.getDAOFactory();
		return result;
	}

	public abstract GoodDAO getGoodDAO();
	public abstract UserDAO getUserDAO();
	public abstract TradeDAO getTradeDAO();
}
