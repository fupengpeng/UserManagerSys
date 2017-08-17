package com.jiudianlianxian.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jiudianlianxian.util.HibernateUtils;

/**
 * 
 * @Title: UserBeanCl
 * @Description: �û���Ϣ����
 * @Company: �����ŵ�������Ϣ�������޹�˾
 * @ProjectName: UserManagerSys
 * @author fupengpeng
 * @date 2017��8��16�� ����11:58:03
 *
 */
public class UserBeanCl {
	private int pageCount = 0;
	private int rowCount = 0;
	private int pageSize = 3;
	
	/**
	 * 
	 * @Description: �޸��û���Ϣ
	 * @date 2017��8��17�� ����4:37:44
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
			//��ӳɹ�
			
			
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
	 * @Description: ����û�
	 * @date 2017��8��17�� ����4:31:25
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
			//��ӳɹ�
			
			
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
	 * @Description: ɾ���û�
	 * @date 2017��8��17�� ����2:41:30
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
				//ɾ���ɹ�
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
	 * ��ȡ��������Ŀ��
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
	 * ���÷�ҳ
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
			// ���÷�ҳ��������Ŀ��ʼλ��
			query.setFirstResult((pageSize * (pageNow - 1)));
			// ����ÿҳ��Ҫչʾ��������Ŀ����
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
	 * ��¼��֤
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
			// 1.ʹ��SessionFactory����session����
			session = HibernateUtils.getSessionObject();
			// 2.��������
			transaction = session.beginTransaction();
			System.out.println("66666666666");
			// 3.crud����
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
