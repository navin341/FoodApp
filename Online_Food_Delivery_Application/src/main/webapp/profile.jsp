<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.foodapp.model.*,java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile - Food Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="styles.css">
</head>
<body><% Users user=(Users)session.getAttribute("loggedInUser"); %>
<%if(user!=null){ %>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">FoodApp</a>
        <div class="navbar-nav ml-auto">
            <a class="nav-item nav-link" href="profile.html"><i class="bi bi-person"></i> Profile</a>
            <a class="nav-item nav-link" href="cart.html"><i class="bi bi-cart"></i> Cart</a>
            <a class="nav-item nav-link" href="orderhistory.html"><i class="bi bi-clock-history"></i> Order History</a>
        </div>
    </nav>

    <div class="container mt-4">
        <h1 class="mb-4">User Profile</h1>
        <div class="card">
            <div class="card-body">
                <div class="profile-info">
                    <div class="info-item d-flex align-items-center mb-3">
                        <i class="bi bi-person-circle info-icon"></i>
                        <div class="info-text ml-3">
                            <h5>User ID</h5>
                            <p><%=user.getUserId() %></p>
                        </div>
                    </div>
                    <div class="info-item d-flex align-items-center mb-3">
                        <i class="bi bi-person info-icon"></i>
                        <div class="info-text ml-3">
                            <h5>Name</h5>
                            <p><%=user.getUserName() %></p>
                        </div>
                    </div>
                    <div class="info-item d-flex align-items-center mb-3">
                        <i class="bi bi-phone info-icon"></i>
                        <div class="info-text ml-3">
                            <h5>Phone Number</h5>
                            <p><%=user.getPhoneNumber() %></p>
                        </div>
                    </div>
                    <div class="info-item d-flex align-items-center mb-3">
                        <i class="bi bi-geo-alt info-icon"></i>
                        <div class="info-text ml-3">
                            <h5>Address</h5>
                            <p><%=user.getAddress() %></p>
                        </div>
                    </div>
                    <div class="info-item d-flex align-items-center mb-3">
                        <i class="bi bi-envelope info-icon"></i>
                        <div class="info-text ml-3">
                            <h5>Email</h5>
                            <p><%=user.getEmail() %></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <%
}%>
<%if(user==null){ %>
<h3>You Haven't LoggedIn</h3><%
}%>
</body>
</html>
<style>
/* Global Styles */
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f9fa;
            color: #343a40;
        }

        /* Navbar Styles */
        .navbar {
            margin-bottom: 30px;
        }
        
        .navbar-brand {
            font-size: 24px;
            font-weight: bold;
        }

        .nav-item .nav-link {
            font-size: 16px;
        }

        /* Card Styles */
        .card {
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .card-body {
            padding: 20px;
        }

        .profile-info {
            display: flex;
            flex-direction: column;
        }

        .info-item {
            background-color: #ffffff;
            padding: 15px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            margin-bottom: 15px;
            transition: box-shadow 0.3s ease;
        }

        .info-item:hover {
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        .info-icon {
            font-size: 24px;
            color: #007bff;
        }

        .info-text h5 {
            font-size: 18px;
            font-weight: bold;
            margin-bottom: 5px;
        }

        .info-text p {
            font-size: 16px;
            margin: 0;
        }

        /* Logged Out Message */
        h3 {
            text-align: center;
            color: #dc3545;
            margin-top: 50px;
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            .info-item {
                padding: 10px;
            }

            .info-text h5 {
                font-size: 16px;
            }

            .info-text p {
                font-size: 14px;
            }
        }
</style>