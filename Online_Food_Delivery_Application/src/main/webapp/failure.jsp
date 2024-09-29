<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Checkout - Food Delivery</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
		<div class="checkout-header">
			<h1>Checkout</h1>
		</div>
		<div class="order-summary">
			<h2>Order Summary</h2>
			<ul>
				<li>
					<span>Item 1: Chicken Biryani</span>
					<span>Quantity: 2</span>
					<span>Price: ₹200</span>
				</li>
				<li>
					<span>Item 2: Veggie Burger</span>
					<span>Quantity: 1</span>
					<span>Price: ₹150</span>
				</li>
				<li>
					<span>Item 3: Garlic Naan</span>
					<span>Quantity: 1</span>
					<span>Price: ₹50</span>
				</li>
				<li>
					<span>Total:</span>
					<span>₹400</span>
				</li>
			</ul>
		</div>
		<div class="payment-methods">
			<h2>Payment Methods</h2>
			<div class="payment-option">
				<input type="radio" id="cod" name="payment-method" checked>
				<label for="cod">Cash on Delivery (COD)</label>
			</div>
			<div class="payment-option">
				<input type="radio" id="online-payment" name="payment-method">
				<label for="online-payment">Online Payment (Credit/Debit Card, Net Banking)</label>
			</div>
		</div>
		<div class="online-payment-form" style="display: none;">
			<h2>Online Payment Details</h2>
			<form>
				<label for="card-number">Card Number:</label>
				<input type="text" id="card-number" placeholder="Enter card number">
				<label for="expiration-date">Expiration Date:</label>
				<input type="text" id="expiration-date" placeholder="MM/YY">
				<label for="cvv">CVV:</label>
				<input type="text" id="cvv" placeholder="Enter CVV">
				<button type="submit">Make Payment</button>
			</form>
		</div>
		<div class="actions">
			<button type="submit" class="btn">Place Order</button>
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

.checkout-header {
	background-color: #337ab7;
	color: #fff;
	padding: 10px;
	border-radius: 10px 10px 0 0;
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

.order-summary span {
	display: inline-block;
	width: 30%;
}

.payment-methods {
	margin-top: 20px;
}

.payment-option {
	margin-bottom: 10px;
}

.payment-option input[type="radio"] {
	margin-right: 10px;
}

.online-payment-form {
	display: none;
}

.online-payment-form h2 {
	margin-top: 0;
}

.online-payment-form label {
	display: block;
	margin-bottom: 10px;
}

.online-payment-form input[type="text"] {
	width: 100%;
	padding: 10px;
	margin-bottom: 20px;
	border: 1px solid #ccc;
}

.online-payment-form button[type="submit"] {
	background-color: #337ab7;
	color: #fff;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
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