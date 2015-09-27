<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="table  table-bordered table-striped table-hover ">
		<thead>
			<tr><td>Usernames</td></tr>
		</thead>

		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					
					<td>${user.name}</td>

				</tr>
			</c:forEach>
		</tbody>

	</table>
</body>
</html>