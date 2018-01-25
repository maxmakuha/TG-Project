<%@include file="header.jsp"%>
<div class="container">
	<div class="wrapper">
		<div class="above-grid" style="text-align: center">
			<label>Teachers</label>
			<button type="button" class="btn btn-primary" data-toggle="modal"
				style="float: right" data-target="#addDialog">Add</button>
		</div>
		<div class="simple-grid" id="teacherGrid"></div>
	</div>
	<div class="modal fade" id="addDialog" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Add new teacher:</h4>
				</div>
				<div class="modal-body">
					<form id="new-teacher">
						<div class="form-group">
							<label for="teacher-name">Name:</label> <input type="text"
								class="form-control" id="teacher-name" name="teacher-name" />
						</div>
						<div class="form-group">
							<label for="teacher-email">E-mail:</label> <input type="email"
								class="form-control" id="teacher-email" name="teacher-email" />
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default"
						onclick="onCreateVerify();">Save</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript"
	src="<c:url value="/resources/js/pages/methTeachers.js"/>"></script>
<%@include file="footer.jsp"%>