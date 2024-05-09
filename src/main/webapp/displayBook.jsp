<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/9/2024
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>List of Students</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa; /* Màu nền nhẹ nhàng cho trang */
            font-family: 'Arial', sans-serif; /* Phông chữ */
        }
        .container {
            background-color: #ffffff; /* Màu nền cho container */
            box-shadow: 0 4px 8px rgba(0,0,0,0.1); /* Bóng đổ */
            border-radius: 8px; /* Bo tròn góc */
            padding: 20px;
            margin-top: 40px; /* Khoảng cách từ top */
        }
        h1 {
            color: #333; /* Màu chữ cho tiêu đề */
            text-align: center; /* Căn giữa tiêu đề */
            margin-bottom: 30px; /* Khoảng cách dưới tiêu đề */
        }
        .table {
            margin-top: 20px; /* Khoảng cách từ nút tạo mới đến bảng */
            text-align: center; /* Căn giữa chữ trong bảng */
        }
        .table-bordered th, .table-bordered td {
            border-color: #dee2e6 !important; /* Màu viền cho bảng */
            text-align: center; /* Thêm dòng này để căn giữa chữ trong các ô */
        }
        .table-dark {
            background-color: #343a40; /* Màu nền cho header bảng */
        }
        .table-dark th {
            color: #ffffff; /* Màu chữ cho header bảng */
        }
        .action-buttons a {
            margin-right: 5px;
            text-decoration: none; /* Gỡ bỏ gạch chân */
        }
        .btn-primary, .btn-info, .btn-warning, .btn-danger {
            color: #fff; /* Màu chữ cho nút */
            border: none; /* Gỡ bỏ viền */
        }
        .btn-info {
            background-color: #17a2b8;
        }
        .btn-warning {
            background-color: #ffc107;
        }
        .btn-danger {
            background-color: #dc3545;
        }
        .posi {
            position: sticky;
            top: 0;
            background-color: #ffffff;
            border: 2px solid #ffffff;
        }
        .search-container form {
            display: flex;
            justify-content: center;
            gap: 10px; /* Khoảng cách giữa input và button */
        }

        .search-container input[type="text"] {
            width: 240px; /* Chiều rộng của trường nhập */
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px; /* Bo tròn góc */
        }

        .search-container button {
            padding: 10px 20px;
            background-color: #28a745; /* Màu nền cho nút */
            color: white;
            border: none;
            border-radius: 5px; /* Bo tròn góc */
            cursor: pointer; /* Hiệu ứng con trỏ khi di chuyển qua nút */
        }

        .search-container button:hover {
            background-color: #218838; /* Màu nền khi hover */
        }

    </style>

    </style>
</head>
<body>

<div class="container mt-5">
    <div class="posi"> <h1>LIST OF BOOKS</h1></div>
    <div class="my-4">
    </div>
    <!-- Thêm form tìm kiếm vào đây -->
<%--    <div class="search-container my-4">--%>
<%--        <form action="/library" method="GET">--%>
<%--            <input type="text" placeholder="Search for book" name="search" required>--%>
<%--            <button type="submit" class="btn btn-success">Search</button>--%>
<%--        </form>--%>
<%--    </div>--%>
    <table class="table table-bordered table-hover">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Book Name</th>
            <th>Author</th>
            <th>Quantity</th>
            <th>Description</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${books}">
            <tr>
                <td><c:out value="${book.id}"/></td>
                <td><c:out value="${book.name}"/></td>
                <td><c:out value="${book.author}"/></td>
                <td><c:out value="${book.quantity}"/></td>
                <td><c:out value="${book.description}"/></td>

                <td class="action-buttons">
                    <a href="library?action=borrow&bookId=${book.id}" class="btn btn-primary">Borrow</a>
<%--                    <a href="library?action=view&id=${student.studentId}" class="btn btn-info btn-sm">View</a>--%>
<%--                    <a href="students?action=edit&id=${student.studentId}" class="btn btn-warning btn-sm">Edit</a>--%>
<%--                    <a href="students?action=delete&id=${student.studentId}" class="btn btn-danger btn-sm">Delete</a>--%>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
