package com.lsk.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	 // @RequestMapping(value = "/", method = RequestMethod.GET)
	 @RequestMapping("/")
	public String home(Locale locale, Model model) {
		
		logger.info("Welcome home! The client locale is {}.", locale);
		//System.out.println("Welcome home! The client locale is {}." + locale);
		
		Date date = new Date();
		// 날짜 형식을 정해주는 DAteFormate 클래스
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate ); // 컨트롤러에서 데이터를 보낼 때, model 객체를 사용함.
		
		return "home";
		
		// value값과 return이 다를때는 return을 사용해야한다.
	}
	
		
		@RequestMapping(value = "/index", method = RequestMethod.GET)
	   public String index(Locale locale, Model model) {
	      
	      return "index";
	     
	}
	
}
