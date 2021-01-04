package Annihilation;

// All the libraries that are required
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * @author Asinsa
 */

public abstract class GameObject {

    //Position
    protected int x, y;
    
    //Speed
    protected float velX = 0, velY = 0;
    protected ID id;
    //Calls SpriteSheet class
    protected SpriteSheet spritesheet;
    
    //GameObject method
    public GameObject(int x, int y, ID id, SpriteSheet spritesheet) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.spritesheet = spritesheet;
    }

    //tick method
    public abstract void tick();

    //render method
    public abstract void render(Graphics graphics);

    //getBounds method
    public abstract Rectangle getBounds();
    
    //getId method
    public ID getId() {
        return id;
    }

    //setId method
    public void setId(ID id) {
        this.id = id;
    }

    //getX method
    public int getX() {
        return x;
    }

    //setX method
    public void setX(int x) {
        this.x = x;
    }

    //getY method
    public int getY() {
        return y;
    }

    //setY method
    public void setY(int y) {
        this.y = y;
    }

    //getVelX method
    public float getVelX() {
        return velX;
    }

    //setVelX method
    public void setVelX(float velX) {
        this.velX = velX;
    }

    //getVelY method
    public float getVelY() {
        return velY;
    }

    //setVelY method
    public void setVelY(float velY) {
        this.velY = velY;
    }
}
