package com.test;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.*;

@WebServlet("/UpdateEvent")
public class UpdateEvent extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb",
                "root",
                "root"
            );

            int id = Integer.parseInt(request.getParameter("id").trim());

            PreparedStatement ps = con.prepareStatement(
                "UPDATE events SET name=?, date=?, location=?, seats=? WHERE id=?"
            );

            ps.setString(1, request.getParameter("name"));
            ps.setString(2, request.getParameter("date"));
            ps.setString(3, request.getParameter("location"));
            ps.setInt(4, Integer.parseInt(request.getParameter("seats")));
            ps.setInt(5, id);

            int rows = ps.executeUpdate();

            // HTML START
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Update Result</title>");
            out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");

            out.println("<style>");
            out.println("body { background-color: #f5f7fb; }");
            out.println(".card { border-radius: 15px; }");
            out.println(".title { color:#5b8def; }");
            out.println("</style>");

            out.println("</head>");
            out.println("<body>");

            out.println("<div class='container mt-5'>");
            out.println("<div class='card shadow p-5 text-center'>");

            if(rows > 0) {
                out.println("<h2 class='title'>Event Updated Successfully 🔄</h2>");
            } else {
                out.println("<h2 class='title'>Event Not Found ❌</h2>");
            }

            // Buttons
            out.println("<div class='mt-4'>");
            out.println("<a href='update.jsp' class='btn btn-primary me-2'>🔄 Update Another</a>");
            out.println("<a href='dashboard.jsp' class='btn btn-outline-secondary'>🏠 Back to Dashboard</a>");
            out.println("</div>");

            out.println("</div>");
            out.println("</div>");

            out.println("</body>");
            out.println("</html>");

            con.close();

        } catch(Exception e) {
            e.printStackTrace();
            out.println("Error: " + e.getMessage());
        }
    }
}