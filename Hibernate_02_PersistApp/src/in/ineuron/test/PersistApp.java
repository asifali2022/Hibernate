package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class PersistApp {

	public static void main(String[] args) {

		Session session =null;
		Transaction transaction=null;
		boolean flag=false;
		
		try 
		{
			 session = HibernateUtil.getSession();
			 
			 if (session != null) 
			 {
				 transaction = session.beginTransaction();
					
			 }
			 if(transaction != null)
			 {
				 Student student =new Student();
				 student.setSid(3);
				 student.setSname("nuanpally");
				 student.setSaddress("coco");
				 student.setSage(25);
				 
				 session.persist(student);
				 flag=true;
				 
			 }
		}
		catch (HibernateException e) 
		{
			e.printStackTrace();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if (flag) {
				transaction.commit();
				System.out.println("Object saved to database....");
			} else {
				transaction.rollback();
				System.out.println("Object not saved to database...");
			}

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
		}
		
	}

}
