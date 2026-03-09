package com.kh.study.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/list")
public class ListController {
	
	
	@RequestMapping("/border")
	public String selectList() {
		
		return "border/list";
	}
	
	@RequestMapping("/insert")
	public String insertList() {
		
		return "border/insert";
	}
	
	@RequestMapping("/detail")
	public String testList() {
		
		return "border/detail";
	}
}
