package pojo;

import java.util.Date;

public class ready {
private Integer pe_id;
private Date re_date;
private String re_man;
public ready() {
	super();
}
public ready(Integer pe_id, Date re_date, String re_man) {
	super();
	this.pe_id = pe_id;
	this.re_date = re_date;
	this.re_man = re_man;
}
public Integer getPe_id() {
	return pe_id;
}
public void setPe_id(Integer pe_id) {
	this.pe_id = pe_id;
}
public Date getRe_date() {
	return re_date;
}
public void setRe_date(Date re_date) {
	this.re_date = re_date;
}
public String getRe_man() {
	return re_man;
}
public void setRe_man(String re_man) {
	this.re_man = re_man;
}

}
