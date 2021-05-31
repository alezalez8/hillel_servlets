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
<%--<img src="${pageContext.request.contextPath}"/>--%>
<form action="UploadImage" method="post" enctype="multipart/form-data"
      name="productForm" id="productForm"><br><br>
    <table width="400px" align="center" border=0 >
        <tr>
            <td align="center" colspan=2 style="font-weight:bold;font-size:20pt;">
                Image Details</td>
        </tr>


<%
    BufferedImage bImage = ImageIO.read(new File("/ua/1.jpg"));//give the path of an image
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ImageIO.write( bImage, "jpg", baos );
    baos.flush();
    byte[] imageInByteArray = baos.toByteArray();
    baos.close();
    String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(imageInByteArray);
%>
<%--
<div>
    <p>As of v6, Java SE provides JAXB</p>
    <img src="data:image/jpg;base64, <%=b64%>" alt="Visruth.jpg not found" />
</div>--%>


</body>
</html>
