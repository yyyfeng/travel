package group5.travel.util;

import java.util.List;

/**  
* @ClassName: Page  
* @Description: TODO(������һ�仰��������������)
* @date 2018��12��4�� ����11:42:18    
* Company www.igeekhome.com
*    
*/
public class Page<T> {
	private int page;//��ǰҳ��
	private int total;//������
	private List<T> rows;//����
	private int maxPageNum;//���ҳ��
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
