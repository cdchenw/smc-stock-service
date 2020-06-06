package com.smc.reository;

import java.sql.Timestamp;
import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.smc.model.StockPrice;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface StockPriceRepository extends CrudRepository<StockPrice, String> {
	
	@Query(value="select a.id, b.day as day, a.price as price from smcdb.vw_stock_price a join\n" + 
			"(SELECT v.id as id, DATE_FORMAT(v.date, '%Y-%m-%d') as day, max(v.date) as date\n" + 
			"FROM smcdb.vw_stock_price v \n" + 
			"group by v.id, day\n" + 
			") b\n" + 
			"on a.id = b.id and a.date = b.date\n" + 
			"where b.day>=DATE_FORMAT(?, '%Y-%m-%d') and b.day<DATE_FORMAT(?, '%Y-%m-%d') and a.comp_id=? and a.exchange_id=? order by b.day asc;", nativeQuery = true)
	List<StockPrice> searchStockPricesByQuery(Timestamp startDate, Timestamp endDate, String compId, String exchangeId);

}
