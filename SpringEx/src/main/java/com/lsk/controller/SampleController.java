
package com.lsk.controller;

import org.lsk.domain.SampleMemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("sample")
public class SampleController {
   private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
   
   // @RequestMapping(value = "sample", method = RequestMethod.GET)  // 웹브라우저를 분석해주는 역할
   @GetMapping("")
   
   /* 
    * GET : 속도는 빠르지만 보안 취약
    * POST: 속도는 느리지만 보안 보장(회원가입할 시)
    * */

   public void basic(Model model) { 
      logger.info("sample 실행됨.");// console 역할
      model.addAttribute("abcd", "aaaa");
      
      // 모델을 사용하기 위해서 매개변수에 모델 변수를 사용함.
      // attributeValue 값을 변수 이름(attributeName)으로 보냄.
   }
   
   // @RequestMapping(value = "sample/ex01", method = RequestMethod.GET)  // 웹브라우저를 분석해주는 역할
   @GetMapping("ex01")
   /* 
    * GET : 속도는 빠르지만 보안 취약
    * 1)<form action="서버주소" method="get">
    * 		id:<input type="text" name="id">
    * 		pw:<input type="password" name="pw">
    * 		name:<input type="text" name="name">
    * 	</form>
    * 2)<a href="서버주소?id=aaa&pw=1234&name=이상국"></a>
    * 
    * POST: 속도는 느리지만 보안 보장(회원가입할 시)
    * 1) <form action="서버주소"method="post"></form>
    *     	id:<input type="text" name="id">
    * 		pw:<input type="password" name="pw">
    * 		name:<input type="text" name="name">
    * */

   public String basic1(Model model) { 
      logger.info("sample 실행됨.");// console 역할
      // bbbb문자열을 zzzz변수에 저장하여 ex01.jsp 보내기
      model.addAttribute("zzzz", "bbbb");
      // return "ex01";
      return "redirect:/";
   }
   
   @RequestMapping(value = "index", method = RequestMethod.GET)
   public String index(Model model) {
	      // cccc문자열을 xxxx변수에 저장하여 index.jsp 보내기
	   model.addAttribute("xxxx", "cccc");
	   return "index";
   }
   
   @RequestMapping(value="member", method=RequestMethod.GET)
   public String member(String id, String pw, String name, Model model) {
	   
	   System.out.println("id="+id);
	   System.out.println("pw="+pw);
	   System.out.println("name="+name);
	   
	   // id값을 id변수에 저장하여 member.jsp에 보내기
	   // pw값을 pw변수에 저장하여 member.jsp에 보내기
	   // name값을 name변수에 저장하여 member.jsp에 보내기
	   
	   model.addAttribute("id", id);
	   model.addAttribute("pw", pw);
	   model.addAttribute("name", name);
	   
	   // return "member";
	   return "redirect:/sample/ex01";
   }
   
   // @RequestMapping(value="sample/memberDTO", method=RequestMethod.POST)
	@PostMapping("memberDTO")
		public String memberDTO(SampleMemberDTO smd, Model model) {
	
		System.out.println("id="+smd.getId());
		System.out.println("pw="+smd.getPw());
		System.out.println("name="+smd.getName()); 
		  
		// SampleMemberDTO값을 id변수에 저장하여 index.jsp에 보내기
		
		model.addAttribute("ID", smd.getId()+smd.getPw()+smd.getName());
		
		// return "memberDTO";
		return "redirect:/"; // "redirect : Controller RequestMapping Value 값 "; // 다른 컨트롤러로 이동.
		// return "redirect:/sample/member"; // 같은 컨트롤러로 이동. (데이터 작업은 완료되고 결과창을 views가 아닌, 다른 Controller를 실행하는 과정으로 이동)
	}
}

