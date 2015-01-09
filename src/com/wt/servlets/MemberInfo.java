package com.wt.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.wt.pkg.Member;

/**
 * Servlet implementation class MemberInfo
 */
public class MemberInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberInfo() {
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
		try {
			String query = "SELECT * FROM MEMBERS";
			PreparedStatement counter = conn.prepareStatement(query);
			ResultSet res = counter.executeQuery();
			List<Member> output = new ArrayList<Member>();
			Date now = new Date();
			while(res.next()) {
				Date birthdate = res.getTimestamp("birthday");
				double days =  (now.getTime() - birthdate.getTime()) / (1000 * 60 * 60 * 24);
				double age = days/365;
				
				Member member = new Member();
				member.setFirstname(res.getString("firstname"));
				member.setLastname(res.getString("lastname"));
				member.setAge(age); 
				output.add(member);
			}
			String json = new Gson().toJson(output);
			response.setContentType("application/json");  // Set content type of the response so that jQuery knows what it can expect.
			response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
			response.getWriter().write(json);       // Write response body.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
