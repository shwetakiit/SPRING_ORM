package kumari.shweta.spring.orm.hibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
    	
    	//Save Employee obj in db 
    	Integer status=employeeDAO.insert(employeeDTO);
    	
    	System.out.println("Is data saved  in db ?:"+status);
    }
}
