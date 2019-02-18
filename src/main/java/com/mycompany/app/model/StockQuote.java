package com.mycompany.app.model;

import java.util.*;
import org.apache.http.annotation.Immutable;
/**
 * A class that stores information about a stock quote
 *
 * @author Linda M Roseberry
 */

@Immutable
public final class StockQuote {
    private final Calendar quoteDate;
    private final String symbol;
    private final double price;

    /**
     * Constructs a new StockQuote instance
     * @param quoteDate date this price is being retrieved
     * @param price price of the stock
     * @param symbol symbol for the company issuing the stock
     */
    public StockQuote(Calendar quoteDate, double price, String symbol) {
        this.quoteDate = quoteDate;
        this.price = price;
        this.symbol = symbol;
    }
    /**
     * @return the date used to get the stock price
     */
    public Calendar getQuoteDate() {

        return quoteDate;
    }

    /**
     * @return the symbol that represents the company issuing this stock
     */
    public String getSymbol() {

        return symbol;
    }

    /**
     * @return the price of one share of this stock
     */
    public double getPrice() {

        return price;
    }
}
