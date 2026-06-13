package com.test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    String user = request.getParameter("username");
	    String pass = request.getParameter("password");

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        java.sql.Connection con = java.sql.DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/testdb",
	            "root",
	            "root"   // change if your password is different
	        );

	        java.sql.PreparedStatement ps = con.prepareStatement(
	            "select * from users where username=? and password=?"
	        );

	        ps.setString(1, user);
	        ps.setString(2, pass);

	        java.sql.ResultSet rs = ps.executeQuery();

	        if(rs.next()) {
	            System.out.println("Login success");
	            response.sendRedirect(request.getContextPath() + "/dashboard.jsp");
	            System.out.println("Redirecting...");
	        } else {
	            response.getWriter().println("Invalid Login");
	        }
	       

	        con.close();

	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}

}
