package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;


public class KeyInput extends KeyAdapter {

    private Handler handler;
    private boolean[] keyDown = new boolean[20];
    private Random r = new Random();
    private FastEnemy fastEnemy;

    public KeyInput(Handler handler) {
        this.handler = handler;

        keyDown[0] = false;
        keyDown[1] = false;
        keyDown[2] = false;
        keyDown[3] = false;

        keyDown[4] = false;
        keyDown[5] = false;
        keyDown[6] = false;
        keyDown[7] = false;
        keyDown[8] = false;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.gameObjects.size(); i++) {
            GameObject tempObject = handler.gameObjects.get(i);

            if (tempObject.getId() == ID.Player) {
                //key events for player 1

                if (key == KeyEvent.VK_W) {
                    tempObject.setVelY(-5);
                    keyDown[0] = true;
                }
                if (key == KeyEvent.VK_S) {
                    tempObject.setVelY(5);
                    keyDown[1] = true;
                }
                if (key == KeyEvent.VK_D) {
                    tempObject.setVelX(5);
                    keyDown[2] = true;
                }
                if (key == KeyEvent.VK_A) {
                    tempObject.setVelX(-5);
                    keyDown[3] = true;
                }
//                if (key == KeyEvent.VK_SLASH && HUD.HEALTH > 49) {
//                    HUD.HEALTH = 100;
//                }
//                 }
//            if (tempObject.getId() == ID.Player2){
//                //key events for player 2

                if (key == KeyEvent.VK_UP) {
                    tempObject.setVelY(-5);
                    keyDown[4] = true;
                }
                if (key == KeyEvent.VK_DOWN) {
                    tempObject.setVelY(5);
                    keyDown[5] = true;
                }
                if (key == KeyEvent.VK_RIGHT) {
                    tempObject.setVelX(5);
                    keyDown[6] = true;
                }
                if (key == KeyEvent.VK_LEFT) {
                    tempObject.setVelX(-5);
                    keyDown[7] = true;
                }
                if (key == KeyEvent.VK_M) {
                    Game.gameState = Game.STATE.Menu;
                    keyDown[8] = true;
                }
                if (key == KeyEvent.VK_H) {
                    Game.gameState = Game.STATE.Help;
                    keyDown[9] = true;
                }
                if (key == KeyEvent.VK_CONTROL && HUD.HEALTH < 11 && HUD.HEALTH > 2) {
                    HUD.HEALTH = 50;

                }

            }

        }
        if (key == KeyEvent.VK_ESCAPE) System.exit(1);
    }


// prints out the numerical value for the key like: Q=81
    //System.out.println(key);

//    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.gameObjects.size(); i++) {
            GameObject tempObject = handler.gameObjects.get(i);

            if (tempObject.getId() == ID.Player) {
                //key events for player 1

                if (key == KeyEvent.VK_W) {
                    keyDown[0] = false;
                    tempObject.setVelY(0);
                }
                if (key == KeyEvent.VK_S) {
                    keyDown[1] = false;
                    tempObject.setVelY(0);
                }
                if (key == KeyEvent.VK_D) {
                    keyDown[2] = false;
                    tempObject.setVelX(0);
                }
                if (key == KeyEvent.VK_A) {
                    keyDown[3] = false;
                    tempObject.setVelX(0);
                }
//            }
                if (key == KeyEvent.VK_UP) {
                    keyDown[4] = false;
                    tempObject.setVelY(0);
                }
                if (key == KeyEvent.VK_DOWN) {
                    keyDown[5] = false;
                    tempObject.setVelY(0);
                }
                if (key == KeyEvent.VK_RIGHT) {
                    keyDown[6] = false;
                    tempObject.setVelX(0);
                }
                if (key == KeyEvent.VK_LEFT) {
                    keyDown[7] = false;
                    tempObject.setVelX(0);
                }
                if (key == KeyEvent.VK_LEFT) {
                    keyDown[7] = false;
                    tempObject.setVelX(0);
                }
                if (key == KeyEvent.VK_LEFT) {
                    keyDown[8] = false;
                }
                if (key == KeyEvent.VK_LEFT) {
                    keyDown[9] = false;
                }


//            if (tempObject.getId() == ID.Player2) {
//              //  key events for player 2
//

            }

        }

    }

}
