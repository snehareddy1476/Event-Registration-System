package com.test;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.*;

@WebServlet("/DeleteEvent")
public class DeleteEvent extends HttpServlet {

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
                "DELETE FROM events WHERE id=?"
            );

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if(rows > 0) {
                out.println("<h2>Event Deleted Successfully ✅</h2>");
            } else {
                out.println("<h2>Event Not Found ❌</h2>");
            }
            out.println("<html>");
            out.println("<head>");
            out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
            out.println("</head>");

            out.println("<body class='bg-light'>");

            out.println("<div class='container mt-5'>");
            out.println("<div class='card shadow p-4 text-center'>");

            if(rows > 0) {
                out.println("<h2 class='text-success'>Event Deleted Successfully ✅</h2>");
            } else {
                out.println("<h2 class='text-danger'>Event Not Found ❌</h2>");
            }

            out.println("<div class='mt-4'>");
            out.println("<a href='delete.jsp' class='btn btn-danger me-2'>❌ Delete Another</a>");
            out.println("<a href='dashboard.jsp' class='btn btn-secondary'>🏠 Back to Dashboard</a>");
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