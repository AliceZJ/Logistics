package pojo;

import java.util.Date;

public class order {
private Integer order_id;
private customer customer;
private String order_type;
private String order_baoguan;
private String pay_type;
private String order_status;
private Date order_date;
private Date tihuo_date;
private String tihuo_type;
private String luru_man;
private String out_address;
private String order_beizhu;
private company company;
private Date caigou_date;
private String caigou_man;
public order() {
	super();
}
public order(Integer order_id, pojo.customer customer, String order_type,
		String order_baoguan, String pay_type, String order_status,
		Date order_date, Date tihuo_date, String tihuo_type, String luru_man,
		String out_address, String order_beizhu, pojo.company company,
		Date caigou_date, String caigou_man) {
	super();
	this.order_id = order_id;
	this.customer = customer;
	this.order_type = order_type;
	this.order_baoguan = order_baoguan;
	this.pay_type = pay_type;
	this.order_status = order_status;
	this.order_date = order_date;
	this.tihuo_date = tihuo_date;
	this.tihuo_type = tihuo_type;
	this.luru_man = luru_man;
	this.out_address = out_address;
	this.order_beizhu = order_beizhu;
	this.company = company;
	this.caigou_date = caigou_date;
	this.caigou_man = caigou_man;
}
public Integer getOrder_id() {
	return order_id;
}
public void setOrder_id(Integer order_id) {
	this.order_id = order_id;
}
public customer getCustomer() {
	return customer;
}
public void setCustomer(customer customer) {
	this.customer = customer;
}
public String getOrder_type() {
	return order_type;
}
public void setOrder_type(String order_type) {
	this.order_type = order_type;
}
public String getOrder_baoguan() {
	return order_baoguan;
}
public void setOrder_baoguan(String order_baoguan) {
	this.order_baoguan = order_baoguan;
}
public String getPay_type() {
	return pay_type;
}
public void setPay_type(String pay_type) {
	this.pay_type = pay_type;
}
public String getOrder_status() {
	return order_status;
}
public void setOrder_status(String order_status) {
	this.order_status = order_status;
}
public Date getOrder_date() {
	return order_date;
}
public void setOrder_date(Date order_date) {
	this.order_date = order_date;
}
public Date getTihuo_date() {
	return tihuo_date;
}
public void setTihuo_date(Date tihuo_date) {
	this.tihuo_date = tihuo_date;
}
public String getTihuo_type() {
	return tihuo_type;
}
public void setTihuo_type(String tihuo_type) {
	this.tihuo_type = tihuo_type;
}
public String getLuru_man() {
	return luru_man;
}
public void setLuru_man(String luru_man) {
	this.luru_man = luru_man;
}
public String getOut_address() {
	return out_address;
}
public void setOut_address(String out_address) {
	this.out_address = out_address;
}
public String getOrder_beizhu() {
	return order_beizhu;
}
public void setOrder_beizhu(String order_beizhu) {
	this.order_beizhu = order_beizhu;
}
public company getCompany() {
	return company;
}
public void setCompany(company company) {
	this.company = company;
}
public Date getCaigou_date() {
	return caigou_date;
}
public void setCaigou_date(Date caigou_date) {
	this.caigou_date = caigou_date;
}
public String getCaigou_man() {
	return caigou_man;
}
public void setCaigou_man(String caigou_man) {
	this.caigou_man = caigou_man;
}

}
