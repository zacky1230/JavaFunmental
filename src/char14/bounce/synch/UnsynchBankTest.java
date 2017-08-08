package char14.bounce.synch;

import char14.bounce.unsynch.Bank;
import char14.bounce.unsynch.TransferRunnable;

/**
 * @author gy1zc3@gmail.com
 *         Created by zacky on 14:49.
 */
public class UnsynchBankTest {
    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;

    public static void main(String[] args) {
        char14.bounce.unsynch.Bank b = new Bank(NACCOUNTS,INITIAL_BALANCE);
        int i;
        for(i = 0; i < NACCOUNTS; i++){
            TransferRunnable r = new TransferRunnable(b,i,INITIAL_BALANCE);
            Thread t = new Thread();
            t.start();
        }
    }
}
