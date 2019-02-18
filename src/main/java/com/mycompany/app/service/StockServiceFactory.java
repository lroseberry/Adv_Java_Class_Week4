package com.mycompany.app.service;

/**
 * This class uses the factory pattern to instantiate stock service objects.
 *
 * @author Linda M Roseberry
 */

public final class StockServiceFactory {

/**
* Constructor is private/hidden
*/
    private StockServiceFactory() {
    }

/**
* Constructs a StockService instance
* @return an object that implements the StockService interface
*/

    public static final StockService createStockService() {

        return new BasicStockService();
    }
}