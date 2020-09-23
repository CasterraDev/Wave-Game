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

    
    //Get Setters
    //Getters
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public int getXSize(){
        return xSize;
    }
    public int getYSize(){
        return ySize;
    }
    public ID getID(){
        return id;
    }
    public float getVelX(){
        return velX;
    }
    public float getVelY(){
        return velY;
    }
    //Setters
    public void setX(float x){
        this.x = x;
    }
    public void setY(float y){
        this.y = y;
    }
    public void setXSize(int x){
        this.xSize = x;
    }
    public void setYSize(int y){
        this.ySize = y;
    }
    public void setID(ID id){
        this.id = id;
    }
    public void setVelX(float x){
        this.velX = x;
    }
    public void setVelY(float y){
        this.velY = y;
    }
}
