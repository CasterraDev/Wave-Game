import java.util.LinkedList;
import java.awt.Graphics;

public class ObjectHandler{
    LinkedList<GameObject> list = new LinkedList<GameObject>(); //Holds every object in the game, so we can parse through it if we need

    public void tick(){
        for (int i = 0; i < list.size(); i++) { //Play the tick method of each object
            GameObject tempObj = list.get(i);

            tempObj.tick();
        }
    }

    public void render(Graphics g){
        for (int i = 0; i < list.size(); i++){ //Play the render method of each object
            GameObject tempObj = list.get(i);

            tempObj.render(g);
        }
    }

    public void addObject(GameObject go){
        list.add(go);
    }

    public void removeObject(GameObject go){
        list.remove(go);
    }
}