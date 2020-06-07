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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class StockPriceService {
	@Autowired
	private StockPriceRepository stockPriceRepository;

	public List<StockPriceRespVO> searchStockPrices(Timestamp startDate, Timestamp endDate,
			List<CompanyExchangeQuery> companyExchanges, String periodicity) throws Exception {
		List<StockPriceRespVO> rsArray = new ArrayList<StockPriceRespVO>();

		companyExchanges.forEach((ce) -> {
			String companyId = ce.getCompanyId();
			String exchangeId = ce.getExchangeId();

			List<StockPrice> listStockPrice = this.stockPriceRepository.searchStockPricesByQuery(startDate, endDate, companyId, exchangeId);// "2020-05-01", "2020-05-13",

			List<StockPrice> filterList = new ArrayList<StockPrice>();
			Map<String, Boolean> dateExistsMap = this.getCalendarMap(startDate, endDate, periodicity);
			for (StockPrice sp : listStockPrice) {
				String dayString = sp.getDay();
				if (dateExistsMap.get(dayString) != null) {
					filterList.add(sp);
				}
			}

			System.out.println("filterList.size=" + filterList.size());
			StockPriceRespVO stockPriceRespVO = new StockPriceRespVO();
			stockPriceRespVO.setCompanyId(companyId);
			stockPriceRespVO.setExchangeId(exchangeId);
			stockPriceRespVO.setLiStockPrice(filterList);
			rsArray.add(stockPriceRespVO);
		});
		System.out.println("rsArray.size=" + rsArray.size());
		return rsArray;
	}

	private Map<String, Boolean> getCalendarMap(Timestamp startDate, Timestamp endDate, String periodicity) {
		Map<String, Boolean> dateExistsMap = new HashMap<String, Boolean>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strStartDate = sdf.format(startDate);

		try {
			while (sdf.parse(strStartDate).getTime() < endDate.getTime()) {
				dateExistsMap.put(strStartDate, Boolean.TRUE);
				Date dtStart = sdf.parse(strStartDate);
				if (periodicity.equals(Constants.PRIOD_DAY)) {
					Date dtStartA1d = new Date(dtStart.getTime() + 24 * 60 * 60 * 1000); // 1day
					strStartDate = sdf.format(dtStartA1d);
				} else if (periodicity.equals(Constants.PRIOD_WEEKLY)) {
					Date dtStartA7d = new Date(dtStart.getTime() + 7 * 24 * 60 * 60 * 1000); // 1day
					strStartDate = sdf.format(dtStartA7d);
				} else if (periodicity.equals(Constants.PRIOD_MONTH)) {
					Calendar calendar = Calendar.getInstance(); // get calendar
					calendar.setTime(dtStart);// set current time to calendar
					calendar.add(Calendar.MONTH, 1); // +1 month
					Date dtStartA1m = calendar.getTime();
					strStartDate = sdf.format(dtStartA1m);
				} else if (periodicity.equals(Constants.PRIOD_QUARTER)) {
					Calendar calendar = Calendar.getInstance(); // get calendar
					calendar.setTime(dtStart);// set current time to calendar
					calendar.add(Calendar.MONTH, 3); // +3 month
					Date dtStartA3m = calendar.getTime();
					strStartDate = sdf.format(dtStartA3m);
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateExistsMap;
	}

}
