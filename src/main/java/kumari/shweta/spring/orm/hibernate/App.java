package kumari.shweta.spring.orm.hibernate;

import java.awt.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Consumer;

import org.hibernate.event.internal.DefaultDeleteEventListener;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.tools.javac.util.JCDiagnostic.Fragment;

import kumari.shweta.spring.orm.dao.EmployeeDAO;
import kumari.shweta.spring.orm.dto.EmployeeDTO;

public class App 
{
    public static void main( String[] args )
    {
   
    	//Create Spring context 
    	
    	ApplicationContext context= new ClassPathXmlApplicationContext("configuration.xml");
    	EmployeeDTO employeeDTO = new EmployeeDTO(1, "Shweta Kumari", "BLR");
    	EmployeeDAO employeeDAO = context.getBean("employeeDao", EmployeeDAO.class);
    	/*
    	//Save Employee obj in db 
    	Integer status=employeeDAO.insert(employeeDTO);
    	System.out.println("Is data saved  in db ?:"+status);
    	
    	*/
    	System.out.println("Press any key?");
    	Scanner scanner = new Scanner(System.in);
    	int pressKey=scanner.nextInt();
    	
    	while(true) {
    		
    	switch (pressKey) {
    	
		case 1:
			System.out.println("Insert Employee record in db");
			
			Integer status = employeeDAO.insert(employeeDTO);
			System.out.println("Is data saved  in db ?:"+status);
			break;
			
		case 2: System.out.println("Enter Employee Id to fetch details");
		Scanner sc = new Scanner(System.in);
		Integer num = sc.nextInt();
		EmployeeDTO employeeDTO2= employeeDAO.getEmployee(num);
		System.out.println(employeeDTO2.getName()+" Id "+employeeDTO2.getEmployeeId()+ " City :"+employeeDTO2.getJobLocation());
		break;
		
		case 3: System.out.println("Fetch all employee records");
		ArrayList<EmployeeDTO> list = employeeDAO.getALLEmployee();
      for (EmployeeDTO employee : list) {
    	  System.out.println("Id: "+employee.getEmployeeId()+ " Name "+employee.getName()+ " Job Location :"+employee.getJobLocation());
		}
      
		case 4 :System.out.println("Enter Employee Id to delete  Record");
		Scanner sc1 = new Scanner(System.in);
		Integer id = sc1.nextInt();
	    employeeDAO.deleteRecord(id);
	    System.out.println("Record deleted SuccessFully");
		break;
	
		case 5: System.out.println("Update the employee record of employee ID???");
		Scanner sc2 = new Scanner(System.in);
		Integer employeeId = sc2.nextInt();
		Optional<EmployeeDTO> employee=Optional.ofNullable(employeeDAO.getHibernateTemplate().get(EmployeeDTO.class,employeeId));
	
		if(employee.isPresent()) {
			EmployeeDTO employeeDTO3 = employee.get();
	        employeeDTO3.setJobLocation("Updated"+employeeDTO3.getJobLocation());
	        employeeDAO.updatingRecord(employeeDTO3);
		}
		break;
		default:
			System.out.println("Invalid case!,Please press key between 1 to 5");
			break;
		}
    }
   }
}
