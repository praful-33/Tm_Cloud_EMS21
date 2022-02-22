package employees.model;

//import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@Entity(name="tm_certification_table")
@Table(name="tm_certification_table")
public class Certification {
	@Column(name = "CERTIFICATION_NAME" )
	private String certification_name;
	
	@Column(name = "CERTIFICATION_PROVIDER" )
	private String certification_provider;
	
	
	@Column(name = "SCORE" )
	private int score;
	
	/*@JsonFormat(pattern="YYYY-MM-DD")
	@Column(name = "COMPLETION_DATE" )
	private Date certification_date;*/
	
	@Column(name = "CERTIFICATION_ID" )
	@Id private int certification_id;
	
	@JsonBackReference
	 @ManyToOne(fetch = FetchType.LAZY )
	@JsonIgnoreProperties(value = {"certification", "handler","hibernateLazyInitializer"}, allowSetters = true)
	  @JoinColumn (name="TECHM_ID",referencedColumnName="TECHM_ID")
	  private  Employee employee;
	
	
//	@ManyToMany(cascade= {CascadeType.REFRESH} , fetch=FetchType.LAZY)
	//@JoinTable(name = "EmpCertification",
		//	 joinColumns = @JoinColumn(name="certificationid"),inverseJoinColumns = @JoinColumn(name = "techm_id"))
//	private Collection<Employee> employee;
}
