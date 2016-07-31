package com.cus_gjh;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import unit.db;

public class order_rece_dao {
	
	public List<Object[]> getList(){
		List<Object[]> l = new ArrayList<Object[]>();
		Connection conn = db.getConn();
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT order_id,customer.customer_id,customer_name,customer_credit FROM customer,ordertable WHERE customer.customer_id=ordertable.customer_id";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Object[] o = new Object[4];
				o[0] = rs.getInt("order_id");
				o[1] = rs.getString("customer_name");
				o[2] = rs.getString("customer_credit");
				o[3] = rs.getInt("customer_id");
				l.add(o);
			}
	        //System.out.println(l.size());

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return l;		
	}

}
