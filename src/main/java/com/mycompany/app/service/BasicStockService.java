package com.mycompany.app.service;

import java.util.*;
import java.text.SimpleDateFormat;
import com.mycompany.app.model.*;
import com.mycompany.app.utility.*;
import javax.validation.constraints.*;

/**
 * BasicStockService provides a concrete implementation of the StockService interface
 *
 * @author Linda M Roseberry
 */

public final class BasicStockService implements StockService {

    private double price = 163.50;
    Calendar currdate = Calendar.getInstance();

	/**
     * Gets today's {@code StockQuote} instance for the given symbol
     * @param symbol symbol for the company issuing the stock
     * @return a {@code StockQuote} instance
     */
    @Override
	@NotNull
    public StockQuote getQuote(String symbol) {

        return new StockQuote(currdate, price, symbol);
    }

    /**
     * Gets the {@code List} of {@code StockQuote} instances for the given symbol and date range
     * @param symbol    symbol for the company issuing the stock
     * @param startDate beginning of the date range
     * @param endDate   end of the date range
     * @return a {@code List} of {@code StockQuote} instances
     */
    @Override
	@NotNull
    public List<StockQuote> getQuote(String symbol, Calendar startDate, Calendar endDate) {

        System.out.println("");
        System.out.println("*** Get one stock price per day for a given date range ***");
        List<StockQuote> stockQuotesList = new ArrayList<StockQuote>();

        while (startDate.after(startDate) || startDate.equals(startDate) && startDate.before(endDate) || startDate.equals(endDate)) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			System.out.println("Quote date: " + sdf.format(startDate.getTime()) + "  Symbol: " + symbol + "  Price: " + price);
            stockQuotesList.add(new StockQuote(startDate, price, symbol));
            price = price + 1;
            startDate.add(Calendar.DATE, 1);
        }
        return stockQuotesList;
    }

	/**
     * Gets the {@code List} of {@code StockQuote} instances for the given symbol, date range, and interval
     * @param symbol    symbol for the company issuing the stock
     * @param startDate beginning of the date range
     * @param endDate   end of the date range
	 * @param interval  time elapsed between stockQuote instances
     * @return a {@code List} of {@code StockQuote} instances
     */
    @Override
	@NotNull
    public List<StockQuote> getQuote(String symbol, Calendar startDate, Calendar endDate, IntervalEnums interval) {

        System.out.println("");
        System.out.println("*** Get stock price at given interval per day ***");
        List<StockQuote> stockQuotesList = new ArrayList<StockQuote>();
        endDate.add(Calendar.DATE, 1);

        while (startDate.before(endDate)) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            System.out.println("Quote date and time: " + sdf.format(startDate.getTime()) + "  Symbol: " + symbol + "  Price: " + price + "  Interval: " + interval);
            stockQuotesList.add(new StockQuote(startDate, price, symbol));
            price = price + 1;
            startDate.add(Calendar.HOUR_OF_DAY, interval.getNumVal());
        }
        return stockQuotesList;
    }
}