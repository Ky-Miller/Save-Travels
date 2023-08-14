<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<div class="container">
	<h1>Edit Expense</h1>
	<a href="/dashboard">Go Back</a>
</div>
<form:form action="/expenses/process/edit/m/${expense.id}" method="post" modelAttribute="expense">
	<input type="hidden" name="method" value="patch"/>
	<div class="form-group">
		<label>Expense Name</label>
		<form:input type="text" path="expense" class="form-control" value="${expense.expense}"/>
		<form:errors path="expense"/>
	</div>
	<div class="form-group">
		<label>Vendor</label>
		<form:input type="text" path="vendor" class="form-control" value="${expense.vendor}"/>
		<form:errors path="vendor"/>
	</div>
	<div class="form-group">
		<label>Amount</label>
		<form:input type="number" path="amount" class="form-control" value="${expense.amount}"/>
		<form:errors path="amount"/>
	</div>		
	<div class="form-group">
		<label>Description</label>
		<form:input type="text" path="description" class="form-control" value="${expense.description}"/>
		<form:errors path="description"/>
	</div>
	<input type="submit" value="submit" class="btn btn-primary">
	</form:form>
</body>
</html>