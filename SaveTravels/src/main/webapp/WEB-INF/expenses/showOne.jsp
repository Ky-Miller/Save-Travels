<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Travels</title>
    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- YOUR own local CSS -->
    <link rel="stylesheet" href="/css/main.css"/>
    <!-- For any Bootstrap that uses JS -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
<div class="container">
		<h1>Expense Details</h1>
		<a href="/dashboard">Go Back</a>
	</div>
	<table class="table">
		<tr>
			<td>Expense Name: </td>
			<td><c:out value="${oneExpense.expense}"/></td>
		</tr>
		<tr>
			<td>Expense Description: </td>
			<td><c:out value="${oneExpense.description}"/></td>
		</tr>
		<tr>
			<td>Vendor: </td>
			<td><c:out value="${oneExpense.vendor}"/></td>
		</tr>
		<tr>
			<td>Amount Spent: </td>
			<td>$<c:out value="${oneExpense.amount}"/></td>
		</tr>
	</table>
</div>
</body>
</html>