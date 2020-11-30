import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

/*
Spawns at an edge of a screen and shoots bullets to the other side
*/

public class Turret extends GameObject {
    float bulDir = 0;
    float timer = 100;
    float timerReset = 100;

    public Turret(float x, float y, int xSize, int ySize, ID id, ObjectHandler objHandler) {
        super(x, y, xSize, ySize, id, objHandler);
        start();
    }

    public void start() {
        velX = 0f;
        velY = 0f;

        Random r = new Random();

        // Spawns the turret on a random side of the window
        // Random number
        int side = r.nextInt(4);

        switch (side) {
            case 0:// Right Side
                x = Game.WIDTH - xSize;
                y = r.nextInt(Game.HEIGHT - ySize * 2);
                break;
            case 1:// Left Side
                x = 0;
                y = r.nextInt(Game.HEIGHT - ySize * 2);
                break;
            case 2:// Top
                x = r.nextInt(Game.WIDTH - xSize * 2);
                y = 0;
                break;
            case 3:// Bottom
                x = r.nextInt(Game.WIDTH - xSize * 2);
                y = Game.HEIGHT - ySize * 2;
                break;

            default:
                break;
        }
        bulDir = side;
    }

    public void tick() {
        bc = new BoxCollider(x, y, xSize, ySize);

        if (timer < 0) {
            timer = timerReset;
            objHandler.addObject(new Bullet(this.x, this.y, 16, 16, ID.Bullet, objHandler, bulDir));
        }
        timer--;
    }

    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect((int) x, (int) y, xSize, ySize);
    }

}
