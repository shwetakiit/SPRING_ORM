/**
 * 
 */
package kumari.shweta.spring.orm.dao;

import java.awt.List;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import kumari.shweta.spring.orm.dto.EmployeeDTO;

/**
 * @author Shweta kumari
 *
 */
public class EmployeeDAO {
	
	//Using this class , we can perform all operation on DB (CRUD) all API for available under this class
	

	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public Integer insert(EmployeeDTO employeeDTO) {
		
	Integer status=	(Integer) this.hibernateTemplate.save(employeeDTO);
	return status;
		
	}

	//For read operation @Transactional annotation not required 
	
	public EmployeeDTO getEmployee(int employeeId) {
		EmployeeDTO employeeDTO = this.hibernateTemplate.get(EmployeeDTO.class,employeeId);
		return employeeDTO;
	}
	
	public ArrayList<EmployeeDTO> getALLEmployee() {
		ArrayList<EmployeeDTO> list=  (ArrayList<EmployeeDTO>) this. hibernateTemplate.loadAll(EmployeeDTO.class);
		return list;
	}
	
	//delete operation -->Write operation need to annotate with @Transactional
	@Transactional
	public void deleteRecord(int id) {
		EmployeeDTO employeeDTO = this.hibernateTemplate.get(EmployeeDTO.class, id);
		this.hibernateTemplate.delete(id);
	}
	
	//update operation
	@Transactional
	public void updatingRecord(EmployeeDTO employeeDTO) {
		
		this.hibernateTemplate.update(employeeDTO);
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	

}
