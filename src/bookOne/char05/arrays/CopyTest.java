package bookOne.char05.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author gy1zc3@gmail.com
 *         Created by zacky on 15:10.
 */
public class CopyTest {
    public static void main(String[] args) {
        //int[] a = {1,2,3};
        //a = (int[]) goodCopyOf(a,10);
        //System.out.println(Arrays.toString(a));
        String[] b = {"Tom","Dick","Harry"};
        b = (String[]) goodCopyOf(b,10);
        System.out.println(Arrays.toString(b));
        System.out.println("The following call will generate an exception.");
        b = (String[]) badCopyOf(b,10);
    }

    private static Object goodCopyOf(Object[] a, int newLength) {
        Class cl = a.getClass();
        if(!cl.isArray()) return null;
        Class compenntType = cl.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(compenntType,newLength);
        System.arraycopy(a,0,newArray,0,Math.min(length,newLength));
        return newArray;
    }

    private static Object[] badCopyOf(Object[] a, int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(a,0,newArray,0,Math.min(newArray.length,newLength));
        return newArray;
    }
}
