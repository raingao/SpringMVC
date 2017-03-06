<%--
  Created by IntelliJ IDEA.
  User: Mingze-2
  Date: 2017/3/2
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询界面</title>
    <style>
        table, tr, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>多选</th>
        <th>姓名：</th>
        <th>价格：</th>
        <th>详情：</th>
        <th>图片：</th>
        <th>编辑：</th>
        <th>删除：</th>
    </tr>
    <c:forEach items="${items}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.price}</td>
            <td>${item.detail}</td>
            <td><img src="/upload/${item.pic}"/></td>
            <td><a href="edit/${item.id}">编辑</a></td>
            <td><a href="delete/${item.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
