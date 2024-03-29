package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class TestApp {

	public static void main(String[] args) throws Exception {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		Integer id = null;

		try {
			session = HibernateUtil.getSession();
			System.out.println(session);

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				Student student = new Student();
				//employee.setEid(1);
				student.setSname("Matthew Rowwan");
				student.setSage(51);
				student.setSaddress("NZL");

				id = (Integer) session.save(student);
				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object inserted to  the database with the id :: " + id);
			} else {
				transaction.rollback();
				System.out.println("Object not inserted to the database...");
			}

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
