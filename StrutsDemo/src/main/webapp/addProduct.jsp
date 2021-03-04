<%--
  Created by IntelliJ IDEA.
  User: Quitomos
  Date: 2021/3/3
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="addProduct">
        <input type="text"  name="product.name" value="${param.name}">
        <br/>
        <input type="submit"    value="submit">
    </form>
</body>
</html>
