package char05;


/**
 * @author gy1zc3@gmail.com
 *         Created by zacky on 20:33.
 */
public class Manager extends Employee {
    private double bonus;
    public Manager(String n, double s, int year, int month, int day) {
        super(n,s,year,month,day);
        bonus = 0;
    }
    public double getSalary(){
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }
    public void setBonus(double b){
        bonus = b;
    }
}
