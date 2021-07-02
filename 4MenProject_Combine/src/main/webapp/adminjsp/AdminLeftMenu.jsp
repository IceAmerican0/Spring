<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 				
                    <ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
                        <li style="background-color: #000; color:#fff;" id="adminMenuTitle">
                           <a href="/MacaronicsServlet?command=admin_product_list" style="color:#fff;"> 관리자 메뉴</a>
                        </li>
                        <li ${param.command.contains("product")==true ? "class='active'" :'' }>
                            <a href="/MacaronicsServlet?command=admin_product_list"><i class="icon-chevron-right"></i>상품리스트</a>
                        </li>
                        <li ${param.command=='admin_order_list' ? "class='active'" :'' }>
                            <a href="/MacaronicsServlet?command=admin_order_list"><i class="icon-chevron-right"></i>주문리스트</a>
                        </li>
                        <li ${param.command=='admin_member_list' ? "class='active'" :'' }>
                            <a href="/MacaronicsServlet?command=admin_member_list"><i class="icon-chevron-right"></i>회원리스트</a>
                        </li>
                        <li ${param.command.contains("qna")==true  ? "class='active'" :'' }>
                            <a href="/MacaronicsServlet?command=admin_qna_list"><i class="icon-chevron-right"></i>Q&A리스트</a>
                        </li>
                  </ul>