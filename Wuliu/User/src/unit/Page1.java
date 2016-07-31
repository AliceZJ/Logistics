package unit;

public class Page1 {

	private int currentPageNum;//当前页数
	private int totalNum;//总条数
	private int count = 2;//每页需要显示多少条
	private int totalPage;//总页数
	public int getCurrentPageNum() {
		return currentPageNum;
	}
	public void setCurrentPageNum(int currentPageNum) {
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
		/*
		 * 6   2
		 * 5   2
		 * 4   2
		 * 3   1
		 */
		
		return totalPage;
	}
}
