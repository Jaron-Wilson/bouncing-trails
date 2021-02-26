package game;

import java.awt.*;
import java.util.Random;


public class MenuParticle extends GameObject {

    private Handler handler;
    private Random r = new Random();

    private Color col;

    public MenuParticle(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;


        velX = r.nextInt(5 - -5) + -5;
        velY = r.nextInt(5 - -5) + -5;
        if (velX == 0) velX = 1;
        if (velY == 0) velY = 1;


        col = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }

    public void tick() {
        if (Game.gameState == Game.STATE.Menu || Game.gameState == Game.STATE.Help || Game.gameState == Game.STATE.End) {
            x += velX;
            y += velY;

            if (y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
            if (x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
            // color of trail, size of trail copy to block size too.
            //                                                                  //how long the trail stays
            handler.addObject(new Trail((int) x, (int) y, ID.Trail, col, 16, 16, 0.05f, handler));
        }else if (Game.gameState == Game.STATE.Game) {
            velX = new Random().nextInt(5 - -5) + -5;
            velY = 5;
            if (y <= 0 || y >= Game.HEIGHT - 32) velY *= 0;
            if (x <= 0 || x >= Game.WIDTH - 16) velX *= 0;
        }
    }


    public void render(Graphics g) {
        g.setColor(col);
//        round pieces
//        g.fillRoundRect((int)x,(int) y, 16, 16, 32, 32);
        g.fillRect((int) x, (int) y, 16, 16);
    }
}
