package bookOne.bounce;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author gy1zc3@gmail.com
 *         Created by zacky on 13:32.
 */
public class BallComponent extends JPanel {
    private static final int DEFAULT_WIDTH = 450;
    private static final int DAFAULT_HEIGHT = 350;

    private java.util.List<Ball> balls = new ArrayList<>();

    public void add(Ball b){
        balls.add(b);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for(Ball b : balls){
            g2.fill(b.getShape());
        }
    }

    public Dimension getPreferredSize(){
        return new Dimension(DEFAULT_WIDTH,DAFAULT_HEIGHT);
    }
}
