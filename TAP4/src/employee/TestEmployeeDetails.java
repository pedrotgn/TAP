package employee;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestEmployeeDetails {

	private EmpBusinessLogic empBusinessLogic;
	private EmployeeDetails employee;

	@Before
	public void setup() {
		System.out.println("setup!");
		empBusinessLogic = new EmpBusinessLogic();
		employee = new EmployeeDetails();
		employee.setName("Rajeev");
		employee.setAge(25);
		employee.setMonthlySalary(8000);
	}

	@Test
	public void testCalculateAppraisal() {
		System.out.println("testCalculateAppraisal");
		double appraisal = empBusinessLogic.calculateAppraisal(employee);
		assertEquals(500, appraisal, 0.0);
	}

	@Test
	public void testCalculateYearlySalary() {
		System.out.println("testCalculateYearlySalary");
		double salary = empBusinessLogic.calculateYearlySalary(employee);
		assertEquals(96000, salary, 0.0);
	}

	@After
	public void tearDown() {
		System.out.println("tear down!");
		employee = null;
	}
}