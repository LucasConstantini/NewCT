<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/reset.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap-responsive.css" rel="stylesheet">
        <link href="css/tabela.css" rel="stylesheet">
        <link href="css/font-awesome.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="jquery.maskedinput-1.3.min.js"></script>
        <script src="jquery.maskMoney.js"></script>
        
        <title>ClearTrip</title>     
    </head>
    <body>
        <template:block id="menu"/>
        <div class="container">
            <template:block id="header"/>
            <div class="span12" style="text-align:center; margin: 0 auto;">
                <template:block id="body"/>
            </div>
            <template:block id="footer"/>
        </div>
    </body>
</html>
