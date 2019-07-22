package group5.travel.service.impl;

import java.util.List;

import group5.travel.dao.IAppointDAO;
import group5.travel.pojo.Appoint;
import group5.travel.service.IAppointService;
import group5.travel.servlet.AppointServlet;
import group5.travel.util.Page;

public class AppointServiceImpl implements IAppointService {
	private IAppointDAO appointDAO;
	
	public void setAppointDAO(IAppointDAO appointDAO) {
		this.appointDAO = appointDAO;
	}

	/**
	 * 分页查询
	 */
	@Override
	public Page<Appoint> queryByPage(int page, int rows) {
		//创建一个page对象
		Page p=new Page<>();
		//调用分页查询的方法
		List<Appoint> appoints = appointDAO.queryByPage(page, rows);
		//调用查询总数的方法
		int total = appointDAO.queryCount();
		int maxPageNum=(int) Math.ceil(total*1.0/rows);
		//分别将数据设置进去
		//最大页码
		p.setMaxPageNum(maxPageNum);
		//当前页码
		p.setPage(page);
		//分页查询到的数据
		p.setRows(appoints);
		//数据总条数
		p.setTotal(total);
		//将数据返回
		return p;
	}
	/**
	 * 修改预约单的状态
	 */
	@Override
	public int updateStatus(int appointId) {
		return appointDAO.updateStatus(appointId);
	}

	@Override
	public int reUpdateStatus(int appointId) {
		// TODO Auto-generated method stub
		return appointDAO.reUpdateStatus(appointId);
	}
	/**
	 * 保存预约单
	 */
	@Override
	public int save(Appoint a) {
		// TODO Auto-generated method stub
		return appointDAO.save(a);
	}

	@Override
	public List<Appoint> queryByUserId(int userId) {
		return appointDAO.queryByUserId(userId);
	}

	@Override
	public Appoint queryByAppointId(int appointId) {
		return appointDAO.queryByAppointId(appointId);
	}

}
