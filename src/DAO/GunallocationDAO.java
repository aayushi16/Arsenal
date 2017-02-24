package DAO;

import VO.GunallocationVO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GunallocationDAO {
		public void insertGunstock(GunallocationVO v) {

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
					Query q=session.createQuery("from GunallocationVO");
					Transaction tr=session.beginTransaction();
					ls = q.list();
					System.out.println("Done");
					tr.commit();
		
				} catch(Exception e) {
					System.out.println(e);

				}
	return ls;
		}
		
		public List searchPL() {		
			// TODO Auto-generated method stub
			java.util.List ls= new ArrayList();
			try {
				
					SessionFactory sessionfactory = new Configuration().configure()
							.buildSessionFactory();
					Session session = sessionfactory.openSession();
					
					
					Date date=Calendar.getInstance().getTime();
					SimpleDateFormat sm1=new SimpleDateFormat("hh:mm:ss");
					String time=sm1.format(date);
					System.out.println("Time Issssssss::"+time);
					
					Query q=session.createQuery("from GunallocationVO where return_status='false' and  retrieve_time > 7 ");
					Transaction tr=session.beginTransaction();
					ls = q.list();
					System.out.println("Done");
					tr.commit();
		
				} catch(Exception e) {
					System.out.println(e);

				}
	return ls;
		}
	
		
		
		public List editGunstock(GunallocationVO v2)
		{
			List ls=new ArrayList();
			try
			{
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session =sessionFactory.openSession();
				Query query=session.createQuery("from GunallocationVO where stock1_id='"+v2.getStock1_id() +"' ");
				ls = query.list();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			return ls;
		}
		public void updateGunstock(GunallocationVO v) {

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
		public void deleteGunstock(GunallocationVO v) {
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

		public List countGuns() {
			// TODO Auto-generated method stub
			java.util.List ls= new ArrayList();
			try {
				
					SessionFactory sessionfactory = new Configuration().configure()
							.buildSessionFactory();
					Session session = sessionfactory.openSession();
					Query q=session.createQuery("SELECT COUNT(g.gunVO.gun_id),g.gunVO.gun_name FROM GunallocationVO as g GROUP BY g.gunVO.gun_id");
					ls = q.list();
					
					System.out.println("List of allocate guns in DAO :"+ls.size());
					System.out.println("Done");
				
				} catch(Exception e) {
					System.out.println(e);

				}
	return ls;

		}
}
