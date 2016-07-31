package pojo;

import java.util.Date;

public class goout {
private Integer gt_id_zl;
private cangguan cangguan;
private order order;
private seat seat;
private Date gt_date_zl;
private String ge_state_zl;
public goout() {
	super();
}
public goout(Integer gt_id_zl, pojo.cangguan cangguan, pojo.order order,
		pojo.seat seat, Date gt_date_zl, String ge_state_zl) {
	super();
	this.gt_id_zl = gt_id_zl;
	this.cangguan = cangguan;
	this.order = order;
	this.seat = seat;
	this.gt_date_zl = gt_date_zl;
	this.ge_state_zl = ge_state_zl;
}
public Integer getGt_id_zl() {
	return gt_id_zl;
}
public void setGt_id_zl(Integer gt_id_zl) {
	this.gt_id_zl = gt_id_zl;
}
public cangguan getCangguan() {
	return cangguan;
}
public void setCangguan(cangguan cangguan) {
	this.cangguan = cangguan;
}
public order getOrder() {
	return order;
}
public void setOrder(order order) {
	this.order = order;
}
public seat getSeat() {
	return seat;
}
public void setSeat(seat seat) {
	this.seat = seat;
}
public Date getGt_date_zl() {
	return gt_date_zl;
}
public void setGt_date_zl(Date gt_date_zl) {
	this.gt_date_zl = gt_date_zl;
}
public String getGe_state_zl() {
	return ge_state_zl;
}
public void setGe_state_zl(String ge_state_zl) {
	this.ge_state_zl = ge_state_zl;
}

}
