<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:import url="shared/header.jsp">
    <c:param name="pageName" value="peselNotGood"></c:param>
</c:import>

<html>
<head>
    <title>Blad PESEL</title>
</head>
<body>
<div id="main" class="container">

    <h1>Ten pesel jest bledny lub znajduje sie juz w naszej bazie</h1>
    <div>Wcisnij <a class="btn btn-success" href="menuForm.html">Wroc</a> i sproboj jeszcze raz
    </div>
</div>
</body>
</html>

<jsp:include page="shared/footer.jsp"/>
