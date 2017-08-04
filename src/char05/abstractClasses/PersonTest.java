package char05.abstractClasses;

/**
 * @author gy1zc3@gmail.com
 *         Created by zacky on 09:54.
 */
public class PersonTest {
    public static void main(String[] args) {
        Person[] people = new Person[2];
        people[0] = new Employee("Harry Hacker",50000,1989,10,1);
        people[1] = new Student("Maria Morris","compute science");

        for(Person p : people){
            System.out.println(p.getName() + "," + p.getDescription());
        }
    }
}
