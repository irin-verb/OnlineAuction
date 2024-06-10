package ru.rsreu.VerbickayaStepanova03.datalayer.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ru.rsreu.VerbickayaStepanova03.datalayer.DAOFactory;
import ru.rsreu.VerbickayaStepanova03.datalayer.GoodDAO;
import ru.rsreu.VerbickayaStepanova03.datalayer.TradeDAO;
import ru.rsreu.VerbickayaStepanova03.datalayer.UserDAO;
import ru.rsreu.VerbickayaStepanova03.resource.QueryManager;

public class OracleDAOFactory extends DAOFactory {

	private static volatile OracleDAOFactory instance;
	private Connection connection;

	private OracleDAOFactory() {
	}

	public static OracleDAOFactory getInstance() throws ClassNotFoundException, SQLException {
		OracleDAOFactory factory = instance;
		if (instance == null) {
			synchronized (OracleDAOFactory.class) {
				factory = new OracleDAOFactory();
				instance = factory;
				factory.connected();
			}
		}
		return factory;
	}

	private void connected() throws ClassNotFoundException, SQLException {
		// Locale.setDefault(Locale.ENGLISH);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = QueryManager.getProperty("oracle.url");
		String user = QueryManager.getProperty("oracle.user");
		String password = QueryManager.getProperty("oracle.password");
		connection = DriverManager.getConnection(url, user, password);
	}

	@Override
	public GoodDAO getGoodDAO() {
		return new OracleGoodDAO(this.connection);
	}

	@Override
	public UserDAO getUserDAO() {
		return new OracleUserDAO(this.connection);
	}

	@Override
	public TradeDAO getTradeDAO() {
		return new OracleTradeDAO(this.connection);
	}

}
