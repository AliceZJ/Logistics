package zhangjuan;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class update_pro_num_service {
	public void u_p_n(HttpServletRequest request, HttpServletResponse response, Integer pid, Integer pnum){
		new u_p_n_dao().update(pid,pnum);
		
	}


}
