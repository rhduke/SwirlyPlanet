/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package theswirlyplanet.main;

import java.util.concurrent.TimeUnit;
import java.util.Random;

/**
 *
 * @author Ron
 */
public class BattleControl {
    
    public static final int INTERVAL = 3; // Testing
    public static Random rand = new Random(3);  // Testing
    public static Random rand2 = new Random(3); // Testing
    
    private BattleQueue que;
    private Party hero;
    private Party enemy;
    private Party all;
  
    private boolean battlemode;
    private BattleLog log;
    
    public BattleControl(BattleQueue que, Party hero, Party enemy) {
        this.que = que;
        this.hero = hero;
        this.enemy = enemy;
        this.battlemode = false;
        this.log = new BattleLog(que, hero, enemy);
        
        all = new Party();
        for (int i = 0; i < hero.size(); i++)
            all.add(hero.index(i));
        for (int i = 0; i < enemy.size(); i++)
            all.add(enemy.index(i));
    }
    
    public void start() {
        this.battlemode = true;
        while (this.battlemode) {
            
            checkQueHead();
            checkForReady();
            increaseATB();
            this.log.printScreen();
            
//            try {
//                TimeUnit.MILLISECONDS.sleep(3000);
//            } catch (InterruptedException e) {
//                //Handle exception
//            }
        }
    }
    
    private void checkQueHead() {
        if (!this.que.isEmpty()) {
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                //Handle exception
            }
            Action a = this.que.deque();
            a.getSource().resetATB();
            a.getSource().setQued(false);
        }
    }
        
    
    private void checkForReady() {
        for (int i = 0; i < this.hero.size(); i++) {
            if (this.hero.index(i).isReady() && !this.hero.index(i).isQued()) {
                this.que.enque(new Attack(this.hero.index(i), 
                    new Targets(this.enemy.index(this.rand2.nextInt(3)))));
                this.hero.index(i).setQued(true);
                System.out.println(hero.index(i).toString() + " added to que");
            }
        }
        for (int i = 0; i < this.enemy.size(); i++) {
            if (this.enemy.index(i).isReady() && !this.enemy.index(i).isQued()) {
                this.que.enque(new Attack(this.enemy.index(i), 
                    new Targets(this.hero.index(this.rand2.nextInt(3)))));
                this.enemy.index(i).setQued(true);
                System.out.println(enemy.index(i).toString() + " added to que");
            }
        }
    }
    
    private void increaseATB() {
        hero.increaseATB();
        enemy.increaseATB();
    }
}
