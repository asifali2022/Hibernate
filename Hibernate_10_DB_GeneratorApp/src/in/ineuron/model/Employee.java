package in.ineuron.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;



@Entity
@Table(name = "EMPL")
public class Employee {

	@Id
//	@GenericGenerator(strategy ="assigned", name="gen1")
//	@GeneratedValue(generator="gen1")
	
//	@GenericGenerator(strategy ="increment", name="gen1")
//	@GeneratedValue(generator="gen1")
	
	@GenericGenerator(name="gen1",strategy ="sequence", parameters = {
	@Parameter(name = "sequence_name", value = "eid_seq")}  )
	@GeneratedValue(generator="gen1")
	
	private Integer eid;
	private String ename;
	private Integer eage;
	private String eaddr;
	
	
	public Employee() 
	{
		System.out.println("Zero Args Constructor");
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Integer getEage() {
		return eage;
	}
	public void setEage(Integer eage) {
		this.eage = eage;
	}
	public String getEaddr() {
		return eaddr;
	}
	public void setEaddr(String eaddr) {
		this.eaddr = eaddr;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eage=" + eage + ", eaddr=" + eaddr + "]";
	}
	
	
	
	

}
