//=======================유효성 검사==============================
function inputCheck(){
	 var form=document.idFindForm;
	
	 var phoneJ=/^\d{11}$/; //전화번호 숫자로만 11자리
	 var nameJ=/^[가-힣]{2,6}$/; //이름 한글로만
	 var emailJ = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])$/i; //이메일체크
	
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
	
	if(form.userEmail1.value.trim()==""){
		alert("이메일을 입력해주세요!");
		form.userEmail1.select();
		return false;
	}	
	form.submit();
}