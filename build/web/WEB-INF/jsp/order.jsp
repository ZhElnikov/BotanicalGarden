
<%@page import="model.pojo.RequestFert"%>
<%@page import="model.pojo.RequestTree"%>
<%@page import="java.util.List"%>

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<HTML>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
        <style>
            <%@include file="/WEB-INF/css/styles.css"%>    
        </style>
        <script>
            <%@include file="/WEB-INF/js/order.js"%>
        </script>
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
            <%
                if (role.equals("1")) {
            %>   
            <div class="row">         
                <div class="col-md-4 col-md-offset-4 ">
                    <FORM method="post" action="#" th:action="" th:object="" name="orderForm">
                        <div class="radiobtn">
                            <div class="row">         
                                <div class="col-md-6 ">
                            <input type="radio" name="target" value="fertilizer"> Удобрение 
                            </div>
                                 <div class="col-md-5" >
                            <input type="radio" name="target" value="tree" checked> Саженец
                             </div>
                                </div>
                        </div>
                        <div>Название заявки</div> 
                        <input type="text" th:value="" id="orderInput" name="orderInput"> 
                        <div>Обоснование заявки</div> 
                        <textarea id="order" name="order" ></textarea>
                        <div class="centerPos">
                            <input class="bigButton" id = "orderBtn" type="submit" value="Подать заявку"></div>             
                    </FORM>
                </div></div>
            <div class="row">      
                <%}

                    //List<RequestFert> fertList = (List<RequestFert>) request.getAttribute("fertList");
                    if (role.equals("2")) {
                        List<RequestTree> treeList = (List<RequestTree>) request.getAttribute("treeList");
                        List<String> treeNames = (List<String>) request.getAttribute("treeNames");
                        for (int i = 0; i < treeList.size(); i++) {
                        RequestTree reqtree = treeList.get(i);
                        String textareaid = "textareaid" + String.valueOf(i);
                        String panelid = "panelid" + String.valueOf(i);
                        String purposeid = "purposeid" + String.valueOf(i);
                        String amountid = "amountid" + String.valueOf(i);
                        String approvebtn = "approvebtn" + String.valueOf(i);
                        String declinebtn = "declinebtn" + String.valueOf(i);
                %>       
                <div class="col-md-4">     
                    <form method="post" th:action="@{/order/response.htm}" th:object="${attrs}" action="order/response.htm" name="orderForm">
                        <div class="panel panel-default">
                            <div class="panel-body" id =<%=panelid%>>
                                 <input type="hidden" th:value="${attrs.id}" id="id" name="id" value="<%=reqtree.getIdRequestTree()%>">
                                 <input type="hidden" th:value="${attrs.type}" id="type" name="type" value="Деревья"> 
                                <input type="text" value="<%=treeNames.get(i)%>" name="names" id="names" readonly> -
                                <input type="text" value="<%=reqtree.getQuantity()%>" name="amount" id=<%=amountid%>  readonly> 
                                <div>
                                    <textarea class = "smallOrder" name="order" id=<%=textareaid%>  readonly><%=reqtree.getBody()%></textarea>   
                                </div>
                                <input class="aproveBtn" th:value="${attrs.status}" type="submit" value="Подтвердить" id="status" name="status" > 
                                <input class="declineBtn" th:value="${attrs.status}" type="submit" value="Отказать" id="status" name="status" >
                            </div>
                        </div> 
                    </form>
                </div>
                <%}
                    List<RequestFert> fertList = (List<RequestFert>) request.getAttribute("fertList");
                    for (int i = 0; i < fertList.size(); i++) {
                        RequestFert reqfert = fertList.get(i);
                        String textareaid = "textareaid" + String.valueOf(i);
                        String panelid = "panelid" + String.valueOf(i);
                        String purposeid = "purposeid" + String.valueOf(i);
                        String amountid = "amountid" + String.valueOf(i);
                        String approvebtn = "approvebtn" + String.valueOf(i);
                        String declinebtn = "declinebtn" + String.valueOf(i);
                %> 
                <div class="col-md-4">     
                    <form method="post" th:action="@{/order/response.htm}" th:object="${attrs}" action="order/response.htm" name="orderForm">
                        <div class="panel panel-default">
                            <div class="panel-body" id =<%=panelid%>>
                                <input type="hidden" th:value="${attrs.id}" id="id" name="id" value="<%=reqfert.getIdRequestFert()%>">
                                <input type="hidden" th:value="${attrs.type}" id="type" name="type" value="Удобрения"> 
                                <input type="text" value="<%=reqfert.getFertName()%>" name="names" id="names" readonly> -
                                <input type="text" value="<%=reqfert.getQuantity()%>" name="amount" id=<%=amountid%>  readonly> 
                                <div>
                                    <textarea class = "smallOrder" name="order" id=<%=textareaid%>  readonly><%=reqfert.getBody()%></textarea>   
                                </div>
                                <input class="aproveBtn" th:value="${attrs.status}" type="submit" value="Подтвердить" id="status" name="status" > 
                                <input class="declineBtn" th:value="${attrs.status}" type="submit" value="Отказать" id="status" name="status" >
                            </div>
                        </div> 
                    </form>
                </div>
            <%}}%>
            </div>
        </div>
        <div class="container" id="footer">
            <div id="footerImage"></div>
            <div id="footerText">&copy; Oak Botanical Garden 2018</div>
        </div>
    </body>
</HTML>>