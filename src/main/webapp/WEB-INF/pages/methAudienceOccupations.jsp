<%@include file="header.jsp"%>
<div class="container">
	<div class="wrapper">
		<div class="above-grid" style="text-align: center">
			<label>Audience "${audience.number}" Occupations</label>
			<button type="button" class="btn btn-primary" data-toggle="modal"
				style="float: right" data-target="#addDialog">Add</button>
		</div>
		<div class="simple-grid" id="occupationGrid"></div>
	</div>
	<div class="modal fade" id="addDialog" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Add new occupation:</h4>
				</div>
				<div class="modal-body">
					<form id="new-occupation">
						<div class="form-group">
							<label for="occupation-day">Day:</label> <select
								class="form-control" id="occupation-day" name="occupation-day">
								<c:forEach var="day" items="${days}">
									<option value="<c:out value="${day.id}" />"><c:out
											value="${day.title}" /></option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="occupation-lesson">Lesson:</label> <select
								class="form-control" id="occupation-lesson" name="occupation-lesson">
								<c:forEach var="lesson" items="${lessons}">
									<option value="<c:out value="${lesson.id}" />"><c:out
											value="${lesson.title}" /></option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="occupation-comment">Comment:</label> <input type="text"
								class="form-control" id="occupation-comment" name="occupation-comment" />
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
<script type="text/javascript">var audienceId = ${audience.id};</script>
<script type="text/javascript"
	src="<c:url value="/resources/js/pages/methAudienceOccupations.js"/>"></script>
<%@include file="footer.jsp"%>