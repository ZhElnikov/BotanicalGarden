<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
     <style>
    <%@include file="/WEB-INF/css/styles.css"%>    
    </style>
</head>

<body>
    <div class="container">
        <div class="panel panel-default" id="loginForm">
            <div class="panel-body">

                <form method="post" action="#" th:action="@{/loginPage}" th:object="${user}" name="authForm">
                <div id="loginTitle">Авторизация</div>

                <div class="row">
                    <div class="col-md-5 col-sm-1">
                        <img src="logo2.png" height=200 id="logoBig">
                    </div>
                    <div class="col-md-7" id="loginFields">
                        <div>
                        <div id="loginField">
                            <span class="glyphicon glyphicon-user" aria-hidden="true" path="login"></span>
                            <span>Логин</span>
                        </div>
                        <input type="text" th:value="${user.login}" id="login" name="login"> 
                        <div id="passwordField">
                            <span class="glyphicon glyphicon-lock" aria-hidden="true" path="login"></span>
                            <span>Пароль</span>
                        </div>
                        <input type="password" th:value="${user.password}" id="password" name="password"></div>
                        <input class="bigButton" type="submit" value="Войти"></div>
                    </div>
                </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>