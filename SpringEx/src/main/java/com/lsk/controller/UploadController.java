package com.lsk.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@GetMapping("upload")
	public void uploadForm() {
		System.out.println("파일업로드 화면...");
	}
	
	@GetMapping("uploadAjax")
	public void uploadAjaxForm() {
		System.out.println("파일업로드 화면...");
	}
	
	// upload.jsp의 form태그를 이용해서 파일 업로드 Controller
	@PostMapping("uploadAction")
	public void uploadAction(MultipartFile[] uploadFile) { 
		//MultipartFile에 있는 메서드 **MultipartFile을 추가하면 DTO가 필요없음
//		//사용자가 업로드한 실제 파일 이름 
//		System.out.println("MultipartFile = "+uploadFile[0].getOriginalFilename());
//		//사용자가 업로드한 실제 파일 크기
//		System.out.println("MultipartFile = "+uploadFile[0].getSize());
//		//사용자가 업로드한 실제 파일 양식
//		System.out.println("MultipartFile = "+uploadFile[0].getContentType());
//		//사용자가 업로드한 실제 파일 이름 
//		System.out.println("MultipartFile = "+uploadFile[1].getOriginalFilename());
//		//사용자가 업로드한 실제 파일 크기
//		System.out.println("MultipartFile = "+uploadFile[1].getSize());
//		//사용자가 업로드한 실제 파일 양식
//		System.out.println("MultipartFile = "+uploadFile[1].getContentType());
		
		//파일 업로드할 경로 지정
		String uploadFolder="C:\\upload";
			
		for(MultipartFile multiparFile : uploadFile) { // uploadFile의 매개변수에 저장된 배열을 multipartFile에 대입하여 순서대로 출력
			System.out.println(multiparFile);
			//사용자가 업로드한 실제 파일 이름 
			System.out.println("MultipartFile = "+multiparFile.getOriginalFilename());
			//사용자가 업로드한 실제 파일 크기
			System.out.println("MultipartFile = "+multiparFile.getSize());
			//사용자가 업로드한 실제 파일 양식
			System.out.println("MultipartFile = "+multiparFile.getContentType());
			
			//File : 파일을 입/출력 담당 클래스
			//uploadFolder에 저장되어 있는 경로로 '실제 파일명으로 저장'
			File saveFile = new File(uploadFolder,multiparFile.getOriginalFilename());
			
			//transferTo() 라는 메소드를 사용해서 '원하는 위치에 저장'하는데, 이것을 사용하기위해선 예외처리를 해주어야 함.
			try {
				multiparFile.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}// end try
		}// for문 end
	}
	
	// uploadAjax.jsp의 form태그를 이용해서 파일 업로드 Controller
	@PostMapping("uploadAjax")
	public void uploadAjaxAction(MultipartFile[] uploadFile) {
		String uploadFolder="C:\\upload";
		
		for(MultipartFile multiparFile : uploadFile) { // uploadFile의 매개변수에 저장된 배열을 multipartFile에 대입하여 순서대로 출력
			System.out.println(multiparFile);
			//사용자가 업로드한 실제 파일 이름 
			System.out.println("MultipartFile = "+multiparFile.getOriginalFilename());
			//사용자가 업로드한 실제 파일 크기
			System.out.println("MultipartFile = "+multiparFile.getSize());
			//사용자가 업로드한 실제 파일 양식
			System.out.println("MultipartFile = "+multiparFile.getContentType());
			
			//File : 파일을 입/출력 담당 클래스
			//uploadFolder에 저장되어 있는 경로로 '실제 파일명으로 저장'
			File saveFile = new File(uploadFolder,multiparFile.getOriginalFilename());
			
			//transferTo() 라는 메소드를 사용해서 '원하는 위치에 저장'하는데, 이것을 사용하기위해선 예외처리를 해주어야 함.
			try {
				multiparFile.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}// end try
		}// for문 end
	}

}
