<%@include file="header.jsp"%>
<div class="container">
	<div class="wrapper">
		<div class="above-grid" style="text-align: center">
			<label>Audiences</label>
			<button type="button" class="btn btn-primary" data-toggle="modal"
				style="float: right" data-target="#addDialog">Add</button>
		</div>
		<div class="simple-grid" id="audienceGrid"></div>
	</div>
	<div class="modal fade" id="addDialog" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Create new audience:</h4>
				</div>
				<div class="modal-body">
					<form id="new-audience">
						<div class="form-group">
							<label for="audience-number">Number:</label> <input type="text"
								class="form-control" id="audience-number" name="audience-number" />
						</div>
						<div class="form-group">
							<label for="audience-size">Size:</label> <input type="number"
								class="form-control" id="audience-size" name="audience-size" />
						</div>
						<div class="form-group">
							<label for="audience-type">Type:</label> <select
								class="form-control" id="audience-type" name="audience-type">
								<c:forEach var="type" items="${types}">
									<option value="<c:out value="${type.id}" />"><c:out
											value="${type.title}" /></option>
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
	src="<c:url value="/resources/js/pages/methAudiences.js"/>"></script>
<%@include file="footer.jsp"%>