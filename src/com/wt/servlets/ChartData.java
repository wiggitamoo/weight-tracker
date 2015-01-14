package com.wt.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.wt.pkg.AverageChart;
import com.wt.pkg.Chart;
import com.wt.pkg.SeriesChart;
import com.wt.pkg.Member;

/**
 * Servlet implementation class ChartData
 */
@WebServlet("/ChartData")
public class ChartData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChartData() {
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
		String name = request.getParameter("name");
		
		String query = "select * from weight where firstname = '" + name + "'  and update_ts > current_timestamp - interval '30 days' order by update_ts";
		PreparedStatement weights;
		SeriesChart series = new SeriesChart();
		
		try {
			weights = conn.prepareStatement(query);
			ResultSet res = weights.executeQuery();
			while(res.next()) {
				Timestamp ts = res.getTimestamp("update_ts");
				series.addTime(ts.getTime());
				double weight = res.getDouble("weight");
				series.addWeight(weight);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		query = "SELECT (extract(day FROM update_ts)::int / 3) AS day3_slot, max(weight),min(weight),max(update_ts) update_ts " + 
				"FROM weight " +
				"WHERE firstname = '" + name + "'  and update_ts > current_timestamp - interval '30 days' " + 
				"GROUP  BY day3_slot ORDER  BY update_ts";
		PreparedStatement avgWeights;
		AverageChart average = new AverageChart();
		try {
			avgWeights = conn.prepareStatement(query);
			ResultSet res = avgWeights.executeQuery();
			while(res.next()) {
				Timestamp ts = res.getTimestamp("update_ts");
				average.addTime(ts.getTime());
				double maxWeight = res.getDouble("max");
				average.addMaxWeight(maxWeight);				
				double minWeight = res.getDouble("min");
				average.addMinWeight(minWeight);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Chart chart = new Chart();
		chart.setSeries(series);
		chart.setAverage(average);
		chart.setName(name);
		
		String json = new Gson().toJson(chart);
		response.setContentType("application/json");  // Set content type of the response so that jQuery knows what it can expect.
		response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
		response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
