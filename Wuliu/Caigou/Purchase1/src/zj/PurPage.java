package zj;

public class PurPage {
	private int currentPageNum;//��ǰҳ��
	private int totalNum;//������
	private int count = 3;//ÿҳ��Ҫ��ʾ������
	private int totalPage;//��ҳ��
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
	public int getTotalNum(){
		return totalNum;
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



