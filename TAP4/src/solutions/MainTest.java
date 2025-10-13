package solutions;

import java.lang.reflect.Proxy;

public class MainTest {
    public static void main(String[] args) {
        EmpBusinessLogic empLogic = new EmpBusinessLogic();

        IEmpBusinessLogic proxyInstance = (IEmpBusinessLogic) Proxy.newProxyInstance(
                IEmpBusinessLogic.class.getClassLoader(),
                new Class[]{IEmpBusinessLogic.class},
                new DynamicProxyHandler(empLogic)
        );

        EmployeeDetails employee = new EmployeeDetails();
        employee.setName("John Doe");
        employee.setMonthlySalary(9000);

        double yearlySalary = proxyInstance.calculateYearlySalary(employee);
        System.out.println("Yearly Salary with bonus: " + yearlySalary);

        double appraisal = proxyInstance.calculateAppraisal(employee);
        System.out.println("Appraisal with bonus: " + appraisal);
    }
}

