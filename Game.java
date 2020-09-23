import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 1280,HEIGHT= WIDTH / 12 * 9; //Gives a 16:9 ratio
    private Thread thread;

    private boolean running;

    public Game(){
        new Window(WIDTH,HEIGHT,"Wave Game",this);
    }

    public synchronized void Start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void Stop(){
        try{
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void tick(){

    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        //Fills the entire screen to whatever color we set
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.dispose();
        bs.show();
    }

    //Game Loop taken from:
    //https://gamedev.stackexchange.com/questions/160329/java-game-loop-efficiency
    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) /ns;
            lastTime = now;
            while(delta >= 1){
                tick(); //Modified Part
                delta--;
            }
            if (running)
                render(); //Modified Part
            frames++;

            if (System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        Stop();
    }

    public static void main(String[] args) {
        new Game();
    }
}