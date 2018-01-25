<%@include file="header.jsp"%>
<div class="container">
	<div class="wrapper">
		<div class="above-grid" style="text-align: center">
			<label>My Subjects</label>
		</div>
		<div class="simple-grid" id="subjectGrid"></div>
	</div>
	<div class="modal fade">
		<select class="form-control" id="subject-year" name="subject-year">
			<c:forEach var="year" items="${years}">
				<option value="<c:out value="${year.id}" />"><c:out
						value="${year.title}" /></option>
			</c:forEach>
		</select> <select class="form-control" id="subject-program"
			name="subject-program">
			<c:forEach var="program" items="${programs}">
				<option value="<c:out value="${program.id}" />"><c:out
						value="${program.title}" /></option>
			</c:forEach>
		</select> <select class="form-control" id="subject-course"
			name="subject-course">
			<c:forEach var="course" items="${courses}">
				<option value="<c:out value="${course.id}" />"><c:out
						value="${course.title}" /></option>
			</c:forEach>
		</select> <select class="form-control" id="subject-semester"
			name="subject-semester">
			<c:forEach var="semester" items="${semesters}">
				<option value="<c:out value="${semester.id}" />"><c:out
						value="${semester.title}" /></option>
			</c:forEach>
		</select>
	</div>
</div>
<script type="text/javascript"
	src="<c:url value="/resources/js/pages/teachSubjects.js"/>"></script>
<%@include file="footer.jsp"%>