import java.util.Random;

public class Spawner {
    private ObjectHandler objHandler;
    private HUD hud;
    private Random r;

    private int timerInterval = 0;
    private int timer = 0;

    public Spawner(ObjectHandler objHandler,HUD hud){
        this.objHandler = objHandler;
        this.hud = hud;
        this.r = new Random();

        //Beginner Enemies
        objHandler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.Enemy));
        objHandler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.Enemy));
    }

    public void tick(){
        if (timerInterval > 10){
            timer++;
            hud.setTimer(timer);
            timerInterval = 0;
        }
        timerInterval++;

        if (timer > 50 && hud.getLevel()== 1){
            objHandler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.Enemy));
            hud.setLevel(hud.getLevel() + 1);
        }else if (timer > 100 && hud.getLevel()== 2){
            objHandler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.Enemy));
            hud.setLevel(hud.getLevel() + 1);
        }else if (timer > 150 && hud.getLevel()== 3){
            objHandler.addObject(new SpeedEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 32), ID.Enemy));
            hud.setLevel(hud.getLevel() + 1);
        }
    }
}
