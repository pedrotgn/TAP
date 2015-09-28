package employee;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestEmployeeDetails {
	
	EmpBusinessLogic empBusinessLogic = new EmpBusinessLogic();
	EmployeeDetails employee = new EmployeeDetails();
	
	//test to check appraisal
	@Test
	public void testCalculateAppriasal() {
		System.out.println("testCalculateAppriasal");
		employee.setName("Rajeev");
		employee.setAge(25);
		employee.setMonthlySalary(8000);
		double appraisal= empBusinessLogic.calculateAppraisal(employee);
		assertEquals(500, appraisal, 0.0);
	}
	
	// test to check yearly salary
	@After
	public void testCalculateYearlySalary() {
		System.out.println("testCalculateYearlySalary");
		employee.setName("Rajeev");
		employee.setAge(25);
		employee.setMonthlySalary(8000);
		double salary= empBusinessLogic.calculateYearlySalary(employee);
		assertEquals(96000, salary, 0.0);
	}
}