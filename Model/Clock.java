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


    Clock(){
        clock = new Timer("Battle Clock");
        listeners = new LinkedList<Tickable>();
    }

    void addListener(Tickable t){
        listeners.add(t);
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
            System.out.print("Tick");
        }
    }

}
