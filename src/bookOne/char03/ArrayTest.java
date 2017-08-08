package bookOne.char03;

import java.util.Arrays;

/**
 * @author gy1zc3@gmail.com
 *         Created by zacky on 20:02.
 */
public class ArrayTest {
    public static void main(String[] args) {
        int a[] = {0,1,2,3,4,6,7,8,9,5};
        //toString
        System.out.println("a:"+String.valueOf(a));
        //copyOf
        int b[] = Arrays.copyOf(a,a.length * 2);
        System.out.println("b:"+String.valueOf(b));
        //sort
        Arrays.sort(a);
        System.out.println(String.valueOf(a));
        //binarySearch
        System.out.println(Arrays.binarySearch(a,3));
    }
}
