package com.test;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.*;

@WebServlet("/SearchEvent")
public class SearchEvent extends HttpServlet {

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

            int id = Integer.parseInt(request.getParameter("id").trim());

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM events WHERE id=?"
            );
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            // HTML START
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Search Result</title>");
            out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");

            out.println("<style>");
            out.println("body { background-color: #f5f7fb; }");
            out.println(".card { border-radius: 15px; }");
            out.println(".title { color:#5b8def; }");
            out.println("</style>");

            out.println("</head>");
            out.println("<body>");

            out.println("<div class='container mt-5'>");
            out.println("<div class='card shadow p-5'>");

            if(rs.next()) {

                out.println("<h2 class='text-center title mb-4'>Event Found ✔</h2>");

                out.println("<table class='table table-bordered text-center'>");
                out.println("<tr><th>ID</th><td>"+rs.getInt(1)+"</td></tr>");
                out.println("<tr><th>Name</th><td>"+rs.getString(2)+"</td></tr>");
                out.println("<tr><th>Date</th><td>"+rs.getString(3)+"</td></tr>");
                out.println("<tr><th>Location</th><td>"+rs.getString(4)+"</td></tr>");
                out.println("<tr><th>Seats</th><td>"+rs.getInt(5)+"</td></tr>");
                out.println("</table>");

            } else {
                out.println("<h2 class='text-center title'>Event Not Found ❌</h2>");
            }

            // Buttons
            out.println("<div class='text-center mt-4'>");
            out.println("<a href='search.jsp' class='btn btn-primary me-2'>🔍 Search Again</a>");
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