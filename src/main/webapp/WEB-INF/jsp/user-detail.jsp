<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp"%>



<div>

<script type="text/javascript">
$(document).ready(function(){
	$('.nav-tabs a:first').tab('show');
	$('.triggerRemove').click(function(e){
		e.preventDefault();
		$('#modalRemove .removeBtn').attr('href', $(this).attr('href'));
		$('#modalRemove').modal();
	});
});
</script>


	<!-- Nav tabs -->
	<ul class="nav nav-tabs" role="tablist">
		<c:forEach items="${user.blogs }" var="blog">
			<li role="presentation"><a href="#blog_${blog.id}"
				aria-controls="settings" role="tab" data-toggle="tab">${blog.name}</a></li>

		</c:forEach>
	</ul>



	<!-- Tab panes -->
	<div class="tab-content">
		<c:forEach items="${user.blogs }" var="blog">
			<div role="tabpanel" class="tab-pane" id="blog_${blog.id}">

				<h1></h1>
				<p>
				<a class="btn btn-danger triggerRemove" href='<spring:url value="/happynews/blog/remove/${blog.id }.html"/>'>remove</a>
				${blog.url}</p>

				<table class="table  table-bordered table-striped table-hover">
					<thead>
						<tr>
							<td>Title</td>

							<td>Link</td>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${blog.items}" var="item">
							<tr>
								<td>${item.title}</td>
								<td>${item.link}</td>
							</tr>

						</c:forEach>
					</tbody>
				</table>


			</div>


		</c:forEach>
	</div>

</div>


<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Remove Blog</h4>
      </div>
      <div class="modal-body">
        Are you sure to permanently delete this blog?
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