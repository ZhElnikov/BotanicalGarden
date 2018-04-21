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
                <img src="https://i.imgur.com/VYTMGtC.png" height='150' id='logo'/>
            </div>
            <div class="col-md-9 " id="accountData">
                <div>
                    <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                    <span id="username">название учетной записи</span>
                </div>
                <div>
                    <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
                    <span><a action="" method="" > Выход </a></span>
                </div>
            </div>
        </div>
        <div clas="navigationPanel">
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#">Личный кабинет</a>
                    </div>
                    <div id="mainmenu">
                        
                            <ul class="nav navbar-nav">
                        <%
                        int role = 1; //user
                        ArrayList<String> pages = new ArrayList<String>();
                        ArrayList<String> links = new ArrayList<String>();
                        if(role==1){
                            pages.add("Профиль"); links.add("/BotanicalGarden/index.htm");
                            pages.add("График и план"); links.add("/plan");
                            pages.add("Заявка на покупку");links.add("/order");
                        }  else {
                            pages.add("Профиль"); links.add("/BotanicalGarden/index.htm");
                            pages.add("График и план"); links.add("/plan");
                            pages.add("Заявки на покупку");links.add("/order");
                            pages.add("Работа сада");links.add("/garden");
                            pages.add("Экскурсии");links.add("/excursion");
                        }
                        for (int i=0;i<pages.size();i++){
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
       
       <div class="panel panel-default">
       <div class="panel-heading">Задание 1</div>
            <div class="panel-body">
            
            </div>
        </div>
    </div>
    <div class="container" id="footer">
        <div id="footerImage"></div>
        <div id="footerText">&copy; Oak Botanical Garden 2018</div>
    </div>
</body>
</HTML>>