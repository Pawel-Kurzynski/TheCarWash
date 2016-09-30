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
<h1>
    Add new Car
</h1>
<c:url var="addAction" value="${pageContext.request.contextPath}/client/carlist/add"></c:url>
<form:form  action="${addAction}" modelAttribute="car" >
    <table>
        <tr>
            <td>
                <form:label path="client">

                    <spring:message text="Client ID"/>
                </form:label>
            </td>
            <td>
                <c:forEach items="client" var="client">
                    ${client = car.client}
                    <form:input path="client" readonly="true" size="8" disabled="true"/>
                <form:hidden path="client"/>
                </c:forEach>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="id">
                    <spring:message text="Car ID"/>
                </form:label>
            </td>
            <td>
                <form:input path="id" readonly="true" size="8" disabled="true"/>
                <form:hidden path="id"/>
            </td>
        </tr>
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
    <h3>List of Cars client: ${client.firstname} ${client.lastname} </h3>
    <table class="tg">
        <tr>
            <th width="80">Client ID</th>
            <th width="100">First Name</th>
            <th width="100">Last Name</th>
            <th width="120">Address ID</th>
            <th width="160">Car</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listCars}" var="cars">
            <tr>
                <td>${client.car.id}</td>
                <td>${client.car.model}</td>
                <td>${client.car.width}</td>
                <td>${client.car.high}</td>
                <td>${client.car.waxing}</td>
                <td>${client.car.plateNumber}</td>
                <td><a href="<c:url value='/client/carlist/${client.id}/edit/' />">Edit</a></td>
                <td><a href="<c:url value='/client/carlist/${client.id}/remove' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<jsp:include page="myFooter.jsp"/>
</body>
</html>
