package com.interview.backbase.controlers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.interview.backbase.controllers.AtmController;
import com.interview.backbase.model.ApiResponseObject;
import com.interview.backbase.model.INGAtmLocation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTest {
	
	private static String city = "LEEUWARDEN";
	
	@Autowired
	private AtmController atmController;

	@Before
	public void setUp() {

		// TODO set up

	}

	@Test
	public void getATMLocationsfromINGTest() throws Exception {
		ApiResponseObject<INGAtmLocation> responseObject = new ApiResponseObject<>();
		responseObject = atmController.getATMLocationsfromING();
		assertNotNull(responseObject);

	}
	@Test
	public void numOfAtmLocByCityTest() throws Exception{
		ApiResponseObject<INGAtmLocation> responseObject = new ApiResponseObject<>();
		responseObject = atmController.getATMLocationsfromINGByCity(city);
		assertNotNull(responseObject);
		assertEquals(11, responseObject.getList().size());
		
	}
}
