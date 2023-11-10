<!DOCTYPE html>
<html>
<#include "base.ftl">
<head>
    <#macro title>Registration</#macro>
</head>

<#macro content>
    <p class="fw-semibold">Welcome!</p>
    <form action="http://localhost:8080/registration" method="post">
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
            <label for="inputPassword" class="col-sm-2 col-form-label">Email</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputPassword" name="email" required>
            </div>
        </div>
        <div class="form-group">
            <label for="inputPhoneNumber" class="col-sm-2 col-form-label">Phone number</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputPhoneNumber" name="phoneNumber" required>
            </div>
        </div>
        <p></p>
        <button type="submit" class="btn btn-primary text-dark mb-3">Register</button>
        <p class="text-muted">
            Already have an account? Go <a href="http://localhost:8080/login" class="text-reset"> here </a>.
        </p>
    </form>
</#macro>
</html>