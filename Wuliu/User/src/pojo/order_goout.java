package pojo;

public class order_goout {
private order order;
private goout goout;
public order_goout() {
	super();
}
public order_goout(pojo.order order, pojo.goout goout) {
	super();
	this.order = order;
	this.goout = goout;
}
public order getOrder() {
	return order;
}
public void setOrder(order order) {
	this.order = order;
}
public goout getGoout() {
	return goout;
}
public void setGoout(goout goout) {
	this.goout = goout;
};

}
