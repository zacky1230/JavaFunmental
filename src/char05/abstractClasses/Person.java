package char05.abstractClasses;

/**
 * @author gy1zc3@gmail.com
 *         Created by zacky on 09:38.
 */
public abstract class Person {
    public abstract String getDescription();
    private String name;

    public Person(String n){
        name = n;
    }

    public String getName(){
        return name;
    }
}
