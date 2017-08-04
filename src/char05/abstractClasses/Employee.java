package char05.abstractClasses;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author gy1zc3@gmail.com
 *         Created by zacky on 09:41.
 */
public class Employee extends Person {
    private double salary;
    private Date hireDay;

    public Employee(String n, double s,int year, int month, int day){
        super(n);
        salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year,month-1,day);
        hireDay = calendar.getTime();
    }

    @Override
    public String getDescription() {
        return String.format("an employee with a salary of $%.2f",salary);
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void setHireDay(Date hireDay) {
        this.hireDay = hireDay;
    }
}
