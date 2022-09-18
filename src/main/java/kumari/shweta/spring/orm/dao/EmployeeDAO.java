/**
 * 
 */
package kumari.shweta.spring.orm.dao;

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

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	

}
