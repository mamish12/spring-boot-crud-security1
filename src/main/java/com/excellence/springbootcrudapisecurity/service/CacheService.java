package com.excellence.springbootcrudapisecurity.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.excellence.springbootcrudapisecurity.models.City;



@Service
public class CacheService {
	
	@Autowired
	CacheManager cacheManager;
	
	public Map<String, City> cityZipCodeMap;
	
	CacheService()
	{
		cityZipCodeMap=new HashMap<>();
		cityZipCodeMap.put("Hiteccity", City.builder().cityName("Hiteccity").zipCode("500081").build());
		cityZipCodeMap.put("SrNagar", City.builder().cityName("SrNagar").zipCode("500038").build());
		cityZipCodeMap.put("Miyapur", City.builder().cityName("Miyapur").zipCode("500049").build());
		cityZipCodeMap.put("Waverock", City.builder().cityName("Waverock").zipCode("500095").build());
		cityZipCodeMap.put("GachiWali", City.builder().cityName("GachiWali").zipCode("500032").build());
	}
	
	@Cacheable(value="city-zip-cache")
	public City getZipCode(String cityName)
	{
		System.out.println("getZipCode Method called");
		return cityZipCodeMap.get(cityName);
	}
	
	public Cache getCacheByName(String cacheName)
	{
		return cacheManager.getCache(cacheName);
	}
	
	@CachePut(value="city-zip-cache",key = "#city.cityName")
	public City addCity(City city)
	{
		cityZipCodeMap.put(city.getCityName(), city);
		return city;
	}
	
	@CacheEvict(value="city-zip-cache",allEntries = true)
	public String removeCache()
	{
		return "Cache removed Successfully";
	}
	
	
	
	

}

