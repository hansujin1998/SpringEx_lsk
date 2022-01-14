
package com.lsk.controller;

import org.lsk.domain.RestSampleDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sample")
// 비동기식 Controller
public class RestSampleController {
	
	// 단순 문자열 반환
	@GetMapping(value="getText", produces="text/plain; charset=UTF-8") // contentType을 무엇으로 할 것인가?
	public String getText() {
		return "おはようございます。"; // 비 동기식 컨트롤러에는 .jsp파일이 없다 -> 모델을 만들어야 한다.
	}
	
	// 객체 반환
	@GetMapping(value="getSample", produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public RestSampleDTO getSample() {
		return new RestSampleDTO(100,"이","상국");
	} // 결과값이 '객체'이다. (두가지 application을 적었을 경우, XML이 우선적으로 표시되고JSON은 .json을 입력해야함)
	
	// 객체 반환2
	@GetMapping(value="getSample2", produces= {MediaType.APPLICATION_XML_VALUE}) // 결과값이 '객체'이다.
	public RestSampleDTO getSample2() {
		return new RestSampleDTO(100,"이","상국");
	}
	
	// ResponseEntity 타입 반환 -> 결과 확인
	@GetMapping(value="check")
	public ResponseEntity<RestSampleDTO> check(int mno, String firstName, String lastName){
		RestSampleDTO rsdto = new RestSampleDTO(140, "정", "자바");
		ResponseEntity<RestSampleDTO> result = null;
			
		// mno가 150 미만이면 비정상, 그렇지 않으면 정상
		if(mno<150)
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(rsdto);
			// status가 502 : BAD_GATEWAY
				else
					result = ResponseEntity.status(HttpStatus.OK).body(rsdto);
					// 정상적으로 처리 status가 200 : OK
		return result;
	}
	
	// 메서드의 매개변수
	// RestController에서 객체타입을 매개변수로 지정해야 되는 경우에는 @RequestBody를 사용해야 됨.
	@PostMapping("mno")
	public RestSampleDTO mno(@RequestBody RestSampleDTO rsdto) {
		System.out.println("rsdto="+rsdto);
		return rsdto;
		}
	
}
