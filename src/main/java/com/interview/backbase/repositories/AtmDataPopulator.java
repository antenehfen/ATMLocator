package com.interview.backbase.repositories;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.interview.backbase.model.INGAtmLocation;
import com.interview.backbase.model.INGAtmLoccationList;

@Component
public class AtmDataPopulator extends RouteBuilder {

	private static final Logger atmDataPopulator = LoggerFactory.getLogger(AtmDataPopulator.class);

	@Autowired
	private RestTemplate restTemplate;

	public List<INGAtmLocation> getDataFromInG() {

		String response = restTemplate.getForObject("https://www.ing.nl/api/locator/atms/", String.class);

		atmDataPopulator.debug("GARBAGE IN RESPONSE:" + "\n\n" + response.substring(0, 5) + "\n\n");
		String tobeParsed = "{\"ingLocations\":" + response.substring(6, response.length()) + "}";

		atmDataPopulator.debug("TO BE PARSED RESPONSE:" + "\n\n" + tobeParsed + "\n\n");

		ObjectMapper objectMapper = new ObjectMapper();

		INGAtmLoccationList ingAtmLocations = null;
		try {

			ingAtmLocations = objectMapper.readValue(tobeParsed, INGAtmLoccationList.class);

			atmDataPopulator.debug("PARSED RESPONSE:" + "\n\n" + ingAtmLocations.toString() + "\n\n");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			atmDataPopulator.error("ERROR while parsing " + ingAtmLocations.toString());

		}
		return Arrays.asList(ingAtmLocations.getIngLocations());
	}

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
