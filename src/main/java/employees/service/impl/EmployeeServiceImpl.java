package employees.service.impl;

import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import employees.model.Employee;
import employees.repo.EmployeeRepo;
import employees.repo.EmployeeRepo.project;
import employees.service.EmployeeService;

@Service
@Component
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepo employeerepo;
	public EmployeeServiceImpl(EmployeeRepo employeerepo) {
		super();
		this.employeerepo = employeerepo;
	}

	@Override
	public Employee findByName(String techmid) {
		return  employeerepo.findBytechmid(techmid);
	}


	@Override
	public List<Employee> getAllMgr(String techmid) {
		return (List<Employee>) employeerepo.getAllMgrEmp(techmid);
	}


	public List<Employee> updateEmployees(List<Employee> employees){
		employeerepo.saveAll(employees);
		return employees;
	}

	@Override
	public List<project> findprojects(String techmid) {
		return employeerepo.findprojects(techmid);
	}
	
	
/*	
	@Override
	public List<Employee> updateAll(List<Employee> employee) {
		List<Employee> existingEmployee =  employeerepo.findBytechmid(employee.techmid);
		
		((Employee) existingEmployee).setFirstName(((Employee) employee).getFirstName());
		((Employee) existingEmployee).setLastName(((Employee) employee).getLastName());
	    
		  employeerepo.saveAll(existingEmployee);
		  return employeerepo.saveAll(employee);
	}
	
		@Override
	public Employee findByemptechmid(String techmid) {
		return employeerepo.findBytechmid(techmid);
	}
	
	
	@Override
	public List<certified> findall1(String techmid) {
		return (List<certified>)  employeerepo.findall1(techmid);
	}
	
	
	@Override
	public List<Getcountdata> getcertificationcountEmp(String techmid) {
		return (List<Getcountdata>) employeerepo.getcertificationcountEmp(techmid);
		
	}

	@Override
	public ArrayList<String> getCertificationCount(String techmid) {
		
		return (ArrayList<String>) employeerepo.getCertificationCount(techmid);
	}

	@Override
	public List<certified> certificationsdata(String techmid) {
		return (List<certified>) employeerepo.certificationsdata(techmid);
	}



	@Override
	public Employee update(Employee employee) {
			Employee existingEmployee = (Employee) employeerepo.findBytechmid(employee.techmid);
			
			existingEmployee.setFirstName(employee.getFirstName());
			existingEmployee.setLastName(employee.getLastName());
			existingEmployee.setEmail(employee.getEmail());
			existingEmployee.setMGRID(employee.getMGRID());
			existingEmployee.setProject(employee.getProject());		
			employeerepo.save(existingEmployee);
			return employeerepo.findBytechmid(employee.techmid);
	}
	
	@Override
	public List<Employee> updateAll(Collection<Employee> employee) {

		 for (Employee emp : employee) {
				
				Employee existingEmployee = (Employee) employeerepo.findBytechmid(emp.techmid);
				((Employee) existingEmployee).setWorkinOnCloud(((Employee) emp).getWorkinOnCloud());
				((Employee) existingEmployee).setHyperscaler(((Employee) emp).getHyperscaler());
				((Employee) existingEmployee).setPsoWork(((Employee) emp).getPsoWork());
				((Employee) existingEmployee).setPrimary_competency(((Employee) emp).getPrimary_competency());				
			  employeerepo.save(existingEmployee);
	}
		return null;
		
	}
	
	
	*/

/*	@Override
	public List<Getallcertdata> getcertificationcount1(String techmid) {
		return (List<Getallcertdata>)  employeerepo.getcertificationcount1(techmid);
	}*/

	//@Override
	//public List<NamesOnly> getcertificationcount2(String techmid) {
		//return (List<NamesOnly>) employeerepo.getcertificationcount2(techmid);}

	

}
