<%@include file="header.jsp"%>
<div class="container">
	<div class="wrapper">
		<div class="above-grid" style="text-align: center">
			<label>"${subject.title}" Groups</label>
			<button type="button" class="btn btn-primary" data-toggle="modal"
				style="float: right" data-target="#addDialog">Add</button>
		</div>
		<div class="simple-grid" id="groupGrid"></div>
	</div>
	<div class="modal fade" id="addDialog" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Create new group:</h4>
				</div>
				<div class="modal-body">
					<form id="new-group">
						<div class="form-group">
							<label for="group-number">Number:</label> <input type="text"
								class="form-control" id="group-number" name="group-number" />
						</div>
						<div class="form-group">
							<label for="group-size">Size:</label> <input type="number"
								class="form-control" id="group-size" name="group-size" />
						</div>
						<div class="form-group">
							<label for="group-type">Type:</label> <select
								class="form-control" id="group-type" name="group-type">
								<c:forEach var="type" items="${types}">
									<option value="<c:out value="${type.id}" />"><c:out
											value="${type.title}" /></option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="group-teacher">Teacher:</label> <select
								class="form-control" id="group-teacher" name="group-teacher">
								<c:forEach var="teacher" items="${teachers}">
									<option value="<c:out value="${teacher.id}" />"><c:out
											value="${teacher.name}" /></option>
								</c:forEach>
							</select>
						</div>
							<div class="form-group">
							<label for="group-audience">Audience Type:</label> <select
								class="form-control" id="group-audience" name="group-audience">
								<c:forEach var="audienceType" items="${audienceTypes}">
									<option value="<c:out value="${audienceType.id}" />"><c:out
											value="${audienceType.title}" /></option>
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
<script type="text/javascript">var subjectId = ${subject.id};</script>
<script type="text/javascript"
	src="<c:url value="/resources/js/pages/methSubjectGroups.js"/>"></script>
<%@include file="footer.jsp"%>