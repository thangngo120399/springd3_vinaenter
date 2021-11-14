<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="<%=request.getContextPath()%>" var="url"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<c:if test="${not empty msgError }">
		<div class="alert alert-danger" role="alert">${msgError }</div>
	</c:if>

	<h1>List</h1>
	<div style="margin: 20px">
		<c:if test="${not empty msgSuccess }">
			<div class="alert alert-success" role="alert">${msgSuccess }</div>
		</c:if>

		<a href="${pageContext.request.contextPath }/news/add"
			class="btn btn-info"> Add</a>
	</div>
	<c:choose>
		<c:when test="${not empty list }">
			<ul>
				<c:forEach items="${list }" var="news">
					<li class="list-group-item"><a
						href="${url}/news/detail/${news.id}"> <c:choose>
								<c:when test="${news.picture == null }">
									<b style="margin-right: 180px">
										Chưa có ảnh</b>
								</c:when>
								<c:otherwise>
									<img style="width: 250px; height: 200px; margin-right: 20px"
										src="${pageContext.request.contextPath }/resources/${news.picture}" />
										
								
								</c:otherwise>
							</c:choose>
							${news.title } - ${news.author} 
					</a></li>

				</c:forEach>
			</ul>
		</c:when>
		<c:otherwise>
			<h3 style="color: red">LIST IS EMPTY!!!</h3>
		</c:otherwise>
	</c:choose>

</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5s.mXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
</html>