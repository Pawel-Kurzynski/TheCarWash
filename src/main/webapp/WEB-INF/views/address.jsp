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
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
    Edit Address
</h1>
<%--<c:if test="${!empty employee.address}">--%>
    <tr>0
        <td>
            <form:label path="client">
                <spring:message text="Client ID"/>
            </form:label>
        </td>
        <td>
            <form:input path="client" readonly="true" size="8"  disabled="true" />
            <form:hidden path="client" />
        </td>
    </tr>
<%--</c:if>--%>
<tr>
    <td>
        <form:label path="locality">
            <spring:message text="Locality"/>
        </form:label>
    </td>
    <td>
        <form:input path="locality" />
    </td>
</tr>
<tr>
    <td>
        <form:label path="zipCode">
            <spring:message text="Zip Code"/>
        </form:label>
    </td>
    <td>
        <form:input path="zipCode" />
    </td>
</tr>
<tr>
    <td>
        <form:label path="street">
            <spring:message text="Street"/>
        </form:label>
    </td>
    <td>
        <form:input path="street" />
    </td>
</tr>
<tr>
    <td colspan="2">
            <input type="submit"
                   value="<spring:message text="Edit Address"/>" />
    </td>
</tr>
<h3>Current address</h3>
<table class="tg">
    <tr>
    <th width="80">Address ID</th>
    <th width="120">Locality</th>
    <th width="120">Street</th>
    <th width="100">Street Number</th>
    </tr>
    <c:forEach items="${listaddress}" var="client">
        <tr>
            <td>${address.id}</td>
            <td>${address.locality}</td>
            <td>${address.street}</td>
            <td>${address.streetNumber}</td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>
