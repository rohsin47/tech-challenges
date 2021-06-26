package com.revolut.moneytransfer.service.impl;

import java.sql.SQLException;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revolut.moneytransfer.dao.MoneyTransferDao;
import com.revolut.moneytransfer.model.Account;
import com.revolut.moneytransfer.model.TransferDetails;
import com.revolut.moneytransfer.service.InfoService;
import com.revolut.moneytransfer.service.TransferService;

/**
 * @author rohsingh
 *
 */
public class TransferServiceImpl implements TransferService {
	
	private static final Logger Log = LoggerFactory.getLogger(TransferServiceImpl.class);
	
	private InfoService infoService;

	private MoneyTransferDao moneyTransferDao;
	
	public TransferServiceImpl() {
		this.infoService = new InfoServiceImpl();
		this.moneyTransferDao = new MoneyTransferDao();
	}

	@Override
	public void transfer(TransferDetails transfer) {
		Log.info("Verifying transfer...");
		Account fromAcc = infoService.getAccountById(transfer.getFromAccountId().toString());
		if(fromAcc != null && fromAcc.getBalance() < transfer.getAmount()) {
			throw new RuntimeException("The transfer cannot be processed as account does not have enough balance.");
		}
		Log.info("Transfer is valid and will be processed now");
		try {
			moneyTransferDao.executeTransfer(transfer);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
