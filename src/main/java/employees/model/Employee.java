package employees.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;


@Entity(name="tm_employee_table")
@Data

@Table(name="tm_employee_table")
public class Employee implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "ID" )
	 private int id;
	
	@Column(name = "TECHM_ID", nullable = false )
	@Id public String techmid;
	
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "HYPERSCALER")
	private String Hyperscaler;
	
	@Column(name = "PROJECT")
	private String project;
	
	@Column(name = "PM_EMPL_ID", columnDefinition = "int default 0")
	private int MGRID;
	
	@Column(name="IBU")
	private String IBU;
	
	@Column(name="IBG")
	private String IBG;
	
	@Column(name="WORKING_ON_CLOUD")
	private String WorkinOnCloud;
	
	@Column(name="PRIMARY_SCOPE_OF_WORK")
	private String psoWork;

	@Column(name="JOB_CODE_DES")
	private String job_code_des;

	@Column(name="CUST_GROUP_NAME")
	private String cust_group_name;

	@Column(name="SKILLS")
	private String skills;

	@Column(name="RESIGNED")
	private String RESIGNED;
	
	@Column(name="primary_competency")
	private String primary_competency;

	@Column(name="employee_ibu")
	private String employee_ibu;
	
	
	@JsonManagedReference
	@OneToMany(mappedBy = "employee" ,fetch = FetchType.LAZY)
	  private Collection<Certification> certification;    
	
	//@Formula("(SELECT GROUP_CONCAT(Distinct C.certification_provider  ) FROM TM_Cloud_EMS.tm_certification_table C WHERE  C.TECHM_ID = E.TECHM_ID GROUP BY E.TECHM_ID)")
	 private String cert; 
}


