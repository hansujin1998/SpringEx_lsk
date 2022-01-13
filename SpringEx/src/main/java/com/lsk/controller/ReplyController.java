package com.lsk.controller;

import java.util.ArrayList;

import org.lsk.domain.ReplyDTO;
import org.lsk.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("replies")
public class ReplyController {
	@Autowired
	private ReplyService rservice;
	
	// 댓글 쓰기를 하기 위한 RequestMapping
	// consumes : 들어오는 데이터 타입 정의(생략가능)
	// produces : 반환하는 데이터 타입 정의(생략가능)
	@PostMapping(value="new", consumes="application/json", produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyDTO rdto){
		System.out.println("ReplyDTO="+rdto);
		int result=rservice.write(rdto);
		// insert 값은 return된다.(메소드가  void였기 때문에 값을 가져오지 않았음)
		// insert 성공 ReplyServiceImpl로 부터 값 1
		// insert 실패 ReplyServiceImpl로 부터 값 0
		// HttpStatus.OK 는 result로 들어감
		return result == 1? new ResponseEntity<>("success",HttpStatus.OK)
							:new ResponseEntity<>("error",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value="list/{bno}", produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ArrayList<ReplyDTO>> getList(@PathVariable int bno){ // 주소 list/{bno}와 int bno의 변수 값이 같아야함
		System.out.println("sysout 값="+bno);
		rservice.list(bno);
		return new ResponseEntity<>(rservice.list(bno),HttpStatus.OK);
		// detail?bno=2 -> detail/bno (@PathVariable) - REST방식에서 주로 사용, URL경로의 일부를 파라미터로 사용하고자 할 때
	}
	
}
