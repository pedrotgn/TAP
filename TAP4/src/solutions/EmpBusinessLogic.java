package solutions;

public class EmpBusinessLogic implements IEmpBusinessLogic{

    @Bonus(1000)
    @Override
    public double calculateYearlySalary(EmployeeDetails employeeDetails) {
        return employeeDetails.getMonthlySalary() * 12;
    }

    @Bonus(500)
    @Override
    public double calculateAppraisal(EmployeeDetails employeeDetails) {
        if (employeeDetails.getMonthlySalary() < 10000) {
            return 500;
        } else {
            return 1000;
        }
    }
}
