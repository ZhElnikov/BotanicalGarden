<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
                    <img src="logo2.png" height='150' id='logo'/>
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
                        <div class="navbar-header">
                            <a class="navbar-brand" href="index.htm">Личный кабинет</a>
                        </div>
                        <div id="mainmenu">

                            <ul class="nav navbar-nav">
                                <%
                                    String role = "2"; //user // Role - userrole(String)
                                    ArrayList<String> pages = new ArrayList<String>();
                                    ArrayList<String> links = new ArrayList<String>();
                                    if (role.equals("1")) {
                                        pages.add("Профиль");
                                        links.add("index.htm");
                                        pages.add("График и план");
                                        links.add("plan.htm");
                                        pages.add("Заявка на покупку");
                                        links.add("order.htm");
                                    } else {
                                        pages.add("Профиль");
                                        links.add("index.htm");
                                        pages.add("График и план");
                                        links.add("plan.htm");
                                        pages.add("Заявки на покупку");
                                        links.add("order.htm");
                                        pages.add("Работа сада");
                                        links.add("garden.htm");
                                        pages.add("Экскурсии");
                                        links.add("excursion.htm");
                                    }
                                    for (int i = 0; i < pages.size(); i++) {
                                %>
                                <li><a href=<%=links.get(i)%>>
                                        <%=pages.get(i)%>
                                    </a></li>
                                    <%}%>   
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>


            <form method="post" action="#" th:action="" th:object="" name="planForm">
                <div class="row">         
                    <div class="col-md-7 col-md-offset-4">
                        <div class="row">         
                            <div class="col-md-4">
                                <div>Начало</div> 
                                <input type="date" th:value="" id="startDate" name="startDate" class="planinput"> 
                            </div>
                            <div class="col-md-4">
                                <div>Окончание</div> 
                                <input type="date" th:value="endDate" id="" name="endDate" class="planinput"> 
                            </div>
                        </div>
                        <div>Описание экскурсии</div> 
                        <textarea id="description" name="description" ></textarea>
                        <div class="row">         
                            <div class="col-md-5">
                                <div>Цена</div> 
                                <input type="text" th:value="price" id="" name="price" class="planinput"> 
                                <span>BYN</SPAN>
                            </div>
                        </div>
                        <input class="createBtn" id = "createBtn" type="submit" value="Создать"> 
                    </div>
                </div>
            </form>  


            <div class="row"> 
                <%for (int i = 0; i < 5; i++) {%>
                <div class="col-md-4">            
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div>
                                <textarea id="smallOrder2" name="order" ></textarea>   
                            </div>
                            <input class="declineBtn" id = "deleteBtn" type="submit" value="Удалить">
                        </div>
                    </div>        
                </div>
                <%}%>
            </div>
        </div>
        <div class="container" id="footer">
            <div id="footerImage"></div>
            <div id="footerText">&copy; Oak Botanical Garden 2018</div>
        </div>
    </body>
</HTML>>