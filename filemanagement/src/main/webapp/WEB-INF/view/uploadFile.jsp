<%@page import="jdk.javadoc.doclet.Taglet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form"
    prefix = "form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form:form action ="uploadFile" modelAttribute="fileUploader" enctype="multipart/form-data">
	
	<h1>select the file to upload </h1> <br/>
	
	<input type="file" name="fileAttachment" />
	<form:button>UPLOAD</form:button>
	
	</form:form>
			
</body>
</html>