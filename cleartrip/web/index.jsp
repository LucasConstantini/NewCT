<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="WEB-INF/imports.jspf"%>
<html>
    <head>

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/reset.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap-responsive.css" rel="stylesheet">
        <link href="css/tabela.css" rel="stylesheet">
        <link href="css/login.css" rel="stylesheet">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>

    </head>
    <body>
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">

                <a class="brand" href="">ClearTrip</a>
            </div>
        </div>
        <br /><br /><br />

        <div class="span12" style="text-align:center; margin: 0 auto;">
            <mtw:form klass="form-horizontal" method="post" action="Login.mtw">
                <fieldset>
                    <!-- Text input-->
                    <div class="control-group">
                        <div class="controls">
                            <label for="mail">Login</label>
                            <mtw:input id="mail" name="login" type="text" klass="input-xlarge" />
                        </div>
                    </div>

                    <!-- Password input-->
                    <div class="control-group">
                        <div class="controls">
                            <label for="pwd">Senha</label>
                            <mtw:input id="pwd" name="senha" type="password" klass="input-xlarge" />
                        </div>
                    </div>

                    <!-- Button -->
                    <div class="control-group">
                        <label class="control-label" for="entrar"></label>
                        <div class="controls">
                            <button type="submit" name="entrar" class="btn btn-primary">Entrar</button>
                        </div>
                    </div>
                </fieldset>
            </mtw:form>
        </div>
    </body>
</html>