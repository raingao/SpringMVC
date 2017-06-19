<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>login</title>
</head>
<body>

<form action="/login/userlogin" method="post">
    <table>
        <tr>
            <td>username:</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>password:</td>
            <td><input type="password" name="password" required></td>
        </tr>
    </table>
    <button type="submit">submit</button>
    <button type="reset">reset</button>
</form>
</body>
</html>
