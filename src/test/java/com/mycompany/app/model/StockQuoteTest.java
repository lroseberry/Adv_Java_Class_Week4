package com.mycompany.app.model;

import org.junit.Before;
import org.junit.Test;
import java.util.*;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.mycompany.app.model.*;

/**
 * JUnit tests for the StockQuote class
 *
 * @author Linda M Roseberry
 */
 
public class StockQuoteTest {
   
	private Calendar quoteDate;
    private String symbol;
    private double price;
	private StockQuote stockQuote;
	private StockQuote stockQuote2;
	private Calendar quoteDate2;

	/**
     * Sets up the logic common to each test
     */
    @Before
    public void setUp() {		
		Calendar quoteDate = Calendar.getInstance();				
        symbol = "APPL";
        price = 163.50;
    }
	
	/**
     * Verifies that the correct symbol is returned
     */
    @Test
    public void testGetSymbolPositive() {
		stockQuote = new StockQuote(quoteDate, price, symbol);
        assertTrue("Value returned from getSymbol() equals expected string",stockQuote.getSymbol().equals(symbol));
    }

    /**
     * Verifies that the symbol returned is not equal to the expected result
     */
    @Test
    public void testGetSymbolNegative() {
		String expected = "IBM";
		stockQuote = new StockQuote(quoteDate, price, symbol);
        assertFalse("Value returned from getSymbol() is not equal expected result",stockQuote.getSymbol().equals(expected));
    }

    /**
     * Verifies that the correct stock price is returned
     */    
	@Test
    public void testGetPricePositive() {
		stockQuote = new StockQuote(quoteDate, price, symbol);
        assertTrue("Value returned from getPrice() equals the expected value",stockQuote.getPrice() == price);
    }

    /**
     * Verifies that an stock price is returned is not equal to the expected result
     */
    @Test
    public void testGetPriceNegative() {
		double expected = 164.50;
		stockQuote = new StockQuote(quoteDate, price, symbol);
        assertFalse("Value returned from getPrice() is not equal to the expected result",stockQuote.getPrice() == expected);
    }
/**
     * Verifies that the correct date is returned
     */
    @Test
    public void testGetQuoteDatePositive() {	
	    quoteDate2 = Calendar.getInstance();
		StockQuote stockQuote2 = new StockQuote(quoteDate2, price, symbol);
        assertTrue("Value returned from getQuoteDate() equals expected value",stockQuote2.getQuoteDate().equals(quoteDate2));
    }

    /**
     * Verifies that the current date returned is not equal to the expected result
     */
    @Test
    public void testGetQuoteDateNegative() {
		StockQuote stockQuote3 = new StockQuote(quoteDate, price, symbol);
		String stringDate = "02/02/2019";
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar expectedDate = Calendar.getInstance();	
		try {
            expectedDate.setTime(sdf.parse(stringDate));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		assertFalse("Value returned from getQuoteDate() is not equal expected result",stockQuote3.getQuoteDate() == expectedDate);
    }

}
