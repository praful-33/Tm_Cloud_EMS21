package employees.repo;

import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import employees.model.Certification;
import employees.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
	Employee findBytechmid(String techmid);
	
	@Query(value=" SELECT DISTINCT E.*,(SELECT GROUP_CONCAT(Distinct C.certification_provider separator ', ') FROM TM_Cloud_EMS.tm_certification_table C WHERE  C.TECHM_ID = E.TECHM_ID GROUP BY E.TECHM_ID) AS cert "
			+ "FROM  TM_Cloud_EMS.tm_employee_table E, TM_Cloud_EMS.tm_certification_table C WHERE  E.TECHM_ID=?1 or E.PM_EMPL_ID=?1",nativeQuery = true)
	List<Employee> getAllMgrEmp(String techmid);
	
	@Query("SELECT distinct E.project as PROJECTs FROM tm_employee_table E where techm_id=?1 or pm_empl_id=?1")
	List<project> findprojects(String techmid);
		
	
	public interface certified {
		
		String getHYPERSCALER();
		String getIBG();
		String getIBU();
		int getPM_EMPL_ID();
		String getRESIGNED();
		String getworkinOnCloud();
		String getCUST_GROUP_NAME();
		String getEMAIL();
		String getFIRST_NAME();
		String setFIRST_NAME();
		String getJOB_CODE_DES();
		String getLAST_NAME();
		String getPROJECT();
		String getPsoWork();
		String getSKILLS();
		String gettechmid();
		String getprimary_competency();
		String getemployee_ibu();
		int getID();
		String getCertified();
		Collection<Certification> getCertification();
		}
		interface project{
			String getPROJECTs();
		}
}

