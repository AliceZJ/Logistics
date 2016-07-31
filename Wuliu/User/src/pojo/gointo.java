package pojo;

import java.util.Date;

public class gointo {
private Integer go_id_zl;
private cangguan cangguan;
private Date go_date_zl;
private String go_state;
public gointo() {
	super();
}
public gointo(Integer go_id_zl, pojo.cangguan cangguan, Date go_date_zl,
		String go_state) {
	super();
	this.go_id_zl = go_id_zl;
	this.cangguan = cangguan;
	this.go_date_zl = go_date_zl;
	this.go_state = go_state;
}
public Integer getGo_id_zl() {
	return go_id_zl;
}
public void setGo_id_zl(Integer go_id_zl) {
	this.go_id_zl = go_id_zl;
}
public cangguan getCangguan() {
	return cangguan;
}
public void setCangguan(cangguan cangguan) {
	this.cangguan = cangguan;
}
public Date getGo_date_zl() {
	return go_date_zl;
}
public void setGo_date_zl(Date go_date_zl) {
	this.go_date_zl = go_date_zl;
}
public String getGo_state() {
	return go_state;
}
public void setGo_state(String go_state) {
	this.go_state = go_state;
}

}
