import java.awt.Graphics;
import java.awt.Color;

public class Player extends GameObject {

    public Player(float x, float y, ID id) {
        super(x, y, id);
    }

    public Player(float x, float y,int xSize,int ySize, ID id) {
        super(x, y,xSize,ySize, id);
    }

    public void tick() {

    }

    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect((int)x, (int)y, xSize, ySize);

    }
    
}
