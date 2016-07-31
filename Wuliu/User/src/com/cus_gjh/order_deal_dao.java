package com.cus_gjh;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.customer;
import pojo.hangye;
import pojo.order;
import pojo.wuliao;
import unit.db;

public class order_deal_dao {
	// 璁㈠崟Dao灞�
	public List<order> getOrderList() {
		List<order> l = new ArrayList<order>();
		Connection conn = db.getConn();
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT order_id,customer_name,order_type,order_baoguan,pay_type,order_status,order_date,tihuo_date,luru_man"
					+ " FROM ordertable,customer WHERE customer.customer_id=ordertable.customer_id";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				order ord = new order();
				ord.setOrder_id(rs.getInt("order_id"));
				customer cus = new customer();
				cus.setCustomer_name(rs.getString("customer_name"));
				ord.setCustomer(cus);
				ord.setOrder_type(rs.getString("order_type"));
				ord.setOrder_baoguan(rs.getString("order_baoguan"));
				ord.setPay_type(rs.getString("pay_type"));
				ord.setOrder_status(rs.getString("order_status"));
				ord.setOrder_date(rs.getString("order_date"));
				ord.setTihuo_date(rs.getString("tihuo_date"));
				ord.setLuru_man(rs.getString("luru_man"));
				l.add(ord);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;

	}

	public List<order> getOrderDetialList(String id) {
		List<order> l = new ArrayList<order>();
		Connection conn = db.getConn();
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT order_id,customer_name,order_date,tihuo_date,order_type,order_baoguan,tihuo_type," +
					"pay_type,order_status,luru_man,out_address,order_beizhu,order_status"
					+ " FROM ordertable,customer WHERE customer.customer_id=ordertable.customer_id" +
					" and ordertable.order_id="+id;
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				order ord = new order();
				ord.setOrder_id(rs.getInt("order_id"));
				customer cus = new customer();
				cus.setCustomer_name(rs.getString("customer_name"));
				ord.setCustomer(cus);
				ord.setOrder_date(rs.getString("order_date"));
				ord.setTihuo_date(rs.getString("tihuo_date"));
				ord.setOrder_type(rs.getString("order_type"));
				ord.setOrder_baoguan(rs.getString("order_baoguan"));
				ord.setTihuo_type(rs.getString("tihuo_type"));
				ord.setPay_type(rs.getString("pay_type"));
				ord.setOrder_status(rs.getString("order_status"));
				ord.setLuru_man(rs.getString("luru_man"));
				ord.setOut_address(rs.getString("out_address"));
				ord.setOrder_beizhu(rs.getString("order_beizhu"));
				ord.setOrder_status(rs.getString("order_status"));
				l.add(ord);
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
	
	public List<wuliao> get_Wuliao(){
		Connection conn = db.getConn();
		List<wuliao> l = new ArrayList<wuliao>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT wuliao_id_gjh,wuliao_name_gjh,wuliao_norms_gjh,wuliao_weight_gjh," +
					"wuliao_unit_gjh,wuliao_count_gjh FROM wuliao";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				wuliao wul = new wuliao();
				wul.setWulaio_id_gjh(rs.getInt("wuliao_id_gjh"));
				wul.setWulaio_name_gjh(rs.getString("wuliao_name_gjh"));
				wul.setWulaio_norms_gjh(rs.getString("wuliao_norms_gjh"));
				wul.setWulaio_weight_gjh(rs.getDouble("wuliao_weight_gjh"));
				wul.setWulaio_unit_gjh(rs.getString("wuliao_unit_gjh"));
				wul.setWulaio_count_gjh(rs.getInt("wuliao_count_gjh"));
				l.add(wul);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;		
	}
	
	public boolean add_order(order ord){
		Connection conn = db.getConn();
		int num = 0;
		String sql = "insert into ordertable(order_id,customer_id,order_type,order_baoguan,pay_type,order_status,order_date,tihuo_date,luru_man) values(" + ord.getOrder_id()
				+ ",'" + ord.getCustomer().getCustomer_id() + "','"
				+ ord.getOrder_type() + "','"
				+ ord.getOrder_baoguan() + "','"
				+ ord.getPay_type() + "','" + ord.getOrder_status() + "','"
				+ ord.getOrder_date() + "','" + ord.getTihuo_date()
				+ "','" + ord.getLuru_man() + "')";
		//String sql1 = "insert into ";
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
	
	public List<order> getOrder_Handle() {
		List<order> l = new ArrayList<order>();
		Connection conn = db.getConn();
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT order_id,customer_name,order_date,order_status"
					+ " FROM ordertable,customer WHERE customer.customer_id=ordertable.customer_id";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				order ord = new order();
				ord.setOrder_id(rs.getInt("order_id"));
				customer cus = new customer();
				cus.setCustomer_name(rs.getString("customer_name"));
				ord.setCustomer(cus);
				ord.setOrder_date(rs.getString("order_date"));
				ord.setOrder_status(rs.getString("order_status"));
				l.add(ord);
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

}
