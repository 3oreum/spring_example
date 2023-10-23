package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07/ex01")
@RestController
public class Lesson07Ex01RestController {
	
	@Autowired
	private StudentBO studentBO;
	
	// C U D
	
	// C: create, insert
	@GetMapping("/1")
	public StudentEntity create() {
		String name = "스폰지밥";
		String phoneNumber = "010-5555-0000";
		String email = "nemo@baji.com";
		String dreamJob ="집게리아사장";
		
		// 지금 들어간 id 값도 바로 꺼낼 수 있다. 게터로. getId(); 
		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
	}
	
	// U : Update
	@GetMapping("/2")
	public StudentEntity update() {
		// id:4 dreamJob을 변경
		// 최종 응답값 JSON
		return studentBO.updateStudentDreamJobById(4, "부자");
	}
	
	// D : Delete
	@GetMapping("/3")
	public String delete() {
		// id:4
		studentBO.deleteStudentById(4);
		return "삭제 완료";
	}
	
	
}
