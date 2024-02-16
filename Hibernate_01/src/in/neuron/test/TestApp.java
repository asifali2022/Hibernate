package in.neuron.test;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.neuron.model.Student;

public class TestApp {

	public static void main(String[] args) throws IOException {
		
// 1. Inform JVM to activate HIBERNATE
		
		Configuration configuration = new Configuration();
		configuration.configure();

// Creating a SessionFactory object to hold many other objects required for
// HIBERNATE
		
		SessionFactory buildSessionFactory = configuration.buildSessionFactory();
		

// Using SessionFactory object, get only one Session object to perform our
// persistence operation
		
		Session session = buildSessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		// connection object,ORM-dialects,L1-Cache,TXTManagement

// 2. Create PERSITENCE Object

		Student student = new Student();
		student.setSid(1);
		student.setSname("Asif");
		student.setSaddress("kolkata");
		student.setSage(25);
		
// 3. Perform PERISTENCE operation using Entity/Model/POJO object

		session.save(student);
		
		System.in.read();
		
// 4. commit the operation based on the result

		transaction.commit();
		//System.out.println("Object saved to database....");

	}

}
