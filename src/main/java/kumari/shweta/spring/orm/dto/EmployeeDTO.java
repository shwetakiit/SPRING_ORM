/**
 * 
 */
package kumari.shweta.spring.orm.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.boot.jaxb.internal.stax.HbmEventReader;

/**
 * @author Shweta kumari
 *
 */
@Entity
@Table(name="employee_deatils")
public class EmployeeDTO {
	@Id
	@Column(name="EMP_ID")
	private Integer employeeId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="CITY")
	private String jobLocation;

	/* No default constructor so we will get message while executing code --->
	 * INFO: HHH000182: No default (no-argument) constructor for class:
	 *  kumari.shweta.spring.orm.dto.EmployeeDTO (class must be instantiated by Interceptor) 
	 */
	
	
	public EmployeeDTO(Integer employeeId, String name, String jobLocation) {
		this.employeeId = employeeId;
		this.name = name;
		this.jobLocation = jobLocation;
	}

	public EmployeeDTO() {
		super();
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJobLocation() {
		return jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	@Override
	public String toString() {
		
		return "employeeId :" + employeeId + " name :" + name + " jobLocation :" + jobLocation;
	}
	
	
	

}
