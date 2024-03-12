package in.ineuron.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.ineuron.model.PersonInfo;
import in.ineuron.util.HibernateUtil;

public class InsertRecordApp {

	 public static void main(String[] args) {
		
	Session session = null;
	Transaction transaction = null;
	Integer id = null;
	boolean flag = false;

	try {
		session = HibernateUtil.getSession();

		if (session != null)
			transaction = session.beginTransaction();

		if (transaction != null) {

			PersonInfo personInfo = new PersonInfo();
			personInfo.setPname("sachin");
			personInfo.setDob(LocalDate.of(1998, 12, 9));
			personInfo.setDom(LocalDateTime.of(1998, 12, 9, 5, 32));
			personInfo.setDoj(LocalTime.of(9, 15));
			id = (Integer) session.save(personInfo);
			flag = true;
		}

	} catch (HibernateException ef) {
		ef.printStackTrace();

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (flag) {
			transaction.commit();
			System.out.println("Object inserted to  the database with the id :: "+id);
		} else {
			transaction.rollback();
			System.out.println("Object not inserted to the database...");
		}
		HibernateUtil.closeSession(session);
		HibernateUtil.closeSessionFactory();
	}

	 }
}


