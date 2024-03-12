package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class TestApp {

	public static void main(String[] args) {

		Session session = null;

		int id = 6;
		

		session = HibernateUtil.getSession();
		Student student = session.get(Student.class, id);
		System.out.println("Before updation in the table :: " + student);
		try {
			if (student != null) {

				System.in.read(); // go to DB and make the change

				session.refresh(student);

				System.out.println("After updation in the table :: " + student);

			} else {
				System.out.println("Record available for the given id :: " + id);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally
		{
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
