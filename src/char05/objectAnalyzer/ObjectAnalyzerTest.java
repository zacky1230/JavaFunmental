package char05.objectAnalyzer;

import java.util.ArrayList;

/**
 * @author gy1zc3@gmail.com
 *         Created by zacky on 14:44.
 */
public class ObjectAnalyzerTest {
    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>();
        for(int i = 1; i <= 5; i++)
            squares.add(i*i);
        System.out.println(new ObjectAnalyzer().toString(squares));
    }
}
