package bookOne.char05.abstractClasses;

/**
 * @author gy1zc3@gmail.com
 *         Created by zacky on 09:47.
 */
public class Student extends Person {
    private String major;
    public Student(String n, String m){
        super(n);
        major = m;
    }
    public String getDescription(){
        return "a student majoring in" + major;
    }
}
