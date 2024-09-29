<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.foodapp.model.Users" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.foodapp.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurant List</title>
<link rel="stylesheet" type="text/css" href="style.css"> <!-- link to your CSS file -->
</head>
<body>
<center>
<% Users user=(Users)session.getAttribute("loggedInUser"); %>
<%if(user!=null){ %>
<span>Welcome Back <%=user.getUserName() %></span><br>
<nav class="nav">
  <ul>
    <li><a class="active" href="profile.jsp"><%=user.getUserName() %></a></li>
    <li><a href="cart.jsp">Cart</a></li>
    <li><a href="oh?user_Id=<%=user.getUserId() %>">Orders</a></li>
    <li><a href="UpdateProfile.jsp">Edit</a></li>
    <li><a href="logout">Logout</a></li>
  </ul>
</nav>
<%
}%>
<%if(user==null){ %>
<h3>You Haven't LoggedIn</h3>
<a href="Login.jsp">Login</a><%
}%>

<%ArrayList<Restaurant>al=(ArrayList)session.getAttribute("allRestaurants");
for(Restaurant r:al){%>
		<div class="container">
			<div class="header">
				<h1><%=r.getRestaurantName() %></h1>
			</div>
			<div class="restaurant-list">
				<ul>
					<li>
						<div class="restaurant-card">
							<img src="D:\ECLIPSE FILES\Online_Food_Delivery_Application\src\main\webapp\WEB-INF\images\starbucks.jpeg" alt="Restaurant 1"
								class="restaurant-image">
							<div class="restaurant-info">
								<p>Cuisine: <%=r.getCuisinetype() %></p>
								<p>Rating: <%=r.getRating() %>*</p>
								<p>Delivery Time:<%=r.getDeliverytime() %> minutes</p>
								<button class="btn"><a href="menu?restaurantId=<%=r.getRestaurantId() %>">View Menu</a></button>
								<input type="hidden" name="RestaurantName" value=<%=r.getRestaurantName() %>>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
		<%}%>
</center>
</body>
</html>
<style>
       /* Global Styles */
body {
    font-family: 'Arial', sans-serif;
    background-color: #f5f5f5;
    color: #333;
    margin: 0;
    padding: 0;
    line-height: 1.6;
}

center {
    display: block;
    margin: 0 auto;
    width: 90%;
    max-width: 1200px;
}

/* Navigation Bar */
.nav {
    background-color: #007bff;
    padding: 10px 0;
    border-radius: 8px;
    margin: 20px 0;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.nav ul {
    list-style: none;
    padding: 0;
    margin: 0;
    display: flex;
    justify-content: center;
    align-items: center;
}

.nav ul li {
    margin: 0 15px;
}

.nav ul li a {
    color: #fff;
    text-decoration: none;
    font-weight: bold;
    padding: 10px 20px;
    border-radius: 5px;
    transition: background-color 0.3s ease, transform 0.2s;
}

.nav ul li a:hover,
.nav ul li a.active {
    background-color: #0056b3;
    transform: translateY(-2px);
}

/* Restaurant Container */
.container {
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
    margin: 20px 0;
    padding: 20px;
}

.header h1 {
    color: #007bff;
    font-size: 26px;
    margin-bottom: 15px;
    text-align: center;
}

/* Restaurant List */
.restaurant-list ul {
    list-style: none;
    padding: 0;
    margin: 0;
}

.restaurant-list li {
    margin-bottom: 20px;
}

.restaurant-card {
    background-color: #fff;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    overflow: hidden;
    display: flex;
    flex-direction: row;
    transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.restaurant-card:hover {
    transform: translateY(-5px);
    box-shadow: 0 8px 16px rgba(0, 0, 0, 0.15);
}

.restaurant-image {
    width: 40%;
    object-fit: cover;
}

.restaurant-info {
    padding: 20px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    width: 60%;
}

.restaurant-info p {
    margin: 10px 0;
    color: #555;
    font-size: 16px;
}

.btn {
    margin-top: 15px;
    text-align: left;
}

.btn a {
    background-color: #007bff;
    color: white;
    padding: 10px 20px;
    text-decoration: none;
    display: inline-block;
    border-radius: 5px;
    transition: background-color 0.3s ease, transform 0.2s;
}

.btn a:hover {
    background-color: #0056b3;
    transform: translateY(-2px);
}

/* Mobile Responsiveness */
@media (max-width: 768px) {
    .restaurant-card {
        flex-direction: column;
    }

    .restaurant-image {
        width: 100%;
        height: 200px;
    }

    .restaurant-info {
        width: 100%;
    }

    .nav ul {
        flex-direction: column;
    }

    .nav ul li {
        margin-bottom: 10px;
    }
}

@media (max-width: 480px) {
    .restaurant-card {
        width: 100%;
    }
}
       
    </style>

