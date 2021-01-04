package Annihilation;

// All the libraries that are required
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Asinsa
 */

public class KeysToMove extends KeyAdapter {
    
    //Calls Manager class
    Manager manager;
    
    //KeysToMove method
    public KeysToMove(Manager manager){
        this.manager = manager;
    }

    //keyPressed method
    public void keyPressed(KeyEvent e) {
        int Key = e.getKeyCode();
        
        //Arrow key movement
        if (Options.KeyMoveChoice.equals("Arrow Keys")){
            for (int i = 0; i < manager.object.size(); i++) {
                GameObject tempObject = manager.object.get(i);
                if (tempObject.getId() == ID.Tank) {
                    if (Key == KeyEvent.VK_UP) {
                        //Calls setUp method in manager class
                        manager.setUp(true);
                    }
                    if (Key == KeyEvent.VK_DOWN) {
                        //Calls setDown method in manager class
                        manager.setDown(true);
                    }
                    if (Key == KeyEvent.VK_LEFT) {
                        //Calls setLeft method in manager class
                        manager.setLeft(true);
                    }
                    if (Key == KeyEvent.VK_RIGHT) {
                        //Calls setRight method in manager class
                        manager.setRight(true);
                    }
                }
            }
        }
        
        //W A S D movement
        if (Options.KeyMoveChoice.equals("W A S D")){
            for (int i = 0; i < manager.object.size(); i++) {
                GameObject tempObject = manager.object.get(i);
                if (tempObject.getId() == ID.Tank) {
                    if (Key == KeyEvent.VK_W) {
                        //Calls setUp method in manager class
                        manager.setUp(true);
                    }
                    if (Key == KeyEvent.VK_S) {
                        //Calls setDown method in manager class
                        manager.setDown(true);
                    }
                    if (Key == KeyEvent.VK_A) {
                        //Calls setLeft method in manager class
                        manager.setLeft(true);
                    }
                    if (Key == KeyEvent.VK_D) {
                        //Calls setRight method in manager class
                        manager.setRight(true);
                    }
                }
            }
        }
    }

    //keyReleased method
    public void keyReleased(KeyEvent e) {
        int Key = e.getKeyCode();
        
        //Arrow key movement
        if (Options.KeyMoveChoice.equals("Arrow Keys")){
            for (int i = 0; i < manager.object.size(); i++) {
                GameObject tempObject = manager.object.get(i);
                if (tempObject.getId() == ID.Tank) {
                    if (Key == KeyEvent.VK_UP) {
                        //Calls setUp method in manager class
                        manager.setUp(false);
                    }
                    if (Key == KeyEvent.VK_DOWN) {
                        //Calls setDown method in manager class
                        manager.setDown(false);
                    }
                    if (Key == KeyEvent.VK_LEFT) {
                        //Calls setLeft method in manager class
                        manager.setLeft(false);
                    }
                    if (Key == KeyEvent.VK_RIGHT) {
                        //Calls setRight method in manager class
                        manager.setRight(false);
                    }
                }
            }
        }
        
        //W A S D movement
        if (Options.KeyMoveChoice.equals("W A S D")){
            for (int i = 0; i < manager.object.size(); i++) {
                GameObject tempObject = manager.object.get(i);
                if (tempObject.getId() == ID.Tank) {
                    if (Key == KeyEvent.VK_W) {
                        //Calls setUp method in manager class
                        manager.setUp(false);
                    }
                    if (Key == KeyEvent.VK_S) {
                        //Calls setDown method in manager class
                        manager.setDown(false);
                    }
                    if (Key == KeyEvent.VK_A) {
                        //Calls setLeft method in manager class
                        manager.setLeft(false);
                    }
                    if (Key == KeyEvent.VK_D) {
                        //Calls setRight method in manager class
                        manager.setRight(false);
                    }
                }
            }
        }
    }
}
