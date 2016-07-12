/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package theswirlyplanet.test;

import theswirlyplanet.main.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import java.io.InputStream;
import java.io.BufferedInputStream;
/**
 *
 * @author Ron
 */
public class BattleTester {
    
	
        static BattleQueue que = new BattleQueue();
        static Party heroes = new Party(true);
        static Party enemies = new Party();
        
        
        static Unit cid = new Unit("Cid");
        static Unit markus = new Unit("Markus");
        static Unit may = new Unit("May");
        static Unit xtra = new Unit("Extra");
        static Unit serp1 = new Unit("Serpent1");
        static Unit serp2 = new Unit("Serpent2");
        static Unit wendigo = new Unit("Wendigo");
        
        static BattleControl control;
        
    public static void main(String[] args) throws Exception {
        
        heroes.add(cid);
        heroes.add(markus);
        heroes.add(may);
        heroes.add(xtra);
        enemies.add(serp1);
        enemies.add(serp2);
        enemies.add(wendigo);
        
        heroes.index(0).atb().setRate(25);
        heroes.index(1).atb().setRate(33);
        heroes.index(2).atb().setRate(29);
        
        enemies.index(0).atb().setRate(21);
        enemies.index(1).atb().setRate(43);
        enemies.index(2).atb().setRate(32);
        
        control =  new BattleControl(que, heroes.getActive(), enemies.getActive());
        
        control.start();
        
//        log.printScreen();
//        
//        InputStream input = new BufferedInputStream(System.in);
//        int token;
//        while(true) {
//            token = input.read();
//            if (token == 'a') {
//                que.enque(new Attack(cid, new Targets(serp1)));
//                log.printScreen();
//            }
//            if (token == 'b') {
//                que.enque(new Attack(markus, new Targets(serp2)));
//                log.printScreen();
//            }
//            if (token == 'c') {
//                que.enque(new Attack(may, new Targets(wendigo)));
//                log.printScreen();
//            }
//            if (token == 's') {
//                que.deque();
//                log.printScreen();
//            }
//       }
//        try {
//            TimeUnit.MINUTES.sleep(100);
//        } catch (InterruptedException e) {
//            //Handle exception
//        }
    }
    
//    public void keyPressed(KeyEvent e) {
//        int key = e.getKeyCode();
//        if (key == KeyEvent.VK_A) {
//            que.enque(new Attack(cid, new Targets(serp1)));
//            
//            log.printScreen();
//        }
//        if (key == KeyEvent.VK_S) {
//            que.enque(new Attack(markus, new Targets(serp2)));
//            log.printScreen();
//        }
//        if (key == KeyEvent.VK_D) {
//            que.enque(new Attack(may, new Targets(wendigo)));
//            log.printScreen();
//        }
//        if (key == KeyEvent.VK_SPACE) {
//            que.deque();
//            log.printScreen();
//        }
//    }
}
