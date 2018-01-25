<%@include file="header.jsp"%>
<br>
<br>
<div class="container">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<div class="above-grid" style="text-align: center">
					<label>${user.name}</label> <input type="hidden"
						value="${user.name}" class="form-control" id="profile-name"
						name="profile-name" />
				</div>
			</div>
			<div class="modal-body">
				<form id="profile">
					<div class="form-group">
						<label for="profile-email">E-mail:</label> <input type="email"
							value="${user.email}" class="form-control" id="profile-email"
							name="profile-email" required maxlength="64" />
					</div>
					<div class="form-group">
						<label for="profile-mobile">Mobile:</label> <input type="text"
							value="${user.mobile}" class="form-control" id="profile-mobile"
							name="profile-mobile" maxlength="15" />
					</div>
					<div class="form-group">
						<label for="profile-address">Address:</label> <input type="text"
							value="${user.address}" class="form-control" id="profile-address"
							name="profile-address" maxlength="15" />
					</div>
					<div class="form-group">
						<label for="profile-comment">Comment:</label>
						<textarea class="form-control" id="profile-comment"
							name="profile-comment" maxlength="100"
							style="height: 100px; resize: none;" disabled>${user.comment}</textarea>
					</div>
					<div class="form-group">
						<label for="profile-password">New Password:</label> <input
							type="password" class="form-control" id="profile-password"
							name="profile-password" placeholder="New Password" maxlength="64" />
					</div>
					<div class="form-group">
						<label for="profile-confirm">Confirm Password:</label> <input
							type="password" class="form-control" id="profile-confirm"
							name="profile-confirm" placeholder="Confirm password"
							maxlength="64" />
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default"
					onclick="updateVerify();">Update</button>
				<button type="button" class="btn btn-default" onclick="goBack();">Back</button>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">var id = ${user.id};</script>
<script type="text/javascript">var roleId = ${user.role.id};</script>
<script type="text/javascript"
	src="<c:url value="/resources/js/pages/methStudentInfo.js"/>"></script>
<%@include file="footer.jsp"%>