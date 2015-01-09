package com.wt.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.pkg.getPerson;

/**
 * Servlet implementation class WeightInfo
 */
public class WeightInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeightInfo() {
    	super();
		try {
			//	Connect to database with JDBC
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://192.168.1.113:5432/weight_tracker";
			Properties props = new Properties();
			props.setProperty("user","postgres");
			props.setProperty("password","postgres");
			conn = DriverManager.getConnection(url, props);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			double weight = Double.parseDouble(request.getParameter("weight"));
			String unit = request.getParameter("unit");
			getPerson person = new getPerson(weight, unit);
			System.out.println(person.getFirst() + " " + person.getLast());
			Date now = new Date();
			Timestamp ts = new Timestamp((now).getTime());
			String query = "INSERT INTO WEIGHT values ('" + person.getFirst() + "','" + person.getLast() + "','" + ts + "', " + weight + ", '" + unit + "')";
			PreparedStatement preparedQuery = conn.prepareStatement(query);
			preparedQuery.executeUpdate();
			preparedQuery.close();
			response.getWriter().write("<strong>Thanks " + person.getFirst() + "!</strong> Your weight has been recorded.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
