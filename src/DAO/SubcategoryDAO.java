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

	public class SubcategoryDAO {
			public void insertSubCategory(SubCategoryVO v) {

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
				List ls= new ArrayList();
				try {
					
						SessionFactory sessionfactory = new Configuration().configure()
								.buildSessionFactory();
						Session session = sessionfactory.openSession();
						Query q=session.createQuery("from SubCategoryVO");
						ls = q.list();
						System.out.println("Done");
			
					} catch(Exception e) {
						e.printStackTrace();

					}
		return ls;
	
			}

			public List editSubCategory(SubCategoryVO v3)
			{
				List ls=new ArrayList();
				try
				{
					SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
					Session session =sessionFactory.openSession();
					Query query=session.createQuery("from SubCategoryVO where subcat_id="+v3.getSubcat_id());
					ls = query.list();
				}
				catch(Exception exception)
				{
					exception.printStackTrace();
				}
				return ls;
			}

			public void updateSubCategory(SubCategoryVO v) {
				
				// TODO Auto-generated method stub
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
			public void deleteSubCategory(SubCategoryVO v) {
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
			
			public List validate(SubCategoryVO uv) {
				// TODO Auto-generated method stub
				try {
					
					SessionFactory sessionfactory = new Configuration().configure()
							.buildSessionFactory();
					Session session = sessionfactory.openSession();
					Query q=session.createQuery("from SubCategoryVO where subcat_name='"+uv.getSubcat_name()+"'");
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

