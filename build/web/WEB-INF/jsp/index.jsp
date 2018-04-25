
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<HTML>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <style><%@include file="/WEB-INF/css/styles.css"%></style>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>        
        <script> <%@include file="/WEB-INF/js/main.js"%></script>
        <script> <%@include file="/WEB-INF/js/profileValidation.js"%></script>
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
                                <li><a id="navbar" href=<%=links.get(i)%>>
                                        <%=pages.get(i)%>
                                    </a></li>
                                    <%}%>   
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>

            <%
                String src = "";
                if (role.equals("1")) {
                    src = "user.png";
                } else {
                    src = "manager.png";
                }

            %>   
            <h3>Мой профиль</h3>
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
            <%
                if (role.equals("2")) {
            %>
            <h3>Создать профиль</h3>
            <form method="post" th:action="" th:object="" action=""  name="createProfileForm">
                <div class="row">         
                    <div class="col-md-3 col-md-offset-1 ">
                        <span>Логин</span>
                        <span class="errorMsg" id="symbol-login">Недопустимые символы!</span>
                        <span class="errorMsg" id="length-login">Длина 1-45 символов!</span>
                        <input class="createProfile login" type="text" id="createlogin" name="" value="" >    
                        <span>Пароль</span>
                        <span class="errorMsg" id="symbol-password">Недопустимые символы!</span>
                        <span class="errorMsg" id="length-password">Длина 1-45 символов!!</span>
                        <input class="createProfile" type="text" id="createpassword" name="" value="" >    

                        <span>e-mail</span>
                        <span class="errorMsg" id="symbol-mail">Некорректно указан адрес!</span>
                        <span class="errorMsg" id="length-mail">Длина 1-45 символов!!</span>
                        <input class="createProfile" type="text" id="createmail" name="" value="" >    

                        <span>Должность</span>
                        <span class="errorMsg" id="symbol-position">Недопустимые символы!</span>
                        <span class="errorMsg" id="length-position">Длина 1-45 символов!!</span>
                        <input class="createProfile" type="text" id="createposition" name="" value="" >    
                    </div>
                    <div class="col-md-3 ">
                        <span>Имя</span>
                        <span class="errorMsg" id="symbol-name">Недопустимые символы!</span>
                        <span class="errorMsg" id="length-name">Длина 1-45 символов!</span>
                        <input class="createProfile" type="text" id="createname" name="" value="" >    
                        <span>Фамилия</span>
                        <span class="errorMsg" id="symbol-surname">Недопустимые символы!</span>
                        <span class="errorMsg" id="length-surname">Длина 1-45 символов!!</span>
                        <input class="createProfile" type="text" id="createsurname" name="" value="" >    
                        <span>Роль</span>
                        <select th:value="" id="" name="" class="createProfile">
                            <option>работник</option>
                            <option>менеджер</option>
                        </select> 
                    </div>   

                    <div class="col-md-4  ">
                        <span>Характеристика</span>
                        <span class="errorMsg" id="symbol-about">Недопустимые символы!</span>
                        <span class="errorMsg" id="length-about">Длина от 1 до 255 символов!</span>
                        <textarea id="createabout" name="" class="createArea"></textarea>
                    </div> 
                </div>        
            </form>
            <input class="createProfileBtn" id ="createProfileBtn" type="submit" value="Создать">   
            
            <h3>Все профили</h3>
            <div class="row">
                <%for (int i =0;i<5;i++) {
                %>                
                <div class="col-md-4"> 
                    <form method="post" th:action="" th:object="" action=""  name="profileForm">
                        <div class="panel panel-default">                          
                         <div class="panel-body" id="">
                        <div>Логин</div>
                        <input class="createProfile-l" type="text" id="logfield" name="" value="">   
                        <div>Пароль</div>
                        <input class="createProfile" type="text" id="" name="" value="" >    
                        <div>e-mail</div>
                        <input class="createProfile" type="text" id="" name="" value="" >    
                        <div>Должность</div>
                        <input class="createProfile" type="text" id="" name="" value="" >    
                         <div>Имя</div>
                        <input class="createProfile" type="text" id="" name="" value="" >    
                        <div>Фамилия</div>
                        <input class="createProfile" type="text" id="" name="" value="" >    
                        <div>Роль</div>     
                        <input class="createProfile" type="text" id="" name="" value="" >
                        <div>Характеристика</div>     
                        <input class="createProfile" type="text" id="" name="" value="" >    
                        <input class="deleteBtn" type="submit" value="Удалить" id = "">
                            </div>
                        </div>  
                    </form>
                </div>
                <%}%>
            </div>
            <%}%>
            <div class="scrolltop"></div>
        </div>
        <div class="container" id="footer">
            <div id="footerImage"></div>
            <div id="footerText">&copy; Oak Botanical Garden 2018</div>
        </div>
    </body>
</HTML>