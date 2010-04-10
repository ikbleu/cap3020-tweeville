/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.Timer;
import java.util.TimerTask;
import java.util.LinkedList;

/**
 *
 * @author spock
 */
public class Clock {

    Timer clock;
    long timePerTick;
    LinkedList<Tickable> listeners;
    boolean ticking = false;


    Clock(long timeBetw){
        clock = new Timer("Battle Clock");
        listeners = new LinkedList<Tickable>();
        timePerTick = timeBetw;
    }

    void addListener(Tickable t){
        listeners.add(t);
    }

    void removeListener(Tickable t){
        listeners.remove(t);
    }

    private class MyTask extends TimerTask{
        LinkedList<Tickable> listeners;

        MyTask(LinkedList<Tickable> tickers){
            listeners = tickers;
        }

        public void run(){
            for(int i = 0; i < listeners.size(); ++i){
                listeners.get(i).onTick();
            }
        }
    }

    void start(){
        clock.scheduleAtFixedRate( new MyTask(this.listeners),
                                        timePerTick, timePerTick );
    }

    void stop(){
        this.clock.cancel();
    }

}
