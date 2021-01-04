package Annihilation;

// All the libraries that are required
import java.io.*;
import java.util.Scanner;

/**
 * @author Asinsa
 */

public class MissionLoader {
    
    private static Scanner MissionsFile;
    public static boolean found = false;
    public static String MissionInfo = "";
    
    //LoadMission method
    public static String LoadMission(Integer Level) {
        
        String tempLevel = "";
        String tempMission = "";
        
        try{
            MissionsFile = new Scanner (new File("Missions.txt"));
            MissionsFile.useDelimiter("[,\n]");
            
            while (MissionsFile.hasNext() && !found){
                tempLevel = MissionsFile.next();
                tempMission = MissionsFile.next();
                
                if (tempLevel.equals(UserData.tempLevel)){
                    found = true;
                    MissionInfo = tempMission;
                }
                else {
                    found = false;
                }
            }
            MissionsFile.close();
        }
        catch(Exception e){
            System.out.println("Error");
        }
        return tempMission;
    }
}
