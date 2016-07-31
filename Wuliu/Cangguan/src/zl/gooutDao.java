package zl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import pojo.cangguan;
import pojo.gointo;
import pojo.goout;
import pojo.order;
import pojo.seat;
import pojo.wuliao;
import util.DB;

public class gooutDao {
	public List<goout> getGooutList(){
		Connection conn = DB.getConn();
		List<goout> l = new ArrayList<goout>();
		try {
			Statement stmt = conn.createStatement();
			
			String	sql = "select * from goout_zl";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				goout gt = new goout();
				gt.setGt_id_zl(rs.getInt("gt_id_zl"));
				gt.setGt_date_zl(rs.getDate("gt_date_zl"));
				gt.setGe_state_zl(rs.getString("gt_state_zl"));
				cangguan cg = new cangguan();
				cg.setCg_id_zl(rs.getInt("cg_id_zl"));
				gt.setCangguan(cg);
				l.add(gt);
			}
			DB.close(conn, stmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;	
}
	public List<cangguan> getcangguanList(){
		Connection conn = DB.getConn();
		List<cangguan> l = new ArrayList<cangguan>();
		try {
			Statement stmt = conn.createStatement();
			
			String	sql = "select * from cangguan_zl";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				cangguan cg = new cangguan();
				cg.setCg_id_zl(rs.getInt("cg_id_zl"));
				cg.setCg_name_zl(rs.getString("cg_name_zl"));
				l.add(cg);
			}
			DB.close(conn, stmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;	
}
	public List<order> getorderList(){
		Connection conn = DB.getConn();
		List<order> l = new ArrayList<order>();
		try {
			Statement stmt = conn.createStatement();
			String	sql = "SELECT *  FROM order_zj";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				order od = new order();
				od.setOrder_id(rs.getInt("order_id"));
				l.add(od);
			}
			DB.close(conn, stmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;	
}
	public List<seat> getcangweiList(){
		Connection conn = DB.getConn();
		List<seat> l = new ArrayList<seat>();
		try {
			Statement stmt = conn.createStatement();
			
			String	sql = "select * from seat_hyj";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				seat s = new seat();
				s.setS_id_hyj(rs.getInt("s_id_hyj"));
				s.setS_name_hyj(rs.getString("s_name_hyj"));
				l.add(s);
			}
			DB.close(conn, stmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;	
}
		public goout getgooutById(Integer gt_id){
		Connection conn = DB.getConn();
		goout gt = new goout();
			try {
				Statement stmt = conn.createStatement();
				String sql = "select * from goout_zl where gt_id_zl="+gt_id;
				ResultSet rs = stmt.executeQuery(sql);
					if(rs.next()){
						gt.setGt_id_zl(rs.getInt("gt_id_zl"));
						gt.setGt_date_zl(rs.getDate("gt_date_zl"));
						gt.setGe_state_zl(rs.getString("gt_state_zl"));
						cangguan cg = new cangguan();
						cg.setCg_id_zl(rs.getInt("cg_id_zl"));
						seat s= new seat();
						s.setS_id_hyj(rs.getInt("dd_id"));
						order od= new order();
						od.setOrder_id(rs.getInt("cw_id"));
						gt.setOrder(od);
						gt.setCangguan(cg);
						gt.setSeat(s);
				}
				DB.close(conn, stmt, rs);
				} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return gt;
		}
		public boolean addgoout(goout gt){
			Connection conn = DB.getConn();
			try {
				Statement stmt = conn.createStatement();
				SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
				String gt_date = sd.format(gt.getGt_date_zl());
				String sql ="insert into goout_zl(gt_id_zl,cg_id_zl,dd_id,cw_id,gt_date_zl,gt_state_zl) values('"+gt.getGt_id_zl()+"','"+gt.getCangguan().getCg_id_zl()+"','"+gt.getOrder().getOrder_id()+"','"+gt.getSeat().getS_id_hyj()+"','"+gt_date+"','"+gt.getGe_state_zl()+"')";
				System.out.println(sql);
				int num = stmt.executeUpdate(sql);
				if(num > 0){
					return true;
				}
				DB.close(conn, stmt, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		public boolean editgoout(goout gt){
			Connection conn = DB.getConn();
			try {
				Statement stmt = conn.createStatement();
				SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
				String gt_date = sd.format(gt.getGt_date_zl());
				String sql ="update goout_zl set cg_id_zl='"+gt.getCangguan().getCg_id_zl()+"',dd_id='"+gt.getOrder().getOrder_id()+"',cw_id='"+gt.getSeat().getS_id_hyj()+"',gt_date_zl='"+gt_date+"',gt_state_zl='"+gt.getGe_state_zl()+"' where gt_id_zl='"+gt.getGt_id_zl()+"'";
				System.out.println(sql);
				int num = stmt.executeUpdate(sql);
				if(num > 0){
					return true;
				}
				DB.close(conn, stmt, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		public boolean deletegoout(Integer gt_id){
			Connection conn = DB.getConn();
			try {
				Statement stmt = conn.createStatement();
				String sql ="delete from goout_zl where gt_id_zl='"+gt_id+"'";
				int num = stmt.executeUpdate(sql);
				if(num > 0){
					return true;
				}
				DB.close(conn, stmt, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		public List<goout> getGooutList_state(){
			Connection conn = DB.getConn();
			List<goout> l = new ArrayList<goout>();
			try {
				Statement stmt = conn.createStatement();
				String	sql = "SELECT ck.gt_id_zl,ck.cg_id_zl,ck.gt_state_zl,od.order_status FROM goout_zl ck,order_zj od WHERE od.order_id=ck.dd_id";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					goout gt = new goout();
					gt.setGt_id_zl(rs.getInt("gt_id_zl"));
					gt.setGe_state_zl(rs.getString("gt_state_zl"));
				    cangguan c = new cangguan();
					c.setCg_id_zl(rs.getInt("cg_id_zl"));
					order od = new order();
				    od.setOrder_status(rs.getString("order_status"));
					gt.setOrder(od);
					gt.setCangguan(c);
					if(("xinjian".equals(gt.getGe_state_zl()))||("shenhe".equals(gt.getGe_state_zl()))){
					l.add(gt);}
				}
				DB.close(conn, stmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return l;	
	}
		public boolean updategoout_state(Integer gt_id){
			Connection conn = DB.getConn();
			try {
				Statement stmt = conn.createStatement();
				String sql ="update goout_zl set gt_state_zl='chuku' where gt_id_zl='"+gt_id+"'";
				int num = stmt.executeUpdate(sql);
				if(num > 0){
					return true;
				}
				DB.close(conn, stmt, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}	
		public List<wuliao> getWuliaoList(Integer gt_id){
			Connection conn = DB.getConn();
			List<wuliao> l = new ArrayList<wuliao>();
			try {
				Statement stmt = conn.createStatement();
				String	sql = "select w.wuliao_id_gjh,w.wuliao_name_gjh,w.wuliao_norms_gjh,w.wuliao_weight_gjh,w.wuliao_unit_gjh,w.wuliao_count_gjh from wuliao w,wl_ck_zl wc,goout_zl gt where w.wuliao_id_gjh=wc.wl_id_zl and wc.ck_id_zl=gt.gt_id_zl and wc.ck_id_zl='"+gt_id+"'";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					wuliao w = new wuliao();
					w.setWulaio_id_gjh(rs.getInt("wuliao_id_gjh"));
					w.setWulaio_name_gjh(rs.getString("wuliao_name_gjh"));
					w.setWulaio_norms_gjh(rs.getString("wuliao_norms_gjh"));
					w.setWulaio_weight_gjh(rs.getDouble("wuliao_weight_gjh"));
					w.setWulaio_unit_gjh(rs.getString("wuliao_unit_gjh"));
					w.setWulaio_count_gjh(rs.getInt("wuliao_count_gjh"));
					l.add(w);
				}
				DB.close(conn, stmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return l;	
	}
}
