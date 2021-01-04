package Annihilation;

// All the libraries that are required
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * @author Asinsa
 */

public class Bullet extends GameObject{

    //Calls manager class
    private Manager manager;

    //Bullet method    
    public Bullet(int x, int y, ID id, Manager manager, int mx, int my, SpriteSheet spritesheet) {
        super(x, y, id, spritesheet);
        this.manager = manager;
        
        velX = (mx - x) / 10;
        velY = (my - y) / 10;
    }

    //tick method
    public void tick() {
        x += velX;
        y += velY;
        
        for (int i = 0; i < manager.object.size(); i++){
            GameObject tempObject = manager.object.get(i);
            
            if (tempObject.getId() == ID.Block){
                if (getBounds().intersects(tempObject.getBounds())){
                    //Calls removeObject method in manager class
                    manager.removeObject(this);
                }
            }
        }
    }

    //render method
    public void render(Graphics graphics) {
        graphics.setColor(Color.YELLOW);
        graphics.fillOval(x, y, 8, 8);
    }

    //getBounds method
    public Rectangle getBounds() {
        return new Rectangle(x, y, 8, 8);
    }
}
