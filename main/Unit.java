/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package theswirlyplanet.main;

/**
 *
 * @author Ron
 */
public class Unit {
    final static String NO_NAME = "No Unit";
    
    private String name;
    private int hp;
    private ATB atb;
    
    public Unit() {
        this.name = NO_NAME;
        this.hp = 100;
        this.atb = new ATB();
    }
    
    public Unit(String name) {
        this();
        this.name = name;
    }
    
    public boolean isReady() {
        return this.atb.isMax();
    }
    
    public void setQued(boolean qued) {
        this.atb.setQued(qued);
    }
    
    public boolean isQued() {
        return this.atb.isQued();
    }
    
    public void resetATB() {
        this.atb.setAtb(0);
    }
    
    public ATB atb() {
        return this.atb;
    }
    
    public String name() {
        return this.name;
    }
    
    public boolean isDefault() {
        return this.name.equals(NO_NAME);
    }
    
    @Override
    public String toString() {
        return ("[" + this.name + ", " + this.hp + "hp"+ this.atb.shortString() + "]");
    }
    

}
