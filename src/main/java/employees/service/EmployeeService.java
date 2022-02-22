package employees.service;

import java.util.List;
import employees.model.Employee;
import employees.repo.EmployeeRepo.project;

public interface EmployeeService {
	/*Collection<Employee> saveEmployee(Employee employee);*/



	Employee findByName(String techmid);
	
	List<project> findprojects(String techmid);

	List<Employee> getAllMgr(String techmid);

	List<Employee> updateEmployees(List<Employee> employees);
	
	
	/*
	List<Getallcertdata> getcertificationcount1(String techmid);
	List<NamesOnly> getcertificationcount2(String techmid);
	Employee findByemptechmid(String techmid);
	List<Getcountdata>  getcertificationcountEmp(String techmid);
	List<Employee> updateAll(Collection<Employee>  employee);
	List<certified> findall1(String techmid);
	Employee update(Employee employee);
	List<certified> certificationsdata(String techmid);
	ArrayList<String> getCertificationCount(String techmid);
	*/
}

