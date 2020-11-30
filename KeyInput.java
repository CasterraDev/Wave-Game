import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/*
This file is to create every keypress that is within the game
Hopefully this will be replaced with another file and that file will be used in any file that needs to use keypresses
*/

public class KeyInput extends KeyAdapter {

    private ObjectHandler objHandler;
    private float playerSpd;
    private boolean[] keyBtn = new boolean[4];

    public KeyInput(ObjectHandler objHandler) {
        this.objHandler = objHandler;
        this.playerSpd = 10f;

        // This fixes the movement stuttering
        keyBtn[0] = false; // W
        keyBtn[1] = false; // S
        keyBtn[2] = false; // A
        keyBtn[3] = false; // D

    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        // Go through the objectHandler list to find the player
        for (int i = 0; i < objHandler.list.size(); i++) {
            GameObject tempObj = objHandler.list.get(i);

            // All KeyEvents for Player
            if (tempObj.id == ID.Player) {
                if (key == KeyEvent.VK_W) {
                    tempObj.setVelY(-playerSpd);
                    keyBtn[0] = true;
                }
                if (key == KeyEvent.VK_S) {
                    tempObj.setVelY(playerSpd);
                    keyBtn[1] = true;
                }
                if (key == KeyEvent.VK_A) {
                    tempObj.setVelX(-playerSpd);
                    keyBtn[2] = true;
                }
                if (key == KeyEvent.VK_D) {
                    tempObj.setVelX(playerSpd);
                    keyBtn[3] = true;
                }
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        // NEED A BETTER WAY FOR THIS
        for (int i = 0; i < objHandler.list.size(); i++) {
            GameObject tempObj = objHandler.list.get(i);

            // All KeyEvents for Player
            if (tempObj.id == ID.Player) {
                if (key == KeyEvent.VK_W)
                    keyBtn[0] = false;
                if (key == KeyEvent.VK_S)
                    keyBtn[1] = false;
                if (key == KeyEvent.VK_A)
                    keyBtn[2] = false;
                if (key == KeyEvent.VK_D)
                    keyBtn[3] = false;

                // This stops a weird stutter effect from happening
                if (!keyBtn[0] && !keyBtn[1])
                    tempObj.setVelY(0);
                if (!keyBtn[2] && !keyBtn[3])
                    tempObj.setVelX(0);
            }
        }
    }
}
