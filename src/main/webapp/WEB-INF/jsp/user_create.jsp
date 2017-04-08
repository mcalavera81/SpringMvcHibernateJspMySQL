<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Add Employee Form</title>
    <script type="text/javascript" src="jquery-3.2.0.js"></script>
    <style>
        .error
        {
            color: #ff0000;
            font-weight: bold;
        }
    </style>
    <link rel="stylesheet" type="text/css" href="main.css">

    <style type="text/javascript">


    </style>
</head>
<body>
    <script>
        (function poll() {
            setTimeout(function() {
                $.ajax({
                    url: "poll",
                    type: "GET",
                    success: function(data) {
                        $("#counter").html("My current count is: "+data);
                    },
                    dataType: "json",
                    complete: poll,
                    timeout: 30000
                })
            }, 3000);
        })();
    </script>
<h1><spring:message code="user.create"/></h1>
<a href="<spring:url value="/user_list.html" />"><spring:message code="user.list"/></a>
<form:form method="POST" action="/user_create.html" modelAttribute="user_form" >
    <div id="counter">0</div>
    <form:errors path="" element="div"/>
    <div>
        <form:label path="id"><spring:message code="user.id"/></form:label>
        <form:input path="id"/>
        <form:errors path="id" cssClass="error"/>
    </div>
    <div>
        <form:label path="password1"><spring:message code="user.password1"/></form:label>
        <form:password path="password1"/>
        <form:errors path="password1" cssClass="error"/>
    </div>
    <div>
        <form:label path="password1"><spring:message code="user.password2"/></form:label>
        <form:password path="password2"/>
        <form:errors path="password2" cssClass="error"/>
    </div>
    <div>
        <form:label path="gender">Gender</form:label>
        <form:radiobuttons path="gender" items="${gender}" />
        <form:errors path="gender" cssClass="error"/>
    </div>
    <div>
        <form:label path="country">Country</form:label>
        <form:select path="country">
            <form:option value="0" label="Select" />
            <form:options items="${countryList}" itemValue="id" itemLabel="name" />
        </form:select>
        <form:errors path="country" cssClass="error"/>
    </div>
    <div>
        <form:label path="skills">Java Skills :</form:label>
        <form:select path="skills" items="${javaSkills}" multiple="true" itemLabel="name" itemValue="id"/>
        <form:errors path="skills" cssClass="error"/>
    </div>
    <div>
        <input type="submit"/>
    </div>
</form:form>
</body>
</html>

