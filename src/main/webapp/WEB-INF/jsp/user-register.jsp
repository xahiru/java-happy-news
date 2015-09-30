<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp"%>



<form:form commandName="user" class="form-horizontal">
	<c:if test="${param.success eq true }">
		<div class="alert alert-success">Registration Successful!!</div>
	</c:if>
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Name:</label>
		<div class="col-sm-10">
			<form:input path="name" class="form-control" />
			<form:errors path="name"/>
		</div>
	</div>
	<div class="form-group">
		<label for="email" class="col-sm-2 control-label">Email:</label>
		<div class="col-sm-10">
			<form:input path="email" class="form-control" />
				<form:errors path="email"/>
		</div>
	</div>

	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Password:</label>
		<div class="col-sm-10">
			<form:password path="password" class="form-control" />
				<form:errors path="password"/>
		</div>
	</div>

	<div class="form-group">

		<div class="col-sm-2">
			<input type="submit" value="Save" class="btn btn-lg btn-primary" />
		</div>
	</div>


</form:form>