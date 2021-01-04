package Annihilation;

// All the libraries that are required
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @author Asinsa
 */

public class ImageLoader {
    
    //Calls BufferedImage class
    public BufferedImage Image;
    
    //loadImage method
    public BufferedImage loadImage(String path){
        try {
            Image = ImageIO.read(getClass().getResource(path));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return Image;
    }
}
