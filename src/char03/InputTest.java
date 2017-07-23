package char03;

import java.util.Scanner;

/**
 * @author gy1zc3@gmail.com
 *         Created by zacky on 20:06.
 */
public class InputTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //get first input
        System.out.print("What is your name?");
        String name = in.nextLine();

        //get second input
        System.out.print("How old are your?");
        int age = in.nextInt();

        //display output on console
        System.out.println("Hello " + name + ". Next Year,you'll be " + (age + 1));
    }
}
