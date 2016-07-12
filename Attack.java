/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package theswirlyplanet.main;

/**
 *
 * @author Ron
 */
public class Attack extends Action {
    public Attack () {
        super();
        this.name = "Attack";
    }
    
    public Attack(Unit src, Targets trgs) {
        super(src, trgs);
        this.name = "Attack";
    }
}
