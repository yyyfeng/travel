package group5.travel.service;

import java.util.List;
import java.util.Map;

import group5.travel.pojo.Menu;
import group5.travel.util.Page;

public interface IMenuService {

	Page queryBy(int page, int rows);

	int remove(int menuId);

	int Add(Menu menu);

	Menu queryById(int id);

	int update(Menu menu);

	Map<String, Object> index();

	List<Menu> queryAll();

}
