<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
      <div class="col-lg-3 col-md-3 col-sm-4 col-md-pull-9">
        <aside class="aa-sidebar">
          <!-- single sidebar -->
          <div class="aa-sidebar-widget">
            <h3>나의 페이지</h3>
            <ul class="aa-catg-nav">      
           <li><a href="MacaronicsServlet?command=cart_list">장바구니(cart)내역</a></li>
            <li><a href="MacaronicsServlet?command=mypage">진행중인 주문내역</a></li>
            <li><a href="MacaronicsServlet?command=order_all">총 주문내역</a></li>    
             <li><a href="MacaronicsServlet?command=qna_list">Q&A 게시글 리스트</a></li>
             <li><a href="MacaronicsServlet?command=qna_write_form">Q&A 게시글 쓰기</a></li>          
            </ul>
          </div>
       </aside>         
      </div>