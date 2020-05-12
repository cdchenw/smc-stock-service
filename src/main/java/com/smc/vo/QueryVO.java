package com.smc.vo;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class QueryVO {

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Timestamp startDt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Timestamp endDt;
	
	private String periodicity;
	
	private List<CompanyExchangeQuery> companyExchanges;
	
	public QueryVO() {
	}

	public Timestamp getStartDt() {
		return startDt;
	}

	public void setStartDt(Timestamp startDt) {
		this.startDt = startDt;
	}

	public Timestamp getEndDt() {
		return endDt;
	}

	public void setEndDt(Timestamp endDt) {
		this.endDt = endDt;
	}

	public String getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(String periodicity) {
		this.periodicity = periodicity;
	}

	public List<CompanyExchangeQuery> getCompanyExchanges() {
		return companyExchanges;
	}

	public void setCompanyExchanges(List<CompanyExchangeQuery> companyExchanges) {
		this.companyExchanges = companyExchanges;
	}
	
}

