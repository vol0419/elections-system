<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:import url="shared/header.jsp">
    <c:param name="pageName" value="kontakt"></c:param>
</c:import>

<html>
<head>
    <title>Kontakt</title>
</head>
<body>
<div id="main" class="container">

    <H1>Skontaktuj się z naszym biurem: </H1>
    <H3>Mail: <a href="biuro@springvoters.com">biuro@springvoters.com</a></H3>
    <H3>Telefon: <a href="tel:+000000">500 300 300</a></H3>
    <H3>Adres:</H3>
    <h5>Główna komisja wyborcza</h5>
    <h5>ul. Ostrobramska 75c lok. 066</h5>
    <h5>04-175 Warszawa </h5>
    <H1> </H1>
    <center><iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d9774.58944398133!2d21.1061776!3d52.2316243!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x3b8e3d66082dfd6!2sAtrium+Promenada!5e0!3m2!1spl!2spl!4v1517008277837" width="900" height="450" frameborder="0" style="border:0" allowfullscreen></iframe></center>
</div>
</body>
</html>

<jsp:include page="shared/footer.jsp"/>
