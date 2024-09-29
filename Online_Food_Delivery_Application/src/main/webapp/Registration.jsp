<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<h1>Food Delivery Application</h1>
    <form action="registration">
<table>
   <tr>
     <td>Name</td>
     <td><input type="text" name="name"></td>
   </tr>
   <tr>
     <td>Email</td>
     <td><input type="text" name="email"></td>
   </tr>
   <tr>
     <td>Password</td>
     <td><input type="password" name="password"></td>
   </tr>
   <tr>
     <td>Confirm Password</td>
     <td><input type="text" name="cpassword"></td>
   </tr>
   <tr>
     <td>Mobile Number</td>
     <td><input type="text" name="phoneNumber"></td>
   </tr>
   <tr>
     <td>Address</td>
     <td><input type="text" name="address"></td>
   </tr>
   <tr>
     <td></td>
     <td><input type="submit" name="Register"></td>
   </tr>
</table>
</form>
</div>
</body>
<style>
   body{
   background-color:pink;
   
   }
   .container{
   display:grid;
   justify-content:center;
   align-items:center;
   }
   
   
   input{
   color:teal;
   }
   table{
   border:1px solid black;
   padding:25px;
   }
</style>
</html>