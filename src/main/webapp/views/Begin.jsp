<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Chủ</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background-color: #f2f2f2;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background-color: #fff;
            padding: 50px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
        }
        h1 {
            margin-bottom: 30px;
        }
        .button {
            padding: 10px 20px;
            margin: 10px;
            font-size: 16px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>Chào Mừng Bạn!</h1>
        <p>Vui lòng chọn chức năng bạn muốn thực hiện:</p>
        <!-- Nút chuyển sang trang đăng nhập -->
        <form action="login.jsp" method="get">
            <button class="button">Đăng Nhập</button>
        </form>

        <!-- Nút chuyển sang trang đăng ký -->
        <form action="Register.jsp" method="get">
            <button class="button">Đăng Ký</button>
        </form>
    </div>

</body>
</html>
