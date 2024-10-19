package com.sample.securitypractice.controllers;

import com.sample.securitypractice.entities.Student;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class StudentController {

	private static List<Student> studentList= new ArrayList<>(List.of(new Student(1,"usman",60)));

	@GetMapping("student")
    public List<Student> getStudentList(){
		return studentList;
	}
	@GetMapping("csrfToken")
	public CsrfToken getCsrf(HttpServletRequest request){
		return (CsrfToken) request.getAttribute("_csrf");
	}
	@PostMapping("student")
	public List<Student> insertStudentInList(@RequestBody Student student){
		studentList.add(student);
		return studentList;
	}

}
