package Annihilation;

// All the libraries that are required
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * @author Asinsa
 */

public class Block extends GameObject {
    
    //Calls BufferedImage class
    private BufferedImage walls;

    //Block method
    public Block(int x, int y, ID id, SpriteSheet spritesheet) {
        super(x, y, id, spritesheet);
        //Calls getImage method in SpriteSheet class
        walls = spritesheet.getImage(3, 2, 32, 32);
    }

    //tick method
    public void tick() {
    }

    //render method
    public void render(Graphics graphics) {
        graphics.drawImage(walls, x, y, null);
    }

    //getBounds method
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }
}
