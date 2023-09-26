package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.domain.Review;

@RestController
public class Lesson03Ex01RestController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	// 요청 URL: http://localhost/lesson03/ex01
	// 요청 URL: http://localhost/lesson03/ex01?id=5
	@RequestMapping("/lesson03/ex01")
	public Review ex01(
			@RequestParam("id") int id // 필수 파라미터
			//@RequestParam(value="id") int id // 필수 파라미터(필수이기 때문에 id를 안 보내면 에러가 남)
			//@RequestParam(value="id", required=true) int id // 필수 파라미터
			//@RequestParam(value="id", required=false) Integer id // 비필수 파라미터(파라미터를 넣어도, 안 넣어도 됨)
			//@RequestParam(value="id", defaultValue="1") int id // 비필수 파라미터, 디폴트값 1
			) {
	
		return reviewBO.getReview(id); // response body => json
	}
}
