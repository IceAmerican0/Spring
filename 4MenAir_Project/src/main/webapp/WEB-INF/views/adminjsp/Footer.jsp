<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<div style="margin-bottom: 150px;">
&nbsp;
</div>
  
     <!-- FOOTER -->
<nav class="avbar navbar-inverse navbar-fixed-bottom" style="margin-top: 50px; ">
  <div class="container text-center" style="color:#fff;">
  <p>&nbsp;</p>
   <p ><a href="http://macaronics.net/" style="color:#fff;">Macaronics.net</a></p>  
    <p>&nbsp;</p>
  </div>
</nav>

  

  <!-- Login Modal -->  
  <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">                      
        <div class="modal-body">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4>로그인</h4>
          <form class="aa-login-form" action="">
            <label for="">아이디<span>*</span></label>
            <input type="text" placeholder="아이디">
            <label for="">비밀번호<span>*</span></label>
            <input type="password" placeholder="비밀번호">
            <button class="aa-browse-btn" type="submit">로그인</button>
            <label for="rememberme" class="rememberme"></label>

            <div class="aa-register-now">
                   계정이 없습니까?<a href="${request.getContextPath() }/MacaronicsServlet?command=join_form">회원가입하기</a>
            </div>
          </form>
        </div>                        
      </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
  </div>    






  <!-- jQuery library -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="../dailyShop/js/bootstrap.js"></script>  
  <!-- SmartMenus jQuery plugin -->
  <script type="text/javascript" src="../dailyShop/js/jquery.smartmenus.js"></script>
  <!-- SmartMenus jQuery Bootstrap Addon -->
  <script type="text/javascript" src="../dailyShop/js/jquery.smartmenus.bootstrap.js"></script>  
  <!-- To Slider JS -->
  <script src="../dailyShop/js/sequence.js"></script>
  <script src="../dailyShop/js/sequence-theme.modern-slide-in.js"></script>  
  <!-- Product view slider -->
  <script type="text/javascript" src="../dailyShop/js/jquery.simpleGallery.js"></script>
  <script type="text/javascript" src="../dailyShop/js/jquery.simpleLens.js"></script>
  <!-- slick slider -->
  <script type="text/javascript" src="../dailyShop/js/slick.js"></script>
  <!-- Price picker slider -->
  <script type="text/javascript" src="../dailyShop/js/nouislider.js"></script>
  <!-- Custom js -->
  <script src="../dailyShop/js/custom.js"></script> 


<script>
//장바구니 에 담기

function go_cart(){
	var loginUser='${sessionScope.loginUser}';
	if(loginUser==null || loginUser==''){
		alert("로그인을 먼저 하세요.");
		return;
	}
	if(document.formm.quantity.value==""){
		alert("수량을 입력하여 주세요.");
		document.formm.quantity.focus();
	}else{
		$("input[name=command]").val("cart_insert");
		document.formm.submit();
	
	}
	
}

$(function(){

	
	$(".cart-ajax").click(function(event){
		event.preventDefault();
		pseq=$(this).attr("data-pseq");
		
		$.ajax({
			url:"MacaronicsServlet?command=cart_ajax",
			type:"post",
			dataType:"text",
			data : {
				pseq:pseq,
				quantity:1
			},
			success:function(result){
				
				if($.trim(result)=='success'){
					if(confirm("장바구니에 담았습니다. 장바구니로 이동하시겠습니까?")){
						
						location.href="/MacaronicsServlet?command=cart_list";
					}		
				}else{
					alert($.trim(result));
				}
			}
		});
	});

	

});
function go_cart_delete(cseq){
	
	if(confirm("정말 삭제하시겠습니까?")){
		location.href="MacaronicsServlet?command=cart_delete&cseq="+cseq;		
	}
	
}

function go_cart_all_delete(){
	
	if(confirm("정말 삭제하시겠습니까?")){
		document.form1.submit();
	}
	
}

function go_cart_ajax_delete(cseq){
	
	if(confirm("정말 삭제하시겠습니까?")){
		
		$.ajax({
			url:"MacaronicsServlet?command=cart_delete_ajax",
			type:"post",
			data:{cseq:cseq},
			success:function(result){
				if($.trim(result)=='success'){
					alert("삭제 했습니다.")
					location.reload();
				}				
			}
			
		});
		
	}
	
}
 
</script>


  </body>
</html>

