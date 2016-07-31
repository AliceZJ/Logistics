package pojo;

public class seat {
private Integer s_id_hyj;
private String s_name_hyj;
private regions regions;
private Integer s_area;
public seat() {
	super();
}
public seat(Integer s_id_hyj, String s_name_hyj, pojo.regions regions,
		Integer s_area) {
	super();
	this.s_id_hyj = s_id_hyj;
	this.s_name_hyj = s_name_hyj;
	this.regions = regions;
	this.s_area = s_area;
}
public Integer getS_id_hyj() {
	return s_id_hyj;
}
public void setS_id_hyj(Integer s_id_hyj) {
	this.s_id_hyj = s_id_hyj;
}
public String getS_name_hyj() {
	return s_name_hyj;
}
public void setS_name_hyj(String s_name_hyj) {
	this.s_name_hyj = s_name_hyj;
}
public regions getRegions() {
	return regions;
}
public void setRegions(regions regions) {
	this.regions = regions;
}
public Integer getS_area() {
	return s_area;
}
public void setS_area(Integer s_area) {
	this.s_area = s_area;
}

}
