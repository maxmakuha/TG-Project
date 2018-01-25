<%@include file="header.jsp"%>
<div class="container">
	<div class="wrapper">
		<div class="above-grid" style="text-align: center">
			<label>Subjects</label>
			<button type="button" class="btn btn-primary" data-toggle="modal"
				style="float: right" data-target="#addDialog">Add</button>
		</div>
		<div class="simple-grid" id="subjectGrid"></div>
	</div>
	<div class="modal fade" id="addDialog" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Create new subject:</h4>
				</div>
				<div class="modal-body">
					<form id="new-subject">
						<div class="form-group">
							<label for="subject-title">Title:</label> <input type="text"
								class="form-control" id="subject-title" name="subject-title" />
						</div>
						<div class="form-group">
							<label for="subject-lectures">Lecture Hours:</label> <input type="number"
								class="form-control" id="subject-lectures" name="subject-lectures" />
						</div>
						<div class="form-group">
							<label for="subject-practices">Practice Hours:</label> <input type="number"
								class="form-control" id="subject-practices" name="subject-practices" />
						</div>
						<div class="form-group">
							<label for="subject-year">Year:</label> <select
								class="form-control" id="subject-year" name="subject-year">
								<c:forEach var="year" items="${years}">
									<option value="<c:out value="${year.id}" />"><c:out
											value="${year.title}" /></option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="subject-program">Program:</label> <select
								class="form-control" id="subject-program" name="subject-program">
								<c:forEach var="program" items="${programs}">
									<option value="<c:out value="${program.id}" />"><c:out
											value="${program.title}" /></option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="subject-course">Course:</label> <select
								class="form-control" id="subject-course" name="subject-course">
								<c:forEach var="course" items="${courses}">
									<option value="<c:out value="${course.id}" />"><c:out
											value="${course.title}" /></option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="subject-semester">Semester:</label> <select
								class="form-control" id="subject-semester" name="subject-semester">
								<c:forEach var="semester" items="${semesters}">
									<option value="<c:out value="${semester.id}" />"><c:out
											value="${semester.title}" /></option>
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
	src="<c:url value="/resources/js/pages/methSubjects.js"/>"></script>
<%@include file="footer.jsp"%>