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

import com.revolut.moneytransfer.model.TransferDetails;

/**
 * @author rohsingh
 *
 */
public interface TransferService {

	void transfer(TransferDetails transfer);

}
