/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;


import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.util.List;

/**
 *
 * @author spock
 */
class DialogueHandler {

    ArrayList<ArrayList<String>> dialogues = new ArrayList<ArrayList<String>>();

    boolean finished;
    int currPart;
    int choice;

    DialogueHandler(String dfile){
        File file = null;
        try{
            file = new File(dfile);
            Scanner s = new Scanner(file);
            while(s.hasNext()){
                String sn = s.next();
                if(sn.equals("-")){
                    ArrayList<String> currDi = new ArrayList<String>();
                    String blah = "";
                    while(true){
                        String cur = s.next();
                        if(cur.equals(":::")){
                            break;
                        }
                        else{
                            blah = blah + " " + cur;
                        }
                    }
                    currDi.add(blah);
                    dialogues.add(currDi);
                }
                if(sn.equals("_"))
                {
                    ArrayList<String> currDi = new ArrayList<String>();
                    String cur = "";
                    while(true){
                        String blah = "";
                        while(true){
                            cur = s.next();
                            if(cur.equals("::") || cur.equals(":::")){
                                break;
                            }
                            else{
                                blah = blah + " " + cur;
                            }
                        }
                        currDi.add(blah);
                        if(cur.equals(":::")){
                            break;
                        }
                    }
                    dialogues.add(currDi);
                }
            }

            finished = false;
            currPart = 0;
            choice = 0;

            System.out.println("Dialogue test!");
            for(int i = 0; i < dialogues.size(); ++i){
                System.out.println("Dialogue 1");
                for(int j = 0; j < dialogues.get(i).size(); ++j){
                    System.out.println(dialogues.get(i).get(j));
                }
            }

        }
        catch(Exception c){
            System.out.println("dialogue loading fail");
            System.exit(1);
        }
    }

    void next(){
        System.out.println(dialogues.get(currPart).get(0));
        currPart++;
        if(currPart >= dialogues.size()){
            currPart = dialogues.size() - 1;
            finished = true;
        }
        choice = 0;
    }

    void scroll(int di){
        if(di < 0){
            --choice;
            if(choice < 0){
                choice = dialogues.get(currPart).size() - 1;
            }
        }
        else{
            ++choice;
            if(choice >= dialogues.get(currPart).size()){
                choice = 0;
            }
        }
    }

    int currSelection(){
       return choice;
    }

    List<String> getDialogue(){
        return dialogues.get(currPart);
    }

    boolean done(){
        if(finished){
            currPart = 0;
            choice = 0;
            finished = false;
            return true;
        }
        return finished;
    }
}
