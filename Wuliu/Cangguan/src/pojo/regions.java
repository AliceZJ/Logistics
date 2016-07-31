package pojo;

public class regions {
private Integer r_id_hyj;
private String r_name_hyj;
private depot depot;
private Integer r_area_hyj;
public regions() {
	super();
}
public regions(Integer r_id_hyj, String r_name_hyj, pojo.depot depot,
		Integer r_area_hyj) {
	super();
	this.r_id_hyj = r_id_hyj;
	this.r_name_hyj = r_name_hyj;
	this.depot = depot;
	this.r_area_hyj = r_area_hyj;
}
public Integer getR_id_hyj() {
	return r_id_hyj;
}
public void setR_id_hyj(Integer r_id_hyj) {
	this.r_id_hyj = r_id_hyj;
}
public String getR_name_hyj() {
	return r_name_hyj;
}
public void setR_name_hyj(String r_name_hyj) {
	this.r_name_hyj = r_name_hyj;
}
public depot getDepot() {
	return depot;
}
public void setDepot(depot depot) {
	this.depot = depot;
}
public Integer getR_area_hyj() {
	return r_area_hyj;
}
public void setR_area_hyj(Integer r_area_hyj) {
	this.r_area_hyj = r_area_hyj;
}

}
