package Annihilation;

// All the libraries that are required
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @author Asinsa
 */

public class EnemyGhost extends GameObject {
    
    //Calls Manager class
    private Manager manager;
    //New instance of the java class random is created
    Random random = new Random();
    int rand = 0;
    int hp = 100;
    //Calls BufferedImage class
    private BufferedImage ghost;
    
    //EnemyGhost method
    public EnemyGhost(int x, int y, ID id, Manager manager, SpriteSheet spritesheet) {
        super(x, y, id, spritesheet);
        this.manager = manager;
        //Calls getImage method in SpriteSheet class
        ghost = spritesheet.getImage(2, 1, 32, 32);
    }
    
    //tick method
    public void tick() {
        x += velX;
        y += velY;
        rand = random.nextInt(10);
        
        // If enemy touches the walls
        for (int i = 0; i < manager.object.size(); i++){
            GameObject tempObject = manager.object.get(i);
            
            if (tempObject.getId() == ID.Block) {
                if (getBoundsBig().intersects(tempObject.getBounds())) {
                    x += (velX*2) * -1;
                    y += (velY*2) * -1;
                    velX *= -1;
                    velY *= -1;
                }
                else if (rand == 0){
                    velX = (random.nextInt(8) -4);
                    velY = (random.nextInt(8) -4);
                }
            }
            
            // If the bullet touches the enemy
            if (tempObject.getId() == ID.Bullet){
                if (getBounds().intersects(tempObject.getBounds())){
                    hp -= 50;
                    //Calls removeObject method in manager class
                    manager.removeObject(tempObject);
                }
            }
        }
        
        // If the hp of the enemy reaches 0
        if (hp <= 0){
            //Calls removeObejct method in manager class
            manager.removeObject(this);
            Game.kills += 1;
        }
    }
    
    //render method
    public void render(Graphics graphics) {
        graphics.drawImage(ghost, x, y, null);
    }

    //getBounds method
    public Rectangle getBounds() { 
        return new Rectangle(x, y, 32, 32);
    }
    
    //getBoundsBig method
    public Rectangle getBoundsBig() {
        return new Rectangle(x - 16, y - 16, 64, 64);
    }
}
