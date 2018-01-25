<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<br>
<br>
<br>
<br>
<br>
<div id='calendar'></div>
<div id="fullCalModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span> <span class="sr-only">close</span></button>
                <h4 id="modalTitle" class="modal-title"></h4>
            </div>
            <div id="modalBody" class="modal-body">
            <strong>Start:</strong> <span id="startTime"></span><br>
    		<strong>End:</strong> <span id="endTime"></span><br><br>
    		<strong>Audience:</strong> <span id="audience"></span><br>
    		<strong>Teacher:</strong> <span id="teacher"></span><br>
    		<span id="periodId" style="display:none"></span>
            </div>
            <div class="modal-footer">
             <button type="button" class="btn btn-danger" onclick="deletePeriod();" data-dismiss="modal">Delete</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="addDialog" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Add new period:</h4>
				</div>
				<div class="modal-body">
					<form id="new-period">
						<div class="form-group">
							<label for="period-lesson">Lesson:</label> <select
								class="form-control" id="period-lesson" name="period-lesson">
								<c:forEach var="lesson" items="${lessons}">
									<option value="<c:out value="${lesson.id}" />"><c:out
											value="${lesson.title}" /></option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="period-group">Group:</label> <select
								class="form-control" id="period-group" name="period-group">
								<c:forEach var="group" items="${groups}">
									<option value="<c:out value="${group.id}" />"><c:out
											value="${group.number}" /></option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="period-audience">Audience:</label> <select
								class="form-control" id="period-audience" name="period-audience">
								<c:forEach var="audience" items="${audiences}">
									<option value="<c:out value="${audience.id}" />"><c:out
											value="${audience.number}" /></option>
								</c:forEach>
							</select>
						</div>
						<span id="newmonth" style="display:none"></span>
						<span id="newday" style="display:none"></span>
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
<script type="text/javascript">var timetableSemester = ${timetable.semester.id}</script>
<script type="text/javascript">var timetableId = ${timetable.id}</script>
<script type="text/javascript">var timetableYear = ${timetable.year.title}</script>
<script type="text/javascript"
	src="<c:url value="/resources/js/pages/methTimetable.js"/>"></script>
<%@include file="footer.jsp"%>