<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/9/2024
  Time: 11:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Borrow Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>Borrow Form</h1>
    <form method="post">
        <input type="hidden" name="bookId" value="${book.id}">
        <div class="mb-3">
            <label for="bookId" class="form-label">Book ID:</label>
            <input type="text" class="form-control" id="bookId" name="nameStudent" value="${book.id}" readonly>
        </div>
        <div class="mb-3">
            <label for="bookName" class="form-label">Book Name:</label>
            <input type="text" class="form-control" id="bookName" name="bookName" value="${book.name}" readonly>
        </div>
        <div class="mb-3">
            <label for="studentName" class="form-label">Student Name:</label>
            <select id="studentName" name="studentName">
                <c:forEach items="${students}" var="student">
                    <option value="${student.id}">${student.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label for="borrowDate" class="form-label">Borrow Date:</label>
            <input type="date" class="form-control" id="borrowDate" name="borrowDate" required>
        </div>
        <div class="mb-3">
            <label for="returnDate" class="form-label">Return Date:</label>
            <input type="date" class="form-control" id="returnDate" name="returnDate" required>
        </div>

        <button type="submit" class="btn btn-primary">Borrow</button>
        <a href="/library" class="btn btn-secondary">Cancel</a>
    </form>
</div>
</body>
</html>

