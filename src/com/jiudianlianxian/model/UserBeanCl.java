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
	 * 
	 * @Description: 修改用户信息
	 * @date 2017年8月17日 下午4:37:44
	 * @param userid
	 * @param username
	 * @param passwd
	 * @param email
	 * @param grade
	 * @return
	 */
	public boolean updateUserById(String userid,String username,String passwd,String email,String grade){
		boolean b = true;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.getSessionObject();
			transaction = session.beginTransaction();
			User user = new User();
			user.setUsername(username);
			user.setPasswd(passwd);
			user.setEmail(email);
			user.setGrade(Integer.parseInt(grade));
			int a = (int) session.save(user);
			System.out.println("a = " + a );
			//添加成功
			
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			b = false;
			transaction.rollback();
		}
		
		
		
		return b;
		
	}
	
	/**
	 * 
	 * @Description: 添加用户
	 * @date 2017年8月17日 下午4:31:25
	 * @param username
	 * @param passwd
	 * @param email
	 * @param grade
	 * @return
	 */
	public boolean addUserById(String username,String passwd,String email,String grade){
		boolean b = true;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.getSessionObject();
			transaction = session.beginTransaction();
			User user = new User();
			user.setUsername(username);
			user.setPasswd(passwd);
			user.setEmail(email);
			user.setGrade(Integer.parseInt(grade));
			int a = (int) session.save(user);
			System.out.println("a = " + a );
			//添加成功
			
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			b = false;
			transaction.rollback();
		}
		
		
		
		return b;
		
	}
	
	/**
	 * 
	 * @Description: 删除用户
	 * @date 2017年8月17日 下午2:41:30
	 * @param id
	 * @return
	 */
	public boolean delUserById(String id){
		boolean b = false;
		Session session = null;
		Transaction transaction = null;
		
		
		try {
			session = HibernateUtils.getSessionObject();
			transaction = session.beginTransaction();
			
			Query query = session.createQuery("delete from User where userId=?");
			query.setParameter(0, Integer.parseInt(id));
			int a = query.executeUpdate();
			System.out.println("a = " + a );
			if (a == 1) {
				//删除成功
				b = true;
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
		
		
		
		return b;
		
	}
	

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
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
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
			
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
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
			System.out.println("66666666666");
			// 3.crud操作
			Query query = session.createQuery("from User where username=?");
			query.setParameter(0, u);
			List<User> list = query.list();
			for (User user : list) {
				if (user.getPasswd().equals(p)) {
					b = true;
				}
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		} 
		System.out.println("b  = " + b);
		return b;
	}

}
