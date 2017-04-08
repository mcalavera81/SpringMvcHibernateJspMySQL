<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="main.css">
    <script type="text/javascript" src="jquery-3.2.0.js"></script>
</head>
<body>
<h1><spring:message code="user.list"/></h1>
<ul>

    <c:forEach items="${users}" var="user">
        <li>
            <hr>
            <spring:message code="label.id"/>       : <c:out value="${user.id}"></c:out> <br/>
            <spring:message code="label.gender"/>   : <c:out value="${user.gender}"></c:out> <br/>
            <spring:message code="label.country"/>  : <c:out value="${user.country.name}"></c:out> <br/>
            <spring:message code="label.skills"/>   :
            <c:forEach var="userSkill" items="${user.skills}" >
                <c:out value="${userSkill.skill.name}"></c:out>
            </c:forEach> <br />

        </li>
    </c:forEach>
</ul>

<a href="<spring:url value="/user_create.html" />"><spring:message code="user.create"/></a>
</body>
</html>
