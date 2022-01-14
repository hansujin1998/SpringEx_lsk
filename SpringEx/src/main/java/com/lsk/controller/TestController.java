
package com.lsk.controller;

import org.lsk.domain.BoardDTO;
import org.lsk.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class TestController {
	
	@Autowired
	TestService service;
	
	@GetMapping("write")
	public void GetWrite() {
		System.out.println("test/GetWrite");
	}
	
	@PostMapping("write")
	public void PostWrite(BoardDTO b) {
		System.out.println("test/PostWrite");
		service.write(b);
	}
	
	@GetMapping("list")
	public void list(BoardDTO b, Model model) {
		System.out.println("test/list");
		model.addAttribute("list", service.list());	
	}
	
}
