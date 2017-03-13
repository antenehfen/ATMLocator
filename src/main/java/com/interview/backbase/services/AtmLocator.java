package com.interview.backbase.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.interview.backbase.model.INGAtmLocation;
import com.interview.backbase.repositories.AtmDataPopulator;

@Service
public class AtmLocator {

	@Autowired
	private AtmDataPopulator atmDataPopulator;
	
	public List<INGAtmLocation> getAtmLocationfromING() throws Exception{
		
		return atmDataPopulator.getDataFromInG();
	}
	
	public List<INGAtmLocation> getAtmLocationsfromINGByCity(String city)throws Exception{
		
		List<INGAtmLocation> locations = new ArrayList<>();
		List<INGAtmLocation> atmLocationsfromING = getAtmLocationfromING();
		if(atmLocationsfromING!=null){
			atmLocationsfromING.forEach(e->{if (city.equalsIgnoreCase(e.getAddress().getCity())){locations.add(e);}});
		}
		
		return locations;
		
		
	}
	
}
