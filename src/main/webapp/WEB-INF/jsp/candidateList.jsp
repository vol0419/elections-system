<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:import url="shared/header.jsp">
    <c:param name="pageName" value="candidateList"></c:param>
</c:import>
<html>
<head>
    <title>LISTA KANDYDATÓW</title>
</head>
<body>
<div id="main" class="container">
    <H1>LISTA KANDYDATÓW</H1>
    <H2></H2>

    <%--@elvariable id="searchCommand" type="edu.uph.ii.platformy.controllers.commands.CandidateFilter"--%>
    <form:form id="searchForm" modelAttribute="searchCommand">
        <div class="row">
            <div class="form-group col-md-6">
                <label for="phrase">Wyszukaj kandydata (podaj imię, nazwisko, miasto lub partię):</label>
                <form:input path="phrase" cssClass="form-control" cssErrorClass="form-control is-invalid"/>
                <form:errors path="phrase" cssClass="error text-danger" element="div"/>
            </div>


        </div>
        <div class="row">

            <div class="form-group col-md-1">
                <button type="submit" class="btn btn-info">
                    <span></span> Wyszukaj
                </button>
            </div>

            <div class="form-group col-md-4">
                <c:if test="${searchCommand.isEmpty() eq false}">
                    <a href="/candidateList.html?all" class="btn btn-success">
                        Pokaż wszystko
                    </a>
                </c:if>
            </div>
        </div>
    </form:form>

    <c:if test="${empty candidateListPage.content}">
        ${searchCommand.isEmpty() ? 'Lista jest pusta':'Brak wyników wyszukiwania'}
    </c:if>

    <c:if test="${not empty candidateListPage.content}">

        <c:choose>
            <c:when test="${searchCommand.isEmpty()}">
                Na liście jest ${candidateListPage.totalElements} kandydatów
            </c:when>
            <c:otherwise>
                Wyszukiwanie zwróciło: ${candidateListPage.totalElements} kandydatów
            </c:otherwise>
        </c:choose>

        <c:set var="boundMin" value="${2000}"/>
        <c:set var="boundMax" value="${5000}"/>

        <table class="table table-striped">
            <thead class="thead-dark">
            <tr>
                <th>Głosuj</th>
                <th>Imię</th>
                <th>Nazwisko</th>
                <th>Miasto</th>
                <th>Partia</th>
                <security:authorize access="hasRole('ADMIN')">
                    <th>Opcje</th>
                </security:authorize>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${candidateListPage.content}" var="candidate">
                <tr>
                    <td>
                        <a class="btn btn-info" href="?id=${candidate.id}">Głosuj</a>
                    </td>
                    <td>
                        <c:out value="${empty candidate.imie?'Brak danych': candidate.imie}" escapeXml="true"/>
                    </td>
                    <td>
                        <c:out value="${empty candidate.nazwisko?'Brak danych': candidate.nazwisko}" escapeXml="true"/>
                    </td>
                    <td>
                        <c:out value="${empty candidate.miasto?'Brak danych': candidate.miasto}" escapeXml="true"/>
                    </td>
                    <td>
                        <c:out value="${empty candidate.partia?'Brak danych': candidate.partia}" escapeXml="true"/>
                    </td>
                    <security:authorize access="hasRole('ADMIN')">
                        <td>
                            <c:url var="deleteUrl" value="/candidateList.html?did=${candidate.id}&page=${candidateListPage.number}&size=${candidateListPage.size}" />
                            <c:url var="editUrl" value="/candidateForm.html?id=${candidate.id}" />
                            <a class="btn btn-danger" href="${deleteUrl}">Usuń</a>
                            <a class="btn btn-success" href="${editUrl}">Edytuj</a>
                        </td>
                    </security:authorize>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <c:set var="page" value="${candidateListPage}" scope="request"/>
        <c:set var="mainUrl" value="candidateList.html" scope="request"/>
        <jsp:include page="shared/pagination.jsp"/>

    </c:if>
    <security:authorize access="hasRole('ADMIN')">
        <a class="btn btn-success" href="candidateForm.html">Dodaj</a>
    </security:authorize>
    <security:authorize access="hasRole('ADMIN')">
        <a class="btn btn-warning" href="candidateList.html?end=${1}">Ogłoś wyniki</a>
    </security:authorize>
    <security:authorize access="hasRole('ADMIN')">
        <a class="btn btn-danger" href="candidateList.html?delete=${1}">Usuń listę</a>
    </security:authorize>
</div>
</body>
</html>
<jsp:include page="shared/footer.jsp"/>
