<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">
    <div class="card p-4 shadow">
        <h2 class="text-center text-danger">Delete Event</h2>

        <form action="DeleteEvent" method="post">
            <input class="form-control mb-3" type="text" name="id" placeholder="Enter Event ID">
            <button class="btn btn-danger w-100">Delete</button>
        </form>

        <a href="dashboard.jsp" class="btn btn-secondary mt-3">Back</a>
    </div>
</div>

</body>
</html>