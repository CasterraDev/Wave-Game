import java.awt.Graphics;
import java.awt.Color;

public class HUD {
    int x,y;
    Color textColor;
    Graphics g;

    float health = Player.Health;
    float maxHealth = 200;
    float shownHealth = health * 2;

    public HUD(int x,int y,Color textColor){
        this.x = x;
        this.y = y;
        this.textColor = textColor;
    }

    public HUD(int x,int y){
        this.x = x;
        this.y = y;
        this.textColor = Color.black;
    }

    public HUD(){
        this.x = 0;
        this.y = 0;
        this.textColor = Color.black;
    }

    public void tick(){
        shownHealth = Math.clamp(shownHealth,0,maxHealth);
    }

    public void render(Graphics g){
        DrawHealthBar();
    }

    public void DrawHealthBar(){
        int xStart = 20, yStart = 20,healthHeight = 30;

        g.setColor(Color.gray);
        g.fillRect(xStart, yStart, (int)maxHealth, healthHeight);

        g.setColor(Color.green);
        g.fillRect(xStart, yStart, (int)shownHealth, healthHeight);

        g.setColor(Color.white);
        g.drawRect(xStart, yStart, (int)maxHealth, healthHeight);
    }
}
