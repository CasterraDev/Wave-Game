import java.awt.Graphics;
import java.awt.Color;

/*
Follows the player by getting it's coords and changing it's velocities to match them
*/

public class FollowerEnemy extends GameObject {
    float spd = 1f;
    float limitX, limitY; // Players coords
    GameObject player;

    public FollowerEnemy(float x, float y, int xSize, int ySize, ID id, ObjectHandler objHandler) {
        super(x, y, xSize, ySize, id, objHandler);
        start();
    }

    public void start() {
        spd = 1f;
        velX = spd;
        velY = spd;

        // Set the player variable by going through the list
        for (int i = 0; i < objHandler.list.size(); i++) {
            if (objHandler.list.get(i).getID() == ID.Player) {
                player = objHandler.list.get(i);
            }
        }
    }

    public void tick() {
        x += velX;
        y += velY;
        bc = new BoxCollider(x, y, xSize, ySize);

        // Follows the player so it doesn't need it's own borders
        /*
         * if (x > Game.WIDTH - xSize*1.5f || x < 0){ velX *= -1; } if (y > Game.HEIGHT
         * - ySize*1.5f || y < 0){ velY *= -1; }
         */

        limitX = player.x;
        limitY = player.y;

        if (x > limitX) { // If right of player go left
            velX = Math.abs(spd) * -1;
        } else if (x < limitX) { // If left of player go right
            velX = Math.abs(spd);
        } else {
            velX = 0;
        }

        if (y > limitY) { // If below player go up
            velY = Math.abs(spd) * -1;
        } else if (y < limitY) { // If above player go down
            velY = Math.abs(spd);
        } else {
            velY = 0;
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect((int) x, (int) y, xSize, ySize);
    }
}