/*@Query(value="SELECT E.TECHM_ID as TECHM_ID,"
+ "(SELECT GROUP_CONCAT( distinct C.certification_provider)"
+ "FROM tm_certification_table C WHERE  C.TECHM_ID = E.TECHM_ID GROUP BY E.TECHM_ID) AS CERT"
+ "FROM tm_employee_table E WHERE E.TECHM_ID=?1 or E.PM_EMPL_ID=?1 ",nativeQuery = true)

@Query(value="SELECT concat( C.certification_provider,' ',count(C.certification_provider)) as count FROM TM_Cloud_EMS.tm_certification_table C where C.TECHM_ID=?1  group by C.certification_provider ", nativeQuery = true)

@Query(value="  SELECT new employees.model.Getcountdata (  E.TECHM_ID, E.FIRST_NAME,E.LAST_NAME,E.HYPERSCALER,E.PROJECT,"	
	+ "E.PM_EMPL_ID,E.IBU,E.IBG,E.WORKING_ON_CLOUD,E.PRIMARY_SCOPE_OF_WORK,E.JOB_CODE_DES,E.CUST_GROUP_NAME,E.SKILLS,E.RESIGNED as cert FROM  TM_Cloud_EMS.tm_employee_table E, TM_Cloud_EMS.tm_certification_table C WHERE E.TECHM_ID=?1 or E.PM_EMPL_ID =?1  group by C.certification_provider )", nativeQuery = true)

@Query(value="  SELECT  E.*,concat( C.certification_provider,' ',count(C.certification_provider)) as cert FROM  TM_Cloud_EMS.tm_employee_table E, TM_Cloud_EMS.tm_certification_table C WHERE E.TECHM_ID=?1 and E.TECHM_ID=C.TECHM_ID  group by C.certification_provider ", nativeQuery = true)

@Query("  SELECT new employees.model.Getcountdata (  E.techm_id, E.firstname,E.lastname,E.Hyperscaler,E.project,"	
	+ "E.MGRID,E.IBU,E.IBG,E.WorkinOnCloud,E.psoWork,E.job_code_des,E.cust_group_name,E.skills,E.RESIGNED FROM  TM_Cloud_EMS.tm_employee_table E, TM_Cloud_EMS.tm_certification_table C WHERE E.TECHM_ID=?1 or E.PM_EMPL_ID =?1  group by C.certification_provider )")

@Query(value="  SELECT new employees.model.Getcountdata ( E.TECHM_ID, E.FIRST_NAME,E.LAST_NAME,E.HYPERSCALER,E.PROJECT,E.PM_EMPL_ID,E.IBU,E.IBG,E.WORKING_ON_CLOUD,E.PRIMARY_SCOPE_OF_WORK,E.JOB_CODE_DES,E.CUST_GROUP_NAME,E.SKILLS,E.RESIGNED,concat( C.certification_provider,' ',count(C.certification_provider)) as count  FROM  TM_Cloud_EMS.tm_employee_table E, TM_Cloud_EMS.tm_certification_table C WHERE E.TECHM_ID=?1 )", nativeQuery = true)

@Query(value ="SELECT * FROM TM_Cloud_EMS.tm_employee_table  where TECHM_ID = ?1  or PM_EMPL_ID = ?1 ",nativeQuery = true)

@Query(value="  SELECT E.TECHM_ID as Techm, E.FIRST_NAME as Name  FROM  TM_Cloud_EMS.tm_employee_table E, TM_Cloud_EMS.tm_certification_table C"
		+ " WHERE E.TECHM_ID=?1 and E.TECHM_ID=C.TECHM_ID group by C.certification_provider", nativeQuery = true)
List<Getallcertdata> getcertificationcount1(String techmid);


	@Query(value="  SELECT new employees.model.Getcountdata ( DISTINCT E.TECHM_ID, E.FIRST_NAME,E.LAST_NAME,E.HYPERSCALER,E.PROJECT,E.PM_EMPL_ID,E.IBU,E.IBG,"
			+ "E.WORKING_ON_CLOUD,E.PRIMARY_SCOPE_OF_WORK,E.JOB_CODE_DES,E.CUST_GROUP_NAME,E.SKILLS,E.RESIGNED,"
			+ "concat( C.certification_provider,' ',count(C.certification_provider)) as cert  FROM  TM_Cloud_EMS.tm_employee_table E, "
			+ "TM_Cloud_EMS.tm_certification_table C "
			+ "WHERE E.TECHM_ID=?1 and E.TECHM_ID=C.TECHM_ID)", nativeQuery = true)
	List<Getcountdata> getcertificationcountEmp(String techmid);



@Query("  SELECT E.TECHM_ID as Techm, E.FIRST_NAME as Name  FROM  TM_Cloud_EMS.tm_employee_table E WHERE E.TECHM_ID=?1 ")
List<NamesOnly> getcertificationcount2(String techmid);

	//Employee And Reportee Details with certification provider
	@Query(value=" SELECT  DISTINCT E.ID, E.TECHM_ID as techmid, E.FIRST_NAME,E.LAST_NAME,E.HYPERSCALER,E.PROJECT,E.PM_EMPL_ID,E.IBU,E.primary_competency as primary_competency,"
			+ "E.IBG,E.WORKING_ON_CLOUD as workinOnCloud, E.employee_ibu,E.PRIMARY_SCOPE_OF_WORK as PsoWork,E.JOB_CODE_DES,E.CUST_GROUP_NAME,E.SKILLS,E.RESIGNED, E.EMAIL,"
			+ "(SELECT GROUP_CONCAT(Distinct C.certification_provider separator ', ') FROM TM_Cloud_EMS.tm_certification_table C WHERE  C.TECHM_ID = E.TECHM_ID GROUP BY E.TECHM_ID) AS Certified "
//			+ ",(SELECT C.certification_provider as certification_provider, C.certification_name as certification_name, C.score as score  FROM TM_Cloud_EMS.tm_certification_table C where C.TECHM_ID= E.TECHM_ID ) as Certification "
		//	+ ",(SELECT group_concat( concat('Provider: ' ,C.certification_provider, ', ','Certificate Name: ',  C.certification_name,', ' , 'Score: ',  C.score ))  FROM TM_Cloud_EMS.tm_certification_table C where C.TECHM_ID =  E.TECHM_ID) as Certification"
			+ "FROM  TM_Cloud_EMS.tm_employee_table E, TM_Cloud_EMS.tm_certification_table C "
			+ "WHERE E.TECHM_ID=?1 or E.PM_EMPL_ID=?1",nativeQuery = true)
	List<certified> findall1(String techmid);
	

	@Query("SELECT E.techmid AS TECHM_ID, E.firstName AS FIRST_NAME, ( E.firstName || ' *') as FULL_NAME, count(Distinct C.certification_provider) as CERT"
			+ " FROM tm_employee_table E ,tm_certification_table C "
					+ "where E.techmid=?1 "
					+ "group by E.techmid")
	List<certified> findall3(String techmid);
	
	
	@Query(value="SELECT concat( C.certification_provider,' ',count(C.certification_provider)) as count FROM TM_Cloud_EMS.tm_certification_table C "
			+ "where C.TECHM_ID=?1  group by C.certification_provider ", nativeQuery = true)
	ArrayList<String> getCertificationCount(String techmid);

	
		
	@Query(nativeQuery = true, value =
	           "SELECT " +
	           "    E.TECHM_ID AS TECHM_ID, E.FIRST_NAME AS FIRST_NAME " +
	           "FROM " +
	           "    TM_Cloud_EMS.tm_employee_table E " +
	           "WHERE" +
	           "E.TECHM_ID=?1")
	    List<certified> certificationsdata(String techmid);
	    
	    @Query(value=" SELECT DISTINCT E.*,concat( C.certification_provider,' ',count(C.certification_provider)) as Certified "
				+ "FROM  TM_Cloud_EMS.tm_employee_table E, TM_Cloud_EMS.tm_certification_table C WHERE  E.TECHM_ID=?1 or E.PM_EMPL_ID=?1 or"
				+ " E.TECHM_ID=C.TECHM_ID ", nativeQuery = true)
		List<certified> getAlEmpwithcertificaation(String techmid);
	    
	 
	
	    
	    


*/