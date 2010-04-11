/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author spock
 */
class TriggerBox {
    double xMin;
    double xMax;
    double yMin;
    double yMax;
    String triggerType;
    String loadingInfoFile;
    String loadingMapFile;
    String imageMap;


    TriggerBox(double x1, double x2, double y1, double y2, String triggerType, String loadingInfoFile, String loadingMapFile){
        xMin = x1;
        xMax = x2;
        yMin = y1;
        yMax = y2;
        this.triggerType = triggerType;
        this.loadingInfoFile = loadingInfoFile;
        this.loadingMapFile = loadingMapFile;

    }

    boolean inside( double x, double y ){

        if(x >= xMin && x <= xMax && y >= yMin && y <= yMax){
            return true;
        }
        return false;
    }

    String getTriggerType(){
        return triggerType;
    }

    String getLoadingInfoFile(){
        return loadingInfoFile;
    }

    String getLoadingMapFile(){
        return loadingMapFile;
    }

    String getImageMap(){
        return imageMap;
    }

}