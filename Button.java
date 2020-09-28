import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Button extends MouseAdapter {
    int x,y,width,height;
    public boolean isPressed;

    public Button(int x,int y,int width,int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void render(Graphics g){
        g.setColor(Color.white);
        g.fillRect(x, y, width, height);
    }

    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        
    }

    public boolean mouseOver(int mx,int my,int x,int y,int xSize,int ySize){
        if (mx < x + xSize || mx > x){
            if (my < y + ySize || my > y){
                return true;
            }
        }
        return false;
    }

    public boolean getIsPressed(){
        return isPressed;
    }
}
