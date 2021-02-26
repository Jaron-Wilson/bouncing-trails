package game;

import java.awt.*;
import java.util.LinkedList;
public class Handler {


    LinkedList<GameObject> gameObjects = new LinkedList<GameObject>();


    public void tick() {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject go = gameObjects.get(i);
            go.tick();
        }
    }

    public void render(Graphics g) {
        for (GameObject gameObject : gameObjects) {
            GameObject tempObject;
            tempObject = gameObject;
            tempObject.render(g);
        }
    }


    //    public void clearEnemies() {
//        for (int i = 0; i < this.object.size(); i++) {
//            GameObject tempObject = this.object.get(i);
//            if (tempObject.getId() != ID.Player) {
//                this.removeObject(tempObject);
//                i--;
//            }
//        }
//    }
    void clearEnemies() {

        gameObjects.clear();
//        if (Game.gameState != Game.STATE.End) ;
//            addObject(new Player(100, 100, ID.Player, this));

    }

    public void addObject(GameObject object) {
        this.gameObjects.add(object);
    }

    void removeObject(GameObject object) {
        this.gameObjects.remove(object);
    }

}
