//=========================유효성 검사==================================
function inputCheck(){
	var form=document.loginForm;
	
	var idJ=/^[a-z]{4,12}$/; //아이디체크 영어로만 4~12자리
	var pwJ=/^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{6,20}$/; //비밀번호체크 모든문자 6~20자리
 	
	if(idJ.test(form.userId.value)==false){
		alert("영어 소문자와 4~12자리로 아이디를 입력해주세요! ");
		form.userId.select();
		return false;
	}
	if(pwJ.test(form.userPw.value)==false){
		alert("영어,숫자,특수문자 중 2가지 이상 6~20자리의 비밀번호를 입력해주세요! ");
		form.userPw.select();
		return false;
	 }
	
	form.submit();
}
