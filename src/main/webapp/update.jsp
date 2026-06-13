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
        <h2 class="text-center text-primary">Update Event</h2>

        <form action="UpdateEvent" method="post">
            <input class="form-control mb-2" type="text" name="id" placeholder="Event ID">
            <input class="form-control mb-2" type="text" name="name" placeholder="New Name">
           <input class="form-control mb-2" type="date" name="date" required>
            <input class="form-control mb-2" type="text" name="location" placeholder="New Location">
            <input class="form-control mb-2" type="text" name="seats" placeholder="Seats">

            <button class="btn btn-primary w-100">Update</button>
        </form>

        <a href="dashboard.jsp" class="btn btn-secondary mt-3">Back</a>
    </div>
</div>

</body>
</html>