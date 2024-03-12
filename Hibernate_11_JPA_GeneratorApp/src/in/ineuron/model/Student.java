package in.ineuron.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

@DynamicUpdate(value = true)
@Entity
@Table(name = "STDTAB")
public class Student {
	
//	@Id
//    @GeneratedValue(generator="gen1",strategy = GenerationType.AUTO)
//	@Column(name = "stdId")
	
//	@Id
//	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)

//	@Id
//	@GeneratedValue(generator = "gen1",strategy = GenerationType.IDENTITY)

//	@Id
//	@SequenceGenerator(name="gen1",sequenceName = "JPA_SID_SEQ",
//	                     initialValue = 5,allocationSize = 5)
//	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "SID_SEQ_GEN")
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer sid;
	
	@Column(name="stdName",length=20)
	private String sname;
	
	@Column(name="stdAddr",length=20)
	private String saddress;
	
	@Column(name = "stdAge")
	private Integer sage;
	
	public Student() {
		System.out.println("Hibernate 0-args Constructor");;
	}
	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
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
