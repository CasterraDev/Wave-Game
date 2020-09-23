import java.awt.Graphics;

public abstract class GameObject {

    protected float x,y;
    protected int xSize,ySize;
    protected ID id;

    protected float velX,velY; //Used for movement

    //Constructors
    public GameObject(float x,float y,int xSize,int ySize,ID id){
        this.x = x;
        this.y = y;
        this.xSize = xSize;
        this.ySize = ySize;
        this.id = id;
    }

    public GameObject(float x,float y,ID id){ //Default size 32x32
        this.x = x;
        this.y = y;
        this.xSize = 32;
        this.ySize = 32;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
}
