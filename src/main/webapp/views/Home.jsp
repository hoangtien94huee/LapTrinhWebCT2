<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Home</title>
</head>
<body>
    <h1>Chào mừng Admin ${username}</h1>
    <p>Đây là trang quản trị.</p>

    <!-- Nút Đăng xuất -->
    <form action="login" method="post">
        <input type="submit" value="Đăng xuất">
    </form>
</body>
</html>
