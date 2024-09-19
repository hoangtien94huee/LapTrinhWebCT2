<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Quên mật khẩu</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	background-color: #f4f4f4;
}

.container {
	background-color: white;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	max-width: 400px;
	width: 100%;
}

.container h2 {
	text-align: center;
	margin-bottom: 20px;
}

.container form {
	display: flex;
	flex-direction: column;
}

.container form input {
	padding: 10px;
	margin: 10px 0;
	border: 1px solid #ccc;
	border-radius: 5px;
}

.container form button {
	padding: 10px;
	background-color: #4CAF50;
	color: white;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.container form button:hover {
	background-color: #45a049;
}
</style>
</head>
<body>
	<div class="container">
		<h2>Quên mật khẩu</h2>
		<form action="forgetpassword" method="post">
			<label for="username">Tên người dùng:</label> <input type="text"
				id="username" name="username" required
				placeholder="Nhập tên người dùng"> <label for="newPassword">Mật
				khẩu mới:</label> <input type="password" id="newPassword" name="newPassword"
				required placeholder="Nhập mật khẩu mới"> <label
				for="confirmPassword">Xác nhận mật khẩu:</label> <input
				type="password" id="confirmPassword" name="confirmPassword" required
				placeholder="Xác nhận mật khẩu mới"> <input type="submit">
			</button>
		</form>
	</div>
</body>
</html>






