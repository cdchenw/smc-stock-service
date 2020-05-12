package com.smc.reository;

import java.sql.Timestamp;
import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.smc.model.StockPrice;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface StockPriceRepository extends CrudRepository<StockPrice, String> {
	
	@Query(value="select vsp.* FROM vw_stock_price vsp where vsp.date>=? and vsp.date<? and vsp.comp_id=? and vsp.exchange_id=?", nativeQuery = true)
	List<StockPrice> searchStockPricesByQuery(Timestamp startDate, Timestamp endDate, String compId, String exchangeId);  

}
