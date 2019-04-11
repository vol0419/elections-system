<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="shared/header.jsp">
    <jsp:param name="pageName" value="candidateDetails"/>
</jsp:include>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Szczegóły kandydata</title>
</head>
<body>
<div id="main" class="container">
<H1>Szczegóły kandydata</H1>
Id: <b>${candidate.id}</b><br/>
    Czas utworzenia wpisu: <b><fmt:formatDate value="${candidate.createdDate}" type="both" timeStyle="medium"/></b><br/>
    Imię: <b>${empty candidate.imie?'Brak danych': candidate.imie}</b><br/>
    Nazwisko: <b>${empty candidate.nazwisko?'Brak danych': candidate.nazwisko}</b><br/>
    Miasto: <b>${empty candidate.miasto?'Brak danych': candidate.miasto}</b><br/>
    Partia <b>${empty candidate.partia?'Brak danych': candidate.partia}</b><br/>

    <a class="btn btn-success" href="/zaglosuj.html?id=${candidate.id}">Zagłosuj</a>

<a class="btn btn-success" href="/candidateList.html">Wstecz</a>
</div>
</body>
</html>

<jsp:include page="shared/footer.jsp"/>