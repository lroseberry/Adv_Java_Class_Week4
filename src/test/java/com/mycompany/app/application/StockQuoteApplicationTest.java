package com.mycompany.app.application;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Calendar;

/**
 * JUnit tests for the StockQuoteApplication class
 *
 * @author Linda M Roseberry
 */
public class StockQuoteApplicationTest {  

	private String startDate;
	private String endDate;
	private String symbol;

	/**
     * Sets up the logic common to each test
     */
@Before
    public final void setUp() {
		symbol = "APPL";
        startDate = "02/09/2019";
        endDate = "02/12/2019";
	}
	
	/**
     * Verify that no exceptions will be thrown when the correct arguments are passed  
     */
    @Test
    public void testMainPositive() {
        String[] args = {symbol, startDate, endDate};
        StockQuoteApplication.main(args);
    }

    /**
     * Verify that the NullPointerException will be thrown when no arguments are passed  
     */
    @Test(expected = NullPointerException.class) 
    public void testMainNegative() {
        StockQuoteApplication.main(null);
    }
}