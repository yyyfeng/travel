package group5.travel.dao;

import java.util.List;

import group5.travel.pojo.Menu;

public interface IMenuDAO {

	List<Menu> queryBy(int page, int rows);

	int queryCount();

	int remove(int menuId);

	int Add(Menu menu);

	Menu queryById(int id);

	int update(Menu menu);

	List<Menu> queryAll(int i, int j);

	List<Menu> queryAll();
}
