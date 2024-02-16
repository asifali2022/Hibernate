package in.neuron.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.neuron.model.Student;
import in.neuron.util.HibernateUtil;

public class SaveApp {

	public static void main(String[] args) {
		
		Session session=null;
	    Transaction transaction =null;
		boolean flag=false;
		try {
		 session = HibernateUtil.getSession();
		 if (session!=null) {
			 transaction=session.beginTransaction();	
		}
		 if (transaction!=null) {
			 
			 Student student =new Student();
			 student.setSid(2);
			 student.setSaddress("france");
			 student.setSage(25);
			 student.setSname("klian Mbappe");
			 
			 session.save(student);
			 flag=true;
			 
		}
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			if (flag) {
				transaction.commit();
				System.out.println("Object saved to database....");
			}
			else
			{
				transaction.rollback();
				System.out.println("Object not saved to database...");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}
