package com.excellence.springbootcrudapisecurity.controller;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	private static final Logger logger = Logger.getLogger(IndexController.class);
	
	//instance initializer block
//	{
//		BasicConfigurator.configure();
//	}

	@GetMapping("/")
	public String index()
	{
		logger.debug("loading index page..");
		logger.info("info level message");
		logger.warn("Warn level message");
		logger.error("erroe level message");
		logger.fatal("fatal level message");
		logger.trace("trace level message");
		
		logger.debug("Exit of index().");
		return "index";
	}
}
