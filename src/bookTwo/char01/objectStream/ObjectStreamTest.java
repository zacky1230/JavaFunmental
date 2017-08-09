package bookTwo.char01.objectStream;

import bookTwo.char01.Employee;
import bookTwo.char01.Manager;

import java.io.*;

/**
 * @author gy1zc3@gmail.com
 *         Created by zacky on 10:47.
 */
public class ObjectStreamTest {
    public static void main(String[] args) throws IOException,ClassNotFoundException{
        Employee harry = new Employee("Harry Hacker",50000, 1989, 10,1);
        Manager carl = new Manager("Carl Cracker",80000, 1987,12,15);
        carl.setSecretary(harry);
        Manager tony = new Manager("Tony Tester",40000,1990,3,15);
        tony.setSecretary(harry);

        Employee[] staff = new Employee[3];
        staff[0] = carl;
        staff[1] = harry;
        staff[2] = tony;

        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.dat"));
            out.writeObject(staff);
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.dat"));
            Employee[] newStaff = (Employee[]) in.readObject();
            newStaff[1].raiseSalary(10);

            for(Employee e: newStaff)
                System.out.println(e);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
