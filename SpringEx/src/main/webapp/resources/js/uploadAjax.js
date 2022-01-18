$(document).ready(function() {
	// 파일의 크기와 확장자(jpg..등)를 검사하는 함수 선언
	// 서버에서 설정해놓은 파일크기 설정
	var maxSize=5242880; //5MB
	// 서버에서 허용가능한 확장자 설정(정규식:규칙있는 것에 검증하고자 할 때 쓰는 식)
	var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
	
	function checkExtension(fileSize,fileName){//파일의 크기, 확장자
		//사용자가 선택한 파일의 크기 >= 서버에서 설정해놓은 파일의 크기이면,
		if(fileSize>=maxSize){
			alert("선택하신 파일의 크기가 큽니다.")
			return false;
		}
		//사용자가 선택한 파일의 확장자가 서버에서 설정해놓은 파일의 확장자이면,
		if(regex.test(fileName)){
			alert("해당 종류의 파일은 업로드 할 수 없습니다.")
			return false;
		}
		return true; // 위 if문 2개가 아니면 true값을 던져라.
	}
	
	// 전송버튼을 클릭하면
	$("input[type='submit']").on("click", function() {
		// 가상의 form태그 : formData라는 객체
		var formData = new FormData();
		// <input type="file" name="uploadFile" multiple>을 inputFile변수에 대입하여 선언
		var inputFile = $("input[name='uploadFile']");
		// inputFile변수값에 배열을 설정하고 파일에 대한 정보를 files변수에 대입하여 선언
		var files = inputFile[0].files;
		// 콘솔창에 내가 선택한 파일들에 대한 정보를 띄움
		console.log(files);

		for (var i = 0; i < files.length; i++) {
			if(!checkExtension(files[i].size,files[i].name)){
				// 업로드를 하지않는다.
				return false;
			}
			formData.append("uploadFile", files[i]); // append : 배열에 순서대로
														// 추가하는 역할
		}
		// ajax : 자바스크립트와 컨트롤러 연결하는 역할
		// formData자체를 데이터로 전송하고,
		// formData를 데이터로 전송할때는 processData와 contentType은 반드시 false
		$.ajax({
			url : "uploadAjax",
			type : "post", // 무조건 post
			data : formData,
			processData : false,
			contentType : false,
			success : function(result) { // 성공시 실행할 함수
				console.log(result);
			}
		})
	})
})