<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<table class="table  table-bordered table-striped table-hover ">
		<thead>
			<tr>
				<td>Usernames</td>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>

					<td><a
						href="<spring:url value="/happynews/users/${user.id}.html"/>">${user.name}</a>
					</td>

				</tr>
			</c:forEach>
		</tbody>

	</table>
</body>
</html>