package pojo;

public class seat_wuliao {
private String sp_sname;
private Integer sp_seatid;
private Integer sp_proid;
private String sp_pname;
public String getSp_sname() {
	return sp_sname;
}
public void setSp_sname(String sp_sname) {
	this.sp_sname = sp_sname;
}
public Integer getSp_seatid() {
	return sp_seatid;
}
public void setSp_seatid(Integer sp_seatid) {
	this.sp_seatid = sp_seatid;
}
public Integer getSp_proid() {
	return sp_proid;
}
public void setSp_proid(Integer sp_proid) {
	this.sp_proid = sp_proid;
}
public String getSp_pname() {
	return sp_pname;
}
public void setSp_pname(String sp_pname) {
	this.sp_pname = sp_pname;
}
public seat_wuliao(String sp_sname, Integer sp_seatid, Integer sp_proid,
		String sp_pname) {
	super();
	this.sp_sname = sp_sname;
	this.sp_seatid = sp_seatid;
	this.sp_proid = sp_proid;
	this.sp_pname = sp_pname;
}
public seat_wuliao() {
	super();
}

}
