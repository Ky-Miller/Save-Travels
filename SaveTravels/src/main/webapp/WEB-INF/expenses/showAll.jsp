<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
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
<h1>Save Travels</h1>
	<table class="table table-hover">
	<thead>	
		<tr>
			<th scope="col">Expense</th>
			<th scope="col">Vendor</th>
			<th scope="col">Amount</th>
			<th scope="col">Actions</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="expense" items="${allExpenses}">
		<tr>
			<td><a href="/show/one/expense/${expense.id}"><c:out value="${expense.expense}" /></a></td>
			<td><c:out value="${expense.vendor}" /></td>
			<td>$<c:out value="${expense.amount}" /></td>
			<td>
			<a href="/expenses/process/edit/m/${expense.id}">Edit</a>
				<form action="/expenses/${expense.id}" method="post">
    				<input type="hidden" name="_method" value="delete">
    				<input type="submit" value="Delete">
				</form>
			</td>
		</tr>
		</c:forEach>
	</tbody>
	</table>
	
	<h2>Add An Expense:</h2>
	<form action="/expenses" method="post">
	<div class="form-group">
		<input type="text" name="expense" class="form-control" placeholder="Expense Name"/>
		<form:errors path="expense"/>
	</div>
	<div class="form-group">
		<input type="text" name="vendor" class="form-control" placeholder="Vendor"/>
		<form:errors path="vendor"/>
	</div>
	<div class="form-group">
		<input type="number" name="amount" class="form-control" placeholder="Amount"/>
		<form:errors path="amount"/>
	</div>		
	<div class="form-group">
		<input type="text" name="description" class="form-control" placeholder="Desciption"/>
		<form:errors path="description"/>
	</div>
	<input type="submit" value="submit" class="btn btn-primary">
	</form>
</body>
</html>