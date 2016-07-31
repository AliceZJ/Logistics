package pojo;

import java.util.Date;

public class purchase {
	private int pur_id;
	private String pur_com;
	private Date pur_date;
	private String pur_man;
	private String pur_status;
	private Date pur_date1;
	public purchase() {
		super();
		// TODO Auto-generated constructor stub
	}
	public purchase(int pur_id, String pur_com, Date pur_date, String pur_man,
			String pur_status,Date pur_date1) {
		super();
		this.pur_id = pur_id;
		this.pur_com = pur_com;
		this.pur_date = pur_date;
		this.pur_man = pur_man;
		this.pur_status = pur_status;
		this.pur_date1 = pur_date1;
	}
	
	public int getPur_id() {
		return pur_id;
	}
	public void setPur_id(int pur_id) {
		this.pur_id = pur_id;
	}
	public String getPur_com() {
		return pur_com;
	}
	public void setPur_com(String pur_com) {
		this.pur_com = pur_com;
	}
	public Date getPur_date() {
		return pur_date;
	}
	public void setPur_date(Date pur_date) {
		this.pur_date = pur_date;
	}
	public String getPur_man() {
		return pur_man;
	}
	public void setPur_man(String pur_man) {
		this.pur_man = pur_man;
	}
	public String getPur_status() {
		return pur_status;
	}
	public void setPur_status(String pur_status) {
		this.pur_status = pur_status;
	}
	public Date getPur_date1() {
		return pur_date1;
	}
	public void setPur_date1(Date pur_date1) {
		this.pur_date1 = pur_date1;
	}
	

}
