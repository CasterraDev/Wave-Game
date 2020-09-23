import java.util.LinkedList;
import java.awt.Graphics;

public class ObjectHandler{
    LinkedList<GameObject> list = new LinkedList<GameObject>();

    public void tick(){
        for (var i = 0; i < list.size(); i++) {
            list.get(i).tick();
        }
    }

    public void render(Graphics g){
        for (int i = 0; i < list.size(); i++){
            list.get(i).render(g);
        }
    }

    public void addObject(GameObject go){
        list.add(go);
    }

    public void removeObject(GameObject go){
        list.remove(go);
    }
}