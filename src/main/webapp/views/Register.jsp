<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form Đăng Ký</title>
    <style>
        body {
        
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f2f2f2;
        }
        .form-container {
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }
        .form-container h2 {
            margin-bottom: 20px;
            font-size: 24px;
            text-align: center;
        }
        .form-container label {
            display: block;
            margin-bottom: 5px;
        }
        .form-container input {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .form-container button {
            width: 100%;
            padding: 10px;
            background-color: #28a745;
            border: none;
            border-radius: 4px;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
        }
        .form-container button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    	<div class="form-container">
        <h2>Đăng Ký</h2>
        <form action="Register" method="post">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>

            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>

            <label for="fullname">Họ và tên:</label>
            <input type="text" id="fullname" name="fullname" required>

            <label for="password">Mật khẩu:</label>
            <input type="password" id="password" name="password" required>

            <label for="phone">Số điện thoại:</label>
            <input type="tel" id="phone" name="phone" required>

            <label for="confirm_password">Xác nhận mật khẩu:</label>
            <input type="password" id="confirm_password" name="confirm_password" required>

            <button type="submit">Đăng Ký</button>
        </form>
    	</div>
</body>
</html>