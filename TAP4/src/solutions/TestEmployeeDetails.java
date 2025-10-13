package solutions;

import java.lang.reflect.Proxy;
import junit.framework.TestCase;

public class TestEmployeeDetails extends TestCase {

    private IEmpBusinessLogic proxyInstance;
    private EmployeeDetails employee;

    protected void setUp() {
        System.out.println("setup!");
        EmpBusinessLogic empBusinessLogic = new EmpBusinessLogic();
        proxyInstance = (IEmpBusinessLogic) Proxy.newProxyInstance(
                IEmpBusinessLogic.class.getClassLoader(),
                new Class[]{IEmpBusinessLogic.class},
                new DynamicProxyHandler(empBusinessLogic)
        );

        employee = new EmployeeDetails();
        employee.setName("Rajeev");
        employee.setMonthlySalary(8000);
    }

    public void testCalculateAppraisal() {
        System.out.println("testCalculateAppraisal");
        double appraisal = proxyInstance.calculateAppraisal(employee);
        // 500 base + 500 bonus
        assertEquals(1000.0, appraisal);
    }

    public void testCalculateYearlySalary() {
        System.out.println("testCalculateYearlySalary");
        double salary = proxyInstance.calculateYearlySalary(employee);
        // 8000*12 = 96000 base + 1000 bonus
        assertEquals(97000.0, salary);
    }

    protected void tearDown() {
        System.out.println("tear down!");
        employee = null;
    }
}
