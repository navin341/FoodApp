<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Food Delivery Application</title>
<link rel="stylesheet" type="text/css" href="style.css"> <!-- link to your CSS file -->
</head>
<body>
  <div class="login-container">
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

  <div class="register-container">
    <h1>Register Page</h1>
    <form action="registration">
      <table class="register-table">
        <tr>
          <td>Name</td>
          <td><input type="text" name="name" required></td>
        </tr>
        <tr>
          <td>Email</td>
          <td><input type="text" name="email" required></td>
        </tr>
        <tr>
          <td>Password</td>
          <td><input type="password" name="password" required></td>
        </tr>
        <tr>
          <td>Confirm Password</td>
          <td><input type="password" name="cpassword" required></td>
        </tr>
        <tr>
          <td>Mobile Number</td>
          <td><input type="text" name="phoneNumber" required></td>
        </tr>
        <tr>
          <td>Address</td>
          <td><input type="text" name="address" required></td>
        </tr>
        <tr>
          <td></td>
          <td><input type="submit" name="Register" value="Register"></td>
        </tr>
      </table>
    </form>
  </div>
</body>
</html>
<style>
 /* Global styles */

* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

body {
  font-family: Arial, sans-serif;
  background-color: #f9f9f9; /* light gray background */
  color: #333; /* dark gray text color */
}

/* Login container styles */

.login-container {
  max-width: 400px;
  margin: 40px auto;
  padding: 20px;
  background-color: #fff; /* white background */
  border: 1px solid #ddd; /* light gray border */
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.login-table {
  width: 100%;
  border-collapse: collapse;
}

.login-table td {
  padding: 10px;
  border: 1px solid #ddd;
}

.login-table td input[type="text"], .login-table td input[type="password"] {
  width: 100%;
  height: 30px;
  padding: 10px;
  border: 1px solid #ddd;
}

.login-table td input[type="submit"] {
  width: 100%;
  height: 30px;
  padding: 10px;
  background-color: #4CAF50; /* green background color */
  color: #fff; /* white text color */
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.login-table td input[type="submit"]:hover {
  background-color: #3e8e41; /* darker green background color on hover */
}

/* Register container styles */

.register-container {
  max-width: 600px;
  margin: 40px auto;
  padding: 20px;
  background-color: #fff; /* white background */
  border: 1px solid #ddd; /* light gray border */
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.register-table {
  width: 100%;
  border-collapse: collapse;
}

.register-table td {
  padding: 10px;
  border: 1px solid #ddd;
}

.register-table td input[type="text"], .register-table td input[type="password"] {
  width: 100%;
  height: 30px;
  padding: 10px;
  border: 1px solid #ddd;
}

.register-table td input[type="submit"] {
  width: 100%;
  height: 30px;
  padding: 10px;
  background-color: #4CAF50; /* green background color */
  color: #fff; /* white text color */
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.register-table td input[type="submit"]:hover {
  background-color: #3e8e41; /* darker green background color on hover */
}
</style>