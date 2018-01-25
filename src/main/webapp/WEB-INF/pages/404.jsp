<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="false"%>
<html>
<head>
<link rel="shortcut icon"
	href="<c:url value="/resources/img/icon.ico"/>" type="image/x-icon">
<link rel="stylesheet"
	href="<c:url value="/resources/style/bootstrap.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/style/bootstrap-theme.min.css"/>">

<title>Error 404</title>
</head>
<body>
	<p style="text-align: center">
		<img src="<c:url value="/resources/img/404.png"/>" /> <br> <a
			class="btn btn-primary" href="<c:url value="/home"/>">Home</a>
	</p>
</body>
</html>