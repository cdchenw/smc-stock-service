package com.smc.vo;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StockPriceVO {

	private String id;

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private String day;

	private BigDecimal price;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
}


