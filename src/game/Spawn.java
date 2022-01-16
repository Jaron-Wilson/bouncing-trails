package game;

import java.util.Random;

public class Spawn {

    private Handler handler;
    private HUD hud;
    private Random r = new Random();

    private int scoreKeep = 0;

    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void tick() {
        scoreKeep++;

        if (scoreKeep >= 250) {
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);

//            BOSS
//            /*else*/ if (hud.getScore() == 100) {
//                handler.clearEnemies();
//                handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 48, -120, ID.EnemyBoss, handler));
//                handler.addObject(new Player(Game.WIDTH / 2, (r.nextInt(Game.HEIGHT - 50)), ID.Player, handler));
            /*} else */if (hud.getLevel() == 2) {
                handler.addObject(new HealEnemy((r.nextInt(Game.WIDTH - 40)), (r.nextInt(Game.HEIGHT - 50)), ID.HealEnemy, handler));
                handler.addObject(new BasicEnemy((r.nextInt(Game.WIDTH - 50)), (r.nextInt(Game.HEIGHT - 50)), ID.BasicEnemy, handler));
            } else if (hud.getLevel() == 3) {
                handler.addObject(new BasicEnemy((r.nextInt(Game.WIDTH - 50)), (r.nextInt(Game.HEIGHT - 50)), ID.BasicEnemy, handler));
            } else if (hud.getLevel() == 4) {
                for (int i = 0, max = r.nextInt(2) + 1; i < max; i++)
                    handler.addObject(new FastEnemy((r.nextInt(Game.WIDTH - 50)), (r.nextInt(Game.HEIGHT - 50)), ID.FastEnemy, handler));
            } else if (hud.getLevel() == 5) {
                for (int i = 0, max = r.nextInt(4) - 1; i < max; i++)
                    handler.addObject(new FastEnemy((r.nextInt(Game.WIDTH - 50)), (r.nextInt(Game.HEIGHT - 50)), ID.FastEnemy, handler));
            } else if (hud.getLevel() == 6) {
                for (int i = 0, max = r.nextInt(4) - 1; i < max; i++)
                    handler.addObject(new SmartEnemy((r.nextInt(Game.WIDTH - 50)), (r.nextInt(Game.HEIGHT - 50)), ID.SmartEnemy, handler));
            } else if (hud.getScore() == 20000) {
                handler.addObject(new BasicEnemy((r.nextInt(Game.WIDTH - 50)), (r.nextInt(Game.HEIGHT - 50)), ID.SmartEnemy, handler));
                handler.addObject(new SmartEnemy((r.nextInt(Game.WIDTH - 50)), (r.nextInt(Game.HEIGHT - 50)), ID.SmartEnemy, handler));
            } else if (hud.getLevel() == 8) {
                for (int i = 0, max = r.nextInt(4); i < max; i++)
                    handler.addObject(new SmartEnemy((r.nextInt(Game.WIDTH - 50)), (r.nextInt(Game.HEIGHT - 50)), ID.SmartEnemy, handler));
            } else if (hud.getScore() == 3000) {
                for (int i = 0, max = r.nextInt(10); i < max; i++)
                    handler.addObject(new EnemyBossBullet((r.nextInt(Game.WIDTH - 50)), (r.nextInt(Game.HEIGHT - 50)), ID.SmartEnemy, handler));
            } else if (hud.getLevel() == 20) {
                for (int i = 0, max = r.nextInt(4); i < max; i++)
                    handler.addObject(new SmartEnemy((r.nextInt(Game.WIDTH - 50)), (r.nextInt(Game.HEIGHT - 50)), ID.SmartEnemy, handler));
            } else if (hud.getLevel() == 25) {
                for (int i = 0, max = r.nextInt(4); i < max; i++)
                    handler.addObject(new FastEnemy((r.nextInt(Game.WIDTH - 50)), (r.nextInt(Game.HEIGHT - 50)), ID.FastEnemy, handler));
            } else if (hud.getLevel() == 50) {
                handler.addObject(new HealEnemy((r.nextInt(Game.WIDTH - 50)), (r.nextInt(Game.HEIGHT - 50)), ID.HealEnemy, handler));
            } else if (hud.getLevel() == 28) {
                handler.addObject(new BasicEnemy((r.nextInt(Game.WIDTH - 50)), (r.nextInt(Game.HEIGHT - 50)), ID.BasicEnemy, handler));
            } else if (hud.getLevel() == 30) {
                handler.addObject(new BasicEnemy((r.nextInt(Game.WIDTH - 50)), (r.nextInt(Game.HEIGHT - 50)), ID.BasicEnemy, handler));
            } else if (hud.getLevel() == 35) {
                for (int i = 0, max = r.nextInt(2) + 1; i < max; i++)
                    handler.addObject(new FastEnemy((r.nextInt(Game.WIDTH - 50)), (r.nextInt(Game.HEIGHT - 50)), ID.FastEnemy, handler));
            } else if (hud.getLevel() == 37) {
                for (int i = 0, max = r.nextInt(4) - 1; i < max; i++)
                    handler.addObject(new FastEnemy((r.nextInt(Game.WIDTH - 50)), (r.nextInt(Game.HEIGHT - 50)), ID.FastEnemy, handler));
            } else if (hud.getLevel() == 40) {
                for (int i = 0, max = r.nextInt(4) - 1; i < max; i++)
                    handler.addObject(new SmartEnemy((r.nextInt(Game.WIDTH - 50)), (r.nextInt(Game.HEIGHT - 50)), ID.SmartEnemy, handler));
            } else if (hud.getScore() == 8000) {
                handler.addObject(new BasicEnemy((r.nextInt(Game.WIDTH - 50)), (r.nextInt(Game.HEIGHT - 50)), ID.BasicEnemy, handler));
                handler.addObject(new EnemyBossBullet((r.nextInt(Game.WIDTH - 50)), (r.nextInt(Game.HEIGHT - 50)), ID.SmartEnemy, handler));
            } else if (hud.getLevel() == 48) {
                for (int i = 0, max = r.nextInt(4); i < max; i++)
                    handler.addObject(new SmartEnemy((r.nextInt(Game.WIDTH - 50)), (r.nextInt(Game.HEIGHT - 50)), ID.SmartEnemy, handler));
            } else if (hud.getScore() == 50) {
                for (int i = 0, max = r.nextInt(10); i < max; i++)
                    handler.addObject(new EnemyBossBullet((r.nextInt(Game.WIDTH - 50)), (r.nextInt(Game.HEIGHT - 50)), ID.SmartEnemy, handler));
            } else if (hud.getLevel() == 55) {
                for (int i = 0, max = r.nextInt(4); i < max; i++)
                    handler.addObject(new SmartEnemy((r.nextInt(Game.WIDTH - 50)), (r.nextInt(Game.HEIGHT - 50)), ID.SmartEnemy, handler));
            } else if (hud.getLevel() == 60) {
                for (int i = 0, max = r.nextInt(4); i < max; i++)
                    handler.addObject(new FastEnemy((r.nextInt(Game.WIDTH - 50)), (r.nextInt(Game.HEIGHT - 50)), ID.FastEnemy, handler));
            }
//            if (hud.getLevel() == 10) {
//                handler.clearEnemies();
//                handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 48, -120, ID.EnemyBoss, handler));
//                handler.addObject(new Player(Game.WIDTH / 2, (r.nextInt(Game.HEIGHT - 50)), ID.Player, handler));
//            }
        }
    }
}