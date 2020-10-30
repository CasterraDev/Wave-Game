import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class MainMenu extends MouseAdapter{ 
    int buttonWidth = 100,buttonHeight = 20;
    String title = "Wave Game";

    public MainMenu(){
    }

    public void tick(){
        
    }

    public void render(Graphics g){
        if (Game.state == Game.STATE.menu){
            Font bigFont = new Font("arial",1,50);
            Font font = new Font("arial",1,30);
            
            //Menu Name
            g.setFont(bigFont);
            g.setColor(Color.white);
            g.drawString(title, Game.WIDTH / 2 - (title.length()/2), 200);

            //Play Button
            g.setFont(font);
            g.setColor(Color.white);
            g.drawRect((Game.WIDTH/2) - (buttonWidth / 2), 100, buttonWidth, buttonHeight);
        }
    }

    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        System.out.println("Mouse at: " + mx + " " + my);
        //Play Button
        if (mouseOver(mx,my,(Game.WIDTH/2)-(buttonWidth/2),100,buttonWidth,buttonHeight)){
            Game.state = Game.STATE.game;
        }
    }

    public boolean mouseOver(int mx,int my,int x,int y,int xSize,int ySize){
        if (mx < x + xSize || mx > x){
            if (my < y + ySize || my > y){
                return true;
            }
        }
        return false;
    }
}
