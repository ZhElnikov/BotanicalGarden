<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<HTML>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
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
                            
        <div class="row">
                <div class="col-md-6">                    
     
           <div class="sectors">
             <div class="rect" id="rectangle1" onmouseover="this.style.backgroundColor='forestgreen';" onmouseout="this.style.backgroundColor='limegreen';"><a href="garden/1.htm" class="linktree" id="linktree-1">Сектор 1</a></div>             
             <div id="rectangle2" class="rect" onmouseover="this.style.backgroundColor='forestgreen';" onmouseout="this.style.backgroundColor='palegreen';"><a href="garden/2.htm" class="linktree" id="linktree-2">Сектор 2</a></div> 
             <div id="rectangle3" class="rect" onmouseover="this.style.backgroundColor='forestgreen';" onmouseout="this.style.backgroundColor='greenyellow';"><a href="garden/3.htm" class="linktree" id="linktree-3">Сектор 3</a></div>  
             <div id="rectangle4" class="rect" onmouseover="this.style.backgroundColor='forestgreen';" onmouseout="this.style.backgroundColor='green';"><a href="garden/4.htm" class="linktree" id="linktree-4">Сектор 4</a></div>  
             <div id="rectangle5" class="rect" onmouseover="this.style.backgroundColor='forestgreen';" onmouseout="this.style.backgroundColor='darkolivegreen';"><a href="garden/5.htm" class="linktree" id="linktree-5" >Сектор 5</a></div>  
             <div id="rectangle6" class="rect" onmouseover="this.style.backgroundColor='forestgreen';" onmouseout="this.style.backgroundColor='#9fdd7a';"><a href="garden/6.htm" class="linktree" id="linktree-6">Сектор 6</a></div>  
             <div id="rectangle7" class="rect" onmouseover="this.style.backgroundColor='forestgreen';" onmouseout="this.style.backgroundColor='#d3faa7';"><a href="garden/7.htm" class="linktree" id="linktree-7">Сектор 7</a></div>  
           </div> 
                
                </div>
            <div class="col-md-2">
           <div>Фото</div> 
                <img src="tree0.png" height='250' width="190" class='hint'/></div>
            <div class="col-md-4">
          <div>описание сектора</div> 
                <textarea id="sectorDescription" name="sectorDescription" >${info}</textarea>                  
                            
            </div>                

        </div>
        
         </div>    
        <div class="scrolltop"></div>
        <div class="container" id="footer">
            <div id="footerImage"></div>
            <div id="footerText">&copy; Oak Botanical Garden 2018</div>
        </div>
    </body>
</HTML>