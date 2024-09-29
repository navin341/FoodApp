<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.foodapp.model.*" %>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Map.Entry"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart Items</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart - Food Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">FoodApp</a>
        <div class="navbar-nav ml-auto">
            <a class="nav-item nav-link" href="profile.html"><i class="bi bi-person"></i> Profile</a>
            <a class="nav-item nav-link" href="cart.html"><i class="bi bi-cart"></i> Cart</a>
            <a class="nav-item nav-link" href="orderhistory.html"><i class="bi bi-clock-history"></i> Order History</a>
        </div>
    </nav>
    <div class="container">
        <h1 class="mb-4">Your Cart</h1>
        <%
            cart ca = (cart) session.getAttribute("cart");

            if (ca != null) {
                Map<Integer, cartItem> cartitems = ca.getAllItems();
                
                if (cartitems != null && !cartitems.isEmpty()) {
                   
                    for (Map.Entry<Integer, cartItem> entry : cartitems.entrySet()) {
                        cartItem cartitem = entry.getValue();
        %>

    <div class="container mt-4">
        <div class="cart-items">
            <!-- Example Cart Item -->
            <div class="cart-item d-flex align-items-center">
                <img src="https://via.placeholder.com/100x100" alt="Item Image" class="item-image">
                <div class="item-details ml-3">
                    <h5 class="item-title">Item Name:<%= cartitem.getName() %></h5>
                    <p class="item-quantity">Quantity: <%= cartitem.getQuantity() %></p>
                    <p class="item-price">Price:<%=cartitem.getPrice() %></p>
                </div>
                <form action="cart">
                <input type="hidden" name="itemId" value="<%= cartitem.getItemId() %>">
                <input type="number" name="quantity" value="<%= cartitem.getQuantity() %>" min="1">
                <input type="submit" name="action" value="update">
		        <input type="submit" name="action" value="remove">
		        </form>
            </div>

            <!-- Repeat the above div for more items -->

        </div>
        <div class="cart-summary mt-4">
            <div class="d-flex justify-content-between">
                <h4>Total</h4>
                <h4><%=cartitem.getSubTotal()%>rs/-</h4>
            </div>
            <a href="checkout.jsp" class="btn btn-primary btn-lg mt-3">Proceed to Checkout</a>
        </div>
    </div>

            <a href="menu.jsp">Add more items</a>
        <%
                    }%>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
                    
              <% } 
                else {
        %>
            <p>Your cart is empty.</p>
        <%
                }
            } 
           
        %>
    </div>
</body>
</html>
 <style>
/* Custom Styles for Cart Page */

/* Navbar Styles */
.navbar {
    margin-bottom: 20px;
}

.navbar-brand {
    font-size: 24px;
    font-weight: bold;
}

.navbar-nav .nav-link {
    font-size: 16px;
    margin-left: 15px;
}

/* Container Styles */
.container {
    max-width: 1200px;
}

/* Cart Items Styles */
.cart-items {
    background-color: #ffffff;
    padding: 15px;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.cart-item {
    padding: 15px;
    border-bottom: 1px solid #e0e0e0;
    display: flex;
    align-items: center;
    margin-bottom: 15px;
}

.item-image {
    width: 100px;
    height: 100px;
    object-fit: cover;
    border-radius: 8px;
}

.item-details {
    flex: 1;
    margin-left: 15px;
}

.item-title {
    font-size: 18px;
    color: #333;
    margin-bottom: 5px;
}

.item-quantity,
.item-price {
    font-size: 16px;
    color: #555;
}

form input[type="number"] {
    width: 60px;
    padding: 5px;
    border: 1px solid #ddd;
    border-radius: 5px;
    font-size: 16px;
}

form input[type="submit"] {
    background-color: #007bff;
    color: #ffffff;
    border: none;
    padding: 8px 12px;
    margin-left: 10px;
    border-radius: 5px;
    font-size: 16px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

form input[type="submit"]:hover {
    background-color: #0056b3;
}

/* Cart Summary Styles */
.cart-summary {
    background-color: #f9f9f9;
    padding: 15px;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    margin-top: 20px;
}

.cart-summary h4 {
    margin: 0;
    font-size: 18px;
}

.btn-primary {
    background-color: #28a745;
    border: none;
    padding: 12px 20px;
    border-radius: 5px;
    font-size: 18px;
    text-transform: uppercase;
    letter-spacing: 1px;
}

.btn-primary:hover {
    background-color: #218838;
}

/* Empty Cart Message Styles */
p {
    text-align: center;
    font-size: 18px;
    color: #666;
    margin-top: 20px;
}

/* Responsive Design */
@media (max-width: 768px) {
    .cart-item {
        flex-direction: column;
        align-items: flex-start;
    }

    .item-image {
        margin-bottom: 10px;
    }

    .item-details {
        margin-left: 0;
    }
}

    </style>
