package bookOne.char04;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author gy1zc3@gmail.com
 *         Created by zacky on 22:31.
 */
public class Employee {
    private String name;
    private double salary;
    private Date hireDay;
    private int id;
    private static int nextId = 1;

    public Employee(String n, double s, int year, int month, int day){
        name = n;
        salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year,month - 1, day);
        hireDay = calendar.getTime();
    }

    public Employee(String n,double s){
        name = n;
        salary = s;
        id = 0;
    }

    public static int getNextId() {
        return nextId;
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

    public Date getHireDay() {
        return hireDay;
    }

    public void setHireDay(Date hireDay) {
        this.hireDay = hireDay;
    }
    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary += raise;
    }
    public boolean equals(Employee other){
        return name.equals(other.name);
    }

    public int getId() {
        return id;
    }

    public void setId() {
        id = nextId;
        nextId++;
    }
}
