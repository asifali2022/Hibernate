package in.ineuron.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class InsertRecordApp {

	public static void main(String[] args) throws Exception {

		Session session = null;
		Transaction transaction = null;
		Long id = null;
		boolean flag = false;

		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				InsurancePolicy policy = new InsurancePolicy();
				policy.setCompany("HDFC");
				policy.setPolicyName("credelia");
				policy.setPolicyType("quaterly");
				policy.setTenure(10);
				
				id = (Long) session.save(policy);
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


