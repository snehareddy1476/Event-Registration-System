package com.test;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.*;

@WebServlet("/InsertEvent")
public class InsertEvent extends HttpServlet {
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

			           

			         PreparedStatement ps = con.prepareStatement(
			             "insert into events values(?,?,?,?,?)"
			         );

			         ps.setInt(1, Integer.parseInt(request.getParameter("id")));
			         ps.setString(2, request.getParameter("name"));
			         ps.setString(3, request.getParameter("date"));
			         ps.setString(4, request.getParameter("location"));
			         ps.setInt(5, Integer.parseInt(request.getParameter("seats")));

			         ps.executeUpdate();

			         out.println("<html>");
			         out.println("<head>");
			         out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
			         out.println("</head>");
			         out.println("<body class='bg-light'>");

			         out.println("<div class='container mt-5'>");
			         out.println("<div class='card shadow p-4 text-center'>");

			         out.println("<h2 class='text-success'>Event Inserted Successfully 🎉</h2>");

			         out.println("<div class='mt-4'>");
			         out.println("<a href='insert.jsp' class='btn btn-success me-2'>➕ Add Another Event</a>");
			         out.println("<a href='dashboard.jsp' class='btn btn-secondary'>🏠 Back to Dashboard</a>");
			         out.println("</div>");

			         out.println("</div>");
			         out.println("</div>");

			         out.println("</body>");
			         out.println("</html>");

			         con.close();

			     } catch(Exception e) {
			         e.printStackTrace();
			         out.println("ERROR: " + e.getMessage());  // VERY IMPORTANT
			     }
			 }
}