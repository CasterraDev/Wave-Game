import java.awt.Graphics;
import java.awt.Color;

public class FollowerEnemy extends GameObject{
    float spd = 1f;
    float limitX,limitY;

    public FollowerEnemy(float x, float y,int xSize,int ySize, ID id,ObjectHandler objHandler) {
        super(x, y,xSize,ySize, id,objHandler);
        start();
    }

    public void start(){
        spd = 1f;
        velX = spd;
        velY = spd;
    }

    public void tick() {
        x += velX;
        y += velY;
        bc = new BoxCollider(x, y, xSize, ySize);

        //Follows the player so it doesn't need it's own borders
        /*
        if (x > Game.WIDTH - xSize*1.5f || x < 0){
            velX *= -1;
        }
        if (y > Game.HEIGHT - ySize*1.5f || y < 0){
            velY *= -1;
        }
        */

        for (int i = 0; i < objHandler.list.size();i++){
            GameObject tempObj = objHandler.list.get(i);

            if (tempObj.getID() == ID.Player){
                limitX = tempObj.x;
                limitY = tempObj.y;
            }
        }

        if (x > limitX){
            velX = Math.abs(spd) * -1;
        }else if (x < limitX){
            velX = Math.abs(spd);
        }else{
            velX = 0;
        }

        if (y > limitY){
            velY = Math.abs(spd) * -1;
        }else if (y < limitY){
            velY = Math.abs(spd);
        }else{
            velY = 0;
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect((int)x, (int)y, xSize, ySize);
    }
}
