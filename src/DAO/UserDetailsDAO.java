package DAO;


import VO.GunVO;
import VO.UserDetailsVO;
import VO.UserVO;
import VO.VehicleVO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class UserDetailsDAO {


			public void insertUserDetails(UserDetailsVO v) {

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
			
			public List search() {		
				// TODO Auto-generated method stub
				java.util.List ls= new ArrayList();
				try {
					
						SessionFactory sessionfactory = new Configuration().configure()
								.buildSessionFactory();
						Session session = sessionfactory.openSession();
						Query q=session.createQuery("from UserDetailsVO");
						Transaction tr=session.beginTransaction();
						ls = q.list();
						System.out.println("Done");
						tr.commit();
			
					} catch(Exception e) {
						e.printStackTrace();

					}
		return ls;
			}
			
			public List getUserName(UserVO userVO) {
				// TODO Auto-generated method stub
				java.util.List ls= new ArrayList();
				try {
					
						SessionFactory sessionfactory = new Configuration().configure()
								.buildSessionFactory();
						Session session = sessionfactory.openSession();
						Query q=session.createQuery("from UserDetailsVO as a where a.userVO="+userVO.getUser_id());
						Transaction tr=session.beginTransaction();
						ls = q.list();
			
					} catch(Exception e) {
						e.printStackTrace();

					}
		return ls;
			}
			
			public List editUserDetails(UserDetailsVO v2)
			{
				List ls=new ArrayList();
				try
				{
					SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
					Session session =sessionFactory.openSession();
					Query query=session.createQuery("from UserDetailsVO where user1_id='"+v2.getUser1_id()+"' ");
					ls = query.list();
				}
				catch(Exception exception)
				{
					exception.printStackTrace();
				}
				return ls;
			}
			public void updateUserDetails(UserDetailsVO v) {

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
			public void deleteUserDetails(UserDetailsVO v) {
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
			
			public List validate(UserDetailsVO uv) {
				// TODO Auto-generated method stub
				try {
					
					SessionFactory sessionfactory = new Configuration().configure()
							.buildSessionFactory();
					Session session = sessionfactory.openSession();
					Query q=session.createQuery("from UserDetailsVO where user1_no='"+uv.getUser1_no()+"'");
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
