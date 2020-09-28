import java.awt.Graphics;
import java.awt.Color;

public class HUD {
    int x,y;
    Color textColor;
    Graphics g;

    float health = Player.Health;
    float maxHealth = 200;
    float shownHealth = health * 2;

    private int timer;
    private int level = 1;

    int xStart = 20, yStart = 20,healthHeight = 30;

    public HUD(int x,int y,Color textColor){
        this.x = x;
        this.y = y;
        this.textColor = textColor;
    }

    public HUD(int x,int y){
        this.x = x;
        this.y = y;
        this.textColor = Color.white;
    }

    public HUD(){
        this.x = 0;
        this.y = 0;
        this.textColor = Color.white;
    }

    public void tick(){
        health = Player.Health;
        shownHealth = Math.clamp(health,0,maxHealth) * 2;
    }

    public void render(Graphics g){
        DrawHealthBar(g);
        DrawTimer(g);
        DrawLevel(g);
    }

    public void DrawHealthBar(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(xStart, yStart, (int)maxHealth, healthHeight);

        g.setColor(Color.green);
        g.fillRect(xStart, yStart, (int)shownHealth, healthHeight);

        g.setColor(Color.white);
        g.drawRect(xStart, yStart, (int)maxHealth, healthHeight);
    }

    public void DrawTimer(Graphics g){
        g.setColor(textColor);
        g.drawString("Timer: " + timer, Game.WIDTH / 2, yStart);
    }

    public void DrawLevel(Graphics g){
        g.setColor(textColor);
        g.drawString("Level: " + level, xStart, yStart + healthHeight + 20);
    }

    public int getTimer(){
        return timer;
    }

    public int getLevel(){
        return level;
    }

    public void setTimer(int timer){
        this.timer = timer;
    }

    public void setLevel(int level){
        this.level = level;
    }
}
