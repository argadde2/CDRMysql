package com.example.demo.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Caller;
import com.example.demo.repository.CallerDAO;

@Controller
@RequestMapping(value = "/rest")
public class ReportController {

	@Autowired
	private CallerDAO callerdao;
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	    public String Form(Model model) {
		model.addAttribute("averagelist",callerdao.getTimetoanswer());
			
	        return "input12";
	    }
	@RequestMapping(value="/companyname",method = RequestMethod.POST)
	public String pidUserSubmit(Model model,@RequestParam("company1") String company1)
	{
	 
	    model.addAttribute("monthlist",callerdao.companymonthlycall(company1));
	    return "result";
	}

	@RequestMapping(value="/companycall",method = RequestMethod.POST)
	public String pidUser(Model model,@RequestParam("company2") String company2)
	{
	 
		model.addAttribute("callslist",callerdao.getcalllist(company2));
	    return "resultlist";
	}
	
	
}
