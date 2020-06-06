package com.smc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smc.model.StockPrice;
import com.smc.reository.StockPriceRepository;
import com.smc.util.Constants;
import com.smc.vo.CompanyExchangeQuery;
import com.smc.vo.StockPriceRespVO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StockPriceService {
	@Autowired
	private StockPriceRepository stockPriceRepository;


	public List<StockPriceRespVO> searchStockPrices(Timestamp startDate, Timestamp endDate, List<CompanyExchangeQuery> companyExchanges, String periodicity) {
		List<StockPriceRespVO> rsArray = new ArrayList<StockPriceRespVO>();
		companyExchanges.forEach(ce->{
			String companyId = ce.getCompanyId();
			String exchangeId = ce.getExchangeId();
			
			List<StockPrice> listStockPrice = this.stockPriceRepository.searchStockPricesByQuery(startDate, endDate, companyId, exchangeId);//"2020-05-01", "2020-05-13",
			
			List<StockPrice> filterList = new ArrayList<StockPrice>();
			if(periodicity.equals(Constants.PRIOD_DAY)) {
				listStockPrice.forEach(sp->{
					System.out.println("date="+ sp.getDay());
					filterList.add(sp);
				});
			}
			System.out.println("filterList.size="+ filterList.size());
			StockPriceRespVO stockPriceRespVO = new StockPriceRespVO();
			stockPriceRespVO.setCompanyId(companyId);
			stockPriceRespVO.setExchangeId(exchangeId);
			stockPriceRespVO.setLiStockPrice(filterList);
			rsArray.add(stockPriceRespVO);
		});
		System.out.println("rsArray.size="+ rsArray.size());
		return rsArray;
	}

}
