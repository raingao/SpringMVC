<%--
  Created by IntelliJ IDEA.
  User: 高宇
  Date: 2017/3/3
  Time: 1:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>编辑界面</title>
    <style>
        table, tr, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath }/items/updateItems" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <th>ID:</th>
            <th>姓名：</th>
            <th>价格：</th>
            <th>详情：</th>
            <th>图片：</th>
        </tr>
        <tr>
            <td><input type="text" name="id" value="${item.id}"></td>
            <td><input type="text" name="name" value="${item.name}"></td>
            <td><input type="text" name="price" value="${item.price}"></td>
            <td><input type="text" name="detail" value="${item.detail}"></td>
            <td><input type="file" name="items_pic"><img src="/upload/${item.pic}" style="width: 100px; height: 100px;"/></td>
        </tr>
        <tr>
            <td colspan="4" align="center">
                <button type="submit">提交更改</button>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
