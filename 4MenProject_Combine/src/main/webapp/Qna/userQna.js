function deleteAction(){//삭제 확인 창 띄우기
	var form=document.qnaDelete;
	
	if(confirm("문의 사항을 삭제하시겠습니까?")==true) {
		form.submit();
	}else{
		return;
	} 
}

function write(){
	var form=document.qnawrite;
	
	form.submit();
}