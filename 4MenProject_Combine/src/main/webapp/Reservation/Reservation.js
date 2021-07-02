function payCancel(){//결제 취소 확인 창 띄우기
	var form=document.cancelAction;
	
	if(confirm("결제를 취소하시겠습니까?")==true) {
		form.submit();
	}else{
		return;
	} 
}