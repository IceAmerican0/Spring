//=======================유효성 검사==============================
function inputCheck(){
	 var form=document.pwFindForm;
	
	 var idJ=/^[a-z]{4,12}$/; //아이디체크 영어로만 4~12자리
	 var phoneJ=/^\d{11}$/; //전화번호 숫자로만 11자리
	 var emailJ = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])$/i; //이메일체크
	
	 if(idJ.test(form.userId.value)==false){
			alert("영어 소문자와 4~12자리로 아이디를 입력해주세요! ");
			form.userId.select();
			return false;
		}
	if(phoneJ.test(form.userTel.value)==false){
		alert("형식에 맞게 전화번호를 입력해주세요! ex)01012341234");
		form.userTel.select();
		return false;
	}
	
	if(form.userEmail1.value.trim()==""){
		alert("이메일을 입력해주세요!");
		form.userEmail1.select();
		return false;
	}
	form.submit();
}