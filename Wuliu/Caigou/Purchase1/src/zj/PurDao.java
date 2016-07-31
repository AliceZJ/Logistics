package zj;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import pojo.applays;
import pojo.purchase;

import util.DB;
public class PurDao {
	//采购申请
	private static final String As_date = null;
	public List<applays> getapplaysList(){
			Connection conn = DB.getConn();
			List<applays> l = new ArrayList<applays>();
			try {
				Statement stmt = conn.createStatement();
				
				String	sql = "select * from applays";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					applays a = new applays();
					a.setAs_id(rs.getString("as_id"));
					a.setAs_date(rs.getDate("as_date"));
					a.setAs_man(rs.getString("as_man"));
					l.add(a);
				}
				DB.close(conn, stmt, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return l;	
	}
			public applays getapplaysById(String as_id){
			Connection conn = DB.getConn();
			applays a = new applays();
				try {
					Statement stmt = conn.createStatement();
					String sql = "select * from applays where as_id="+as_id;
					ResultSet rs = stmt.executeQuery(sql);
						if(rs.next()){
							a.setAs_id(rs.getString("as_id"));
							a.setAs_date(rs.getDate("as_date"));
							a.setAs_man(rs.getString("as_man"));
					}
					DB.close(conn, stmt, rs);
					} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			return a;
			}
			public boolean addapplays(applays a){
				Connection conn = DB.getConn();
				try {
					Statement stmt = conn.createStatement();
					SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
					String as_date = sd.format(a.getAs_date());
					String sql ="insert into applays(as_id,as_date,as_man,as_status,achieve_date,beizhu) values('"+a.getAs_id()+"','"+as_date+"','"+a.getAs_man()+"','"+null+"','"+null+"','"+null+"')";
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
			public boolean editapplays(applays a){
				Connection conn = DB.getConn();
				try {
					Statement stmt = conn.createStatement();
					SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
					String as_date = sd.format(a.getAs_date());
					String sql ="update applays set as_date='"+as_date+"',as_man='"+a.getAs_man()+"' where as_id='"+a.getAs_id()+"'";
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
			public boolean deleteapplays(String as_id){
				Connection conn = DB.getConn();
				try {
					Statement stmt = conn.createStatement();
					String sql ="delete from applays where as_id='"+as_id+"'";
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
			//采购订单
			private static final String pur_date = null;
			public List<purchase> getpurchaseList(){
					Connection conn = DB.getConn();
					List<purchase> l = new ArrayList<purchase>();
					try {
						Statement stmt = conn.createStatement();
						
						String	sql = "select * from purchase";
						ResultSet rs = stmt.executeQuery(sql);
						while(rs.next()){
							purchase p= new purchase();
							p.setPur_id(rs.getInt("pur_id"));
							p.setPur_com(rs.getString("pur_com"));
							p.setPur_date(rs.getDate("pur_date"));
							p.setPur_man(rs.getString("pur_man"));
							p.setPur_status(rs.getString("pur_status"));
							l.add(p);
						}
						DB.close(conn, stmt, rs);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return l;	
			}
					public purchase getpurchaseById(String pur_id){
					Connection conn = DB.getConn();
					purchase p = new purchase();
						try {
							Statement stmt = conn.createStatement();
							String sql = "select * from purchase where pur_id="+pur_id;
							ResultSet rs = stmt.executeQuery(sql);
								if(rs.next()){
									p.setPur_id(rs.getInt("pur_id"));
									p.setPur_com(rs.getString("pur_com"));
									p.setPur_date(rs.getDate("pur_date"));
									p.setPur_man(rs.getString("pur_man"));
									p.setPur_status(rs.getString("pur_status"));
							}
							DB.close(conn, stmt, rs);
							} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
					return p;
					}
					public boolean addpurchase(purchase p){
						Connection conn = DB.getConn();
						try {
							Statement stmt = conn.createStatement();
							SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
							String pur_date = sd.format(p.getPur_date());
							String sql ="insert into purchase(pur_id,pur_com,pur_date,pur_man,pur_status,pur_date1) values('"+p.getPur_id()+"','"+p.getPur_com()+"','"+pur_date+"','"+p.getPur_man()+"','"+p.getPur_status()+"','"+p.getPur_date1()+"')";
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
					public boolean editpurchase(purchase p){
						Connection conn = DB.getConn();
						try {
							Statement stmt = conn.createStatement();
							SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
							String pur_date = sd.format(p.getPur_date());
							String pur_date1 = sd.format(p.getPur_date());
							String sql ="update purchase set pur_date='"+pur_date+"',pur_com='"+p.getPur_com()+"',pur_man='"+p.getPur_man()+"',pur_status='"+p.getPur_status()+"' where pur_id='"+p.getPur_id()+"',pur_date1='"+pur_date1+"'";
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
					public boolean deletepurchase(int pur_id){
						Connection conn = DB.getConn();
						try {
							Statement stmt = conn.createStatement();
							String sql ="delete from purchase where pur_id='"+pur_id+"'";
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
					//订单接收
					public List<purchase> getpurchase_receiveList(){
							Connection conn = DB.getConn();
							List<purchase> l = new ArrayList<purchase>();
							try {
								Statement stmt = conn.createStatement();
								
								String	sql = "select * from purchase";
								ResultSet rs = stmt.executeQuery(sql);
								while(rs.next()){
									purchase p= new purchase();
									p.setPur_id(rs.getInt("pur_id"));
									p.setPur_com(rs.getString("pur_com"));
									p.setPur_date(rs.getDate("pur_date"));
									p.setPur_status(rs.getString("pur_status"));
									l.add(p);
								}
								DB.close(conn, stmt, rs);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							return l;	
					}
			
}

