package com.stocks.proj;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;
import yahoofinance.quotes.fx.FxQuote;
import yahoofinance.quotes.fx.FxSymbols;
import yahoofinance.quotes.stock.StockQuote;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * @author naznen mulani
 * @since 12/05/2019
 * @version 1.0
 *
 */
public class StockDemo 
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stock stock;
		Stock s1;
		try {
			
		
			System.out.println("*************Hey Welcome to Stock!!**************************");
			
			//Get the AMD STOCK history
			stock = YahooFinance.get("AMD");
			stock.getHistory();
			stock.print();
			
			//Get the IDEA 
			s1 = YahooFinance.get("IDEA", true); 
   			s1.getQuote();
			 s1.print();
			 
			 //Get the multiple stock data by sending request together
			 String[] symbols = new String[] {"INTC", "BABA", "TSLA", "AIR.PA", "YHOO"};
			 Map<String, Stock> stocks = YahooFinance.get(symbols); // single request
			 Stock intel = stocks.get("INTC");
			 Stock airbus = stocks.get("AIR.PA");
			 
			 //Get FXQuote for USD/GBP (USDGBP=X)
			 FxQuote usdeur = YahooFinance.getFx(FxSymbols.USDEUR);
			 FxQuote usdgbp = YahooFinance.getFx("USDGBP=X");
			 System.out.println(usdeur);
			 System.out.println(usdgbp);
			 
			 //Get the Tesla history
			 Stock tesla = YahooFinance.get("TSLA", true);
			 System.out.println(tesla.getHistory());
		
			 
			 //Get the Google stock data last 5 years, monthly
			 Calendar from = Calendar.getInstance();
			 Calendar to = Calendar.getInstance();
			 from.add(Calendar.YEAR, -5); // from 5 years ago
			 Stock google = YahooFinance.get("GOOG", from, to, Interval.MONTHLY);
			 
			 //Get the Google stock data since last 1 years, monthly 
			 Calendar fromdate = Calendar.getInstance();
			 Calendar todate = Calendar.getInstance();
			 from.add(Calendar.YEAR, -1); // from 1 year ago
			 Stock goog = YahooFinance.get("GOOG");
			 List<HistoricalQuote> googleHistQuotes = goog.getHistory(from, to, Interval.MONTHLY);
			 for(int i=0;i<googleHistQuotes.size();i++){
				    System.out.println(googleHistQuotes.get(i));
				} 
			 
			
	
		
	
		} catch (IOException e) {
			
			System.out.println("Somethign went wrong..........");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
