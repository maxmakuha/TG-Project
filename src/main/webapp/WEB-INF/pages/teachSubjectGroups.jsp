<%@include file="header.jsp"%>
<div class="container">
	<div class="wrapper">
		<div class="above-grid" style="text-align: center">
			<label>My "${subject.title}" Groups</label>
		</div>
		<div class="simple-grid" id="groupGrid"></div>
	</div>
	<div class="modal fade">
		<select class="form-control" id="group-type" name="group-type">
			<c:forEach var="type" items="${types}">
				<option value="<c:out value="${type.id}" />"><c:out
						value="${type.title}" /></option>
			</c:forEach>
		</select> <select class="form-control" id="group-audience"
			name="group-audience">
			<c:forEach var="audienceType" items="${audienceTypes}">
				<option value="<c:out value="${audienceType.id}" />"><c:out
						value="${audienceType.title}" /></option>
			</c:forEach>
		</select>
	</div>
</div>
<script type="text/javascript">var subjectId = ${subject.id};</script>
<script type="text/javascript"
	src="<c:url value="/resources/js/pages/teachSubjectGroups.js"/>"></script>
<%@include file="footer.jsp"%>