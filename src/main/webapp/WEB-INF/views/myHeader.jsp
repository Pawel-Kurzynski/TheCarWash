<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Pablo
  Date: 13.09.2016
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="header-container">

    <div class="site-name">Car Wash Application</div>
    <div class="header-bar">
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            Hello
            <a href="${pageContext.request.contextPath}/accountInfo">
                    ${pageContext.request.userPrincipal.name} </a>
            &nbsp;|&nbsp;
            <a href="${pageContext.request.contextPath}client/logout">Logout</a>

        </c:if>

        <c:if test="${pageContext.request.userPrincipal.name == null}">

            <a href="${pageContext.request.contextPath}/login">Login</a>
        </c:if>
    </div>
</div>

