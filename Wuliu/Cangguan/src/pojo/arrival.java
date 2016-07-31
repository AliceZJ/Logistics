package pojo;

import java.util.Date;

public class arrival {
private order order;
private ready ready;
private Date ar_date;
private String ar_man;
private String ar_status;
public arrival() {
	super();
}
public arrival(pojo.order order, pojo.ready ready, Date ar_date, String ar_man,
		String ar_status) {
	super();
	this.order = order;
	this.ready = ready;
	this.ar_date = ar_date;
	this.ar_man = ar_man;
	this.ar_status = ar_status;
}
public order getOrder() {
	return order;
}
public void setOrder(order order) {
	this.order = order;
}
public ready getReady() {
	return ready;
}
public void setReady(ready ready) {
	this.ready = ready;
}
public Date getAr_date() {
	return ar_date;
}
public void setAr_date(Date ar_date) {
	this.ar_date = ar_date;
}
public String getAr_man() {
	return ar_man;
}
public void setAr_man(String ar_man) {
	this.ar_man = ar_man;
}
public String getAr_status() {
	return ar_status;
}
public void setAr_status(String ar_status) {
	this.ar_status = ar_status;
}

}
