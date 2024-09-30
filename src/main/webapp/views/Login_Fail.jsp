<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Failed</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background-color: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 300px;
        }
        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }
        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="checkbox"] {
            margin-right: 10px;
        }
        .remember-me {
            display: flex;
            align-items: center;
            margin-bottom: 15px;
        }
        .button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 10px;
        }
        .button:hover {
            background-color: #0056b3;
        }
        .links {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
        }
        .links a {
            color: #007bff;
            text-decoration: none;
        }
        .links a:hover {
            text-decoration: underline;
        }
        .error {
            color: red;
            font-size: 0.9em;
            margin: 5px 0;
        }
        .password-container {
            position: relative;
        }
        .toggle-password {
            position: absolute;
            right: 10px;
            top: 50%;
            transform: translateY(-50%);
            cursor: pointer;
            color: #007bff;
            background: none;
            border: none;
        }
        .alert {
            color: red;
            text-align: center;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Login Failed</h2>
        <c:if test="${not empty alert}">
            <p class="alert">${alert}</p>
        </c:if>
        <form id="loginForm" action="login" method="post" onsubmit="return validateForm()">
            <input type="text" id="username" name="username" placeholder="Username"><br>
            <span id="usernameError" class="error"></span>
            
            <div class="password-container">
                <input type="password" id="password" name="password" placeholder="Password"><br>
                <button type="button" class="toggle-password" onclick="togglePassword()">Show</button>
            </div>
            <span id="passwordError" class="error"></span>
            
            <div class="remember">
                <input type="checkbox" name="remember"> Nhớ tôi <!-- Nút nhớ tôi -->
            </div>
            <input type="submit" class="button" value="Login">
        </form>

        <div class="links">
            <a href="Register">Register</a>
            <a href="forgetpassword">Forget Password</a>
        </div>
    </div>

    <script>
        // Toggle password visibility
        function togglePassword() {
            var passwordField = document.getElementById('password');
            var toggleButton = document.querySelector('.toggle-password');
            if (passwordField.type === "password") {
                passwordField.type = "text";
                toggleButton.textContent = "Hide";
            } else {
                passwordField.type = "password";
                toggleButton.textContent = "Show";
            }
        }

        // Form validation
        function validateForm() {
            var username = document.getElementById('username').value;
            var password = document.getElementById('password').value;
            var isValid = true;

            // Clear previous error messages
            document.getElementById('usernameError').textContent = '';
            document.getElementById('passwordError').textContent = '';

            // Validate username
            if (username === "") {
                document.getElementById('usernameError').textContent = 'Username is required';
                isValid = false;
            }

            // Validate password
            if (password === "") {
                document.getElementById('passwordError').textContent = 'Password is required';
                isValid = false;
            }

            return isValid;
        }
    </script>
</body>
</html>
