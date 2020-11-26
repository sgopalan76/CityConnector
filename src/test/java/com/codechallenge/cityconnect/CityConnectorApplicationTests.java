package com.codechallenge.cityconnect;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import com.codechallenge.cityconnectservice.util.AppConfig;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
class CityConnectorApplicationTests {

	@Test
	void cityConnectorRoutes_1() throws Exception {
		assertEquals("yes", AppConfig.returnCityConnectorBean().fetchCityConnectorRoutes("San Diego", "Los Angeles"));
	}

	@Test
	void cityConnectorRoutes_2() throws Exception {
		assertEquals("yes", AppConfig.returnCityConnectorBean().fetchCityConnectorRoutes("Los Angeles", "San Diego"));
	}

	@Test
	void cityConnectorRoutes_3() throws Exception {
		assertEquals("yes", AppConfig.returnCityConnectorBean().fetchCityConnectorRoutes("Boston", "New York"));
	}

	@Test
	void cityConnectorRoutes_4() throws Exception {
		assertEquals("yes", AppConfig.returnCityConnectorBean().fetchCityConnectorRoutes("boston", "New york"));
	}

	@Test
	void cityConnectorRoutes_5() throws Exception {
		assertEquals("yes", AppConfig.returnCityConnectorBean().fetchCityConnectorRoutes("trenton", "albany"));
	}

	@Test
	void cityConnectorRoutes_6() throws Exception {
		assertEquals("no", AppConfig.returnCityConnectorBean().fetchCityConnectorRoutes("Delhi", "Mumbai"));
	}

	@Test
	void cityConnectorRoutes_7() throws Exception {
		assertEquals("no", AppConfig.returnCityConnectorBean().fetchCityConnectorRoutes("Richmond", "DC"));
	}

	@Test
	void cityConnectorRoutes_8() throws Exception {
		assertEquals("no",
				AppConfig.returnCityConnectorBean().fetchCityConnectorRoutes("San Francisco", "Los Angeles"));
	}

	@Test
	void cityConnectorRoutes_9() throws Exception {
		assertEquals("yes", AppConfig.returnCityConnectorBean().fetchCityConnectorRoutes("newark", "boston"));
	}

	@Test
	void cityConnectorRoutes_10() throws Exception {
		assertEquals("no", AppConfig.returnCityConnectorBean().fetchCityConnectorRoutes("", ""));
	}

	@Test
	void cityConnectorRoutes_11() throws Exception {
		assertEquals("no", AppConfig.returnCityConnectorBean().fetchCityConnectorRoutes("", "Chennai"));
	}

}
