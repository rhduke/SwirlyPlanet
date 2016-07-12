/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package theswirlyplanet.main;

/**
 *
 * @author Ron
 */
public abstract class Action {
    public static String NO_ACTION = "No Action";
    
    protected String name;
    protected Unit src;
    protected Targets trgs;
    protected int dmg;
    
    public Action() {
        this.name = NO_ACTION;
        this.src = new Unit();
        this.dmg = 0;
        this.trgs = new Targets();
    }
    
    public Action(Unit src, Targets trgs) {
        this.name = NO_ACTION;
        this.src = src;
        this.trgs = trgs;
        this.dmg = 0;
    }
    
    public Unit getSource() {
        return this.src;
    }
    
    public boolean isDefault() {
        return this.name.equals(NO_ACTION);
    }
    
    @Override
    public String toString(){
        return "[" + this.name + ":" + "[s=" + this.src.toString() + "]," + trgs.toString() + "]";
    }
}
