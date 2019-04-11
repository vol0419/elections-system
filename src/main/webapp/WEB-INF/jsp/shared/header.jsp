<%--
  Created by IntelliJ IDEA.
  User: grzesiek
  Date: 14.10.2017
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>

    <!-- this is header-css -->
    <link href="statics/css/loc.css" rel="stylesheet">
    <link href="statics/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css"
          href="statics/css/style15.css" />
    <script src="<c:url value="/statics/js/timer.js" />"></script>
    <script src="<c:url value="/statics/js/jquery-1.12.3.min.js" />"></script>

    <script>

        $(document).ready(function() {
            var NavY = $('.nav').offset().top;

            var stickyNav = function(){
                var ScrollY = $(window).scrollTop();

                if (ScrollY > NavY) {
                    $('.nav').addClass('sticky');
                } else {
                    $('.nav').removeClass('sticky');
                }
            };

            stickyNav();

            $(window).scroll(function() {
                stickyNav();
            });
        });

    </script>

</head>
<body>
<div class="nav">
    <!-- this is header -->
    <ol>
        <li>
                <a   href="/" ${param['pageName'] == 'home' ?'class="active"':''}>Strona główna</a>
        </li>
        <li ${param['pageName'] == 'dishListPage' ?'class="active"':''}>
            <a   href="menuList.html?all">List głosujących</a>
        </li>


                    <li ${param['pageName'] == 'candidateListPage' ?'class="active"':''}>
                        <a href="candidateList.html?all">Lista kandydatów</a>
                    </li>


                    <li ${param['pageName'] == 'kontakt' ?'class="active"':''}>
                        <a href="kontakt.html">Kontakt</a>
                    </li>
                    <li ${param['pageName'] == 'info' ?'class="active"':''}>
                        <a href="info.html">Informację</a>
                    </li>



                    <security:authorize access="isAnonymous()">
                        <li ${param['pageName'] == 'logonForm' ?'class="active"':''}>
                            <a href="/login">Zaloguj się</a>
                        </li>
                    </security:authorize>

        <security:authorize access="hasRole('ROLE_ADMIN')">
            <li ${param['pageName'] == 'electionstart' ?'class="active"':''}>
                <a   href="electionstart.html">Rozpocznij wybory</a>
            </li>
        </security:authorize>

        <security:authorize access="hasRole('ROLE_ADMIN')">
            <li ${param['pageName'] == 'electionstart' ?'class="active"':''}>
                <a   href="electionstop.html">Zakończ wybory</a>
            </li>
        </security:authorize>



                    <security:authorize access="isAuthenticated()">
                        <li>
                            <label style="color:yellow; margin-top: 15px;">
                                Witaj <security:authentication property="principal.username"/>!
                            </label>
                        </li>
                        <li>
                            <a href="#" onclick="document.getElementById('logout').submit()">Wyloguj się</a>
                            <form action="/logout" id="logout" method="post" style="display: none;">
                                <security:csrfInput/>
                            </form>
                        </li>
                    </security:authorize>


    </ol>
</div>
</body>
</html>