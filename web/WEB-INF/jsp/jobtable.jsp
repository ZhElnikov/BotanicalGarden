<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<HTML>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <style>
            <%@include file="/WEB-INF/css/styles.css"%>    
        </style>
    </head>

    <body>
        <div class="container" id="wrap">
            <div class="row">
                <div class="col-md-3 col-sm-1">
                    <img src="logo2.png" height='100' id='logo'/>
                </div>
                <div class="col-md-9 " id="accountData">
                    <div>
                        <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                        <span id="username">${userlogin}</span>
                    </div>
                    <div>
                        <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
                        <span><a action="" method="" href="login.htm"> Выход </a></span>
                    </div>
                </div>
            </div>
            <div clas="navigationPanel">
                <nav class="navbar navbar-default">
                    <div class="container-fluid">                      
                        <div id="mainmenu">
                            <ul class="nav navbar-nav">
                                <li><a href="">пользователи</a></li>
                                <li><a href="">профили</a></li>
                                <li><a href="">отчеты</a></li>
                                <li><a href="">заявки1</a></li>
                                <li><a href="">заявки2</a></li>
                                <li><a href="">сектора</a></li>
                                <li><a href="">почва</a></li>
                                <li><a href="">экскурсии</a></li>
                                <li><a href="">деревья</a></li>
                                <li><a href="">работы</a></li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>  
                    <h3>Таблица заданий и работ</h3>   
            <div class="row" >
                <div class="col-md-1 col-md-offset-1" id="tablehead"> id </div>
                <div class="col-md-3 " id="tablehead"> описание</div>
                <div class="col-md-1 " id="tablehead"> пользователь</div>
                <div class="col-md-1 " id="tablehead"> начало </div>
                <div class="col-md-1 " id="tablehead"> конец </div>
                <div class="col-md-1 " id="tablehead"> дедлайн </div>
            </div>  
            <%
                for (int i =0; i<5;i++) {          
            %>        
            <div class="row">
                <form method="post" th:object="" name="tableForm" class="tablerow">
                <div class="col-md-1 col-md-offset-1"> <input type="text" th:value="" id="" name="" class="tableInput"> </div>
                <div class="col-md-3 "> <input type="text" th:value="" id="" name="" class="tableInput-large3"> </div>
                <div class="col-md-1 "> <input type="text" th:value="" id="" name="" class="tableInput"> </div>
                <div class="col-md-1 "> <input type="text" th:value="" id="" name="" class="tableInput"> </div>
                <div class="col-md-1 "> <input type="text" th:value="" id="" name="" class="tableInput"> </div>
                <div class="col-md-1 "> <input type="text" th:value="" id="" name="" class="tableInput"> </div>
                <div class="col-md-1 "> <input class="editRow" id = "" type="submit" value="изменить"></div>
                <div class="col-md-1 "> <input class="deleteRow" id = "" type="submit" value="удалить"></div>
                </form>
            </div>              
            <%}
             %>
             
             <div class="row">
                <form method="post" th:object="" name="tableForm" class="tablerow">
                <div class="col-md-1 col-md-offset-1"> <input type="text" th:value="" id="" name="" class="tableInput"> </div>
                <div class="col-md-3 "> <input type="text" th:value="" id="" name="" class="tableInput-large3"> </div>
                <div class="col-md-1 "> <input type="text" th:value="" id="" name="" class="tableInput"> </div>
                <div class="col-md-1 "> <input type="text" th:value="" id="" name="" class="tableInput"> </div>
                <div class="col-md-1 "> <input type="text" th:value="" id="" name="" class="tableInput"> </div>
                <div class="col-md-1 "> <input type="text" th:value="" id="" name="" class="tableInput"> </div>
                <div class="col-md-1 "> <input class="addRow" id = "" type="submit" value="добавить"></div>
                </form>
            </div>  
        </div>
        <div class="container" id="footer">
            <div id="footerImage"></div>
            <div id="footerText">&copy; Oak Botanical Garden 2018</div>
        </div>
    </body>
</HTML>>

