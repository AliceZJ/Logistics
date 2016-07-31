package pojo;

import java.util.Date;

public class product_reject {
private Integer pr_id;
private cangguan cangguan;
private Date pr_date;
private String pr_reason;
public product_reject() {
	super();
}
public product_reject(Integer pr_id, pojo.cangguan cangguan, Date pr_date,
		String pr_reason) {
	super();
	this.pr_id = pr_id;
	this.cangguan = cangguan;
	this.pr_date = pr_date;
	this.pr_reason = pr_reason;
}
public Integer getPr_id() {
	return pr_id;
}
public void setPr_id(Integer pr_id) {
	this.pr_id = pr_id;
}
public cangguan getCangguan() {
	return cangguan;
}
public void setCangguan(cangguan cangguan) {
	this.cangguan = cangguan;
}
public Date getPr_date() {
	return pr_date;
}
public void setPr_date(Date pr_date) {
	this.pr_date = pr_date;
}
public String getPr_reason() {
	return pr_reason;
}
public void setPr_reason(String pr_reason) {
	this.pr_reason = pr_reason;
}

}
