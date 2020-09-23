
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame; 
class Window extends Canvas { 

    /**
     *
     */
    private static final long serialVersionUID = -5696908830287663947L;

    public Window(int width, int height, String title, Game game) {
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width,height));
        frame.setMaximumSize(new Dimension(width,height));
        frame.setMinimumSize(new Dimension(width,height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.Start();
    }
} 