<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<jsp:include page="shared/header.jsp">
    <jsp:param name="pageName" value="bookingForm"/>
</jsp:include>
<html>
<body>

<div class="container">

    <div class="row" style="margin-top:20px">
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <%--@elvariable id="voters" type="edu.uph.ii.platformy.models.Voters"--%>


                    <h1>Wprowadź dane do potwierdzenia</h1>
                   potwierdzić swój głos musisz podać swoje dane</h1>
                <form:form modelAttribute="voters">
                    <fieldset>
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




                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <input type="submit" class="btn btn-lg btn-primary btn-block" value="Zagłosuj"/>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                        </div>
                    </div>
                </fieldset>
            </form:form>
        </div>
    </div>

</div>
</body>
</html>
<jsp:include page="shared/footer.jsp"></jsp:include>