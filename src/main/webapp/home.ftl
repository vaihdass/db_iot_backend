<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="scripts/scripts.js"></script>
</head>
<body>
<#if isLoggedIn == false>
    <a href="/registration">Зарегистрироваться</a>
    <a href="/login">Залогиниться</a> <br>
</#if>
Выберите хаб:
<select id="hub">
</select>
<button id="hub_button">Подтвердить</button>
<div id="data"></div>

</body>
</html>