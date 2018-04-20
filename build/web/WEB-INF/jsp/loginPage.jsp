<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="styles.css" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
</head>

<body>
    <div class="container">
        <div class="panel panel-default" id="loginForm">
            <div class="panel-body">
                 <form action="" method="post" commandName="user">
                <div id="loginTitle">???????????</div>
                <div class="row">
                    <div class="col-md-5 col-sm-1">
                        <img src="logo2.png" height=200 id="logoBig">
                    </div>
                    <div class="col-md-7" id="loginFields">
                        <div>
                        <div id="loginField">
                            <i class="fa fa-user-circle" aria-hidden="true" path="login"></i>
                            <span>?????</span>
                        </div>
                        <input type="text" id="loginInp">
                        <div id="passwordField">
                            <i class="fa fa-key" aria-hidden="true" path="password"></i>
                            <span>??????</span>
                        </div>
                        <input type="password" id="passwInp"></div>
                       <a class="bigButton" href="onSubmit" id="loginBtn" action="onSubmit">?????</a>
                    </div>
                </div>
                </form>
            </div>
        </div>
    </div>
</body>