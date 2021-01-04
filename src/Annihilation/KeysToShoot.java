package Annihilation;

// All the libraries that are required
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Asinsa
 */

public class KeysToShoot extends MouseAdapter {
    
    //Calls Manager class
    private Manager manager;
    //Calls Camera class
    private Camera camera;
    //Calls Game class
    private Game game;
    //Calls SpriteSheet class
    private SpriteSheet spritesheet;
    
    //KeysToShoot method
    public KeysToShoot(Manager manager,Camera camera, Game game, SpriteSheet spritesheet){
        this.manager = manager;
        this.camera = camera;
        this.game = game;
        this.spritesheet = spritesheet;
    }
    
    public void mouseClicked(MouseEvent e){
        int mx = (int)(e.getX() + camera.getX());
        int my = (int)(e.getY() + camera.getY());
        
        for (int i = 0; i < manager.object.size(); i++) {
            GameObject tempObject = manager.object.get(i);

            if (tempObject.getId() == ID.Tank && game.ammo > 0) {
                manager.addObject(new Bullet(tempObject.getX()+16, 
                        tempObject.getY()+24, ID.Bullet, manager, mx, my, spritesheet));
                game.ammo -= 1;
            }
        }
    }
}
