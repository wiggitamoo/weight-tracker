package com.wt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FirstDAO extends GenericDAO<First> {
	//Private
	private final static String TABLENAME = "members";
    public FirstDAO(Connection con) {
        super(con, TABLENAME);
    }

    @Override
    public String name() throws SQLException {
        String query = "SELECT * FROM "+this.tableName;
        PreparedStatement counter;
        counter = this.con.prepareStatement(query);
        ResultSet res = counter.executeQuery();
        res.next();
        return res.getString("firstname");
    }

	@Override
	public int count() throws SQLException {
		String query = "SELECT count(*) as count FROM "+this.tableName;
        PreparedStatement counter;
        counter = this.con.prepareStatement(query);
        ResultSet res = counter.executeQuery();
        res.next();
        return res.getInt("count");
	}

   

}