package employees.controller;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import employees.model.Employee;
import employees.repo.EmployeeRepo.project;
import employees.service.EmployeeService;

@CrossOrigin(origins = "*")
@Controller
@RestController
@RequestMapping("/api/employees/emp")
public class EmployeeController {

	private EmployeeService employeeService;
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping("{techmid}")
	public  Employee  getAllEmp(@PathVariable("techmid") String techmid){
		return employeeService.findByName(techmid) ;
	}
	
	@GetMapping("/mgr/{techmid}")
	public  List<Employee>  getAllMgrEmp(@PathVariable("techmid") String techmid){
		return employeeService.getAllMgr(techmid) ;
	}
	
	@GetMapping("/projects/{techmid}")
	public List<project> findprojects(@PathVariable("techmid") String techmid){
		return employeeService.findprojects(techmid);
	}
	
    @PutMapping("/updateEmployees")
    public List<Employee> updateEmployees(@RequestBody List<Employee> employee) {        
            return employeeService.updateEmployees(employee);
    }
      
}

	/*@GetMapping("/Getcountdata/{techmid}")
	public  List<Getcountdata>   getAllCertifications(@PathVariable("techmid") String techmid){
		return employeeService.getcertificationcountEmp(techmid) ;
	}
	@GetMapping("/getCertificationCount/{techmid}")
	public  ArrayList<String>   getCertificationCount(@PathVariable("techmid") String techmid){
		return employeeService.getCertificationCount(techmid) ;
	}
	
	@GetMapping("/employee/{techmid}")
	public  Employee  getAllEmp1(@PathVariable("techmid") String techmid){
		return employeeService.findByemptechmid(techmid) ;
	}
	
	@GetMapping("/employees/{techmid}")
	public List<certified>  findall1(@PathVariable("techmid") String techmid){
		return employeeService.findall1(techmid);
	}
	
	
	    @PutMapping("")
    public List<Employee> updateEmployee(@RequestBody Collection<Employee> employee) {

           employeeService.updateAll(employee);
            return employeeService.updateAll(employee);
    }
	
		@PutMapping("/single")
    public Employee updateEmp(@RequestBody Employee employee ) {
    
            employeeService.update(employee);
            return employeeService.update(employee);
    }
    
	@GetMapping("/certificationsdata/{techmid}")
	public List<certified>  certificationsdata(@PathVariable("techmid") String techmid){
		return employeeService.certificationsdata(techmid) ;
	}*/
   	
	
	
	/*
	@GetMapping("/Count/{techmid}")
	public List<Getallcertdata>  getCount(@PathVariable("techmid") String techmid){
		return employeeService.getcertificationcount1(techmid) ;
	}*/
	
	/*@GetMapping("/Count1/{techmid}")
	public List<NamesOnly>  getCount1(@PathVariable("techmid") String techmid){
		return employeeService.getcertificationcount2(techmid) ;
	}*/
    
	
	/*@PutMapping
	public Collection<Employee> saveEmployee(@RequestBody Employee employee){
		return new Collection<Employee>(HttpStatus.OK);}*/

	/*@PutMapping
	public ResponseEntity<Employee> save1Employee(@RequestBody Employee employee) {
		    ObjectMapper objectMapper = new ObjectMapper();
		    try {
		    	Employee student=objectMapper.readValue(employee, Employee);
		    	
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		
				return new ResponseEntity<Employee>((Employee) employeeService.saveEmployee(employee), HttpStatus.OK);
		}
		
		 @PutMapping
	public ResponseEntity<Employee> save1Employee(@RequestBody Employee employee) {
	    ObjectMapper objectMapper = new ObjectMapper();
	    try {
	    	Employee student=objectMapper.readValues(employee,TypeReference<List<MyObject>>);
	    	
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	
			return new ResponseEntity<Employee>((Employee) employeeService.update(employee), HttpStatus.OK);
	}
	

		*/

