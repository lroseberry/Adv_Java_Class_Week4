package com.mycompany.app.application;

import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import com.mycompany.app.service.*;
import com.mycompany.app.model.*;
import com.mycompany.app.utility.*;
import static com.mycompany.app.utility.IntervalEnums.*;

/**
 * This class gets the price of a stock for a give date range and interval
 */
public class StockQuoteApplication {

    /**
     * A main method which enables program execution
     * @param args an array that should contain as elements:
     *       {@code String} representations of a symbol, start date, and end date
	 * @throws ParseException
     */
    public static void main(String[] args) {
		Calendar startDate, endDate;

		StockService stockService = StockServiceFactory.createStockService();

        if (args.length == 0) {
			System.out.println("Required command line arguments are missing!");
			System.exit(0);
		}
		StockQuote stockQuote = stockService.getQuote(args[0]);

        if (args.length > 1) {
			startDate = formatDate(args[1]);
			endDate = formatDate(args[2]);
			List<StockQuote> stockQuoteListRange = stockService.getQuote(args[0], startDate, endDate);
			}

		if (args.length > 1) {
			startDate = formatDate(args[1]);
			endDate = formatDate(args[2]);
			IntervalEnums interval = HOURLY;
			List<StockQuote> stockQuoteListInterval = stockService.getQuote(args[0], startDate, endDate, interval);
		}
	}
  
	 /**
     * Format date string into a Calendar object
     * @param  stringDate date to be formatted
	 * @return a Calendar object
     */
	private static Calendar formatDate(String stringDate) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar date = Calendar.getInstance();
		try {
			date.setTime(simpleDateFormat.parse(stringDate));
		}
			catch (ParseException pe) {
			   System.out.println("Unable to parse date - " + stringDate);
               pe.printStackTrace();
           }
		return date;
	}
}