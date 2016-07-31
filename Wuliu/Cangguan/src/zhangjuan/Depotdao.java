package zhangjuan;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import pojo.depot;
import unit.db;

public class Depotdao {
	/*
	 * 传入的是仓库的id,如果不传值,则查询整个仓库表
	 */
  public List<depot> getDepots(Integer d_id) throws SQLException{
	  List<depot> l=new ArrayList<depot>();
	 Connection conn=db.getConn();
	 Statement st=conn.createStatement();
	 String sql="";
	 if(d_id==null){
		 sql="select * from depot_hyj";
	 }
	 else {
		sql="select * from depot_hyj where d_id_hyj="+d_id+"";
	}
	 ResultSet rs=st.executeQuery(sql);
	 while(rs.next()){
		 depot d=new depot();
		 d.setD_id_hyj(rs.getInt("d_id_hyj"));
		 d.setD_addr_hyj(rs.getString("d_addr_hyj"));
		 d.setD_area_hyj(rs.getInt("d_area_hyj"));
		 d.setD_name_hyj(rs.getString("d_name_hyj"));
		 d.setD_type_hyj(rs.getString("d_type_hyj"));
		 l.add(d);
		//System.out.println(d.getD_name_hyj());
	 }
	 rs.close();
	 st.close();
	  return l;
  }
  public depot getDepot(Integer d_id) throws SQLException {
	  depot d=new depot();
	 Connection conn=db.getConn();
	 Statement st=conn.createStatement();
	String sql="select * from depot_hyj where d_id_hyj="+d_id+"";
	 ResultSet rs=st.executeQuery(sql);
	   if(rs.next()){
		 d.setD_id_hyj(rs.getInt("d_id_hyj"));
		 d.setD_addr_hyj(rs.getString("d_addr_hyj"));
		 d.setD_area_hyj(rs.getInt("d_area_hyj"));
		 d.setD_name_hyj(rs.getString("d_name_hyj"));
		 d.setD_type_hyj(rs.getString("d_type_hyj")); }
		//System.out.println(d.getD_name_hyj());
	 st.close();
	  return d;
  }
}
