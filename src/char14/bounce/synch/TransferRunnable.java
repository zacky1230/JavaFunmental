package char14.bounce.synch;

import char14.bounce.unsynch.Bank;

/**
 * @author gy1zc3@gmail.com
 *         Created by zacky on 14:54.
 */
public class TransferRunnable implements Runnable {
    private char14.bounce.unsynch.Bank bank;
    private int fromAccount;
    private double maxAmount;
    private int DELAY = 10;

    public TransferRunnable(Bank b, int from, double max){
        bank = b;
        fromAccount = from;
        maxAmount = max;
    }

    @Override
    public void run() {
        try{
            while (true){
                int toAccount = (int)(bank.size() * Math.random());
                double amount = maxAmount * Math.random();
                bank.transfer(fromAccount,toAccount,amount);
                Thread.sleep((int)(DELAY * Math.random()));
            }
        }catch (InterruptedException e){

        }
    }
}
