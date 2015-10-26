package com.echarts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.echarts.entities.PieData;
import com.echarts.models.PieDataModel;
import com.echarts.models.User;
import com.echarts.services.LoadDataService;

@Controller
public class LoadDataController {
	@Autowired
	//@Qualifier("loaddataservice")
	private LoadDataService service;
	
	@RequestMapping(value = "/signin.jsonp")
	public User signIn(@RequestParam("name") String userName) {
		System.out.println(userName);
		
		//PieDataModel data1 = new PieDataModel();
		//data1.setName("A");
		//data1.setValue(335);
		User user = new User();
		user.setId("1");
		user.setName(userName);
		return user; 
	}
	/*
	public String login(@RequestParam("name") String userName, @RequestParam String callback) {
		System.out.println(userName);
		
		//return "Hello " + userName + "!";
		String hello = "Hello " + userName + "!";
		return callback + "({\"result\":\"" + hello + "\"})"; 
	}
	*/
	
	@RequestMapping(value = "/signinbyjosn.do")
	@ResponseBody
	public String signInByJson(@RequestBody User user) {
		System.out.println(user.getName());
		
		return "Hello " + user.getName() + "!"; 
	}
	
	
	@RequestMapping(value = "/loaddata.jsonp"/*, method = { RequestMethod.POST }
					headers = { "Accept=application/json" }*/)
	//@ResponseBody
	public PieDataModel[] load() {				
		return service.load();		 
	}
	
	@RequestMapping(value = "/savedata.jsonp"/*, method = { RequestMethod.POST }
			headers = { "Accept=application/json" }*/)
	public void save() {
		PieData data = new PieData();
		data.setName("A");
		data.setValue(335);
		service.save(data);		 
	}
	
}
