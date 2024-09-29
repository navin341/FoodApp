<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="style.css"> <!-- link to your CSS file -->
</head>
<body>
  <div class="login-page">
    <h1>Login Page</h1>
    <form action="login">
      <table class="login-table">
        <tr>
          <td>Email</td>
          <td><input type="text" name="email" required></td>
        </tr>
        <tr>
          <td>Password</td>
          <td><input type="password" name="password" required></td>
        </tr>
        <tr>
          <td></td>
          <td><input type="submit" name="Login" value="Login"></td>
        </tr> 
      </table>
    </form>
  </div>
</body>
</html> 
<style>
 /* Global Styles */
body {
    font-family: 'Roboto', sans-serif;
    background-color: #f0f0f0;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

h1 {
    color: #333;
    margin-bottom: 30px;
    font-size: 30px;
    text-align: center;
    font-weight: 700;
}

/* Login Page Container */
.login-page {
    background-color: #ffffff;
    padding: 50px 40px;
    border-radius: 10px;
    box-shadow: 0 10px 20px rgba(0, 0, 0, 0.15);
    width: 100%;
    max-width: 400px;
    text-align: center;
}

.login-page form {
    display: flex;
    flex-direction: column;
    align-items: center;
}

.login-page input[type="text"], 
.login-page input[type="password"] {
    width: 100%;
    padding: 15px;
    margin-bottom: 20px;
    border-radius: 5px;
    border: 1px solid #ccc;
    font-size: 16px;
    background-color: #f9f9f9;
    transition: border-color 0.3s ease;
}

.login-page input[type="text"]:focus, 
.login-page input[type="password"]:focus {
    border-color: #007bff;
    outline: none;
}

.login-page input[type="submit"] {
    background-color: #007bff;
    color: white;
    padding: 15px;
    border: none;
    border-radius: 5px;
    font-size: 16px;
    cursor: pointer;
    transition: background-color 0.3s ease, transform 0.2s;
    width: 100%;
}

.login-page input[type="submit"]:hover {
    background-color: #0056b3;
    transform: translateY(-3px);
}

/* Table Styles */
.login-table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 20px;
}

.login-table td {
    padding: 10px;
}

.login-table td:first-child {
    text-align: left;
    font-weight: bold;
    color: #555;
    width: 30%;
}

.login-table td:last-child {
    text-align: right;
    width: 70%;
}

/* Mobile Responsiveness */
@media (max-width: 480px) {
    .login-page {
        padding: 30px 20px;
        width: 90%;
    }

    .login-page h1 {
        font-size: 26px;
    }

    .login-page input[type="text"], 
    .login-page input[type="password"] {
        padding: 12px;
    }

    .login-page input[type="submit"] {
        padding: 12px;
    }
}
 
</style>
	
