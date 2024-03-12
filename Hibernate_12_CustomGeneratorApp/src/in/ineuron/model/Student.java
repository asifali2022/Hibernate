package in.ineuron.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name = "STDTAB")
public class Student {
	

	@Id
	@GenericGenerator(name = "gen1",strategy ="in.ineuron.idgenerator.StudentGenerator" )
	@GeneratedValue(generator = "gen1")
	
	@Column(name = "stdId")
	private String sid;
	
	@Column(name="stdName",length=20)
	private String sname;
	
	@Column(name="stdAddr",length=20)
	private String saddress;
	
	@Column(name = "stdAge")
	private Integer sage;
	
	public Student() {
		System.out.println("Hibernate 0-args Constructor");;
	}
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public Integer getSage() {
		return sage;
	}
	public void setSage(Integer sage) {
		this.sage = sage;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", saddress=" + saddress + ", sage=" + sage + "]";
	}
	
    
}
