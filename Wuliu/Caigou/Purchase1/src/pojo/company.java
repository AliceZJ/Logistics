package pojo;

import java.util.Date;

public class company {
private Integer c_id_hyj;
private String c_name_hyj;
private Integer c_hyid_hyj;
private Date c_time_hyj;
private String c_legal_hyj;
public company() {
	super();
}
public company(Integer c_id_hyj, String c_name_hyj, Integer c_hyid_hyj,
		Date c_time_hyj, String c_legal_hyj) {
	super();
	this.c_id_hyj = c_id_hyj;
	this.c_name_hyj = c_name_hyj;
	this.c_hyid_hyj = c_hyid_hyj;
	this.c_time_hyj = c_time_hyj;
	this.c_legal_hyj = c_legal_hyj;
}
public Integer getC_id_hyj() {
	return c_id_hyj;
}
public void setC_id_hyj(Integer c_id_hyj) {
	this.c_id_hyj = c_id_hyj;
}
public String getC_name_hyj() {
	return c_name_hyj;
}
public void setC_name_hyj(String c_name_hyj) {
	this.c_name_hyj = c_name_hyj;
}
public Integer getC_hyid_hyj() {
	return c_hyid_hyj;
}
public void setC_hyid_hyj(Integer c_hyid_hyj) {
	this.c_hyid_hyj = c_hyid_hyj;
}
public Date getC_time_hyj() {
	return c_time_hyj;
}
public void setC_time_hyj(Date c_time_hyj) {
	this.c_time_hyj = c_time_hyj;
}
public String getC_legal_hyj() {
	return c_legal_hyj;
}
public void setC_legal_hyj(String c_legal_hyj) {
	this.c_legal_hyj = c_legal_hyj;
}


}
