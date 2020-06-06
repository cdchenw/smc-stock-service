package com.smc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smc.service.StockPriceService;
import com.smc.vo.QueryVO;
import com.smc.vo.StockPriceRespVO;

@RestController
@RequestMapping("/stockprice")
public class StockPriceController {
	@Autowired
	private StockPriceService stockPriceService;
	
	@PostMapping("/search")
	public List<StockPriceRespVO> searchStockPrices(@RequestBody QueryVO queryVO) throws Exception{
		List<StockPriceRespVO> listStockPrice = this.stockPriceService.searchStockPrices(queryVO.getStartDt(), queryVO.getEndDt(), queryVO.getCompanyExchanges(), queryVO.getPeriodicity());
		return listStockPrice;
	}
	
//	@PostMapping("/")
//	public List<StockPrice> importStockPrice(@RequestBody QueryVO queryVO) throws Exception{
//		List<StockPrice> rsArray = new ArrayList<StockPrice>();
//		queryVO.getCompanyExchanges().forEach(ce->{
//			String companyId = ce.getCompanyId();
//			String exchangeId = ce.getExchangeId();
//			
//			List<StockPrice> listStockPrice = this.stockPriceService.searchStockPrices(queryVO.getStartDt(), queryVO.getEndDt(), companyId, exchangeId);
//			listStockPrice.forEach(sp->{
////				StockPriceVO vo =new StockPriceVO();
////				vo.setDate(sp.getDate());
////				vo.setPrice(sp.getPrice());
//				rsArray.add(sp);
//			});
//		});
//		return rsArray; 
//	}
	
}
