<%@include file="header.jsp"%>
<div class="container">
	<div class="wrapper">
		<div id="tabs">
			<ul>
				<li><a href="#tabs-1">Students</a></li>
				<li><a href="#tabs-2">Rhythm</a></li>
			</ul>
			<div id="tabs-1">
				<div class="above-grid" style="text-align: center">
					<label>"${group.number}" Students</label>
				</div>
				<div class="simple-grid" id="groupStudentsGrid"></div>
			</div>
			<div id="tabs-2">
				<div align="center">
					<div class="above-grid" style="width: 60%">
						<label>"${group.number}" Rhythm</label>
						<button type="button" class="btn btn-primary" data-toggle="modal"
							style="float: right; font-size: 10pt;" data-target="#addDialog">Add</button>
					</div>
					<div class="simple-grid" id="groupRhythmGrid"></div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade">
		<select class="form-control" id="student-course" name="student-course">
			<c:forEach var="course" items="${courses}">
				<option value="<c:out value="${course.id}" />"><c:out
						value="${course.title}" /></option>
			</c:forEach>
		</select> <select class="form-control" id="student-program"
			name="student-program">
			<c:forEach var="program" items="${programs}">
				<option value="<c:out value="${program.id}" />"><c:out
						value="${program.title}" /></option>
			</c:forEach>
		</select>
	</div>
	<div class="modal fade" id="addDialog" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Add new rhythm:</h4>
				</div>
				<div class="modal-body">
					<form id="new-rhythm">
						<div class="form-group">
							<label for="rhythm-week">Week:</label> <select
								class="form-control" id="rhythm-week" name="rhythm-week">
								<c:forEach var="week" items="${weeks}">
									<option value="<c:out value="${week.id}" />"><c:out
											value="${week.title}" /></option>
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
<script type="text/javascript">var subjectId = ${group.subject.id};</script>
<script type="text/javascript">var groupId = ${group.id};</script>
<script>
	$(function() {
		$("#tabs").tabs();
	});
</script>
<style>
#tabs .ui-state-active {
	background: #3F729B;
	border: none;
}
</style>
<script type="text/javascript"
	src="<c:url value="/resources/js/pages/teachSubjectGroupStudents.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/pages/teachSubjectGroupRhythm.js"/>"></script>
<%@include file="footer.jsp"%>