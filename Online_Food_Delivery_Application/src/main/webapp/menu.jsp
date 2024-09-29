<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.foodapp.model.menu,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MenuMowa</title>
<link rel="stylesheet" type="text/css" href="style.css"> <!-- link to your CSS file -->
</head>
<body>
<center>
<h1>Menu</h1>
<%ArrayList<menu>al=(ArrayList)session.getAttribute("menu");
if(al!=null){
for(menu m:al){%>
	<div class="menu-item">
	    <h3><%=m.getMenuName() %></h3>
	    <p><%=m.getDescription() %></p>
	    <p>
	    price:
	    <%=m.getPrice()%>
	    </p>
	    <form action="cart">
	      <table>
	          <tr>
	            <td><input type="hidden" name="itemId"  value="<%=m.getMenuId()%>"></td>
	          </tr>
	          <tr>
	            <td>Quantity:<input type="number" name="quantity" value="1" min="1" class="quantity-input"></td>
	          </tr>
	          <tr>
	            <td><input type="submit" value="Add To Cart" class="add-to-cart-btn"></td>
	            <td><input type="hidden" name="action" value="add"></td>
	          </tr>
	      </table>
	    </form>
	</div>
<% }}
else{%>
	<h1>your menu items are empty come by tomorrow</h1>
<%}%>
</center>
</body>
</html>
<style>
/* Global Styles */
body {
    font-family: 'Verdana', sans-serif;
    background: linear-gradient(135deg, #f9f9f9, #e0e0e0);
    margin: 0;
    padding: 20px;
    color: #333;
}

h1 {
    color: #333;
    margin-bottom: 40px;
    font-size: 34px;
    text-align: center;
    font-weight: 700;
    text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.1);
}

/* Menu Item Container */
.menu-item {
    background-color: #ffffff;
    padding: 25px;
    border-radius: 12px;
    box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1);
    margin-bottom: 25px;
    transition: transform 0.3s ease, box-shadow 0.3s ease;
    max-width: 600px;
    width: 100%;
    border-left: 8px solid #3498db; /* Accent color */
}

.menu-item:hover {
    transform: translateY(-10px);
    box-shadow: 0 12px 24px rgba(0, 0, 0, 0.2);
}

.menu-item h3 {
    color: #e74c3c; /* Header color */
    margin-bottom: 12px;
    font-size: 24px;
    text-transform: capitalize;
    font-weight: 600;
}

.menu-item p {
    font-size: 16px;
    margin-bottom: 12px;
    color: #7f8c8d; /* Description text color */
    line-height: 1.6;
}

/* Quantity Input */
.quantity-input {
    width: 60px;
    padding: 10px;
    border: 2px solid #3498db; /* Border color matching accent */
    border-radius: 5px;
    font-size: 16px;
    text-align: center;
    color: #333;
    background-color: #f1f1f1; /* Light background for input */
}

/* Add to Cart Button */
.add-to-cart-btn {
    background-color: #2ecc71; /* Button color */
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 5px;
    font-size: 16px;
    cursor: pointer;
    transition: background-color 0.3s ease, transform 0.2s ease;
}

.add-to-cart-btn:hover {
    background-color: #27ae60; /* Darker green on hover */
    transform: translateY(-2px);
}

/* Form Table Styles */
form table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 10px;
}

form table td {
    padding: 10px 0;
}

/* Centering the Page */
center {
    display: flex;
    flex-direction: column;
    align-items: center;
}

</style>


