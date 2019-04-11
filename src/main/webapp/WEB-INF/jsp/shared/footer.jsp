<%--
  Created by IntelliJ IDEA.
  User: grzesiek
  Date: 14.10.2017
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>




<div class="footer">
            © 2018 System Wyborczy
            <security:authorize access="isAuthenticated()">
                <security:authentication property="authorities" var="roleList"></security:authentication>

                Witaj
                <c:forEach items="${roleList}" var="role">
                    ${role},
                </c:forEach>

            </security:authorize>



</div>
</body>
</html>