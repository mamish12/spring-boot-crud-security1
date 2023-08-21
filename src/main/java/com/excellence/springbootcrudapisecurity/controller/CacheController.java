package com.excellence.springbootcrudapisecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.excellence.springbootcrudapisecurity.models.City;
import com.excellence.springbootcrudapisecurity.service.CacheService;


@RestController
public class CacheController {
	
	@Autowired
	 CacheService cacheService;
	
	@GetMapping("/city")
	public City getCityByName(@RequestParam("name") String name)
	{
		return cacheService.getZipCode(name);
	}
	
	@GetMapping("/cache")
	public Cache getCacheDetails(@RequestParam("name") String name)
	{
		return cacheService.getCacheByName(name);
	}
	
	@PostMapping("/city")
	public City addCache(City city)
	{
		return cacheService.addCity(city);
	}
	
	@DeleteMapping("/cache")
	public String removeCache()
	{
		return cacheService.removeCache();
	}

}

