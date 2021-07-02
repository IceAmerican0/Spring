<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%
	request.setCharacterEncoding("utf-8");
	int maxSize = 1024*1024*5; 
	String encType = "utf-8"; 
	String savefile = "img"; 
	ServletContext scontext = getServletContext(); 
	String realFolder = scontext.getRealPath(savefile); 
	MultipartRequest multi=null;
	
	System.out.println(realFolder);
	
	String subject="";
	String content="";
	String fileName="";
	String uploadFile="";
	 
	try{ 
	multi=new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy()); 
	subject=multi.getParameter("subject");
	content=multi.getParameter("content");
	fileName=multi.getParameter("fileName");
	uploadFile=multi.getParameter("fileName");
	} catch(Exception e) { 
	e.printStackTrace(); 
	} 
	
	
%> --%>
<%
    // 파일이 저장되는 경로
    String path = request.getSession().getServletContext().getRealPath("img");

    int size = 1024 * 1024 * 10; // 저장가능한 파일 크기
    String file = ""; // 업로드 한 파일의 이름(이름이 변경될수 있다)
    String originalFile = ""; // 이름이 변경되기 전 실제 파일 이름
    String subject="";
	String content="";
	

    // 실제로 파일 업로드하는 과정
    try{
        MultipartRequest multi = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());

        Enumeration files = multi.getFileNames();
        String str = (String)files.nextElement(); // 파일 이름을 받아와 string으로 저장

        subject=multi.getParameter("subject");
    	content=multi.getParameter("content");
        file = multi.getFilesystemName(str); // 업로드 된 파일 이름 가져옴
        originalFile = multi.getOriginalFileName(str); // 원래의 파일이름 가져옴

    } catch (Exception e) {
        e.printStackTrace();
    }
    
%>
	제목 : <%=subject %>
	내용 : <%=content %>
	파일 이름 : <%=file%>
	<img src="../img/<%=file%>}" width=400 height=400></img> 
</body>
</html>