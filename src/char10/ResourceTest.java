package char10;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

/**
 * @author gy1zc3@gmail.com
 *         Created by zacky on 23:54.
 */
public class ResourceTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame jFrame = new ResourceTestFrame();
                jFrame.setTitle("ResourceTest");
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame.setVisible(true);
            }
        });
    }
}

class ResourceTestFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 300;

    public ResourceTestFrame(){
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        URL aboutURL = getClass().getResource("about.gif");
        Image img = new ImageIcon(aboutURL).getImage();
        setIconImage(img);

        JTextArea textArea = new JTextArea();
        InputStream stream = getClass().getResourceAsStream("about.txt");
        Scanner in = new Scanner(stream);
        while (in.hasNext())
            textArea.append(in.nextLine() + "\n");
        add(textArea);
    }
}
