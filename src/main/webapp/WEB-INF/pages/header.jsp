<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<link rel="shortcut icon"
	href="<c:url value="/resources/img/icon.ico"/>" type="image/x-icon">
<link rel="stylesheet"
	href="<c:url value="/resources/style/style.css"/>">
<link rel="stylesheet/less" type="text/css"
	href="<c:url value="/resources/style/nav.less" />">
<link rel="stylesheet/less" type="text/css"
	href="<c:url value="/resources/style/footer.less" />">
<link rel="stylesheet/less" type="text/css"
	href="<c:url value="/resources/style/main.less" />">
<link rel="stylesheet/less" type="text/css"
	href="<c:url value="/resources/style/login.less" />">
<link rel="stylesheet/less" type="text/css"
	href="<c:url value="/resources/style/help.less" />">
<link rel="stylesheet/less" type="text/css"
	href="<c:url value="/resources/style/grid.less" />">
<link rel="stylesheet"
	href="<c:url value="/resources/style/style.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/style/bootstrap.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/style/dataTablesCss/dataTables.bootstrap.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/style/dataTablesCss/dataTables.responsive.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/style/dataTablesCss/dataTables.tableTools.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/style/bootstrap-theme.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/js/jqueryui/jquery-ui.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/js/jqueryui/jquery-ui.structure.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/js/jqueryui/jquery-ui.theme.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/style/jsgrid.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/style/jsgrid-theme.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/style/font-awesome.min.css"/>">
<script src="<c:url value="/resources/js/jquery-3.1.1.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script
	src="<c:url value="/resources/js/dataTablesJs/jquery.dataTables.js"/>"></script>
<script
	src="<c:url value="/resources/js/dataTablesJs/dataTables.bootstrap.js"/>"></script>
<script
	src="<c:url value="/resources/js/dataTablesJs/dataTables.responsive.js"/>"></script>
<script
	src="<c:url value="/resources/js/dataTablesJs/dataTables.tableTools.min.js"/>"></script>
<script src="<c:url value="/resources/js/less.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jqueryui/jquery-ui.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jsgrid.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.validate.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/webutils.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/input.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/pages/header.js"/>"></script>

<link rel="stylesheet"
	href="<c:url value="/resources/style/fullcalendar/fullcalendar.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/fullcalendar/moment.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/fullcalendar/fullcalendar.js"/>"></script>

<title>Timetable Generator</title>

</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid grey">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a href="<c:url value="/home"/>"> <img
					src="<c:url value="/resources/img/logo_nav.png"/>"
					class="img-rounded" />
				</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav ">

					<security:authorize access="hasRole('METHODIST')">
						<li class="menu-button"><a
							href="<c:url value="/methodist/timetables"/>">Timetables</a></li>
						<li class="menu-button"><a
							href="<c:url value="/methodist/subjects"/>">Subjects</a></li>
						<li class="menu-button"><a
							href="<c:url value="/methodist/teachers"/>">Teachers</a></li>
						<li class="menu-button"><a
							href="<c:url value="/methodist/students"/>">Students</a></li>
						<li class="menu-button"><a
							href="<c:url value="/methodist/audiences"/>">Audiences</a></li>
					</security:authorize>

					<security:authorize access="hasRole('TEACHER')">
						<li class="menu-button"><a
							href="<c:url value="/teacher/timetables"/>">Timetables</a></li>
						<li class="menu-button"><a
							href="<c:url value="/teacher/subjects"/>">Subjects</a></li>
						<li class="menu-button"><a
							href="<c:url value="/teacher/absences"/>">Absences</a></li>
					</security:authorize>

					<security:authorize access="hasRole('STUDENT')">
						<li class="menu-button"><a
							href="<c:url value="/student/timetables"/>">Timetables</a></li>
					</security:authorize>

				</ul>

				<security:authorize access="isAuthenticated()">
					<ul class="nav navbar-nav navbar-right">
						<li class="right-li">
							<div class="btn-group">
								<button type="button" class="btn dropbtn dropdown-toggle"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">
									<p class="email">
										<span class="glyphicon glyphicon-th" aria-hidden="true"></span>
										&nbsp; ${pageContext.request.userPrincipal.name}
									</p>
								</button>
								<div class="dropdown-menu dropdown-menu-right">
									<div class="dropdown-element" data-toggle="modal"
										data-target="#reportBugDialog">
										<span class="glyphicon glyphicon-exclamation-sign"
											aria-hidden="true"></span> &nbsp; Report bugs
									</div>
									<div class="dropdown-element">
										<a href="<c:url value="/profile"/>"> <span
											class="glyphicon glyphicon-user" aria-hidden="true"></span>
											&nbsp; My Profile
										</a>
									</div>
									<div class="dropdown-element">
										<a href="<c:url value="/logout"/>"> <span
											class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
											&nbsp; Log out
										</a>
									</div>
								</div>
							</div>
						</li>
					</ul>
				</security:authorize>
			</div>
		</div>
	</nav>

	<div class="modal fade" id="reportBugDialog" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Report bugs</h4>
				</div>
				<div class="modal-body">
					<form id="report-bug">
						<div class="form-group">
							<label for="report-title">Title:</label> <input type="text"
								class="form-control" id="report-title" name="report-title" />
						</div>
						<div class="form-group">
							<label for="report-description">Description:</label>
							<textarea class="form-control" id="report-description"
								name="report-description" style="height: 200px; resize: none;" /></textarea>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary"
						onclick="sendReport();">Send</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>