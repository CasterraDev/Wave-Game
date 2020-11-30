import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 960, HEIGHT = WIDTH / 12 * 9; // Gives a 4:3 ratio
    private Thread thread; // The thread the game is using

    private boolean running; // If the game is running
    private ObjectHandler objHandler; // Holds list with all the GameObjects
    private HUD hud; // Draws the Hud e.g. health bar, timer, wave count
    private Spawner spawner; // Spawns all the enemies
    private MainMenu mainMenu; // Deals with all the menus and buttons

    public static enum STATE { // Like scenes in Unity
        menu, game, loseScreen, winScreen,
    }

    public static STATE state = STATE.menu;// Scene/State the game is in || Start in the main menu scene

    public Game() {
        objHandler = new ObjectHandler();
        this.addKeyListener(new KeyInput(objHandler)); // For Player Movement

        hud = new HUD();

        mainMenu = new MainMenu();
        this.addMouseListener(mainMenu); // Only need mouse for the main menu

        Window window = new Window(WIDTH, HEIGHT, "Wave Game", this); // Create the Window
        this.requestFocus(); // Make sure to have it show up above any other program
    }

    public synchronized void Start() {
        // Start a thread
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void Stop() {
        try {
            // Stops the thread
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Tick() for the objects physics and calculations
    public void tick() {
        // First tick of the game state
        if (state == STATE.game && spawner == null) {
            // Makes a player object
            objHandler.addObject(new Player(100, 100, 32, 32, ID.Player, objHandler));
            // Start the spawner
            spawner = new Spawner(objHandler, hud);
        }

        // If you haven't won or lose play every files tick method
        if (state != STATE.winScreen && state != STATE.loseScreen) {
            objHandler.tick();
            if (Game.state == Game.STATE.game) {
                hud.tick();
                spawner.tick();
            }
        }
    }

    // Render() for the objects graphics and painting
    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        // Fills the entire screen to whatever color we set a.k.a makes the background
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // Then draw all objects after background
        objHandler.render(g);

        // Draw HUD after objects so it is on top
        hud.render(g);

        // Menus on top of everything
        mainMenu.render(g);

        g.dispose();
        bs.show();
    }

    // Dynamic game Loop taken from:
    // https://gamedev.stackexchange.com/questions/160329/java-game-loop-efficiency
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick(); // Modified Part
                delta--;
            }
            if (running)
                render(); // Modified Part
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
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