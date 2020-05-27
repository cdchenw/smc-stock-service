package com.smc.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.smc.model.StockPrice;
import com.smc.vo.CompanyExchangeQuery;
import com.smc.vo.QueryVO;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StockPriceControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testSearchStockPrices() throws ParseException {
		QueryVO queryVO = new QueryVO();
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		queryVO.setStartDt(new Timestamp(sdf.parse("2020-05-01").getTime()));
		queryVO.setEndDt(new Timestamp(sdf.parse("2020-05-03").getTime()));
		queryVO.setPeriodicity("week");
		List<CompanyExchangeQuery> companyExchanges = new ArrayList<CompanyExchangeQuery>();
		CompanyExchangeQuery ceq1 = new CompanyExchangeQuery();
		ceq1.setCompanyId("aaefc180-2354-4822-b2fd-450a7f08da08");
		ceq1.setExchangeId("173df4e9-77ad-44e4-b014-5fd5a3a1d38b");
		companyExchanges.add(ceq1);
		queryVO.setCompanyExchanges(companyExchanges);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<QueryVO> httpRequst =new HttpEntity<QueryVO>(queryVO, headers);
		ParameterizedTypeReference<StockPrice[]> typeReference = new ParameterizedTypeReference<StockPrice[]>() {};
		ResponseEntity<StockPrice[]> response = restTemplate.exchange("/stockprice/search", HttpMethod.POST, httpRequst, typeReference);
        StockPrice[] arrStockPrices = response.getBody();
        
        for(StockPrice item: arrStockPrices) {
        	System.out.println("name>>"+item.getStockCode());
        }
	}

}
