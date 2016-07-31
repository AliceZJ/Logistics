package pojo;

import java.util.Date;

public class product_check {
private Integer pc_id;
private seat seat;
private cangguan cangguan;
private Date pc_date;
private Integer pc_number;
public product_check() {
	super();
}
public product_check(Integer pc_id, pojo.seat seat, pojo.cangguan cangguan,
		Date pc_date, Integer pc_number) {
	super();
	this.pc_id = pc_id;
	this.seat = seat;
	this.cangguan = cangguan;
	this.pc_date = pc_date;
	this.pc_number = pc_number;
}
public Integer getPc_id() {
	return pc_id;
}
public void setPc_id(Integer pc_id) {
	this.pc_id = pc_id;
}
public seat getSeat() {
	return seat;
}
public void setSeat(seat seat) {
	this.seat = seat;
}
public cangguan getCangguan() {
	return cangguan;
}
public void setCangguan(cangguan cangguan) {
	this.cangguan = cangguan;
}
public Date getPc_date() {
	return pc_date;
}
public void setPc_date(Date pc_date) {
	this.pc_date = pc_date;
}
public Integer getPc_number() {
	return pc_number;
}
public void setPc_number(Integer pc_number) {
	this.pc_number = pc_number;
}

}
