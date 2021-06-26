/*
* Copyright (C) 2020 BlackRock.
*
* Created on Feb 5, 2020
*
* Last edited by: $Author: $
*             on: $Date: $
*       Filename: $Id:  $
*       Revision: $Revision: $
*/
package com.crypto.app.portfolio;

import com.crypto.app.event.Event;
import com.crypto.app.model.Portfolio;

/**
 * @author rohsingh
 *
 */
public class PortfolioEvent extends Event {
    
    Portfolio portfolio;

    public PortfolioEvent(Portfolio portfolio) {
        super();
        this.portfolio = portfolio;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
    
    

}
