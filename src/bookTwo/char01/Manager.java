package bookTwo.char01;

/**
 * @author gy1zc3@gmail.com
 *         Created by zacky on 10:50.
 */
public class Manager extends Employee {
    private Employee secretary;
    public Manager(String n, double s, int year, int month, int day) {
        super(n,s,year,month,day);
    }
    public void setSecretary(Employee secretary){
        this.secretary = secretary;
    }
}
