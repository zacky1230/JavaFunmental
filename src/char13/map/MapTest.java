package char13.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gy1zc3@gmail.com
 *         Created by zacky on 11:43.
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String, Employee> staff = new HashMap<>();
        staff.put("144-25-5464",new Employee("Amy Lee"));
        staff.put("567-24-2546",new Employee("Harry Hacker"));
        staff.put("157-62-7935",new Employee("Gary Cooper"));
        staff.put("456-62-5527",new Employee("Francesca Cruz"));

        System.out.println(staff);
        staff.remove("456-62-5527");

        for(Map.Entry<String,Employee> entry: staff.entrySet()){
            String key = entry.getKey();
            Employee value = entry.getValue();
            System.out.println("key= " + key + ",value=" + value);
        }
    }
}


class Employee{
    private String name;
    Employee(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}