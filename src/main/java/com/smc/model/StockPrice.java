package com.smc.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "vw_stock_price")
public class StockPrice{
	
	@Id
	@Column(name="id")
	@JsonFormat
	private String id;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@Column(name = "date")
	private Timestamp date;

	@Column(name = "price")
	@JsonFormat
	private BigDecimal price;
	
	@Column(name = "comp_id")
	@JsonFormat
	private String compId;
	
	@Column(name = "exchange_id")
	@JsonFormat
	private String exchangeId;
	
	@Column(name = "stock_code")
	@JsonFormat
	private String stockCode;
	
	public StockPrice() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCompId() {
		return compId;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

	public String getExchangeId() {
		return exchangeId;
	}

	public void setExchangeId(String exchangeId) {
		this.exchangeId = exchangeId;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
}
