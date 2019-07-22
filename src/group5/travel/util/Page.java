package group5.travel.util;

import java.util.List;

/**  
* @ClassName: Page  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年12月4日 上午11:42:18    
* Company www.igeekhome.com
*    
*/
public class Page<T> {
	private int page;//当前页码
	private int total;//总条数
	private List<T> rows;//数据
	private int maxPageNum;//最大页码
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public int getMaxPageNum() {
		return maxPageNum;
	}
	public void setMaxPageNum(int maxPageNum) {
		this.maxPageNum = maxPageNum;
	}
	
}
