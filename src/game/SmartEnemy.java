package game;

import java.awt.*;


public class SmartEnemy extends GameObject {

    private Handler handler;
    private GameObject player;

    public SmartEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        for (int i = 0; i < handler.gameObjects.size(); i++) {
            if (handler.gameObjects.get(i).getId() == ID.Player) player = handler.gameObjects.get(i);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 6, 6);
    }

    public void tick() {
        x += velX;
        y += velY;

        float diffX = x - player.getX() - 8;
        float diffY = y - player.getY() - 8;
        float distance = (float) Math.sqrt((x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));

        velX = ((-1 / distance) * diffX);
        velY = ((-1 / distance) * diffY);

        if (y <= 0 || y >= Game.HEIGHT - 12) velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 6) velX *= -1;

        // color of trail, size of trail copy to block size too.
        //                                                                  //how long the trail stays
        handler.addObject(new Trail((int) x, (int) y, ID.Trail, Color.green, 6, 6, 0.02f, handler));

    }

    public void render(Graphics g) {
        g.setColor(Color.green);
//        round pieces
//        g.fillRoundRect((int) x, (int) y, 6, 6, 12, 12);
        g.fillRect((int) x, (int) y, 6, 6);
    }
}
