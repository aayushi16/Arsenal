package DAO;
	
	import VO.GunVO;
import VO.UserVO;
import VO.VehicleVO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

	public class VehicleDAO {
		public void insertVehicle(VehicleVO v) {

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
					Query q=session.createQuery("from VehicleVO");
					Transaction tr=session.beginTransaction();
					ls = q.list();
					System.out.println("Done");
					tr.commit();
		
				} catch(Exception e) {
					System.out.println(e);

				}
	return ls;
		}
		public List editVehicle(VehicleVO v2)
		{
			List ls=new ArrayList();
			try
			{
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				Session session =sessionFactory.openSession();
				Query query=session.createQuery("from VehicleVO where vehicle_id='"+v2.getVehicle_id()+"' ");
				ls = query.list();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			return ls;
		}
		public void updateVehicle(VehicleVO v) {

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
		public void deleteVehicle(VehicleVO v) {
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
		
		public List validate(VehicleVO uv) {
			// TODO Auto-generated method stub
			try {
				
				SessionFactory sessionfactory = new Configuration().configure()
						.buildSessionFactory();
				Session session = sessionfactory.openSession();
				Query q=session.createQuery("from VehicleVO where vehicle_no='"+uv.getVehicle_no()+"'");
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
