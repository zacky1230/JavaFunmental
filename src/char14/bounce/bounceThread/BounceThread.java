package char14.bounce.bounceThread;


import char14.bounce.Ball;
import char14.bounce.BallComponent;

import javax.swing.*;
import java.awt.*;

/**
 * @author gy1zc3@gmail.com
 *         Created by zacky on 13:56.
 */
public class BounceThread {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new BounceFrame();
                frame.setTitle("BounceThread");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class BallRunnabel implements Runnable{
    private Ball ball;
    private Component component;
    public static final int STEPS = 1000;
    public static final int DELAY = 5;

    public BallRunnabel(Ball aBall, Component aComponet){
        ball = aBall;
        component = aComponet;
    }

    public void run(){
        try {
            for(int i = 1; i <= STEPS; i++){
                ball.move(component.getBounds());
                component.repaint();
                Thread.sleep(DELAY);
            }
        }catch (InterruptedException e){
            
        }
    }
}

class BounceFrame extends JFrame{
    private BallComponent comp;
}
