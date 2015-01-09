package com.wt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

public class DAOManager {

    public DAOManager() throws Exception {
        try
        {
//            InitialContext ctx = new InitialContext();
//            this.src = (DataSource)ctx.lookup("jndi/MYSQL"); //The string should be the same name you're giving to your JNDI in Glassfish.
        }
        catch(Exception e) { throw e; }
    }

    public void open() throws SQLException, ClassNotFoundException {
        try
        {
            if(this.con==null || this.con.isClosed()) {
        	//	Connect to database with JDBC
        		Class.forName("org.postgresql.Driver");
        		String url = "jdbc:postgresql://localhost:5432/WT2";
        		Properties props = new Properties();
        		props.setProperty("user","postgres");
        		props.setProperty("password","password");
        		Connection conn;
        		this.con = DriverManager.getConnection(url, props);
            }
        }
        catch(SQLException e) { throw e; }
    }

    public void close() throws SQLException {
        try
        {
            if(this.con!=null && !this.con.isClosed())
                this.con.close();
        }
        catch(SQLException e) { throw e; }
    }
    
    public enum Table { FIRST, SECOND }

    public GenericDAO getDAO(Table t) throws SQLException, ClassNotFoundException 
    {

        try
        {
            if(this.con == null || this.con.isClosed()) //Let's ensure our connection is open   
                this.open();
        }
        catch(SQLException e){ throw e; }

        switch(t)
        {
        case FIRST:
            return new FirstDAO(this.con);
        case SECOND:
//            return new SecondDAO(this.con);
        default:
            throw new SQLException("Trying to link to an unexistant table.");
        }

    }

    //Private
    private DataSource src;
    private Connection con;

}

