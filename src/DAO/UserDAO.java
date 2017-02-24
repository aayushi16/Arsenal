package DAO;

import VO.CategoryVO;
import VO.SubCategoryVO;
import VO.UserVO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserDAO {

			public void insertUser(UserVO v) {

				Session session = null;
				try {

					SessionFactory sessionFactory = new Configuration().configure()
							.buildSessionFactory();
					session = sessionFactory.openSession();
					Transaction tr = session.beginTransaction();
				
					session.save(v);
			
					tr.commit();
					
				} 
				catch (Exception e) {
					e.printStackTrace();
		}
			}
				public List editUser(UserVO v2)
				{
					List ls=new ArrayList();
					try
					{
						SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
						Session session =sessionFactory.openSession();
						Query query=session.createQuery("from UserVO where user_id='"+v2.getUser_id()+"' ");
						ls = query.list();
					}
					catch(Exception exception)
					{
						exception.printStackTrace();
					}
					return ls;
				}
				public void updateUser(UserVO v) {

					Session session = null;
					try {

						SessionFactory sessionFactory = new Configuration().configure()
								.buildSessionFactory();
						session = sessionFactory.openSession();
						Transaction tr = session.beginTransaction();
					
						session.saveOrUpdate(v);
				
						tr.commit();
						
					} 
					catch (Exception e) {
						e.printStackTrace();
			}
				}
			
			
			public List search() {		
				// TODO Auto-generated method stub
				java.util.List lss= new ArrayList();
				try {
					
						SessionFactory sessionfactory = new Configuration().configure()
								.buildSessionFactory();
						Session session = sessionfactory.openSession();
						Query q=session.createQuery("from UserVO");
						Transaction tr=session.beginTransaction();
						lss = q.list();
						System.out.println("Done");
						tr.commit();
			
					} catch(Exception e) {
						System.out.println(e);

					}
		return lss;
			}
			
			public void deleteUser(UserVO v) {
				// TODO Auto-generated method stub
				Session session = null;
				try {

					SessionFactory sessionFactory = new Configuration().configure()
							.buildSessionFactory();
					session = sessionFactory.openSession();
					Transaction tr = session.beginTransaction();
				
					session.delete(v);
			
					tr.commit();
					
				} 
				catch (Exception e) {
					e.printStackTrace();
		}
				
			}
			public List validate(UserVO uv) {
				// TODO Auto-generated method stub
				try {
					
					SessionFactory sessionfactory = new Configuration().configure()
							.buildSessionFactory();
					Session session = sessionfactory.openSession();
					Query q=session.createQuery("from UserVO where user_name='"+uv.getUser_name()+"' and password='"+uv.getPassword()+"'");
					Transaction tr=session.beginTransaction();
					List lss = q.list();
					System.out.println("valll ls sizee"+lss.size());
					return lss;
		
				} catch(Exception e) {
					System.out.println(e);

				}

				
				
				return null;
			}
		
}
