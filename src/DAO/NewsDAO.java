package DAO;

import VO.NewsVO;
import VO.UserVO;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class NewsDAO {

				public void insertNews(NewsVO v) {

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
							Query q=session.createQuery("from NewsVO");
							Transaction tr=session.beginTransaction();
							ls = q.list();
							System.out.println("Done");
							tr.commit();
				
						} catch(Exception e) {
							e.printStackTrace();

						}
			return ls;
				}
		
				public List editNews(NewsVO v2)
				{
					List ls=new ArrayList();
					try
					{
						SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
						Session session =sessionFactory.openSession();
						Query query=session.createQuery("from NewsVO where news_id='"+v2.getNews_id() +"' ");
						ls = query.list();
					}
					catch(Exception exception)
					{
						exception.printStackTrace();
					}
					return ls;
				}
				public void updateNews(NewsVO v) {

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
				public void deleteNews(NewsVO v) {
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
				public List searchnews() {
					// TODO Auto-generated method stub

					
					java.util.List ls= new ArrayList();
					try {
						
							SessionFactory sessionfactory = new Configuration().configure()
									.buildSessionFactory();
							Session session = sessionfactory.openSession();
							Query q=session.createQuery("from NewsVO");
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