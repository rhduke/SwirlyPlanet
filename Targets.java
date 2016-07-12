/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package theswirlyplanet.main;

/**
 *
 * @author Ron
 */
public class Targets {
    public static int MAX_SIZE = 10;
    
    private Unit[] trgs;
    private int size;
    
    public Targets() {
        this.trgs = new Unit[MAX_SIZE];
        this.size = 0;
        for(int i = 0; i < MAX_SIZE; i++)
            this.trgs[i] = new Unit();
    }
    
    public Targets(Unit trg) {
        this();
        this.add(trg);
    }
    
    public boolean add(Unit trg) {
        boolean success = false;
        for (int i = 0; i < MAX_SIZE; i++) {
            if (trg != null && this.trgs[i].isDefault()) {
                this.trgs[i] = trg;
                this.size++;
                success = true;
                break;
            }
        }
        return success;
    }
    
    public int size() {
        return this.size;
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public boolean isFull() {
        return this.size == MAX_SIZE;
    }
    
    @Override
    public String toString() {
        StringBuffer buff = new StringBuffer("[t=");
        if (isEmpty())
                buff.append("no targets]");
        else {
            for (int i = 0; i < size(); i++) {
                buff.append(this.trgs[i].name());
                if (i != size() - 1)
                    buff.append(",");
            }
        }
        return buff.toString();
    }
}
