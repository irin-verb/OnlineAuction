package ru.rsreu.VerbickayaStepanova03.datalayer;

import java.sql.SQLException;

import ru.rsreu.VerbickayaStepanova03.datalayer.oracle.OracleDAOFactory;

public enum DBType {
	ORACLE {
		@Override
		public DAOFactory getDAOFactory() {
			DAOFactory oracleDAOFactory = null;
			try {
				oracleDAOFactory = OracleDAOFactory.getInstance();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return oracleDAOFactory;
		}
	};

	public abstract DAOFactory getDAOFactory();

}
