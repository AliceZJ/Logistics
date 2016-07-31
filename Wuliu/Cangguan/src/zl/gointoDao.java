package zl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import pojo.gointo;
import pojo.cangguan;
import pojo.wuliao;
import util.DB;
public class gointoDao {
	public List<gointo> getGointoList(){
			Connection conn = DB.getConn();
			List<gointo> l = new ArrayList<gointo>();
			try {
				Statement stmt = conn.createStatement();
				
				String	sql = "select * from gointo_zl";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					gointo go = new gointo();
					go.setGo_id_zl(rs.getInt("go_id_zl"));
					go.setGo_date_zl(rs.getDate("go_date_zl"));
					go.setGo_state(rs.getString("go_state"));
					cangguan cg = new cangguan();
					cg.setCg_id_zl(rs.getInt("cg_id_zl"));
					go.setCangguan(cg);
					l.add(go);
				}
				DB.close(conn, stmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return l;	
	}
			public gointo getgointoById(int rukuid){
			Connection conn = DB.getConn();
			gointo go = new gointo();
				try {
					Statement stmt = conn.createStatement();
					String sql = "select * from gointo_zl where go_id_zl="+rukuid;
					ResultSet rs = stmt.executeQuery(sql);
						if(rs.next()){
							go.setGo_id_zl(rs.getInt("go_id_zl"));
							go.setGo_date_zl(rs.getDate("go_date_zl"));
							go.setGo_state(rs.getString("go_state"));
							cangguan cg = new cangguan();
							cg.setCg_id_zl(rs.getInt("cg_id_zl"));
							go.setCangguan(cg);
					}
					DB.close(conn, stmt, rs);
					} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			return go;
			}
			public boolean addgointo(gointo go){
				Connection conn = DB.getConn();
				try {
					Statement stmt = conn.createStatement();
					SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
					String go_date = sd.format(go.getGo_date_zl());
					String sql ="insert into gointo_zl(go_id_zl,cg_id_zl,go_date_zl,go_state) values('"+go.getGo_id_zl()+"','"+go.getCangguan().getCg_id_zl()+"','"+go_date+"','"+go.getGo_state()+"')";
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
			public boolean editgointo(gointo go){
				Connection conn = DB.getConn();
				try {
					Statement stmt = conn.createStatement();
					SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
					String go_date = sd.format(go.getGo_date_zl());
					String sql ="update gointo_zl set cg_id_zl='"+go.getCangguan().getCg_id_zl()+"',go_date_zl='"+go_date+"',go_state='"+go.getGo_state()+"' where go_id_zl='"+go.getGo_id_zl()+"'";
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
			public boolean deletegointo(int go_id){
				Connection conn = DB.getConn();
				try {
					Statement stmt = conn.createStatement();
					String sql ="delete from gointo_zl where go_id_zl='"+go_id+"'";
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
			public List<gointo> getGointoList_state(){
				Connection conn = DB.getConn();
				List<gointo> l = new ArrayList<gointo>();
				try {
					Statement stmt = conn.createStatement();
					
					String	sql = "select * from gointo_zl";
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()){
						gointo go = new gointo();
						go.setGo_id_zl(rs.getInt("go_id_zl"));
						go.setGo_date_zl(rs.getDate("go_date_zl"));
						go.setGo_state(rs.getString("go_state"));
						cangguan cg = new cangguan();
						cg.setCg_id_zl(rs.getInt("cg_id_zl"));
						go.setCangguan(cg);
						if("shenhe".equals(go.getGo_state()))
						l.add(go);
					}
					DB.close(conn, stmt, rs);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return l;	
		}
			public boolean updategointo_state(Integer go_id){
				Connection conn = DB.getConn();
				try {
					Statement stmt = conn.createStatement();
					String sql ="update gointo_zl set go_state='ruku' where go_id_zl='"+go_id+"'";
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
			public List<wuliao> getWuliaoList(Integer go_id){
				Connection conn = DB.getConn();
				List<wuliao> l = new ArrayList<wuliao>();
				try {
					Statement stmt = conn.createStatement();
					String	sql = "select w.wuliao_id_gjh,w.wuliao_name_gjh,w.wuliao_norms_gjh,w.wuliao_weight_gjh,w.wuliao_unit_gjh,w.wuliao_count_gjh from wuliao w,wl_rk_zl wr,gointo_zl go where w.wuliao_id_gjh=wr.wl_id_zl and wr.go_id_zl=go.go_id_zl and wr.go_id_zl='"+go_id+"'";
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

