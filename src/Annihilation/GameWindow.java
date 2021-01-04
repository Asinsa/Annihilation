package Annihilation;

// All the libraries that are required
import javax.swing.JFrame;

/**
 * @author Asinsa
 */

public class GameWindow {
    
    //GameWindow method
    public GameWindow (int width, int height, String title, Game game){
        
        JFrame frame = new JFrame(title);
        
        // Setting size of the game screen
        frame.add(game);
        frame.setSize(1378, 734);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(-6,0);
        frame.setVisible(true);
    }
}
