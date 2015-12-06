package com.echarts.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.echarts.entities.Address;
import com.echarts.entities.Book;
import com.echarts.entities.Student;
import com.echarts.services.StudentService;

@Controller
public class StudentMapperController {
	@Autowired
	private StudentService service;
	
	@RequestMapping(value = "/onetoone.jsonp"/*, method = { RequestMethod.POST }
			headers = { "Accept=application/json" }*/)
	public void oneToOne() {		
		Address address = new Address();
		address.setName("北清路");
		Student student = new Student();
		student.setName("zcc");
		student.setAddress(address);
		service.save(student);		 
	}
	
	@RequestMapping(value = "/onetomany.jsonp"/*, method = { RequestMethod.POST }
			headers = { "Accept=application/json" }*/)
	public void oneToMany() {		
		Address address = new Address();
		address.setName("北清路");
		
		Book book1 = new Book();
		book1.setName("Thinking in Java");
		Book book2 = new Book();
		book2.setName("C++");
		Set<Book> books = new HashSet<>();
		books.add(book1);
		books.add(book2);
		
		Student student = new Student();
		student.setName("zcc");
		student.setAddress(address);
		student.setBooks(books);
		service.save(student);		 
	}
}
