<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:import url="shared/header.jsp">
    <c:param name="pageName" value="electionForm"></c:param>
</c:import>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<div id="main" class="container">

    <%--@elvariable id="election" type="edu.uph.ii.platformy.models.Vehicle"--%>
    <form:form modelAttribute="election">



    <div class="form-group">
        <label for="date">Data Zakończenia</label>
        <form:input path="date" cssClass="form-control" type="date" cssErrorClass="form-control is-invalid"/>
        <form:errors path="date" cssClass="error text-danger" element="div"/>
    </div>





    <div class="form-group">
        <button type="submit" class="btn btn-success" class="btn btn-success">Wyślij</button>
    </div>
    </form:form>

</body>
</html>

</div>

<jsp:include page="shared/footer.jsp"/>