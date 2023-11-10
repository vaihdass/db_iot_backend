<!DOCTYPE html>
<html lang="en">
<#include "base.ftl">
<head>
    <meta charset="UTF-8">
    <#macro title>Home</#macro>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="scripts/scripts.js"></script>
</head>
<body>
<#macro content>
<#if isLoggedIn == false>
    <a href="/registration">Зарегистрироваться</a>
    <a href="/login">Залогиниться</a> <br>
</#if>
    <span>Выберите хаб:</span>
    <select id="hub"></select>
    <button id="hub_btn">Получить</button>
    <div id="data"></div>
</#macro>
</body>
</html>