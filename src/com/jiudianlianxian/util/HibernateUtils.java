package com.jiudianlianxian.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * Title: HibernateUtils 
 * Description: hibernate������ 
 * Company: �����ŵ�������Ϣ�������޹�˾
 * ProjectName: UserManagerSys
 * @author fupengpeng
 * @date 2017��8��16�� ����8:56:48
 *
 */
public class HibernateUtils {

	/**
	 * ��������SessionFactory���� SessionFactory�����������Դ����ֻ����һ��SessionFactory����
	 */
	private static final Configuration configuration;
	private static final SessionFactory sessionFactory;

	static {
		configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
	}

	// �ṩ���������뱾���̰߳󶨵�session����ķ���
	public static Session getSessionObject() {
		return sessionFactory.getCurrentSession();
	}

	// �ṩ��������SessionFactory����
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void main(String[] args) {

	}

}
