package com.smc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smc.model.StockPrice;
import com.smc.reository.StockPriceRepository;

import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional
public class StockPriceService {
	@Autowired
	private StockPriceRepository stockPriceRepository;


	public List<StockPrice> searchStockPrices(Timestamp startDate, Timestamp endDate, String compId, String exchangeId ) {
		List<StockPrice> listStockPrice = this.stockPriceRepository.searchStockPricesByQuery(startDate, endDate, compId, exchangeId);
		return listStockPrice;
	}

}
