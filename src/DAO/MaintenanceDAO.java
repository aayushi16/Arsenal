	package DAO;
	
	import VO.MaintenanceVO;
	import VO.VehicleVO;

	import java.util.ArrayList;
	import java.util.List;

	import org.hibernate.Query;
	import org.hibernate.Transaction;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.cfg.Configuration;

	public class MaintenanceDAO {
			public void insertMaintenance(MaintenanceVO v) {

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
						Query q=session.createQuery("from MaintenanceVO");
						Transaction tr=session.beginTransaction();
						ls = q.list();
						System.out.println("Done");
						tr.commit();
			
					} catch(Exception e) {
						System.out.println(e);

					}
		return ls;
			}
			public List editMaintenance(MaintenanceVO v2)
			{
				List ls=new ArrayList();
				try
				{
					SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
					Session session =sessionFactory.openSession();
					Query query=session.createQuery("from MaintenanceVO where m_id='"+v2.getM_id()+"' ");
					ls = query.list();
				}
				catch(Exception exception)
				{
					exception.printStackTrace();
				}
				return ls;
			}
			public void updateMaintenance(MaintenanceVO v) {

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
			
			public void deleteMaintenance(MaintenanceVO v) {
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
	}