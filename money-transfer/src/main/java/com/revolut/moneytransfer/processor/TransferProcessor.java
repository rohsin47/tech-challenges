package com.revolut.moneytransfer.processor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revolut.moneytransfer.model.TransferDetails;
import com.revolut.moneytransfer.service.TransferService;
import com.revolut.moneytransfer.service.impl.TransferServiceImpl;

/**
 * @author rohit
 *
 */
public class TransferProcessor {
	
	private static final Logger Log = LoggerFactory.getLogger(TransferProcessor.class);
	
	private static final ExecutorService executor = Executors.newCachedThreadPool();
	
	private TransferService transferService;
	
	public TransferProcessor() {
		this.transferService = new TransferServiceImpl();
	}
	
	public void processTransfer(TransferDetails transferData) {
		Log.info("Processing Transfer from Account : {} to Account : {} for Amount : {} by User : {}", 
				transferData.getFromAccountId(), transferData.getToAccountId(),
				transferData.getAmount(), transferData.getUserId());
		
		executor.submit(new Runnable() {		
			@Override
			public void run() {
				transferService.transfer(transferData);
			}
		});
	}

}
