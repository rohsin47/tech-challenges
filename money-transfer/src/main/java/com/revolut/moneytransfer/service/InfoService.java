/*
* Copyright (C) 2019 BlackRock.
*
* Created on Jul 8, 2019
*
* Last edited by: $Author: $
*             on: $Date: $
*       Filename: $Id:  $
*       Revision: $Revision: $
*/
package com.revolut.moneytransfer.service;

import com.revolut.moneytransfer.model.Account;
import com.revolut.moneytransfer.model.User;

/**
 * @author rohsingh
 *
 */
public interface InfoService {

	Account getAccountById(String accountId);

	User getUserById(String userId);

}
