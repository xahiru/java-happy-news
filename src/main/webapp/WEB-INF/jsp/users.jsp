<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp"%>

<script type="text/javascript">
$(document).ready(function(){
	
	$('.triggerRemove').click(function(e){
		e.preventDefault();
		$('#modalRemove .removeBtn').attr('href', $(this).attr('href'));
		$('#modalRemove').modal();
	});
});
</script>
<body>
	<table class="table  table-bordered table-striped table-hover ">
		<thead>
			<tr>
				<td>Usernames</td>
				<td>Action</td>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>

					<td><a
						href="<spring:url value="/happynews/users/${user.id}.html"/>">${user.name}</a>
					</td>
					<td>
					<a class="btn btn-danger triggerRemove" href='<spring:url value="/happynews/user/remove/${user.id }.html"/>'>remove</a>
			
					</td>

				</tr>
			</c:forEach>
		</tbody>

	</table>
	<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Remove user</h4>
      </div>
      <div class="modal-body">
        Are you sure to permanently delete this user?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
       <a class="btn btn-danger removeBtn" href="">Remove</a>
      </div>
    </div>
  </div>
</div>
	
</body>
</html>