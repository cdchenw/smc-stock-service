package com.smc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smc.model.StockPrice;
import com.smc.service.StockPriceService;
import com.smc.vo.QueryVO;

@RestController
@RequestMapping("/stockprice")
public class StockPriceController {
	@Autowired
	private StockPriceService stockPriceService;
	
	@PostMapping("/search")
	public List<StockPrice> searchStockPrices(@RequestBody QueryVO queryVO) throws Exception{
		List<StockPrice> rsArray = new ArrayList<StockPrice>();
		queryVO.getCompanyExchanges().forEach(ce->{
			String companyId = ce.getCompanyId();
			String exchangeId = ce.getExchangeId();
			
			List<StockPrice> listStockPrice = this.stockPriceService.searchStockPrices(queryVO.getStartDt(), queryVO.getEndDt(), companyId, exchangeId);
			listStockPrice.forEach(sp->{
//				StockPriceVO vo =new StockPriceVO();
//				vo.setDate(sp.getDate());
//				vo.setPrice(sp.getPrice());
				rsArray.add(sp);
			});
		});
		return rsArray;
//		return rsArray.toArray(new StockPrice[rsArray.size()]); 
	}
	
	@PostMapping("/")
	public List<StockPrice> importStockPrice(@RequestBody QueryVO queryVO) throws Exception{
		List<StockPrice> rsArray = new ArrayList<StockPrice>();
		queryVO.getCompanyExchanges().forEach(ce->{
			String companyId = ce.getCompanyId();
			String exchangeId = ce.getExchangeId();
			
			List<StockPrice> listStockPrice = this.stockPriceService.searchStockPrices(queryVO.getStartDt(), queryVO.getEndDt(), companyId, exchangeId);
			listStockPrice.forEach(sp->{
//				StockPriceVO vo =new StockPriceVO();
//				vo.setDate(sp.getDate());
//				vo.setPrice(sp.getPrice());
				rsArray.add(sp);
			});
		});
		return rsArray; 
	}
	
}
