import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class MainMenu extends MouseAdapter {
    int buttonWidth = 200, buttonHeight = 50;
    int titleHeight = 200;

    String title = "Wave Game";

    public MainMenu() {
    }

    public void tick() {

    }

    public void render(Graphics g) {
        Font bigFont = new Font("arial", 1, 50);
        Font font = new Font("arial", 1, 30);

        // The Main Menu
        if (Game.state == Game.STATE.menu) {

            int titleWidth = g.getFontMetrics(bigFont).stringWidth(title);

            // Menu Name
            g.setFont(bigFont);
            g.setColor(Color.white);
            g.drawString(title, Game.WIDTH / 2 - (titleWidth / 2), titleHeight);

            // Play Button
            int playButtonHeight = titleHeight + 100;
            g.setFont(font);
            g.setColor(Color.white);
            g.drawRect((Game.WIDTH / 2) - (buttonWidth / 2), playButtonHeight, buttonWidth, buttonHeight);
            // Play Text
            String playTxt = "Play";
            int playTxtWidth = g.getFontMetrics(font).stringWidth(playTxt);
            g.drawString(playTxt, (Game.WIDTH / 2) - (playTxtWidth / 2), playButtonHeight + 40);

            // Twitter Button
            // String twitterTxt = "Twitter";
            // int twitterTxtWidth = g.getFontMetrics(font).stringWidth(twitterTxt);
            // g.setFont(font);
            // g.setColor(Color.white);
            // g.drawRect((Game.WIDTH) - (buttonWidth), Game.HEIGHT - (buttonHeight * 2),
            // buttonWidth, buttonHeight);
            // Twitter Txt
            // g.drawString(twitterTxt, (Game.WIDTH) - (twitterTxtWidth * 2) + 10,
            // Game.HEIGHT - buttonHeight - 20);
        } else if (Game.state == Game.STATE.winScreen) {

            String winTxt = "You Won";
            g.setFont(bigFont);
            // Get Width of text so it can be centered
            int winTxtWidth = g.getFontMetrics(bigFont).stringWidth(winTxt);
            g.drawString(winTxt, (Game.WIDTH / 2) - (winTxtWidth / 2), Game.HEIGHT / 2);

        } else if (Game.state == Game.STATE.loseScreen) {

            String loseTxt = "You Lose";
            g.setFont(bigFont);
            // Get Width of text so it can be centered
            int loseTxtWidth = g.getFontMetrics(bigFont).stringWidth(loseTxt);
            g.drawString(loseTxt, (Game.WIDTH / 2) - (loseTxtWidth / 2), Game.HEIGHT / 2);
        }
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        System.out.println("Mouse at: " + mx + " " + my);
        if (Game.state == Game.STATE.menu) {
            // Play Button
            if (mouseOver(mx, my, (Game.WIDTH / 2) - (buttonWidth / 2), titleHeight + 100, buttonWidth, buttonHeight)) {
                Game.state = Game.STATE.game;
            }
            //// Twitter Button
            // if (mouseOver(mx, my, (Game.WIDTH) - (buttonWidth), Game.HEIGHT -
            //// (buttonHeight * 2), buttonWidth,
            // buttonHeight)) {
            // Utility.openURL("Twitter.com");
            // }
        } else if (Game.state == Game.STATE.winScreen) {

        } else if (Game.state == Game.STATE.loseScreen) {

        }
    }

    public boolean mouseOver(int mx, int my, int x, int y, int xSize, int ySize) {
        if (mx < x + xSize && mx > x) {
            if (my < y + ySize && my > y) {
                return true;
            }
        }
        return false;
    }
}
