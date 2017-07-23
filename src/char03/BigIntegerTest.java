package char03;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author gy1zc3@gmail.com
 *         Created by zacky on 20:16.
 */
public class BigIntegerTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("How much numbers do you need to draw?");
        int k = in.nextInt();

        System.out.print("What is the highest number you can draw?");
        int n = in.nextInt();

        /**
         * compute binomial coefficient n*(n-1)*(n-2)*...*(n-k+1)/(1*2*3)
         */
        BigInteger lotterOdds = BigInteger.valueOf(1);

        for (int i = 1; i <= k; i++){
            lotterOdds = lotterOdds.multiply(BigInteger.valueOf(n - i + 1)).divide(BigInteger.valueOf(i));

            System.out.println("Your odds are 1 in " + lotterOdds + ". Good luck!");
        }
    }
}
