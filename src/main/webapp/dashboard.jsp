<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body {
    background-color: #f5f7fb;
}

.card {
    border-radius: 15px;
}

.custom-btn {
    background-color: #5b8def;
    color: white;
    border: none;
}

.custom-btn:hover {
    background-color: #4a7be0;
}
</style>

</head>

<body>

<div class="container mt-5">
    <div class="card shadow p-4">
        <h2 class="text-center mb-4" style="color:#6c8ef5;">Online Event Registration System</h2>
        <hr>

        <div class="d-grid gap-3 mt-4">
            <a href="insert.jsp" class="btn custom-btn">➕ Add Event</a>
            <a href="list.jsp" class="btn custom-btn">📋 View Events</a>
            <a href="search.jsp" class="btn custom-btn">🔍 Search Event</a>
            <a href="update.jsp" class="btn custom-btn">🔄 Update Event</a>
            <a href="delete.jsp" class="btn custom-btn">❌ Delete Event</a>
        </div>
    </div>
</div>

</body>
</html>