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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			// 3.crud����
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
