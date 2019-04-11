<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:import url="shared/header.jsp">
    <c:param name="pageName" value="info"></c:param>
</c:import>

<html>
<head>
    <title>Informację</title>
</head>
<body>
<div id="main" class="container">

    <h4>Podałes błędne dane </h4>
    <div>Wcisnij <a class="btn btn-success" href="zaglosuj.html">Wroc</a> i sproboj jeszcze raz</div>

</div>
</body>
</html>

<jsp:include page="shared/footer.jsp"/>
