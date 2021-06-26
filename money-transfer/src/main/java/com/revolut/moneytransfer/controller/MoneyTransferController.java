package com.revolut.moneytransfer.controller;

import java.util.Random;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revolut.moneytransfer.model.Account;
import com.revolut.moneytransfer.model.TransferDetails;
import com.revolut.moneytransfer.model.User;
import com.revolut.moneytransfer.processor.TransferProcessor;
import com.revolut.moneytransfer.service.InfoService;
import com.revolut.moneytransfer.service.impl.InfoServiceImpl;
import com.revolut.moneytransfer.util.MoneyTransferConstants;

/**
 * @author rohsingh
 *
 */
@Path(MoneyTransferConstants.BASE_URL)
@Produces(MediaType.APPLICATION_JSON)
public class MoneyTransferController {
	
	private static final Logger Log = LoggerFactory.getLogger(MoneyTransferController.class);

	private InfoService infoService;

	private TransferProcessor transferProcessor;
	
	public MoneyTransferController() {
		this.infoService = new InfoServiceImpl();
		this.transferProcessor = new TransferProcessor();
	}

	@GET
	@Path("/account/{accountId}")
	public Response getAccountInfoById(@PathParam("accountId") Long accountId) {
		Account bankAccount = infoService.getAccountById(String.valueOf(accountId));
		if (bankAccount == null) {
			throw new WebApplicationException("The bank account does not exist", Response.Status.NOT_FOUND);
		}
		return Response.ok(bankAccount).build();
	}

	@GET
	@Path("/user/{userId}")
	public Response getUserInfoById(@PathParam("userId") Long userId) {
		User user = infoService.getUserById(String.valueOf(userId));
		if (user == null) {
			throw new WebApplicationException("The user does not exist", Response.Status.NOT_FOUND);
		}
		return Response.ok(user).build();
	}
	
	@GET
	@Path("/balance/{accountId}")
	public Response getAccountBalanceById(@PathParam("accountId") Long accountId) {
		Account bankAccount = infoService.getAccountById(String.valueOf(accountId));
		if (bankAccount == null) {
			throw new WebApplicationException("The bank account does not exist", Response.Status.NOT_FOUND);
		}
		return Response.ok(bankAccount.getBalance()).build();
	}

	@POST
	@Path("/transfer/")
	public Response transferMoney(
			@PathParam("fromAccount") Long fromAccount, 
			@PathParam("toAccount") Long toAccount, 
			@PathParam("amount") Double amount, 
			@PathParam("userId") String userId, 
			@PathParam("status") String status) {
		Long transferId = new Random().nextLong();
		TransferDetails transfer = new TransferDetails(transferId, fromAccount, toAccount, amount, userId, status);
		transferProcessor.processTransfer(transfer);
		return Response.ok().build();
	}

}
