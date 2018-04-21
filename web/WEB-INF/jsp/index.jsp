<<<<<<< HEAD
<%@page import="org.springframework.web.servlet.DispatcherServlet"%>
=======
<%@page import="org.springframework.ui.ModelMap"%>
>>>>>>> 4152336142286e463b15d632a6d18ae8e285c0c2
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
                                    //ServletContext context = config.getServletContext();
                                    //WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
                                   // String roletest = context.getAttribute("userrole").toString();
                                    Cookie cookies[] = request.getCookies();
                                    System.out.println(cookies.length);
                                    for (int i = 0; i < cookies.length; i++){
                                        if (cookies[i].getName().equals("role")) {
                                            System.out.println("!!! " + i);
                                        }
                                    }
                                    
                                    String role = "0"; //user // Role - userrole(String)

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
                String src="";
                if (role.equals("1")) {
                    src = "user.png";
                } else {
                    src = "manager.png";
                }

            %>   
            <div class="row">         
                <div class="col-md-2 col-md-offset-2 ">
                    <img src=<%=src%> height='150' id="avatar"/>
                </div>
                
               
                        <div class="col-md-3">
                            <div>Логин</div>
                            <input class="profile" type="text" id="login" name="login" value="${userlogin}" readonly> 
                            <div>Имя</div>
                            <input class="profile" type="text" id="name" name="name" value="${profile.getName()}" readonly> 
                            <div>Фамилия</div>
                            <input class="profile" type="text" id="surname" name="surname" value="${profile.getSurname()}" readonly> 
                            <div>Должность</div>
                            <input class="profile" type="text" id="position" name="position" value="${profile.getSpecialization()}" readonly> 
                            <div>Характеристика</div>
                            <textarea id="characterstic" name="characterstic" readonly>${profile.getAbout()} </textarea>  </div>  
                            <div class="col-md-3">
                    <span>Задания</span>
                    <textarea id="tasks" name="tasks" >${jobs}</textarea>
                </div>
              
            </div>
        </div>
        <div class="container" id="footer">
            <div id="footerImage"></div>
            <div id="footerText">&copy; Oak Botanical Garden 2018</div>
        </div>
    </body>
</HTML>>