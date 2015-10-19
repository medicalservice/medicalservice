package com.echarts.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.echarts.models.PieDataModel;
import com.echarts.models.User;

@Controller
public class LoadDataController {

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
	public PieDataModel[] loadData() {
		//System.out.println(user);
		PieDataModel data1 = new PieDataModel();
		data1.setName("A");
		data1.setValue(335);
		PieDataModel data2 = new PieDataModel();
		data2.setName("B");
		data2.setValue(679);
		PieDataModel data3 = new PieDataModel();
		data3.setName("C");
		data3.setValue(1548);
		
		PieDataModel[] datas = new PieDataModel[] { data1, data2, data3 };		
		
		return datas;
		//"[{\"value\":335,\"name\":\"A\"},{\"value\":679,\"name\":\"B\"},{\"value\":1548,\"name\":\"C\"}]"; 
	}
}
