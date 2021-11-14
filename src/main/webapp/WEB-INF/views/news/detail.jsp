<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
</head>
<body>

	<h1>Detail</h1>
	<h1>${news.title }</h1>
	<h3>
		Created date:
		<fmt:formatDate pattern="yyyy-MM-dd" value="${news.createdDate}" />
	
	</h3>
	<h3>${news.author }</h3>
</body>
</html>