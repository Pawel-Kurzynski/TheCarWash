<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Pablo
  Date: 01.09.2016
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Address page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style.css">

</head>

<body>
    <jsp:include page="myHeader.jsp"/>
<h1>
    Edit Address
</h1>
<c:url var="addAction" value="add"></c:url>

<form:form action="${addAction}" modelAttribute="address">

<table>
    <tr>
        <td>
            <form:label path="id">
                <spring:message text="Address ID"/>
            </form:label>
        </td>
        <td>
            <form:input path="id" readonly="true" size="8" disabled="true"/>
            <form:hidden path="id"/>
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="client.id">
                <spring:message text="Client ID"/>
            </form:label>
        </td>
        <td>
            <form:input path="client.id" readonly="true" size="8" disabled="true"/>
            <form:hidden path="client.id"/>
        </td>
    </tr>
        <tr>
            <td>
                <form:label path="locality">
                    <spring:message text="Locality"/>
                </form:label>
            </td>
            <td>
                <form:input path="locality"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="zipCode">
                    <spring:message text="Zip Code"/>
                </form:label>
            </td>
            <td>
                <form:input path="zipCode"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="street">
                    <spring:message text="Street"/>
                </form:label>
            </td>
            <td>
                <form:input path="street"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="streetNumber">
                    <spring:message text="Street Number"/>
                </form:label>
            </td>
            <td>
                <form:input path="streetNumber"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit"
                       value="<spring:message text="Edit Address"/>"/>
            </td>
        </tr>
    </form:form>
</table>
<h3>Current address</h3>
<table class="tg">
    <tr>
        <th width="80">Address ID</th>
        <th width="120">Locality</th>
        <th width="120">Zip Code</th>
        <th width="120">Street</th>
        <th width="100">Street Number</th>
        <th width="100">Client ID</th>
    </tr>
        <tr>
            <td>${address.id}</td>
            <td>${address.locality}</td>
            <td>${address.zipCode}</td>
            <td>${address.street}</td>
            <td>${address.streetNumber}</td>
            <td>${address.client.id}</td>
        </tr>
</table>
<jsp:include page="myFooter.jsp"/>
</body>
</html>
