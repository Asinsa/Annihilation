package Annihilation;

// All the libraries that are required
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Scanner;

/**
 * @author Asinsa
 */

public class UserData {
    
    //CreateUserData method
    public void CreateUserData (String Username, String Password, Integer Level){
        
        //Makes the username and password into a single string called UserData
        String NewUserData = Username + "," + Password + "," + Level;
        PlayerName = Username;
        
        //The string UserData will be appended onto the file LoginDetails
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("LoginDetails.txt", true));
            writer.write(NewUserData);
            writer.newLine();
            writer.flush();
            writer.close();
        }
        catch (IOException x){
            System.err.format("IOException:", x);
        }
    }
    
    private static Scanner DataFile;
    public static boolean found = false;
    
    //VerifyLogin method
    public static String VerifyLogin(String Username, String Password) {
        
        String tempUsername = "";
        String tempPassword = "";
        
        // The file DataFile is read 1 line at a time until username and password match
        try{
            DataFile = new Scanner (new File("LoginDetails.txt"));
            DataFile.useDelimiter("[,\r\n]");
            
            while (DataFile.hasNext() && !found){
                tempUsername = DataFile.next();
                tempPassword = DataFile.next();
                
                if (tempUsername.equals(Username.trim()) && tempPassword.equals(Password.trim())){
                    found = true;
                }
                else {
                    found = false;
                }
            }
            DataFile.close();
        }
        catch(Exception e){
            System.out.println("Error");
        }
        return tempLevel;
    }
    
    public static Integer Level = 1;
    public static String tempLevel = "";
    public static String PlayerName = "";
    
    //GetUserData method
    public String[] GetUserData (String Username){
        
        //Holds current line of data
        String[] Line = new String[2];
        Path DataFile = Paths.get("LoginDetails.txt");
        Charset charset = Charset.forName("US-ASCII");
        
        // File serched until the username matches then, player's name & level saved as variables
        try (BufferedReader reader = Files.newBufferedReader(DataFile, charset)){
            for (String line; (line = reader.readLine()) != null;){
                Line = line.split(",");
                if (Line[0].equals(Username)){
                    Level = Integer.parseInt(Line[2]);
                    tempLevel = Line[2];
                    PlayerName = Line[0];
                }
            }
            return Line;
        }
        catch (IOException ex) {
            System.err.format("IOException: ");
        }
        return Line;
    }
}
