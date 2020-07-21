package List.DoublyLinkedList;

public class EmployeeNode {
    private Employee employee;
    private EmployeeNode next;
    private EmployeeNode previous;

    public EmployeeNode getPrevious() {
        return previous;
    }

    public void setPrevious(EmployeeNode previous) {
        this.previous = previous;
    }

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
