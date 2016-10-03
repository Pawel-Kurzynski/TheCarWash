<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Pablo
  Date: 21.09.2016
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car List</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style.css">

</head>
<body>
<jsp:include page="myHeader.jsp"/>

<h2>Current client: ${car.client.firstName} ${car.client.lastName} </h2>
<h3>Add new Car</h3>

<c:url var="addAction" value="${pageContext.request.contextPath}/client/carlist/add"></c:url>

<form:form  action="${addAction}" modelAttribute="car" >
    <table>
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
        <td>
            <form:label path="id">
                <spring:message text="Car ID"/>
            </form:label>
        </td>
        <td>
            <form:input path="id" readonly="true" size="8" disabled="true"/>
            <form:hidden path="id"/>
        </td>x
        <tr>
            <td>
                <form:label path="plateNumber">
                    <spring:message text="Plate Number"/>
                </form:label>
            </td>
            <td>
                <form:input path="plateNumber"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="model">
                    <spring:message text="Model"/>
                </form:label>
            </td>
            <td>
                <form:input path="model"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="width">
                    <spring:message text="Width"/>
                </form:label>
            </td>
            <td>
                <form:input path="width"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="high">
                    <spring:message text="High"/>
                </form:label>
            </td>
            <td>
                <form:input path="high"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="waxing">
                    <spring:message text="Waxing"/>
                </form:label>
            </td>
            <td>
                <form:input path="waxing"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty car.model}">
                    <input type="submit"
                           value="<spring:message text="Edit Car"/>"/>
                </c:if>
                <c:if test="${empty car.model}">
                    <input type="submit"
                           value="<spring:message text="Add Car"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>


<br>
<c:if test="${!empty listCars}">
    <h3>List of cars</h3>
    <table class="tg">
        <tr>
            <th width="70">Car ID</th>
            <th width="100">Model</th>
            <th width="60">Width</th>
            <th width="60">High</th>
            <th width="70">Waxing</th>
            <th width="100">Plate Number</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listCars}" var="car">
            <tr>
                <td>${car.client.id}</td>
                <td>${car.model}</td>
                <td>${car.width}</td>
                <td>${car.high}</td>
                <td>${car.waxing}</td>
                <td>${car.plateNumber}</td>
                <td><a href="<c:url value='/client/carlist/${car.client.id}/edit/${car.id}' />">Edit</a></td>
                <td><a href="<c:url value='/client/carlist/${car.client.id}/remove/${car.id}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<jsp:include page="myFooter.jsp"/>
</body>
</html>
