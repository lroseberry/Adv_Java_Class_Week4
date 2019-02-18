package com.mycompany.app.service;

import java.util.*;
import com.mycompany.app.model.*;
import com.mycompany.app.utility.*;

/**
     * An interface for StockService that requires classes to define  
	 * methods for getting stock quotes
     *
     * @author Linda M Roseberry
     */

    public interface StockService {
        /**
         * Return the current price for a share of stock for the
         * given symbol
         * @param symbol the stock symbol of the company you want a
         * quote for e.g. APPL for APPLE
         */
        StockQuote getQuote(String symbol);

        /**
         * Get a list of stock quotes for the provided symbol
         * @param symbol the stock symbol to search for
         * @param from the date of the first stock quote
         * @param until the date of the last stock quote
         * @return a list of StockQuote instances.
         * One for each day in the range specified.
         */
        List<StockQuote> getQuote(String symbol, Calendar from, Calendar until);

        /**
         * Get a historical list of stock quotes for the provided symbol
         * @param symbol the stock symbol to search for
         * @param from the date of the first stock quote
         * @param until the date of the last stock quote
         * @param interval the number of StockQuotes to get e.g. if interval.DAILY
         * was specified one StockQuote per day will be returned
         * @return a list of StockQuote instances.
         */
        List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, IntervalEnums interval);

    }