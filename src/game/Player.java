package game;

import java.awt.*;
import java.util.Random;


public class Player extends GameObject {

    Random r = new Random();
    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 32, 32);
    }

    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp((int) x, 0, Game.WIDTH - 46);
        y = Game.clamp((int) y, 0, Game.HEIGHT - 70);

        handler.addObject(new Trail((int) x, (int) y, ID.Trail, Color.white, 32, 32, 0.1f, handler));


        collision();

    }

    private void collision() {

        for (int i = 0; i < handler.gameObjects.size(); i++) {

            GameObject tempObject = handler.gameObjects.get(i);

            if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.EnemyBoss) { // tempobject is now basic enemy.
                if (getBounds().intersects(tempObject.getBounds())) {
                    //collision code
                    HUD.HEALTH -= 2;

                }
            }
            if (tempObject.getId() == ID.HealEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    //collision code
                    HUD.HEALTH += 4;
                }
            }
            if (tempObject.getId() == ID.SmartEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    //collision code
                    HUD.HEALTH -= 0.2;
                }
            }
        }
    }

    public void render(Graphics g) {


        Graphics2D g2d = (Graphics2D) g;


        g.setColor(Color.white);
        // set size for boxes
        g.fillRect((int) x, (int) y, 32, 32);

        if (HUD.HEALTH < 11 && HUD.HEALTH > 2) {
            g.setColor(Color.cyan);
            g.drawString("Press Ctrl to gain Health", 200, 200);
        }
//        // boundary for player box
//
//        g.setColor(Color.red);
//        g2d.draw(getBounds());
//
//
//         //for if you want 2 players.
//         if (id == ID.Player) g.setColor(Color.white);
//       else if (id == ID.Player2) g.setColor(Color.blue);
//         //set block color
//        g.setColor(Color.white);

//        round pieces
//        g.fillRoundRect(x, y, 32, 32, 32, 32);
    }


}
