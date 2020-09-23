import java.awt.Graphics;
import java.awt.Color;

public class Player extends GameObject {
    public static float Health = 100;
    public Player(float x, float y, ID id) {
        super(x, y, id);
    }

    public Player(float x, float y,int xSize,int ySize, ID id) {
        super(x, y,xSize,ySize, id);
    }

    public void tick() {
        x += velX;
        y += velY;

        //Clamps the player to the screen
        x = Math.clamp(x, 0, Game.WIDTH - xSize);
        y = Math.clamp(y, 0, Game.HEIGHT - ySize);
    }

    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect((int)x, (int)y, xSize, ySize);
    }
}
