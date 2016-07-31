package pojo;

public class customer {
private Integer customer_id;
private String customer_name;
private String customer_short;
private hangye hangye;
private String customer_address;
private String customer;
private String customer_phone;
private String customer_email;
private String customer_credit;
public customer() {
	super();
}
public customer(Integer customer_id, String customer_name,
		String customer_short, pojo.hangye hangye, String customer_address,
		String customer, String customer_phone, String customer_email,
		String customer_credit) {
	super();
	this.customer_id = customer_id;
	this.customer_name = customer_name;
	this.customer_short = customer_short;
	this.hangye = hangye;
	this.customer_address = customer_address;
	this.customer = customer;
	this.customer_phone = customer_phone;
	this.customer_email = customer_email;
	this.customer_credit = customer_credit;
}
public Integer getCustomer_id() {
	return customer_id;
}
public void setCustomer_id(Integer customer_id) {
	this.customer_id = customer_id;
}
public String getCustomer_name() {
	return customer_name;
}
public void setCustomer_name(String customer_name) {
	this.customer_name = customer_name;
}
public String getCustomer_short() {
	return customer_short;
}
public void setCustomer_short(String customer_short) {
	this.customer_short = customer_short;
}
public hangye getHangye() {
	return hangye;
}
public void setHangye(hangye hangye) {
	this.hangye = hangye;
}
public String getCustomer_address() {
	return customer_address;
}
public void setCustomer_address(String customer_address) {
	this.customer_address = customer_address;
}
public String getCustomer() {
	return customer;
}
public void setCustomer(String customer) {
	this.customer = customer;
}
public String getCustomer_phone() {
	return customer_phone;
}
public void setCustomer_phone(String customer_phone) {
	this.customer_phone = customer_phone;
}
public String getCustomer_email() {
	return customer_email;
}
public void setCustomer_email(String customer_email) {
	this.customer_email = customer_email;
}
public String getCustomer_credit() {
	return customer_credit;
}
public void setCustomer_credit(String customer_credit) {
	this.customer_credit = customer_credit;
}
@Override
public String toString() {
	return "customer [customer_id=" + customer_id + ", customer_name="
			+ customer_name + ", customer_short=" + customer_short
			+ ", hangye=" + hangye + ", customer_address=" + customer_address
			+ ", customer=" + customer + ", customer_phone=" + customer_phone
			+ ", customer_email=" + customer_email + ", customer_credit="
			+ customer_credit + "]";
}


}
