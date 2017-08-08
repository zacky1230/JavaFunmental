package bookOne.char14.synch;

import bookOne.char14.unsynch.Bank;
import bookOne.char14.unsynch.TransferRunnable;

/**
 * @author gy1zc3@gmail.com
 *         Created by zacky on 14:49.
 */
public class UnsynchBankTest {
    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;

    public static void main(String[] args) {
        bookOne.char14.unsynch.Bank b = new Bank(NACCOUNTS,INITIAL_BALANCE);
        int i;
        for(i = 0; i < NACCOUNTS; i++){
            TransferRunnable r = new TransferRunnable(b,i,INITIAL_BALANCE);
            Thread t = new Thread();
            t.start();
        }
    }
}
