package char03;

/**
 * @author gy1zc3@gmail.com
 *         Created by zacky on 19:51.
 */
public class TestArrayCopy {
    public static void main(String[] args) {
        int[] smallPrimes = {1,2,3,4,5,6};
        int[] luckyNumber = smallPrimes;
        luckyNumber[5] = 12;
        for (int i : smallPrimes) {
            System.out.println(i);
        }
    }
}
