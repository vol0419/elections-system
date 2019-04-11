<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:import url="shared/header.jsp">
	<c:param name="pageName" value="candidateList"></c:param>
</c:import>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="main" class="container">

	<%--@elvariable id="candidate" type="edu.uph.ii.platformy.models.Candidate"--%>
		<form:form modelAttribute="candidate">

			<div class="form-group">
				<label for="imie">Imię:</label>
				<form:input path="imie" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
				<form:errors path="imie" cssClass="error text-danger" element="div"/>
			</div>
			<div class="form-group">
				<label for="nazwisko">Nazwisko:</label>
				<form:input path="nazwisko" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
				<form:errors path="nazwisko" cssClass="error text-danger" element="div"/>
			</div>
		<div class="form-group">
			<label for="miasto">Miasto:</label>
			<form:input path="miasto" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
			<form:errors path="miasto" cssClass="error text-danger" element="div"/>
		</div>
		<div class="form-group">
			<label for="partia">Partia:</label>
			<form:input path="partia" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
			<form:errors path="partia" cssClass="error text-danger" element="div"/>
		</div>

			<div class="form-group">
				<button type="submit" class="btn btn-success" class="btn btn-success">Wyślij</button>
			</div>
		</form:form>

</body>
</html>

</div>

<jsp:include page="shared/footer.jsp"/>
