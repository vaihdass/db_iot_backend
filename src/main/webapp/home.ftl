<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link rel="icon" href="favicon.ico">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="styles/styles.css">

    <title>Home / IOT</title>
</head>
<body>
<span id="scroll-to-top" style="display: none;">
    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-up-short" viewBox="0 0 16 16">
        <path fill-rule="evenodd" d="M8 12a.5.5 0 0 0 .5-.5V5.707l2.146 2.147a.5.5 0 0 0 .708-.708l-3-3a.5.5 0 0 0-.708 0l-3 3a.5.5 0 1 0 .708.708L7.5 5.707V11.5a.5.5 0 0 0 .5.5z"/>
    </svg>
</span>

<header>
    <h1>IOT</h1>
    <small>&laquo;Connect Smart. Control Easy.&raquo;</small>
</header>

<main>
    <div id="content" class="content-class">
        <#if isLoggedIn == false>
            <div class="login__link__container">
                <a class="login__link" href="/registration">Зарегистрироваться</a>
                <span>|</span>
                <a class="login__link" href="/login">Залогиниться</a><br>
            </div>
        <#else>
            <div class="select__container">
                <span class="select__label">Выберите хаб:</span>
                <select id="hub">
                    <option value="0">-</option>
                </select>
                <button id="hub_btn">Получить</button>
            </div>
            <div class="cards__container" id="data"></div>
        </#if>
    </div>
</main>
</div>

<footer>
    <small><a href="https://github.com/vaihdass/db_iot_backend">Source code (Github)</a></small>
</footer>

</body>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<script src="scripts/scripts.js"></script>
<script>
    function scrollToTop() {
        $('html, body').animate({ scrollTop: 0 }, 115);
        return false;
    }

    function toggleScrollToTopButton() {
        let threshold = 200;
        if ($(window).scrollTop() > threshold) {
            $('#scroll-to-top').fadeIn('slow');
        } else {
            $('#scroll-to-top').fadeOut('slow');
        }
    }

    $(document).ready(function () {
        $('#scroll-to-top').click(scrollToTop);
        $(window).scroll(toggleScrollToTopButton);
    });
</script>
</html>