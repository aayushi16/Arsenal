package DAO;


import VO.CircularVO;
import VO.UserVO;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CircularDAO {


			public void insertCircular(CircularVO v) {

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
						Query q=session.createQuery("from CircularVO");
						Transaction tr=session.beginTransaction();
						ls = q.list();
						System.out.println("Done");
						tr.commit();
			
					} catch(Exception e) {
						e.printStackTrace();

					}
		return ls;
			}
	
			public List editCircular(CircularVO v2)
			{
				List ls=new ArrayList();
				try
				{
					SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
					Session session =sessionFactory.openSession();
					Query query=session.createQuery("from CircularVO where circular_id='"+v2.getCircular_id() +"' ");
					ls = query.list();
				}
				catch(Exception exception)
				{
					exception.printStackTrace();
				}
				return ls;
			}
			public void updateCircular(CircularVO v) {

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
			public void deleteCircular(CircularVO v) {
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
			public List searchcircular() {
				// TODO Auto-generated method stub
				
				java.util.List ls= new ArrayList();
				try {
					
						SessionFactory sessionfactory = new Configuration().configure()
								.buildSessionFactory();
						Session session = sessionfactory.openSession();
						Query q=session.createQuery("from CircularVO");
						Transaction tr=session.beginTransaction();
						ls = q.list();
						System.out.println("Done");
						tr.commit();
			
					} catch(Exception e) {
						e.printStackTrace();

					}
		return ls;
				
	
}
}