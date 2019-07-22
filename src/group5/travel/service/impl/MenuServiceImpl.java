package group5.travel.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import group5.travel.dao.IMenuDAO;
import group5.travel.dao.ITripDAO;
import group5.travel.pojo.Menu;
import group5.travel.pojo.Trip;
import group5.travel.service.IMenuService;
import group5.travel.util.Page;

public class MenuServiceImpl implements IMenuService {
	private ITripDAO tripDAO;
	public void setTripDAO(ITripDAO tripDAO) {
		this.tripDAO = tripDAO;
	}
	
	private IMenuDAO menuDAO;

	public void setMenuDAO(IMenuDAO menuDAO) {
		this.menuDAO = menuDAO;
	}

	public Page queryBy(int page, int rows) {
		List<Menu> menu = menuDAO.queryBy(page,rows);
		//System.out.println(menu);
		int max = menuDAO.queryCount();
		Page p = new Page();
		p.setRows(menu);
		p.setTotal(max);
		p.setPage(page);
		//System.out.println(p);
		return p;
	}

	
	public int remove(int menuId) {
		return menuDAO.remove(menuId);
	}

	@Override
	public int Add(Menu menu) {
		return menuDAO.Add(menu);
	}

	@Override
	public Menu queryById(int id) {
		return menuDAO.queryById(id);
	}

	@Override
	public int update(Menu menu) {
		return menuDAO.update(menu);
	}

	@Override
	public Map<String, Object> index() {
		int i=1;
		int j=8;
		Map<String, Object> map = new HashMap<>();
		List<Menu> st=null;
		//List<Trip> trip=null;
		//String str ="µ±¼¾ÂÃÐÐ";
		try {
			st = menuDAO.queryAll(i,j);
			//trip = tripDAO.queryBymenu(str);
		} catch (Exception e) {
		}
		//System.out.println(trip);
		map.put("menu", st);
		//map.put("trip", trip);
		return map;
	}

	@Override
	public List<Menu> queryAll() {
		// TODO Auto-generated method stub
		return menuDAO.queryAll();
	}
	
}
