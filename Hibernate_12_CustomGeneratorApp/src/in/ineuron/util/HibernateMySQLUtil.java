package in.ineuron.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import in.ineuron.model.Student2;


public class HibernateMySQLUtil {
	
	private static SessionFactory sessionFactory=null;
	private static Session session=null;
	
	static
	{
		sessionFactory = new Configuration().configure("in/ineuron/cgf/hibernate2.cfg.xml")
		              .addAnnotatedClass(Student2.class)
		              .buildSessionFactory();
	}
	
	public static Session getSession()
	{
		if (session != null)
		{
			 session = sessionFactory.openSession();
		}
		return session;
		
	}
	
	public static void closeSession(Session session) {
		if (session != null)
			session.close();
	}

	public static void closeSessionFactory() {
		if (sessionFactory != null)
			sessionFactory.close();
	}
	
}
