<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>


<P>  The time on the server is ${serverTime}. </p>

<a href="<c:url value='/client' />" >List of Clients</a>
<a href="<c:url value='/employee' />" >List of Employees</a>

</body>
</html>