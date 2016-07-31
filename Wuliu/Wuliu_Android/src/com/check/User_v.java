package com.check;

public class User_v {

	private Integer uid;
	private Integer uroleid;
	private String uname;
	private String upsw;
	private String urole;
	private Integer ustate;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpsw() {
		return upsw;
	}
	public void setUpsw(String upsw) {
		this.upsw = upsw;
	}
	public String getUrole() {
		return urole;
	}
	public void setUrole(Integer rid) {
		if(rid==1000)
			urole="管理员";
		if(rid==1001)
			urole="采购员";
		if(rid==1004)
			urole="仓库管理员";
	}
	public Integer getUstate() {
		return ustate;
	}
	public void setUstate(Integer ustate) {
		this.ustate = ustate;
	}
	public User_v(Integer uid, String uname,  String urole,
			Integer ustate, String upsw, Integer uroleid) {
		super();
		this.uid = uid;
		this.uroleid = uroleid;
		this.uname = uname;
		this.upsw = upsw;
		this.urole = urole;
		this.ustate = ustate;
	}
	public User_v() {
		super();
	}
	public Integer getUroleid() {
		return uroleid;
	}
	public void setUroleid(Integer uroleid) {
		this.uroleid = uroleid;
	}
	
}
