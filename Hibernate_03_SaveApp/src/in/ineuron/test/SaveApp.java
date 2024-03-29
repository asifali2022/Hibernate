package in.ineuron.test;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class SaveApp {

	public static void main(String[] args) {

		Session session =null;
		Transaction transaction=null;
		Integer id = null;
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
				 student.setSid(4);
				 student.setSname("jeffrey");
				 student.setSaddress("melon");
				 student.setSage(23);
				 
				  id= (Integer) session.save(student);
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
				System.out.println("object saved with the id :: " + id);
			
			} else {
				transaction.rollback();
				System.out.println("Object not saved to database...");
			}

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
		}
		
	}

}
