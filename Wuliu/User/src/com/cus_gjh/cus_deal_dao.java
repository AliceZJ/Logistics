package com.cus_gjh;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pojo.customer;
import pojo.hangye;
import unit.db;

public class cus_deal_dao {
	public List<customer> getCusList() {
		List<customer> l = new ArrayList<customer>();
		Connection conn = db.getConn();
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT customer_id,customer_name,customer_short,hangye_name_gjh,customer,customer_credit FROM customer,hangye WHERE customer.hangye_id_gjh=hangye.hangye_id_gjh";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				customer cd = new customer();
				cd.setCustomer_id(rs.getInt("customer_id"));
				cd.setCustomer_name(rs.getString("customer_name"));
				cd.setCustomer_short(rs.getString("customer_short"));
				hangye hb = new hangye();
				hb.setHangye_name_gjh(rs.getString("hangye_name_gjh"));
				cd.setHangye(hb);
				cd.setCustomer(rs.getString("customer"));
				cd.setCustomer_credit(rs.getString("customer_credit"));
				l.add(cd);
				// System.out.println(l);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;

	}

	public List<customer> getCusDetialList(String id) {
		List<customer> l = new ArrayList<customer>();
		Connection conn = db.getConn();
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT customer_id,customer_name,customer_short,customer.hangye_id_gjh,"
					+ "customer_address,customer,customer_phone,customer_email,customer_credit"
					+ " FROM customer,hangye WHERE customer.hangye_id_gjh=hangye.hangye_id_gjh"
					+ " and customer.customer_id=" + id;
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				customer cd = new customer();
				cd.setCustomer_id(rs.getInt("customer_id"));
				cd.setCustomer_name(rs.getString("customer_name"));
				cd.setCustomer_short(rs.getString("customer_short"));
				hangye hb = new hangye();
				hb.setHangye_id_gjh(rs.getInt("hangye_id_gjh"));
				cd.setHangye(hb);
				cd.setCustomer_address(rs.getNString("customer_address"));
				cd.setCustomer(rs.getString("customer"));
				cd.setCustomer_phone(rs.getString("customer_phone"));
				cd.setCustomer_email(rs.getString("customer_email"));
				cd.setCustomer_credit(rs.getString("customer_credit"));
				l.add(cd);
				// System.out.println(l);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;

	}

	public List<hangye> getHangye() {
		List<hangye> l = new ArrayList<hangye>();
		Connection conn = db.getConn();
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM hangye";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				hangye hy = new hangye();
				hy.setHangye_id_gjh(rs.getInt("hangye_id_gjh"));
				hy.setHangye_name_gjh(rs.getString("hangye_name_gjh"));
				l.add(hy);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	public boolean add_Cus(customer cst) {
		Connection conn = db.getConn();
		int num = 0;
		String sql = "insert into customer values(" + cst.getCustomer_id()
				+ ",'" + cst.getCustomer_name() + "','"
				+ cst.getCustomer_short() + "','"
				+ cst.getHangye().getHangye_id_gjh() + "','"
				+ cst.getCustomer_address() + "','" + cst.getCustomer() + "','"
				+ cst.getCustomer_phone() + "','" + cst.getCustomer_email()
				+ "','" + cst.getCustomer_credit() + "')";
		try {
			Statement stmt = conn.createStatement();
			num = stmt.executeUpdate(sql);

			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (num > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean delete_Cus(int num) {
		Connection conn = db.getConn();
		int count = 0;
		try {
			Statement stmt = conn.createStatement();
			String sql = "delete from customer where customer_id=" + num;
			count = stmt.executeUpdate(sql);

			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (count > 0)
			return true;
		else
			return false;
	}

	public boolean edit_Cus(int num,customer cst) {
		Connection conn = db.getConn();
		int count = 0;
		try {
			Statement stmt = conn.createStatement();
			String sql = "update customer set customer_name='"+cst.getCustomer_name()+"'," +
					"customer_short='"+cst.getCustomer_short()+"'," +"hangye_id_gjh='"+cst.getHangye().getHangye_id_gjh()+"',"
					+"customer_address='"+cst.getCustomer_address()+"',"+"customer='"+cst.getCustomer()+"',"+
					"customer_phone='"+cst.getCustomer_phone()+"',"+"customer_email='"+cst.getCustomer_email()+"',"+
					"customer_credit='"+cst.getCustomer_credit()+"'"+
					" where customer_id=" + num;
			count = stmt.executeUpdate(sql);

			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (count > 0)
			return true;
		else
			return false;
	}

	public customer get_CusById(int num) {
		Connection conn = db.getConn();
		customer cd = new customer();
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT customer_name,customer_short,customer.hangye_id_gjh,hangye_name_gjh,"
					+ "customer_address,customer,customer_phone,customer_email,customer_credit"
					+ " FROM customer,hangye WHERE customer.hangye_id_gjh=hangye.hangye_id_gjh"
					+ " and customer.customer_id=" + num;
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				cd.setCustomer_name(rs.getString("customer_name"));
				cd.setCustomer_short(rs.getString("customer_short"));
				hangye hb = new hangye();
				hb.setHangye_name_gjh(rs.getString("hangye_name_gjh"));
				hb.setHangye_id_gjh(rs.getInt("hangye_id_gjh"));
				cd.setHangye(hb);
				cd.setCustomer_address(rs.getNString("customer_address"));
				cd.setCustomer(rs.getString("customer"));
				cd.setCustomer_phone(rs.getString("customer_phone"));
				cd.setCustomer_email(rs.getString("customer_email"));
				cd.setCustomer_credit(rs.getString("customer_credit"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cd;
	}

}
