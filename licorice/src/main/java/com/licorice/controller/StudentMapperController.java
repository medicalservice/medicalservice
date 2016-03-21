package com.licorice.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.licorice.entity.Address;
import com.licorice.entity.Book;
import com.licorice.entity.Student;
import com.licorice.entity.Teacher;
import com.licorice.service.StudentService;

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
		book1.setStudent(student);
		book2.setStudent(student);
		service.save(student);		 
	}
	
	@RequestMapping(value = "/manytomany.jsonp"/*, method = { RequestMethod.POST }
			headers = { "Accept=application/json" }*/)
	public void manyToMany() {
		Student student1 = new Student();
		student1.setName("zcc1");		
		Student student2 = new Student();
		student2.setName("zcc2");
		
		Teacher teacher1 = new Teacher();
		teacher1.setName("t1");
		Teacher teacher2 = new Teacher();
		teacher2.setName("t2");
		
		Set<Student> students = new HashSet<>(); 
		students.add(student1);
		students.add(student2);
		
		Set<Teacher> teachers = new HashSet<>(); 
		teachers.add(teacher1);
		teachers.add(teacher2);
		
		student1.setTeachers(teachers);
		student2.setTeachers(teachers);
		
		teacher1.setStudents(students);
		teacher2.setStudents(students);
		
		service.save(student1);
		service.save(student2);
		
	}
}
