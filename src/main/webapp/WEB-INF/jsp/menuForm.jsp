<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:import url="shared/header.jsp">
	<c:param name="pageName" value="menuList"></c:param>
</c:import>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
<div  id="main"  class="content">

	<%--@elvariable id="voters" type="edu.uph.ii.platformy.models.Voters"--%>
	<form:form modelAttribute="voters">

	<div class="form-group">
		<label for="name">Imie:</label>
		<form:input path="name" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
		<form:errors path="name" cssClass="error text-danger" element="div"/>
	</div>
	<div class="form-group">
		<label for="surename">Nazwisko:</label>
		<form:input path="surename" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
		<form:errors path="surename" cssClass="error text-danger" element="div"/>
	</div>
	<div class="form-group">
		<label for="pesel">PESEL:</label>
		<form:input path="pesel" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
		<form:errors path="pesel" cssClass="error text-danger" element="div"/>
	</div>


		<div class="form-group">
			<label for="idnumber">Numer dowodu:</label>
			<form:input path="idnumber" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
			<form:errors path="idnumber" cssClass="error text-danger" element="div"/>
		</div>



	<div class="form-group">
		<button type="submit" class="btn btn-success" class="btn btn-success">Wyślij</button>
	</div>
	</form:form>

</body>
</html>

</div>

<jsp:include page="shared/footer.jsp"/>
