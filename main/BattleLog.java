/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package theswirlyplanet.main;

/**
 *
 * @author Ron
 */
public class BattleLog {
    private BattleQueue que;
    private Party heroes;
    private Party enemies;
    
    public BattleLog(BattleQueue que, Party heroes, Party enemies) {
        this.que = que;
        this.heroes = heroes;
        this.enemies = enemies;
    }
    
    public void printScreen() {
        System.out.println(heroes.toString() + "\n" + enemies.toString() + "\n" + que.toString());
    }
}
