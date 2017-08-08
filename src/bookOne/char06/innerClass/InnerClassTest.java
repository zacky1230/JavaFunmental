package bookOne.char06.innerClass;

import javax.swing.*;

/**
 * @author gy1zc3@gmail.com
 *         Created by zacky on 11:56.
 */
public class InnerClassTest {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(1000,true);
        clock.start();
        JOptionPane.showMessageDialog(null,"Quit Program?");
        System.exit(0);
    }
}
