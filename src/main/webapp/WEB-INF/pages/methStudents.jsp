<%@include file="header.jsp"%>
<div class="container">
	<div class="wrapper">
		<div class="above-grid" style="text-align: center">
			<label>Students</label>
			<button type="button" class="btn btn-primary" data-toggle="modal"
				style="float: right" data-target="#addDialog">Add</button>
		</div>
		<div class="simple-grid" id="studentGrid"></div>
	</div>
	<div class="modal fade" id="addDialog" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Add new student:</h4>
				</div>
				<div class="modal-body">
					<form id="new-student">
						<div class="form-group">
							<label for="student-name">Name:</label> <input type="text"
								class="form-control" id="student-name" name="student-name" />
						</div>
						<div class="form-group">
							<label for="student-email">E-mail:</label> <input type="email"
								class="form-control" id="student-email" name="student-email" />
						</div>
						<div class="form-group">
							<label for="student-course">Course:</label> <select
								class="form-control" id="student-course" name="student-course">
								<c:forEach var="course" items="${courses}">
									<option value="<c:out value="${course.id}" />"><c:out
											value="${course.title}" /></option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="student-program">Program:</label> <select
								class="form-control" id="student-program" name="student-program">
								<c:forEach var="program" items="${programs}">
									<option value="<c:out value="${program.id}" />"><c:out
											value="${program.title}" /></option>
								</c:forEach>
							</select>
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
	src="<c:url value="/resources/js/pages/methStudents.js"/>"></script>
<%@include file="footer.jsp"%>