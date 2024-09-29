<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.foodapp.model.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout Page</title>
<link rel="stylesheet" type="text/css" href="style.css"> <!-- link to your CSS file -->
</head>
<body>
<div class="checkout-container">
  <table class="item-table">
    <tr>
      <th>Item Name:</th>
      <th>Quantity:</th>
      <th>Price:</th>
      <th>SubTotal:</th>
    </tr>
    <%!float total=0; %>
    <%cart c=(cart)session.getAttribute("cart");
    if(c!=null){
      for(cartItem cit:c.getAllItems().values()){
    %>
    <tr>
      <td><%=cit.getName()  %></td>
      <td><%=cit.getQuantity()  %></td>
      <td><%=cit.getPrice() %></td>
      <td><%=cit.getSubTotal() %></td>
      <%total=total+cit.getSubTotal(); %>
    </tr>
    <%}} %>
  </table>
  <h3 class="total">Total: <%=total%></h3>
  <form action="checkout12">
  <input type="hidden" name="total" value=<%=total %>>
    <label for="address">Delivery Address</label>
    <textarea id="address" name="address" required></textarea><br><br>
    
    <label>Payment Method</label>
    <select name="PaymentMethod">
       <option value="Online">Credit Card</option>
       <option value="Online">Debit Card</option>
       <option value="cash">Cash On Delivery</option>
    </select><br><br>
    
    <input type="submit" value="Place Order">
  </form>
</div>
</body>
</html>
<style>
  /* Global Styles */
body {
    font-family: 'Arial', sans-serif;
    background-color: #f4f4f4;
    color: #333;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

/* Container Styles */
.checkout-container {
    background-color: #fff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    max-width: 600px;
    width: 100%;
    box-sizing: border-box;
}

/* Table Styles */
.item-table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 20px;
}

.item-table th, .item-table td {
    border: 1px solid #ddd;
    padding: 8px;
    text-align: center;
}

.item-table th {
    background-color: #007bff;
    color: white;
    font-weight: bold;
}

.item-table tr:nth-child(even) {
    background-color: #f9f9f9;
}

.item-table tr:hover {
    background-color: #f1f1f1;
}

/* Total Amount */
.total {
    text-align: right;
    margin: 20px 0;
    font-size: 1.5em;
    font-weight: bold;
}

/* Form Styles */
form {
    margin-top: 20px;
}

label {
    display: block;
    margin-bottom: 10px;
    font-weight: bold;
}

textarea {
    width: 100%;
    height: 80px;
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 4px;
    box-sizing: border-box;
}

select {
    width: 100%;
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 4px;
    box-sizing: border-box;
    margin-bottom: 20px;
}

/* Button Styles */
input[type="submit"] {
    background-color: #28a745;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    width: 100%;
    font-size: 1.2em;
    font-weight: bold;
}

input[type="submit"]:hover {
    background-color: #218838;
}
  
</style>