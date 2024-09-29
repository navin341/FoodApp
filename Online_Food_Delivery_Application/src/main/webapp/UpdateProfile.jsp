<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.foodapp.model.*" %>
<<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Profile</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <h1>Edit Your Profile</h1>
        <form action="profile">
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text"  name="name" placeholder="John Doe" required>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email"  name="email" placeholder="john.doe@example.com" required>
            </div>
            <div class="form-group">
                <label for="phone">Phone Number</label>
                <input type="text"  name="PhoneNumber" placeholder="+1234567890" required>
            </div>
            <div class="form-group">
                <label for="password">password</label>
                <input type="text" name="password" placeholder="Enter Your Password" required>
            </div>
            <input type="submit" class="submit-btn" value="Save Changes">
        </form>
    </div>
</body>
</html>
<style>
    body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
}

.container {
    background-color: #ffffff;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    padding: 20px;
    width: 100%;
    max-width: 600px;
}

h1 {
    color: #333;
    text-align: center;
    margin-bottom: 20px;
}

.profile-form {
    display: flex;
    flex-direction: column;
}

.form-group {
    margin-bottom: 15px;
}

.form-group label {
    display: block;
    font-weight: bold;
    margin-bottom: 5px;
    color: #555;
}

.form-group input,
.form-group textarea {
    width: 100%;
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 4px;
    font-size: 16px;
}

.form-group textarea {
    resize: vertical;
}

.submit-btn {
    background-color: #007bff;
    color: #ffffff;
    border: none;
    padding: 15px;
    border-radius: 4px;
    font-size: 16px;
    cursor: pointer;
    transition: background-color 0.3s;
}

.submit-btn:hover {
    background-color: #0056b3;
}

</style>