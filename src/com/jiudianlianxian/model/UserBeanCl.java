package com.jiudianlianxian.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jiudianlianxian.util.HibernateUtils;

/**
 * 
 * @Title: UserBeanCl
 * @Description: 用户信息处理
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: UserManagerSys
 * @author fupengpeng
 * @date 2017年8月16日 上午11:58:03
 *
 */
public class UserBeanCl {
	private int pageCount = 0;
	private int rowCount = 0;
	private int pageSize = 3;

	/**
	 * 获取数据总条目数
	 * 
	 * @return
	 */
	public int getPageCount() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.getSessionObject();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from User");
			List<User> list = query.list();
			rowCount = list.size();
			if (rowCount % pageSize == 0) {
				pageCount = rowCount / pageSize;
			} else {
				pageCount = rowCount / pageSize + 1;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageCount;
	}

	/**
	 * 设置分页
	 * 
	 * @param pageNow
	 * @return
	 */
	public List getUsersByPage(int pageNow) {

		Session session = null;
		Transaction transaction = null;
		List<User> list = null;
		try {
			session = HibernateUtils.getSessionObject();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from User");
			// 设置分页的数据条目起始位置
			query.setFirstResult((pageSize * (pageNow - 1)));
			// 设置每页所要展示的数据条目数量
			query.setMaxResults(pageSize);
			list = query.list();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * 登录验证
	 * 
	 * @param u
	 * @param p
	 * @return
	 */
	public boolean checkUser(String u, String p) {
		boolean b = false;
		Session session = null;
		Transaction transaction = null;
		try {
			// 1.使用SessionFactory创建session对象
			session = HibernateUtils.getSessionObject();
			// 2.开启事物
			transaction = session.beginTransaction();
			// 3.crud操作
			Query query = session.createQuery("from User where username=?");
			query.setParameter(0, u);
			List<User> list = query.list();
			for (User user : list) {
				if (user.getPasswd().equals(p)) {
					b = true;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

}
