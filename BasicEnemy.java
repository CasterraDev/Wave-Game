import java.awt.Graphics;
import java.awt.Color;

public class BasicEnemy extends GameObject {
    public BasicEnemy(float x, float y, ID id) {
        super(x, y, id);
        start();
    }

    public BasicEnemy(float x, float y, int xSize, int ySize, ID id) {
        super(x, y, xSize, ySize, id);
        start();
    }

    public void start(){
        velX = 10f;
        velY = 10f;
    }

    public void tick() {
        x += velX;
        y += velY;
        bc = new BoxCollider(x, y, xSize, ySize);

        if (x > Game.WIDTH - xSize*1.5f || x < 0){
            velX *= -1;
        }
        if (y > Game.HEIGHT - ySize*1.5f || y < 0){
            velY *= -1;
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int)x, (int)y, xSize, ySize);
    }
    
}
