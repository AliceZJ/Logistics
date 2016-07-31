package pojo;

public class seat_wuliao {
private seat seat;
private wuliao wuliao;
public seat_wuliao() {
	super();
}
public seat_wuliao(pojo.seat seat, pojo.wuliao wuliao) {
	super();
	this.seat = seat;
	this.wuliao = wuliao;
}
public seat getSeat() {
	return seat;
}
public void setSeat(seat seat) {
	this.seat = seat;
}
public wuliao getWuliao() {
	return wuliao;
}
public void setWuliao(wuliao wuliao) {
	this.wuliao = wuliao;
}

}
