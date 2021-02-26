package game;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;


public class Menu extends MouseAdapter {

    private Game game;
    private Handler handler;
    private HUD hud;
    private Random r = new Random();


    public Menu(Game game, Handler handler, HUD hud) {
        this.game = game;
        this.hud = hud;
        this.handler = handler;
    }

    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        //play button
        if (Game.gameState == Game.STATE.Menu && mouseOver(mouseX, mouseY, 210, 150, 200, 70)) {
            Game.gameState = Game.STATE.Game;
            handler.clearEnemies();
            handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
            handler.addObject(new BasicEnemy((r.nextInt(Game.WIDTH - 50)), (r.nextInt(Game.HEIGHT - 50)), ID.BasicEnemy, handler));

        }

        //help button
        if (Game.gameState == Game.STATE.Menu && mouseOver(mouseX, mouseY, 210, 250, 200, 70)) {
            Game.gameState = Game.STATE.Help;
        }

        //back button for help
        if (Game.gameState == Game.STATE.Help || Game.gameState == Game.STATE.End) {
            if (mouseOver(mouseX, mouseY, 320, 350, 200, 70)) {
                Game.gameState = Game.STATE.Menu;
                return;
            }
        }
        //back button for help
        if (Game.gameState == Game.STATE.Help) {
            if (mouseOver(mouseX, mouseY, 95, 350, 200, 70)) {
                Game.gameState = Game.STATE.Game;
                hud.setLevel(1);
                hud.setScore(0);

                handler.clearEnemies();
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
                handler.addObject(new BasicEnemy((r.nextInt(Game.WIDTH - 50)), (r.nextInt(Game.HEIGHT - 50)), ID.BasicEnemy, handler));
            }
        }
        //back button
        if (Game.gameState == Game.STATE.End) {
            if (mouseOver(mouseX, mouseY, 210, 350, 200, 70)) {
                Game.gameState = Game.STATE.Game;
                hud.setLevel(1);
                hud.setScore(0);

                handler.clearEnemies();
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
                handler.addObject(new BasicEnemy((r.nextInt(Game.WIDTH - 50)), (r.nextInt(Game.HEIGHT - 50)), ID.BasicEnemy, handler));
            }
        }

        //quit button
        if (Game.gameState == Game.STATE.Menu && mouseOver(mouseX, mouseY, 210, 350, 200, 70)) {
            System.exit(1);
        }
    }

    public void mouseReleased(MouseEvent e) {

    }

    private boolean mouseOver(int mouseX, int mouseY, int x, int y, int width, int height) {
        return (mouseX > x && mouseX < x + width
                && mouseY > y && mouseY < y + height);
    }


    public void tick() {

    }

    public void render(Graphics g) {
        if (Game.gameState == Game.STATE.Menu) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Menu", 240, 70);

            g.setFont(fnt2);
            g.drawRect(210, 150, 200, 64);
            g.drawString("Play", 270, 190);

            g.drawRect(210, 250, 200, 64);
            g.drawString("Help", 270, 290);

            g.drawRect(210, 350, 200, 64);
            g.drawString("Quit", 270, 390);
        } else if (Game.gameState == Game.STATE.Help) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt3 = new Font("arial", 1, 20);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Help", 240, 70);

            g.setFont(fnt3);
            g.drawString("   Use WASD to move player and dodge the enemies", 50, 200);
            g.drawString("Use Arrowkeys to move player and dodge the enemies", 50, 250);


            g.setFont(fnt2);
            g.drawRect(95, 350, 200, 64);
            g.drawString("Play", 160, 390);
            g.drawRect(320, 350, 200, 64);
            g.drawString("Back", 380, 390);
        } else if (Game.gameState == Game.STATE.End) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt3 = new Font("arial", 1, 20);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Game Over", 200, 70);

            g.setFont(fnt3);
            g.drawString("  You lost with a score of: " + hud.getScore(), 50, 200);
            g.drawString("  You lost with at level: " + hud.getLevel(), 50, 240);

            g.setFont(fnt2);
            g.drawRect(240, 350, 200, 64);
            g.drawString("Try Again?", 270, 390);
        }
    }

}
