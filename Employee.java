public class Employee {
    private String name;
    private int id;
    private String position;
    private double salary;

    // Constructor
    public Employee(String name, int id, String position, double salary) {
        this.name = name;
        this.id = id;
        this.position = position;
        this.salary = salary;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create an Employee object
        Employee employee = new Employee("Abdul Basit", 123456, "Manager", 50000.00);

        // Display employee details
        System.out.println("Employee Name: " + employee.getName());
        System.out.println("Employee ID: " + employee.getId());
        System.out.println("Employee Position: " + employee.getPosition());
        System.out.println("Employee Salary: " + employee.getSalary());
    }
}

