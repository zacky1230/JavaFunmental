package bookTwo.char01.randomAccess;

/**
 * @author gy1zc3@gmail.com
 * Created by zacky on 09:42.
 */

import bookTwo.char01.Employee;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomFileTest {

    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Cracker", 7500, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 5000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 4000, 1990, 3, 15);
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream("employee.dat"));
            for (Employee e : staff) e.writeData(out);
            out.close();
            RandomAccessFile in = new RandomAccessFile("employee.dat", "r");
            int n = (int) (in.length() / Employee.RECORD_SIZE);
            Employee[] newstaff = new Employee[n];
            for (int i = n - 1; i >= 0; i--) {
                newstaff[i] = new Employee();
                in.seek(i * Employee.RECORD_SIZE);
                newstaff[i].readData(in);
            }
            in.close();
            for (Employee e : newstaff) {
                System.out.println(e);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
