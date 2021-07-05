

//==================주소 api 팝업창 띄우기=================================
function goPopup(){
	// 주소검색을 수행할 팝업 페이지를 호출합니다.
	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
	var pop = window.open("jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	
	// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
    //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
}

//=====================주소 정보 받아서 현 페이지에 정보 등록=======================
function jusoCallBack(roadFullAddr){
	document.registerForm.userAdd.value = roadFullAddr;
}

//=======================유효성 검사==============================

function inputCheck(){
	 var form=document.registerForm;
	
	var idJ=/^[a-z]{4,12}$/; //아이디체크 영어로만 4~12자리
	 var pwJ=/^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{6,20}$/; //비밀번호체크 모든문자 6~20자리
	 var phoneJ=/^\d{11}$/; //전화번호 숫자로만 11자리
	 var birthJ=/^\d{6}$/; //생일 숫자로만 6자리	
	 var nameJ=/^[가-힣]{2,10}$/; //이름 한글로만
	
	if(idJ.test(form.userId.value)==false){
		alert("영어 소문자와 4~12자리로 아이디를 입력해주세요! ");
		form.userId.select();
		return false;
	}
	if(pwJ.test(form.userPw1.value)==false){
		alert("영어,숫자,특수문자 중 2가지 이상 6~20자리의 비밀번호를 입력해주세요! ");
		form.userPw1.select();
		return false;
	}
	if(pwJ.test(form.userPw2.value)==false){
		alert("비밀번호를 한번 더 입력해주세요!");
		form.userPw2.select();
		return false;
	}
	if((form.userPw1.value)!=(form.userPw2.value)){
		alert("비밀번호가 일치하지 않습니다!");
		form.userPw2.select();
		return false;
	}
	if(nameJ.test(form.userName.value)==false){
		alert("한글로 이름을 입력해주세요! ");
		form.userName.select();
		return false;
	}
	if(phoneJ.test(form.userTel.value)==false){
		alert("형식에 맞게 전화번호를 입력해주세요! ex)01012341234");
		form.userTel.select();
		return false;
	}
	if(birthJ.test(form.userBirthday.value)==false){
		alert("형식에 맞게 생일을 입력해주세요! ex)891210");
		form.userBirthday.select();
		return false;
	}
	
	if(form.userEmail1.value.trim()==""){
		alert("이메일을 입력해주세요!");
		form.userEmail1.select();
		return false;
	} 
	 
	if(form.userAdd.value.trim()==""){
		alert("주소를 입력해주세요!");
		form.findButton.select();
		return false;
	}
	
	
	form.submit();
}