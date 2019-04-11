<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Konrad
  Date: 2018-01-28
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<link rel="stylesheet" type="text/css"
      href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
      href="statics/css/style4.css " />

<script src="<c:url value="/statics/js/timer.js" />"></script>

<html>
<head>

    <title>HOME</title>
</head>
<body onload="odliczanie();">
<div class="logo">
    <img src="https://upload.wikimedia.org/wikipedia/commons/c/c9/Herb_Polski.svg" width="90" height="74" style="float: left;"/>
    <span style="color: #FFFFFF">System<a style="color: red">Wyborczy </a></span>
    <div style="clear:both;"></div>
</div>
<div class="wrapper"> </div>
<div class="header">
</div>

<div id="main" class="content">
    <div class="tile1">
        <a   href="menuList.html?all" class="tilelink"><i class=icon-home><br>Listy glosujacych</i></a>
    </div>
    <div class="tile1">
        <a href="candidateList.html" class="tilelink"><i class=icon-home><br>Listy kandydatow</i></a>
    </div>
    <div class="tile3">
        <a href="http://pkw.gov.pl/" class="tilelink"><i class=icon-picture><br>Komisja Wyborcza</i></a>
    </div>
    <div class="tile3">
        ${param['pageName'] == 'oNas' ?'class="active"':''}
        <a href="/info.html" class="tilelink"><i class=icon-video><br>O nas</i></a>
    </div>
    <div style="clear:both"></div>
    <div class="tile2">
        <div  id="zegar">12:00:00</div>
    </div>
    <div class="tile1">

        <a href="/kontakt.html" class="tilelink"><i class=icon-phone><br>Kontakt </i></a>
    </div>
    <div class="tile1">
        <security:authorize access="isAnonymous()">

            <br> <a   href="/login" class="tilelink"   >Zaloguj</a>

        </security:authorize>
        <security:authorize access="isAuthenticated()">

            </br>  <a   href="#" class="tilelink"  onclick="document.getElementById('logout').submit()" >Wyloguj się</a>

            <form action="/logout" id="logout" method="post" style="display: none;">
                <security:csrfInput/>
            </form>
        </security:authorize>
    </div>







</div>





</body>
</html>


