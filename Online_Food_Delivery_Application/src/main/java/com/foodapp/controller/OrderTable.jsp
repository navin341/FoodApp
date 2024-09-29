<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.foodapp.model.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> Welcome To Orders</h1>
<% ArrayList<orderItem>al=(ArrayList)session.getAttribute("OrderItems");
if(al!=null){
for(orderItem oi:al){%>
<div class="orderItems">
   <table>
       <tr>
          <td>Menu Id:</td>
          <td><%=oi.getMenuId() %></td>
       </tr>
        <tr>
          <td>Quantity:</td>
          <td><%=oi.getQuantity() %></td>
       </tr>
        <tr>
          <td>subTotal:</td>
          <td><%=oi.getSubTotal() %></td>
       </tr>
        <tr>
          <td>Menu Names:</td>
          <td><input type="button" name="submit" value="submit"></td>
       </tr>
   </table>
</div>
<%}} %>

</body>
</html>
<style>
  body{
  background-color:rgb(255, 130, 37);
  }
</style>