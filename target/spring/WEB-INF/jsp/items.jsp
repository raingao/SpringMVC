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
    <meta charset="utf8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/static/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
    <link href="/static/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <script src="/static/bootstrap/js/bootstrap.min.js"></script>
    <script src="/static/js/jquery-3.2.1.slim.min.js"/>
</head>
<body>
<div class="table-responsive">
    <table class="table">
        <caption>响应式表格布局</caption>
        <thead>
        <tr>
            <th>产品</th>
            <th>付款日期</th>
            <th>状态</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>产品1</td>
            <td>23/11/2013</td>
            <td>待发货</td>
        </tr>
        <tr>
            <td>产品2</td>
            <td>10/11/2013</td>
            <td>发货中</td>
        </tr>
        <tr>
            <td>产品3</td>
            <td>20/10/2013</td>
            <td>待确认</td>
        </tr>
        <tr>
            <td>产品4</td>
            <td>20/10/2013</td>
            <td>已退货</td>
        </tr>
        </tbody>
    </table>
</div>
<%--<table class="table table-hover">--%>
    <%--<tr>--%>
        <%--<th>多选</th>--%>
        <%--<th>姓名：</th>--%>
        <%--<th>价格：</th>--%>
        <%--<th>详情：</th>--%>
        <%--<th>图片：</th>--%>
        <%--<th>编辑：</th>--%>
        <%--<th>删除：</th>--%>
    <%--</tr>--%>
    <%--<c:forEach items="${items}" var="item">--%>
        <%--<tr>--%>
            <%--<td>${item.id}</td>--%>
            <%--<td>${item.name}</td>--%>
            <%--<td>${item.price}</td>--%>
            <%--<td>${item.detail}</td>--%>
            <%--<td><img src="/upload/${item.pic}" style="width: 100px; height: 100px;"/></td>--%>
            <%--<td><a href="edit/${item.id}">编辑</a></td>--%>
            <%--<td><a href="delete/${item.id}" onclick="confirm('是否确认删除');">删除</a></td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
<%--</table>--%>

</body>
</html>
