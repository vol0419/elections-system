<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:import url="shared/header.jsp">
    <c:param name="pageName" value="menuList"></c:param>
</c:import>
<html>
<head>
    <title>Lista Glosujacych</title>
</head>
<body>
<div  id="main" class="content">
    <H1>Lista Glosujacych</H1>


    <%--@elvariable id="searchCommand" type="edu.uph.ii.platformy.controllers.commands.VotershFilter"--%>


    <c:if test="${empty menuListPage.content}">
        ${searchCommand.isEmpty() ? 'Lista osob jest pusta':'Brak wyników wyszukiwania'}
    </c:if>

    <c:if test="${not empty menuListPage.content}">

        <c:choose>
            <c:when test="${searchCommand.isEmpty()}">
                Lista zawiera ${menuListPage.totalElements} osob
            </c:when>
            <c:otherwise>
                Wynik wyszukiwania: ${menuListPage.totalElements} osob
            </c:otherwise>
        </c:choose>

        <c:set var="boundMin" value="${20000}"/>
        <c:set var="boundMax" value="${40000}"/>

        <table class="table table-striped">
            <thead class="thead-dark">
            <tr>

                <th>Imie</th>
                <th>Nazwisko</th>
                <th>Numer Dowodu</th>

                <th>PESEL</th>

                <security:authorize access="hasRole('ADMIN')">
                    <th>Opcje</th>
                </security:authorize>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${menuListPage.content}" var="voters">
                <tr>

                    <td>

                            ${voters.name}



                    </td>
                    <td>
                        <c:out value="${empty voters.surename?'Brak danych': voters.surename}" escapeXml="true"/>

                    </td>
                    <td>${voters.idnumber}</td>


                    <td><fmt:formatNumber   value="${voters.pesel}"  /></td>


                    <security:authorize access="hasRole('ADMIN')">
                        <td>
                            <c:url var="deleteUrl" value="/menuList.html?did=${voters.id}&page=${menuListPage.number}&size=${menuListPage.size}" />
                            <c:url var="editUrl" value="/menuForm.html?id=${voters.id}" />
                            <a class="btn btn-danger" href="${deleteUrl}">Usuń</a>
                            <a class="btn btn-success" href="${editUrl}">Edytuj</a>
                        </td>
                    </security:authorize>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <c:set var="page" value="${menuListPage}" scope="request"/>
        <c:set var="mainUrl" value="menuList.html" scope="request"/>
        <jsp:include page="shared/pagination.jsp"/>

    </c:if>
    <security:authorize access="hasRole('ADMIN')">
        <a class="btn btn-success" href="menuForm.html">Dodaj Nowa Osobe</a>
    </security:authorize>
    <security:authorize access="hasRole('ADMIN')">
        <a class="btn btn-danger" href="menuform.html?delete=${1}">Usuń listę</a>
    </security:authorize>
</div>
</body>
</html>
<jsp:include page="shared/footer.jsp"/>
