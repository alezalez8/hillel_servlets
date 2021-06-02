<%--
  Created by IntelliJ IDEA.
  User: Aleks_alez
  Date: 02.06.2021
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" enctype="multipart/form-data"

<table width="400px" align="center" border=0>


    <p>Name : ${name}</p>



    <%--    <img src="${pageContext.request.contextPath}/img/1.jpg" height="400" width="400"/>--%>
    <img src="${pageContext.request.contextPath}/images/${name}" height="400" width="400"/>
</body>
</html>
