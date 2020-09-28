import java.awt.Graphics;
import java.awt.Color;

public class Player extends GameObject {
    public static float Health = 100;
    public boolean onlyOnce = true;

    public Player(float x, float y,int xSize,int ySize, ID id,ObjectHandler objHandler) {
        super(x, y,xSize,ySize, id,objHandler);
    }

    public void tick() {
        x += velX;
        y += velY;

        bc = new BoxCollider(x, y, xSize, ySize);

        for (int i = 0; i < objHandler.list.size();i++){
            GameObject tempObj = objHandler.list.get(i);

            if (tempObj.getID() == ID.Enemy){
                if (bc.intersects(tempObj.bc)){
                    if (onlyOnce){
                        Health -= 5/4;
                        onlyOnce = false;
                        System.out.println("OnlyOnce");
                    }
                }
                onlyOnce = true;
                System.out.println("hello");
            }
        }

        //Clamps the player to the screen
        x = Math.clamp(x, 0, Game.WIDTH - xSize);
        y = Math.clamp(y, 0, Game.HEIGHT - ySize);
    }

    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect((int)x, (int)y, xSize, ySize);
    }
}
