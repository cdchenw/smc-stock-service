package com.smc.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "vw_stock_price")
@IdClass(IdDay.class)
public class StockPrice{
	
	@Id
	@Column(name="id")
	@JsonFormat
	private String id;

	@Id
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Column(name = "day")
	private String day;

	@Column(name = "price")
	@JsonFormat
	private BigDecimal price;
	
	public StockPrice() {
		
	}
	
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

class IdDay implements Serializable{
	 
	private static final long serialVersionUID = 6440618584111311842L;

	private String id;
	 
	private String day;

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
	 
	 
}