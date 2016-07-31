package zhangjuan;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import unit.db;

public class u_p_n_dao {
public void update(Integer id,Integer num){
	
	 Connection conn=db.getConn();
	 Statement st = null;
	try {
		st = conn.createStatement();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} 
	String sql="update pro_num_che set pc_num="+num+" where pc_pid="+id+"";
	
	 try {
		Integer n=st.executeUpdate(sql);
		//System.out.println(n);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 try {
		st.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

}
