<%@include file="header.jsp"%>
<div class="container">
	<div class="wrapper">
		<div class="login-form" style="text-align: center">
			<form name='login' action="j_spring_security_check" method='POST'
				class="form-signin">
				<img src="<c:url value="/resources/img/logo.png"/>"
					class="img-rounded logo-login" />
				<div class="form-group ">
					<input type="text" class="form-control" name="username"
						placeholder="Username" id="UserName"> <i
						class="fa fa-user"></i>
				</div>
				<div class="form-group log-status">
					<input type="password" class="form-control" name="password"
						placeholder="Password" id="Passwod"> <i class="fa fa-lock"></i>
				</div>
				<br>
				<button type="Submit" class="btn btn-primary" name="Submit"
					value="Login" type="Submit" style="width: 100px">Log in</button>
				<br><br><br>
				
				<c:if test="${not empty error}">
					<div class="error">${error}</div>
				</c:if>
				<c:if test="${not empty logout}">
					<div class="msg">${logout}</div>
				</c:if>

			</form>
		</div>
	</div>
</div>
<%@include file="footer.jsp"%>