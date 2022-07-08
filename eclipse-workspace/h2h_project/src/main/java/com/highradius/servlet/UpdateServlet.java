package com.highradius.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//jdbc
		try {
			final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
			final String USER="root";
			final String PASS="Redrum@1";
			final String URL="jdbc:mysql://localhost:3306/grey_goose";
			
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(URL,USER,PASS);
			Statement stm=con.createStatement();
			
			String name=request.getParameter("name");
			String id=request.getParameter("id");
			
			String query = "INSERT INTO attendance VALUES ('"+name+"', '"+id+"')";
			stm.executeUpdate(query);
			
			//give response to the UI
			PrintWriter out = response.getWriter();
			out.println(name + "["+ id+"]" + "Your attendance is updated ");
	
			
			stm.close();
			con.close();
			
			
			
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
