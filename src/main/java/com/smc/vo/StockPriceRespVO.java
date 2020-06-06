package com.smc.vo;

import java.util.List;

import com.smc.model.StockPrice;

public class StockPriceRespVO {

	private String companyId;
	
	private String exchangeId;
	
	
	public StockPriceRespVO() {
	}

	private List<StockPrice> liStockPrice;

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getExchangeId() {
		return exchangeId;
	}

	public void setExchangeId(String exchangeId) {
		this.exchangeId = exchangeId;
	}

	public List<StockPrice> getLiStockPrice() {
		return liStockPrice;
	}

	public void setLiStockPrice(List<StockPrice> liStockPrice) {
		this.liStockPrice = liStockPrice;
	}
	
}

