<!DOCTYPE html>
<html>
<#include "base.ftl">
<head>
    <#macro title>Login</#macro>
</head>

<#macro content>
    <p class="fw-semibold">Enter data</p>
    <form action="http://localhost:8080/login" method="post">
        <div class="form-group">
            <label class="col-sm-2 col-form-label">Username</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="username" required>
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="inputPassword" name="password" required>
            </div>
        </div>
        <div class="form-group">
<#--            если неправильный логин/пароль-->
            <#if incorrect??>
                <p class="text-danger">Wrong password or username</p>
            </#if>
        </div>
        <p></p>
        <button type="submit" class="btn btn-primary text-dark mb-3">Sign In</button>
        <p class="text-muted">
            Do you want to create an account? Go <a href="http://localhost:8080/register" class="text-reset"> here </a>.
        </p>
    </form>
</#macro>
</html>