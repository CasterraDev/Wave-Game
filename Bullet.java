import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

/*
Goes only one direction and destroys itself if it hits the edge of the window
*/

public class Bullet extends GameObject {
    float spd = 10f;

    Random r = new Random();

    public Bullet(float x, float y, int xSize, int ySize, ID id, ObjectHandler objHandler, float bulDir) {
        super(x, y, xSize, ySize, id, objHandler, bulDir);
        start();
    }

    public void start() {
        velX = 0f;
        velY = 0f;

        if (dir == 0) {// Turret Right side
            velX = -spd;
        } else if (dir == 1) {// Turret Left side
            velX = spd;
        } else if (dir == 2) {// Turret Top
            velY = spd;
        } else if (dir == 3) {// Turret Bottom
            velY = -spd;
        }
    }

    public void tick() {
        x += velX;
        y += velY;
        bc = new BoxCollider(x, y, xSize, ySize);

        if (x > Game.WIDTH - xSize * 1.5f || x < 0) {
            for (int i = 0; i < objHandler.list.size(); i++) {
                if (objHandler.list.get(i).objCode == this.objCode) {
                    objHandler.removeObject(objHandler.list.get(i));
                }
            }
        }
        if (y > Game.HEIGHT - ySize * 1.5f || y < 0) {
            for (int i = 0; i < objHandler.list.size(); i++) {
                if (objHandler.list.get(i).objCode == this.objCode) {
                    objHandler.removeObject(objHandler.list.get(i));
                }
            }
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect((int) x, (int) y, xSize, ySize);
    }

}
