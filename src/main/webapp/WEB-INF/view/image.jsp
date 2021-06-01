<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="javax.imageio.ImageIO" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.ByteArrayOutputStream" %><%--
  Created by IntelliJ IDEA.
  User: Aleks_alez
  Date: 31.05.2021
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="UploadImage" method="post" enctype="multipart/form-data"

<table width="400px" align="center" border=0>

    <img src="${pageContext.request.contextPath}/img/1.jpg" height="200" width="200"/>

</table>
</form>
</body>
</html>
