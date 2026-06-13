package com.test;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.*;

@WebServlet("/ListEvents")
public class ListEvents extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
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

            PreparedStatement ps = con.prepareStatement("SELECT * FROM events");
            ResultSet rs = ps.executeQuery();

            // HTML START
            out.println("<html>");
            out.println("<head>");
            out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
            out.println("</head>");

            out.println("<body class='bg-light'>");

            out.println("<div class='container mt-5'>");
            out.println("<div class='card shadow p-4'>");

            out.println("<h2 class='text-center text-info mb-4'>📋 Event List</h2>");

            out.println("<table class='table table-bordered table-hover text-center'>");
            out.println("<thead class='table-dark'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Date</th><th>Location</th><th>Seats</th></tr>");
            out.println("</thead>");
            out.println("<tbody>");

            while(rs.next()) {
                out.println("<tr>");
                out.println("<td>"+rs.getInt(1)+"</td>");
                out.println("<td>"+rs.getString(2)+"</td>");
                out.println("<td>"+rs.getString(3)+"</td>");
                out.println("<td>"+rs.getString(4)+"</td>");
                out.println("<td>"+rs.getInt(5)+"</td>");
                out.println("</tr>");
            }

            out.println("</tbody>");
            out.println("</table>");

            // Buttons
            out.println("<div class='text-center mt-4'>");
            out.println("<a href='ListEvents' class='btn btn-primary me-2'>🔄 Refresh</a>");
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