package pojo;

public class pro_num_che {
  private String pc_sname;
  private String pc_pname;
  private Integer pc_sid;
  private Integer pc_pid;
  private Integer pc_num;
public String getPc_sname() {
	return pc_sname;
}
public void setPc_sname(String pc_sname) {
	this.pc_sname = pc_sname;
}
public String getPc_pname() {
	return pc_pname;
}
public void setPc_pname(String pc_pname) {
	this.pc_pname = pc_pname;
}
public Integer getPc_sid() {
	return pc_sid;
}
public void setPc_sid(Integer pc_sid) {
	this.pc_sid = pc_sid;
}
public Integer getPc_pid() {
	return pc_pid;
}
public void setPc_pid(Integer pc_pid) {
	this.pc_pid = pc_pid;
}
public Integer getPc_num() {
	return pc_num;
}
public void setPc_num(Integer pc_num) {
	this.pc_num = pc_num;
}
public pro_num_che(String pc_sname, String pc_pname, Integer pc_sid,
		Integer pc_pid, Integer pc_num) {
	super();
	this.pc_sname = pc_sname;
	this.pc_pname = pc_pname;
	this.pc_sid = pc_sid;
	this.pc_pid = pc_pid;
	this.pc_num = pc_num;
}
public pro_num_che() {
	super();
}
  
}
