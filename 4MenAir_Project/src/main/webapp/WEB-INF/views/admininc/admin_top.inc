<%@ page contentType="text/html; charset=utf-8" language="java"  %>
      <tr>
        <td height="67"><table width="815" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="223" height="67" rowspan="2" align="center"><a href="Admin_Index.jsp"><img src="adminImg/logo.JPG" width=60% border="0" /></a></td>
          </tr>
          <tr>
            <td>
            <ul class="ul">
             <li class="list">| <a href="goodslist.jsp" class="navi">상품리스트</a></li>
             <li class="list">| <a href="goodsinfo_insert2.jsp" class="navi">상품등록</a></li>
             <li class="list">| 
	     
	    <%
		String admin_id = (String)session.getAttribute("adminId");
		if (admin_id == null)	
			out.print("<a href = \"Admin_Login.jsp\"  class = \"navi\">로그인</a></li>");
		else
			out.print("<a href = \"Admin_Logout.jsp\" class = \"navi\">로그아웃</a></li>");
	    %>
          </td>
          </tr>
        </table></td>
      </tr>