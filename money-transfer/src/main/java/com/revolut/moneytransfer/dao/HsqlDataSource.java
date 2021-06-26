package com.revolut.moneytransfer.dao;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.Properties;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.revolut.moneytransfer.util.MoneyTransferConstants;

/**
 * @author rohsingh
 *
 */
public class HsqlDataSource {

	private static final Logger log = LoggerFactory.getLogger(HsqlDataSource.class);

	private static Properties properties = null;
	
	private static ComboPooledDataSource dataSource;

	static {
		try {
			properties = new Properties();
			properties.load(new FileInputStream("resources/database.properties"));			
			dataSource = new ComboPooledDataSource();
			dataSource.setDriverClass(properties.getProperty(MoneyTransferConstants.DB_DRIVER_CLASS));			
			dataSource.setJdbcUrl(properties.getProperty(MoneyTransferConstants.DB_URL));
			dataSource.setUser(properties.getProperty(MoneyTransferConstants.DB_USERNAME));
			dataSource.setPassword(properties.getProperty(MoneyTransferConstants.DB_PASSWORD));
			dataSource.setMinPoolSize(20);
			dataSource.setMaxPoolSize(50);
			dataSource.setAcquireIncrement(5);

		} catch (PropertyVetoException | IOException e) {
			e.printStackTrace();
		}

		log.info("The HsqlDB database has been initialized");
	}

	public static Connection getConnection() throws SQLDataException {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new SQLDataException(e);
		}
	}

	public ResultSet query(String query) throws SQLException {
		return getConnection().createStatement().executeQuery(query);
	}

	public int update(String query) throws SQLException {
		return getConnection().createStatement().executeUpdate(query);
	}
	
	public PreparedStatement prepare(String query) throws SQLDataException, SQLException {
		return getConnection().prepareStatement(query);
	}
}
