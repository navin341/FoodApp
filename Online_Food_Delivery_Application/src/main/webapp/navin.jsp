<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Order Success - Zomato</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
		<div class="success-message">
			<h1>Order Placed Successfully!</h1>
			<p>Your order has been placed successfully. You will receive a confirmation email and SMS with your order details.</p>
			<p>Order ID: #</p>
			<p>Restaurant:<%=session.getAttribute("RestaurantName") %>></p>
			<p>Estimated Delivery Time:</p>
		</div>
		<div class="order-summary">
			<h2>Order Summary</h2>
			<ul>
				<li><strong>Items:</strong></li>
				<li><strong>Total:</strong></li>
			</ul>
		</div>
		<div class="actions">
			<a href="#" class="btn">Track Your Order</a>
			<a href="OrderHistory.jsp" class="btn">View Order History</a>
		</div>
	</div>
</body>
</html>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f5f5f5;
}

.container {
	max-width: 600px;
	margin: 40px auto;
	padding: 20px;
	background-color: #fff;
	border: 1px solid #ddd;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.success-message {
	background-color: #dff0d8;
	padding: 20px;
	border-radius: 10px;
	margin-bottom: 20px;
}

.success-message h1 {
	color: #3c763d;
	margin-top: 0;
}

.order-summary {
	margin-top: 20px;
}

.order-summary ul {
	list-style: none;
	padding: 0;
	margin: 0;
}

.order-summary li {
	margin-bottom: 10px;
}

.order-summary strong {
	font-weight: bold;
}

.actions {
	margin-top: 20px;
	text-align: center;
}

.actions .btn {
	background-color: #337ab7;
	color: #fff;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.actions .btn:hover {
	background-color: #23527c;
}
</style>