package Annihilation;

// All the libraries that are required
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * @author Asinsa
 */

public class SupplyKit extends GameObject{
    
    //Calls BufferedImage class
    private BufferedImage supplyKit;

    //SupplyKit method
    public SupplyKit(int x, int y, ID id, SpriteSheet spritesheet) {
        super(x, y, id, spritesheet);
        //Calls getImage method in SpriteSheet class
        supplyKit = spritesheet.getImage(4, 2, 32, 32);
    }

    //tick method
    public void tick() {
    }

    //render method
    public void render(Graphics graphics) {
        graphics.drawImage(supplyKit, x, y, null);
    }
    
    //getBounds method
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }
}
