<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Pablo
  Date: 27.08.2016
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Add a new Car
</h1>
<%--<c:url var="addAction" value="client/add"></c:url>--%>

<%--<form:form action="${addAction}" modelAttribute="clinet">--%>
    <%----%>
    <%--<table>--%>
      <%--<c:if test="${client.name}">--%>
          <%--<tr>--%>
              <%--<td>--%>
                  <%--<form:label path="id">--%>
                      <%--<spring:message text="ID"/>--%>
                  <%--</form:label>--%>
              <%--</td>--%>
          <%--</tr>--%>
      <%--</c:if>--%>
    <%--</table>--%>
    <%----%>
<%--</form:form>--%>
<br>
<h3>List of CLIENTS</h3>
<c:if test="${!empty listClients}">
    <table class="tg">
        <tr>
            <th width="80">Client ID</th>
            <th width="100">First Name</th>
            <th width="100">Last Name</th>
            <th width="120">Address</th>
            <th width="160">Car</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listClients}" var="client">
            <tr>
                <td>${client.id}</td>
                <td>${client.firstName}</td>
                <td>${client.lastName}</td>
                <td><a href="<c:url value='/client/address/${client.id}' />" >Address</a></td>
                <td><a href="<c:url value='/client/cars/${client.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/client/edit/${client.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/client/remove/${client.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
