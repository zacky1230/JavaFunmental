package char06.innerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @author gy1zc3@gmail.com
 *         Created by zacky on 11:57.
 */
public class TalkingClock {
    private int interval;
    private boolean beep;
    public TalkingClock(int interval, boolean beep){
        this.interval = interval;
        this.beep = beep;
    }

    public void start(){
        //局部内部类
        class TimePrinter implements ActionListener{
            public void actionPerformed(ActionEvent event){
                Date now = new Date();
                System.out.println("At the tone, the time is " + now);
                if(beep) Toolkit.getDefaultToolkit().beep();
            }
        }
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval, listener);
        t.start();
    }
}
