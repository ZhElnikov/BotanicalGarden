<%@page import="model.pojo.Tour"%>
<%@page import="java.util.List"%>
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>        
        <script> <%@include file="/WEB-INF/js/main.js"%></script>
        <script> <%@include file="/WEB-INF/js/excursionValidation.js"%></script>
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
                        <div class="navbar-header">
                            <a class="navbar-brand" href="index.htm">Личный кабинет</a>
                        </div>
                        <div id="mainmenu">

                            <ul class="nav navbar-nav">
                                <%
                                    String role = request.getAttribute("userrole").toString();
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
                            <h3>Создание экскурсии</h3>
            <form method="post" th:action="@{/excursion.htm}" th:object="${tour}" action="excursion.htm" name="exAddForm">
                <div class="row">         
                    <div class="col-md-7 col-md-offset-4">
                        <div class="row">         
                            <div class="col-md-4">
                                <span>Начало</span> 
                                <span class="errorMsg" id="start-empty">Не выбрана!</span>
                                <input type="date" th:value="${tour.startDate}" id="startDate" name="startDate" class="planinput"> 
                            </div>
                            <div class="col-md-5">
                                <span>Окончание</span> 
                                <span class="errorMsg" id="end-empty">Не выбрана!</span>
                                <span class="errorMsg" id="end-today">Не раньше сегодня!</span>
                                <span class="errorMsg" id="wrong-interval">Не раньше начала!</span>
                                <input type="date" th:value="${tour.endDate}" id="endDate" name="endDate" class="planinput"> 
                            </div>
                        </div>
                        <span>Описание экскурсии</span> 
                        <span class="errorMsg" id="length-area">Длина от 1 до 255 символов!</span>
                        <span class="errorMsg" id="symbol-area">Недопустимые символы!</span>
                        <div>
                        <textarea id="body" name="body" class="bigArea"></textarea>
                        </div>
                        <div class="row">         
                            <div class="col-md-5">
                                <span>Цена</span> 
                                <span class="errorMsg" id="length-price">Длина от 1 до 255 символов!</span>
                                <span class="errorMsg" id="symbol-price">Цена-положительное число!</span>
                                <div>
                                <input type="text" th:value="${tour.price}" id="price" name="price" class="planinput price-check"> 
                                <span>BYN</SPAN>
                                </div>
                              
                            </div>
                                <div class="col-md-1">
                                  <input class="createBtn bigButton btn" id = "createBtn" type="submit" value="Создать">    
                                </div>
                        
                        
                        
                        </div>
                       
                    </div>
                </div>
            </form>  

<h3>Все экскурсии</h3>
            <div class="row"> 
                <%
                    List<Tour> tours = (List<Tour>) request.getAttribute("tours");
                    for (int i = 0; i < tours.size(); i++) {
                        Tour tour = tours.get(i);
                        String body = "Тур: " + tour.getBody() + "\r\nс: " + tour.getStartDate() + " по: " + tour.getEndDate();
                %>
                <div class="col-md-4">  
                    <form method="post" th:action="@{/excursion/delete.htm}" th:object="${tour}" action="excursion/delete.htm" name="excursionForm">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <input type="hidden" th:value="${tour.idTour}" id="idTour" name="idTour" value="<%=tour.getIdTour()%>"  >
                            <div>
                                <textarea class="excArea" id="body" name="body" readonly><%=body%></textarea>   
                            </div>
                            <div class="row">
                                <div class="col-md-7"> 
                            <span>Цена</span>
                            <input type="text" th:value="${tour.price}" id="price" name="price" value="<%=tour.getPrice()%>" readonly>
                            </div>
                            <div class="col-md-2"> 
                            <input class="declineBtn btnLeft" id = "deleteBtn" type="submit" value="Удалить">
                            </div>
                            </div>
                        </div>
                    </div>   
                    </form>
                </div>
                <%}%>
            </div>
        </div>
        <div class="scrolltop"></div>
        <div class="container" id="footer">
            <div id="footerImage"></div>
            <div id="footerText">&copy; Oak Botanical Garden 2018</div>
        </div>
    </body>
</HTML>>