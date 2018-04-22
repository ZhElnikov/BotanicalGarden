<%@page import="model.pojo.Job"%>
<%@page import="model.pojo.Profile"%>
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
        <style><%@include file="/WEB-INF/css/styles.css"%></style>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>        
        <script> <%@include file="/WEB-INF/js/main.js"%></script>

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

            <%if (role.equals("2")) {%>
            <form method="post" action="" th:action="@{/plan}" th:object="${job}"  th:object="${profile}" name="planForm">
                <div class="row">         
                    <div class="col-md-7 col-md-offset-4">
                        <div class="row">         
                            <div class="col-md-4">
                                <div>Начало</div>
                                <input type="text" th:value="${job.startDate}" id="startDate" name="startDate" class="planinput" > 
                            </div>
                <div class="col-md-4">
                                <div>Дедлайн</div>
                                <input type="text" th:value="${job.deadline}" id="deadline" name="deadline" class="planinput" > 
                            </div>
                        </div>
                        <div>Описание задачи</div> 
                        <textarea id="body" name="body"></textarea>
                        <div class="row">         
                            
                            <div class="col-md-5">
                                <div>Выбор работника</div> 
                                <select th:value="${profile.name}" id="name" name="name">
                                     <%
                                        List<Profile> profiles = (List<Profile>) request.getAttribute("profiles");
                                        for (int i = 0; i < profiles.size(); i++) {
                                            String string = (i + (int)1) + ". " + profiles.get(i).getName() + " " + profiles.get(i).getSurname();
                                     %>
                                    <option><%=string%></option>
                                    <%}%>
                                </select>  
                            </div>
                            <div class="col-md-4">
                            <input class="bigButton" id ="createBtn" type="submit" value="Создать"> 
                        </div>
 </div>
                         </div>
                </div>
                
               
            </form>  


            <div class="row"> 
                <%
                    List<String> allJobs = (List<String>) request.getAttribute("alljobs");
                    for (int i = 0; i < allJobs.size(); i++) {
                        String textareaid = "textareaid" + String.valueOf(i);
                        String panelid = "panelid" + String.valueOf(i);
                        String buttonid = "buttonid" + String.valueOf(i);
                %>
                
                    <div class="col-md-4">  
                        <form method="post" th:action="@{/plan/delete.htm}" th:object="${job}" action="plan/delete.htm" name="planForm">
                        <div class="panel panel-default">
                            <input type="hidden" th:value="${job.idJob}" id="idJob" name="idJob" value="<%=i+1%>"  > 
                            <div class="panel-body" id="<%=panelid%>">
                                <div>
                                    <textarea class="smallOrder2" name="order" id=<%=textareaid%>  readonly><%=allJobs.get(i)%></textarea>   
                                </div>
                                <input class="deleteBtn" type="submit" value="Удалить" id = <%=buttonid%> >
                            </div>
                        </div>   
                             </form>
                    </div>
               
                <%}%>
            </div>
            <%}
                if (role.equals("1")) {
            %>
            <div class="row"> 
                <%
                    List<Job> userJobs = (List<Job>) request.getAttribute("userjobs");
                    for (int i = 0; i < userJobs.size(); i++) {
                                String textareaid = "textareaid" + String.valueOf(i);
                                String panelid = "panelid" + String.valueOf(i);
                                String buttonid = "buttonid" + String.valueOf(i);
                                String nres = "Задание: " + userJobs.get(i).getBody() + "\r\nсрок - " + userJobs.get(i).getDeadline();
                    %>
                <div class="col-md-4"> 
                    <form method="post" th:action="@{/plan/complete.htm}" th:object="${job}" action="plan/complete.htm"  name="planForm">
                        <div class="panel panel-default">
                            <input type="hidden" th:value="${job.idJob}" id="idJob" name="idJob" value="<%=userJobs.get(i).getIdJob()%>"  > 
                            
                            <div class="panel-body" id=<%=panelid%>>
                                <div>
                                    <textarea class="smallOrder2" name="order" id=<%=textareaid%> readonly><%=nres%></textarea>   
                                </div>
                                <input class="completeBtn" type="submit" value="Выполнено" id = <%=buttonid%>>
                            </div>
                        </div>  
                    </form>
                </div>
                <%}%>
            </div>
            <%}%>
        </div>
        <div class="scrolltop"></div>
        <div class="container" id="footer">
            <div id="footerImage"></div>
            <div id="footerText">&copy; Oak Botanical Garden 2018</div>
        </div>
    </body>
</HTML>>