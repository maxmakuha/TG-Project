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
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">var timetableSemester = ${timetable.semester.id}</script>
<script type="text/javascript">var timetableId = ${timetable.id}</script>
<script type="text/javascript">var timetableYear = ${timetable.year.title}</script>
<script type="text/javascript"
	src="<c:url value="/resources/js/pages/teachTimetable.js"/>"></script>
<%@include file="footer.jsp"%>