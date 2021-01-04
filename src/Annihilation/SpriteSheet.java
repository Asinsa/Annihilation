package Annihilation;

// All the libraries that are required
import java.awt.image.BufferedImage;

/**
 * @author Asinsa
 */

public class SpriteSheet {
    
    //Calls BufferedImage class
    private BufferedImage image;
    
    //SpriteSheet method
    public SpriteSheet(BufferedImage image){
        this.image = image;
    }
    
    //getImage method
    public BufferedImage getImage(int column, int row, int width, int height){
        return image.getSubimage((column*32)-32, (row*32)-32, width, height);
    }
}
