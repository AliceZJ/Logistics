package com.admin.gl_v;

public class Page1 {

	private int currentPageNum;
	private int totalNum;
	private int count = 3;
	private int totalPage;
	
	public int getCurrentPageNum(){
		return currentPageNum;		
	}
	public void setCurrentPageNum(int currentPageNum){
		this.currentPageNum = currentPageNum;		
	}


	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
		this.totalPage = this.totalNum%this.count == 0?this.totalNum/this.count:this.totalNum/this.count+1;
	}

	public int getCount() {
		return count;
	}

	public int getTotalPage() {
		return totalPage;
	}
}
