//==============켜졌을때 오늘날짜 달력에 바로 입력==============
window.onload=function(){
	var today=new Date();
	
	var todayDate = today.toISOString().slice(0, 10); // 년 월 일 10자리까지 가져옴
	
	bir = document.getElementById("today");
	
	bir.value = todayDate;
	
	bir.min=todayDate;
	
	var monthLater=new Date(now.setMonth(now.getMonth()+1));
	var monthLaterDate=monthLater.toISOString().slice(0, 10);
	console.log(monthLaterDate);
	bir.max=monthLaterDate;
}




//===============로그아웃=====================
function user_Logout(){
  			location.href="user_Logout";
}

//===============항공편 조회 유효성 검사===================
function formChk(){
	var form=document.flightFindForm;
	
	if(form.from.value==""){
		alert("출발지를 선택해주세요!");
		return false;
	}
	
	if(form.to.value==""){
		alert("도착지를 선택해주세요!");
		return false;
	}
	
	form.submit();
}

//===============출발지 선택시 도착지 변경====================
function Change(e){
	var to_Jeju=["CJU(제주)"];
	var to_Incheon=["ICN(인천)"];
	var target=document.getElementById("to");
	
	if(e.value=="ICN(인천)") var to=to_Jeju;
	else if(e.value=="CJU(제주)") var to=to_Incheon;
	else if(e.value=="") var to=["도착지를 선택해주세요"];
	
	target.options.length=0;
	
	for(x in to){
		var opt=document.createElement("option");
		opt.value=to[x];
		opt.innerHTML=to[x];
		target.appendChild(opt);
	}
}