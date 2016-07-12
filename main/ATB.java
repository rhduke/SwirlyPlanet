/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package theswirlyplanet.main;

import java.util.Random;

/**
 *
 * @author Ron
 */
public class ATB {
    public static final int MAX_ATB = 1000;
    public static final int START_RATE = 10;
    
    private float atb;
    private float rate;
    private Random rand;
    private boolean qued;
    
    public ATB() {
        this.atb = 0;
        this.rate = START_RATE;
        this.rand = new Random(MAX_ATB);
        this.qued = false;
    }
    
    public void setRate(float rate) {
        this.rate = rate;
    }
    
    public void setAtb(float atb) {
        this.atb = atb;
    }
    
    public void increase() {
        this.atb = this.atb + this.rate;
    }
    
    public float atb() {
        return this.atb;
    }
    
    public float rate() {
        return this.rate;
    }
    
    public void random() {
        this.atb = this.rand.nextInt(MAX_ATB);
    }
    
    public void setQued(boolean qued) {
        this.qued = qued;
    }
    
    public Boolean isQued() {
        return this.qued;
    }
    
    public boolean isMax() {
        return this.atb >= MAX_ATB;
    }
    
    @Override
    public String toString() {
        return "[ATB: " + this.atb + "(" + this.rate + ")]";
    }
    
    public String shortString() {
        return "[" + this.atb + "atb]";
    }
}
