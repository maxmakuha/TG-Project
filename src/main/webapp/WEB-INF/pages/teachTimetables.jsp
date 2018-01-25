<%@include file="header.jsp"%>
<div class="container">
	<div class="wrapper">
		<div class="above-grid" style="text-align: center">
			<label>Timetables</label>
		</div>
		<div class="simple-grid" id="timetableGrid"></div>
	</div>
	<div class="modal fade">
		<select class="form-control" id="timetable-year" name="timetable-year">
			<c:forEach var="year" items="${years}">
				<option value="<c:out value="${year.id}" />"><c:out
						value="${year.title}" /></option>
			</c:forEach>
		</select> <select class="form-control" id="timetable-program"
			name="timetable-program">
			<c:forEach var="program" items="${programs}">
				<option value="<c:out value="${program.id}" />"><c:out
						value="${program.title}" /></option>
			</c:forEach>
		</select> <select class="form-control" id="timetable-course"
			name="timetable-course">
			<c:forEach var="course" items="${courses}">
				<option value="<c:out value="${course.id}" />"><c:out
						value="${course.title}" /></option>
			</c:forEach>
		</select> <select class="form-control" id="timetable-semester"
			name="timetable-semester">
			<c:forEach var="semester" items="${semesters}">
				<option value="<c:out value="${semester.id}" />"><c:out
						value="${semester.title}" /></option>
			</c:forEach>
		</select>
	</div>
</div>
<script type="text/javascript"
	src="<c:url value="/resources/js/pages/teachTimetables.js"/>"></script>
<%@include file="footer.jsp"%>