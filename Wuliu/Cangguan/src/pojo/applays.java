package pojo;

import java.util.Date;

public class applays {
private Integer as_id;
private Date as_date;
private String as_man;
private String as_status;
public applays() {
	super();
}
public applays(Integer as_id, Date as_date, String as_man, String as_status) {
	super();
	this.as_id = as_id;
	this.as_date = as_date;
	this.as_man = as_man;
	this.as_status = as_status;
}
public Integer getAs_id() {
	return as_id;
}
public void setAs_id(Integer as_id) {
	this.as_id = as_id;
}
public Date getAs_date() {
	return as_date;
}
public void setAs_date(Date as_date) {
	this.as_date = as_date;
}
public String getAs_man() {
	return as_man;
}
public void setAs_man(String as_man) {
	this.as_man = as_man;
}
public String getAs_status() {
	return as_status;
}
public void setAs_status(String as_status) {
	this.as_status = as_status;
}

}
