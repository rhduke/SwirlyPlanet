/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package theswirlyplanet.main;

/**
 *
 * @author Ron
 */
public class BattleQueue {
    public int MAX_SIZE = 10;
    
    private Action acts[];
    private int head;
    private int tail;
    private int size;
    
    public BattleQueue() {
        this.head = 0;
        this.tail = 0;
        this.size = 0;
        this.acts = new Action[MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++)
            this.acts[i] = new EmptyAction();
    }
    
    public boolean enque(Action act) {
        boolean success = false;
        if (!isFull() && act != null) {
            this.acts[tail] = act;
            this.tail = (this.tail + 1) % MAX_SIZE;
            this.size++;
            success = true;
        } else
            System.out.println("Queue full!");
        return success;
    }
    
    public Action deque() {
        Action token = new EmptyAction();
        if (!isEmpty()) {
            token = this.acts[head];
            this.acts[head] = new EmptyAction();
            this.head = (this.head + 1) % MAX_SIZE;
            this.size--;
        } else
            System.out.println("Queue empty!");
        return token;
    }
    
    public boolean isFull() {
        return this.size == MAX_SIZE;
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    @Override
    public String toString() {
        StringBuffer buff = new StringBuffer();
        for (int i = 0; i < MAX_SIZE; i++) {
            buff.append(i + ":");
            if (!acts[i].isDefault())
                buff.append(acts[i].toString());
            else
                buff.append("empty");
            if (i == this.tail)
                buff.append("{tail}");
            if (i == this.head)
                buff.append("{head}");
            buff.append("\n");
        }
        return buff.toString();
    }
}
