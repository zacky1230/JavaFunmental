package bookOne.char06.interfaces;


/**
 * @author gy1zc3@gmail.com
 *         Created by zacky on 16:25.
 */
public class Employee implements Comparable<Employee> {
    private String name;
    private double salary;
    public Employee(String n,double s){
        name = n;
        salary = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent /100;
        salary += raise;
    }
    public int compareTo(Employee other){
        return Double.compare(salary,other.salary);
    }
}
