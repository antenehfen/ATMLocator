package com.interview.backbase.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.interview.backbase.model.ApiResponseObject;
import com.interview.backbase.model.INGAtmLocation;
import com.interview.backbase.services.AtmLocator;

/**
 * 
 * @author anteneh.mengistu
 *
 */

@RestController
public class AtmController {
	
	@Autowired
	private AtmLocator atmLocator;
	
	@RequestMapping(value ="/locations",
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	
	@ResponseBody
	public ApiResponseObject<INGAtmLocation> getATMLocationsfromING() throws Exception{
		
		ApiResponseObject<INGAtmLocation> responseObject = new ApiResponseObject<>();
		
		responseObject.setList(atmLocator.getAtmLocationfromING());
		
		return responseObject;
	}
	
	
	@RequestMapping(value = "/locations/{city}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ApiResponseObject<INGAtmLocation> getATMLocationsfromINGByCity(
	@PathVariable ("city") String city) throws Exception{
		ApiResponseObject<INGAtmLocation> resObject = new ApiResponseObject<>();
		
		resObject.setList(atmLocator.getAtmLocationsfromINGByCity(city));
		return resObject;
		
	}

}
