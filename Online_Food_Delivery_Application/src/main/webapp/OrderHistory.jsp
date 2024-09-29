<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.foodapp.model.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Your Order's History</h1>
<%ArrayList<orderHistory>al=(ArrayList)session.getAttribute("OrderHistory");
if(al!=null){
	for(orderHistory oh:al){%>
	<div class="history">
	   <table>
	    <tr>
	         <td>OrderId:</td>
	         <td><a href="orderNumber?orderId=<%=oh.getOrderId() %>">View Order</a></td>
	      </tr>
	      <tr>
	         <td>OrderDate:</td>
	         <td><%=oh.getOrderDate() %></td>
	      </tr>
	      <tr>
	         <td>Total Amount:</td>
	         <td><%=oh.getTotalAmount() %></td>
	      </tr>
	      <tr>
	         <td>Status:</td>
	         <td><%=oh.getStatus() %></td>
	      </tr>
	   </table>
	</div>
<%}}%>
</body>
</html>
<style>
  /* Global Styles */
body {
    font-family: 'Arial', sans-serif;
    background-color: #f5f5f5;
    margin: 0;
    padding: 20px;
    color: #333;
}

h1 {
    font-size: 28px;
    color: #2c3e50;
    margin-bottom: 30px;
    text-align: center;
    font-weight: bold;
    text-transform: uppercase;
    letter-spacing: 1px;
}

/* History Container */
.history {
    background-color: #ffffff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    margin-bottom: 20px;
    max-width: 800px;
    margin-left: auto;
    margin-right: auto;
}

.history table {
    width: 100%;
    border-collapse: collapse;
}

.history td {
    padding: 10px;
    border-bottom: 1px solid #ddd;
}

.history td:first-child {
    font-weight: bold;
    color: #3498db; /* Accent color for labels */
}

.history a {
    color: #3498db; /* Accent color for links */
    text-decoration: none;
}

.history a:hover {
    text-decoration: underline;
}

/* Responsive Design */
@media (max-width: 768px) {
    body {
        padding: 10px;
    }

    .history {
        padding: 15px;
    }

    .history td {
        font-size: 14px;
    }
}

</style>