import java.awt.Graphics;
import java.util.Random;

public abstract class GameObject {

    protected float x, y;// Coords
    protected int xSize, ySize;// Width and height
    protected ID id; // Whether it's a player,enemy,turret,bullet,etc
    protected ObjectHandler objHandler;// Object that has a list of GameObjects
    public BoxCollider bc = new BoxCollider(x, y, xSize, ySize);// Box Collider for a hitbox
    protected float dir = 0; // Only for Bullet.java || The direction it needs to go

    Random r = new Random();

    // Unique code for each object
    public int objCode = r.nextInt(100000000);

    // Velocity for the x and y axis
    protected float velX, velY; // Used for movement

    // Constructors
    public GameObject(float x, float y, int xSize, int ySize, ID id, ObjectHandler objHandler) {
        this.x = x;
        this.y = y;
        this.xSize = xSize;
        this.ySize = ySize;
        this.id = id;
        this.objHandler = objHandler;
    }

    public GameObject(float x, float y, int xSize, int ySize, ID id) {
        this.x = x;
        this.y = y;
        this.xSize = xSize;
        this.ySize = ySize;
        this.id = id;
    }

    // For Bullet.java
    public GameObject(float x, float y, int xSize, int ySize, ID id, ObjectHandler objHandler, float dir) {
        this.x = x;
        this.y = y;
        this.xSize = xSize;
        this.ySize = ySize;
        this.id = id;
        this.objHandler = objHandler;
        this.dir = dir;
    }

    public GameObject(float x, float y, ID id) { // Default size 32x32
        this.x = x;
        this.y = y;
        this.xSize = 32;
        this.ySize = 32;
        this.id = id;
    }

    // Abstract Methods
    public abstract void tick();

    public abstract void render(Graphics g);

    // Get Setters
    // Getters
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getXSize() {
        return xSize;
    }

    public int getYSize() {
        return ySize;
    }

    public ID getID() {
        return id;
    }

    public float getVelX() {
        return velX;
    }

    public float getVelY() {
        return velY;
    }

    // Setters
    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXSize(int x) {
        this.xSize = x;
    }

    public void setYSize(int y) {
        this.ySize = y;
    }

    public void setID(ID id) {
        this.id = id;
    }

    public void setVelX(float x) {
        this.velX = x;
    }

    public void setVelY(float y) {
        this.velY = y;
    }
}
