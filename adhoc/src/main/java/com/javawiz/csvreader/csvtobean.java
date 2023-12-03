package com.javawiz.csvreader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class csvtobean {
	public static void main(String[] args) {

		// Hashmap to map CSV data to
		// Bean attributes.
		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("Stock Invested in", "stockName");
		mapping.put("Sector", "sector");
		mapping.put("Value(Mn)", "value");

		mapping.put("1M Change", "oneMonthChange");
		mapping.put("% of Total Holdings", "percentageOfTotalHolding");
		mapping.put("1Y Highest Holding", "highestHolding");
		mapping.put("1Y Lowest Holding", "lowestHolding");
		mapping.put("Quantity", "quantity");
		mapping.put("MF House", "mfHouse");

		// HeaderColumnNameTranslateMappingStrategy
		// for Student class
		HeaderColumnNameTranslateMappingStrategy<Stock> strategy = new HeaderColumnNameTranslateMappingStrategy<>();
		strategy.setType(Stock.class);
		strategy.setColumnMapping(mapping);

		// Create castobaen and csvreader object
		CSVReader csvReader = null;
		try {
			// csvReader = new CSVReader(new FileReader("src/main/resources/stocks.csv"));
			csvReader = new CSVReader(
					new FileReader("C:\\Users\\mail2\\OneDrive\\Desktop\\stocks_analysis\\boi.csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		CsvToBean<Stock> csvToBean = new CsvToBean<>();

		// call the parse method of CsvToBean
		// pass strategy, csvReader to parse method
		csvToBean.setCsvReader(csvReader);
		csvToBean.setMappingStrategy(strategy);
		List<Stock> list = csvToBean.parse();
		
		List<StockReplica> listOfStockReplica = list.stream()
				.map(stock -> new StockReplica(
						stock.getStockName().trim(), 
						stock.getSector().trim(),
						Double.parseDouble(stock.getValue()),
						trimAndReplace(stock.getOneMonthChange()),
						trimAndReplace(stock.getPercentageOfTotalHolding()),
						getHolding(stock.getHighestHolding()), 
						getHolding(stock.getLowestHolding()), 
						stock.getQuantity().trim(), stock.getMfHouse().trim()))
				.sorted(Comparator.comparing(StockReplica::getPercentageOfTotalHolding).reversed())
				.collect(Collectors.toList());
		//listOfStockReplica.forEach(System.out::println);
		
		//System.out.println("++++++++++++++++++++++++++++++++++++++");
		String stocks = list.stream()
				.map(stock -> String.valueOf(new StockReplica(
						stock.getStockName().trim(), 
						stock.getSector().trim(),
						Double.parseDouble(stock.getValue()),
						trimAndReplace(stock.getOneMonthChange()),
						trimAndReplace(stock.getPercentageOfTotalHolding()),
						getHolding(stock.getHighestHolding()), 
						getHolding(stock.getLowestHolding()), 
						stock.getQuantity(), 
						stock.getMfHouse())))
				.collect(Collectors.joining(",\n"));
		System.out.println(stocks);
	}
	
	public static Double getHolding(String value) {
		return Double.parseDouble(value.trim().substring(0, value.trim().lastIndexOf("%")));
	}
	
	public static Double trimAndReplace(String value) {
		return Double.parseDouble(value.trim().replace("%", ""));
	}
}