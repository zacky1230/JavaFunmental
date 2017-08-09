package bookTwo.char01;

import bookTwo.char01.randomAccess.DataIO;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
/**
 * @author gy1zc3@gmail.com
 *         Created by zacky on 22:31.
 */
public class Employee implements Serializable {
    public static final int NAME_SIZE=40;
    public static final int RECORD_SIZE=2*NAME_SIZE+8+4+4+4;
    private String name;
    private Double salary;
    private Date hireDay;

    public Employee(){
    }
    public Employee(String n,double s,int year,int month,int day){
        name=n;
        salary=s;
        GregorianCalendar calendar=new GregorianCalendar(year, month-1, day);
        hireDay=calendar.getTime();
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public Date getHireDay() {
        return hireDay;
    }
    public void raiseSalary(double percent){
        salary+=salary*percent/100;
    }
    public String toString(){
        return getClass().getName()+"[name="+name+",salary="+salary+",hireDay="
                +hireDay+"]";
    }
    public void writeData(PrintWriter out){
        GregorianCalendar calendar=new GregorianCalendar();
        calendar.setTime(hireDay);
        out.println(name+"|"+salary+"|"+calendar.get(Calendar.YEAR)+"|"
                +(calendar.get(Calendar.MONTH)+1)+"|"+calendar.get(Calendar.DAY_OF_MONTH));
    }
    public void readData(Scanner in){
        String line=in.nextLine();
        String[] tokens=line.split("\\|");
        name=tokens[0];
        salary=Double.parseDouble(tokens[1]);
        int y=Integer.parseInt(tokens[2]);
        int m=Integer.parseInt(tokens[3]);
        int d=Integer.parseInt(tokens[4]);
        GregorianCalendar calendar=new GregorianCalendar(y, m-1,d);
        hireDay=calendar.getTime();
    }
    public void writeData(DataOutput out) throws IOException{
        DataIO.writeFixedString(name, NAME_SIZE, out);
        out.writeDouble(salary);
        GregorianCalendar calendar=new GregorianCalendar();
        calendar.setTime(hireDay);
        out.writeInt(calendar.get(Calendar.YEAR));
        out.writeInt(calendar.get(Calendar.MONTH)+1);
        out.writeInt(calendar.get(Calendar.DAY_OF_MONTH));
    }
    public void readData(DataInput in) throws IOException{
        name=DataIO.readFixedString(NAME_SIZE, in);
        salary=in.readDouble();
        int y=in.readInt();
        int m=in.readInt();
        int d=in.readInt();
        GregorianCalendar calendar=new GregorianCalendar(y, m-1, d);
        hireDay=calendar.getTime();
    }
}