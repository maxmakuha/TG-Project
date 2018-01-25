<%@include file="header.jsp"%>
<div class="container">
	<div class="wrapper">
		<div class="jumbotron">
			<img src="<c:url value="/resources/img/logo.png"/>"
				class="img-rounded main-logo" />
			<h2 class="welcome-header">Welcome to Timetable Generator!</h2>
			<security:authorize access="isAnonymous()">
				<p class="text">Please log in to get started</p>
				<div class="text-center">
					<a class="btn btn-large btn-primary btn-log-in"
						href="<c:url value="/login"/>">Log In</a>
				</div>
			</security:authorize>
		</div>
	</div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
