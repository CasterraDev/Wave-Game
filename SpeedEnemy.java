import java.awt.Graphics;
import java.awt.Color;

public class SpeedEnemy extends GameObject {
    public SpeedEnemy(float x, float y, ID id){
        super(x, y, id);
        start();
    }

    public SpeedEnemy(float x, float y, int xSize, int ySize, ID id) {
        super(x, y, xSize, ySize, id);
        start();
    }

    public void start(){
        
        
        velX = 8f;
        velY = 16f;
    }

    public void tick() {
        x += velX;
        y += velY;
        bc = new BoxCollider(x, y, xSize, ySize);

        if (x > Game.WIDTH - xSize || x < 0){
            velX *= -1;
        }
        if (y > Game.HEIGHT - ySize || y < 0){
            velY *= -1;
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect((int)x, (int)y, xSize, ySize);
    }
    
}
