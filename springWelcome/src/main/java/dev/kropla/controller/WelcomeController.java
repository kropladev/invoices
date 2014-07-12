package dev.kropla.controller;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

public class WelcomeController {
	private final Logger log= LoggerFactory.getLogger(this.getClass());
	/**
	 * Main site controller. Triggered on application  start.
	 * Serves list of all invoices from db
	 * @param map Model map object
	 * @return View name: invoiceList
	 */
	@RequestMapping("/index")
	public String setupForm(Map<String, Object> map){
		log.info("Controller::GET /index.htm setupForm()");
		map.put("message", "hello");
		return "index";
	}
}
