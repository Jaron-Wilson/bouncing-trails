package game;

import java.awt.*;
import java.util.Random;


public class FastEnemy extends GameObject {

    private Handler handler;
    private Random r = new Random();

    public FastEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = r.nextInt(10 - -7) + -7;
        velY = r.nextInt(10 - -7) + -7;

    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }

    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
        // color of trail, size of trail copy to block size too.
        //                                                                  //how long the trail stays
        handler.addObject(new Trail((int) x, (int) y, ID.Trail, Color.blue, 16, 16, 0.02f, handler));
    }


    public void render(Graphics g) {
        g.setColor(Color.blue);
//        round pieces
//        g.fillRoundRect(x, y, 16, 16, 32, 32);
        g.fillRect((int) x, (int) y, 16, 16);
    }
}
