package List.EmployeeExample;

public class EmployeeNode {
    private Employee employee;
    private EmployeeNode next;


    public EmployeeNode(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmp() {
        return employee;
    }

    public EmployeeNode getNext() {
        return next;
    }

    public void setEmp(Employee employee) {
        this.employee = employee;
    }

    public void setNext(EmployeeNode next) {
        this.next = next;
    }

    public String toString() {
        return employee.toString();
    }
}
