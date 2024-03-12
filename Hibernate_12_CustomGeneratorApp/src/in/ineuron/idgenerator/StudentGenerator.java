package in.ineuron.idgenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class StudentGenerator implements IdentifierGenerator {
     
	Connection connection=null;
	Statement   stmt=null;
	ResultSet resultSet=null;
	
	@Override
	public Serializable generate(SharedSessionContractImplementor si, Object obj) throws HibernateException {
		System.out.println("StudentGenerator.GENERATOR_NAME");
		String id = " ";
		connection  = si.connection();
	    try {		
	    	connection  = si.connection();
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery("select SID_SEQ.nextval from dual");
			
			while(resultSet.next())
			{
				int i = resultSet.getInt(1);
				
				if(i<=9)
					id="IC00"+i;
				else if(i>9 && i<=99)
					id="IC0"+i;
				else
					id="IC"+i;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
		return id;
	}

}
