package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.ineuron.model.Student2;
import in.ineuron.util.HibernateMySQLUtil;


public class TestApp2 {

	public static void main(String[] args) throws Exception {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		String id = null;

		try {
			session = HibernateMySQLUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				Student2 student = new Student2();
				//employee.setEid(1);
				student.setSname("Roman Reign");
				student.setSage(45);
				student.setSaddress("USA");

				id = (String) session.save(student);
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

			HibernateMySQLUtil.closeSession(session);
			HibernateMySQLUtil.closeSessionFactory();
		}

	}

}
