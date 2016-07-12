/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package theswirlyplanet.main;

/**
 *
 * @author Ron
 */
public class Party {
    public static final int MAX_SIZE = 10;
    public static final int BAT_POSITIONS = 3;
    
    private Unit[] party;
    private int size;
    private boolean isHero;
    
    public Party() {
        this.size = 0;
        this.party = new Unit[MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++)
            this.party[i] = new Unit();
        this.isHero = false;
    }
    
    public Party(boolean isHero) {
        this();
        this.isHero = isHero;
    }
    
    public boolean add(Unit unit) {
        boolean success = false;
        if (!isFull() && unit != null) {
            for (int i = 0; i < MAX_SIZE; i++) {
                if (this.party[i].isDefault()) {
                    this.party[i] = unit;
                    this.size++;
                    success = true;
                    break;
                }
            }
        }
        return success;
    }
    
    public Party getActive() {
        Party active = new Party();
        if (this.isHero()) {
            for (int i = 0; i < BAT_POSITIONS; i++) {
                if (!this.party[i].isDefault()) {
                    active.add(this.party[i]);
                }
            }
            return active;
        } else
            return this;
        
    }
    
    public Unit index(int i) {
        return this.party[i];
    }
    
    public int size() {
        return this.size;
    }
    
    public void increaseATB() {
        for (int i = 0; i < size(); i++) {
            if (!this.party[i].atb().isMax())
                this.party[i].atb().increase();
        }
    }
    
    public boolean isFull() {
        return this.size == MAX_SIZE;
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public boolean isHero() {
        return this.isHero;
    }
    
    @Override
    public String toString() {
        StringBuffer buff = new StringBuffer("[Party:");
        if (isEmpty())
            buff.append("empty]");
        else
            for (int i = 0; i < size(); i++) {
                buff.append(this.party[i].toString());
                if (i != size() - 1)
                    buff.append(",");
            }
        buff.append("]");
        return buff.toString();
            
    }
}
