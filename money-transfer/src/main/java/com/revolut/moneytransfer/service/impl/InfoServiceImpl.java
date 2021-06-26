package com.revolut.moneytransfer.service.impl;

import java.sql.SQLException;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revolut.moneytransfer.dao.MoneyTransferDao;
import com.revolut.moneytransfer.model.Account;
import com.revolut.moneytransfer.model.User;
import com.revolut.moneytransfer.service.InfoService;

/**
 * @author rohsingh
 *
 */
public class InfoServiceImpl implements InfoService {
	
	private static final Logger Log = LoggerFactory.getLogger(InfoServiceImpl.class);
	
	private MoneyTransferDao moneyTransferDao;
	
	public InfoServiceImpl() {
		this.moneyTransferDao = new MoneyTransferDao();
	}

	@Override
	public Account getAccountById(String accountId) {
		Log.info("Get Account Info for : {}", accountId);
		try {
			return moneyTransferDao.getAccount(Long.valueOf(accountId));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUserById(String userId) {
		Log.info("Get User Info for : {}", userId);
		try {
			return moneyTransferDao.getUser(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
