<%--
  Created by IntelliJ IDEA.
  User: Quitomos
  Date: 2021/3/10
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>

<html>
<head>
    <title>upload</title>
</head>
<body>
<form action="uploadImage" method="post" enctype="multipart/form-data">
    选择图片:<input type="file" name="image" accept="image/*" /> <br>
    <input type="submit" value="上传">
</form>
</body>
</html>
