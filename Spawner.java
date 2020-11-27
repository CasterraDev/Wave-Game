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

        int curLvl = hud.getLevel();
        if (Game.state == Game.STATE.game){
            if (timer > 50 && curLvl== 1){ //Lvl 2
                objHandler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64), ID.Enemy));
                objHandler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64), ID.Enemy));
                hud.setLevel(curLvl + 1);
            }else if (timer > 100 && curLvl== 2){ //Lvl 3
                objHandler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64), ID.Enemy));
                hud.setLevel(curLvl + 1);
            }else if (timer > 150 && curLvl== 3){ //Lvl 4
                objHandler.addObject(new SpeedEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64), ID.Enemy));
                objHandler.addObject(new FollowerEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64),64,64, ID.Enemy,objHandler));
                hud.setLevel(curLvl + 1);
            }else if (timer > 200 && curLvl == 4){ //Lvl 5 maybe mini boss fight?????
                objHandler.addObject(new SpeedEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64), ID.Enemy));
                objHandler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64), ID.Enemy));
                hud.setLevel(curLvl + 1);
            }else if (timer > 250 && curLvl == 5){ //Lvl 6
                objHandler.clearObjectsByID(ID.Enemy);
                objHandler.addObject(new SpeedEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64), ID.Enemy));
                objHandler.addObject(new SpeedEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64), ID.Enemy));
                objHandler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64), ID.Enemy));
                hud.setLevel(curLvl + 1);
            }else if (timer > 300 && curLvl == 6){ //Lvl 7
                objHandler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64), ID.Enemy));
                hud.setLevel(curLvl + 1);
            }else if (timer > 350 && curLvl == 7){ //Lvl 8
                objHandler.addObject(new FollowerEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64),64,64, ID.Enemy,objHandler));
                hud.setLevel(curLvl + 1);
            }else if (timer > 400 && curLvl == 8){ //Lvl 9
                objHandler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64), ID.Enemy));
                objHandler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64), ID.Enemy));
                hud.setLevel(curLvl + 1);
            }else if (timer > 450 && curLvl == 9){ //Lvl 10 maybe big boss fight?????
                objHandler.addObject(new SpeedEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64), ID.Enemy));
                objHandler.addObject(new SpeedEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64), ID.Enemy));
                hud.setLevel(curLvl + 1);
            }else if (timer > 450 && curLvl == 10){
                Game.state = Game.STATE.winScreen;
            }
        }

        //objHandler.addObject(new FollowerEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64),64,64, ID.Enemy,objHandler));
    }
}
