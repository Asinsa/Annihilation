package Annihilation;

/**
 * @author Asinsa
 */

public class Camera {

    private float x, y;

    //Camera method
    public Camera(float x, float y) {
        this.x = x;
        this.y = y;
    }

    //tick method
    public void tick(GameObject object) {
        x += ((object.getX() - x) - 1378/2) * 0.05f;
        y += ((object.getY() - y) - 734/2) * 0.05f;
        
        if (x <= 0) {
            x = 0;
        }
        if (x >= 850) {
            x = 850;
        }
        if (y <= 0) {
            y = 0;
        }
        if (y >= 585) {
            y = 585;
        }
    }
    
    //getX method
    public float getX() {
        return x;
    }

    //setX method
    public void setX(float x) {
        this.x = x;
    }

    //getY method
    public float getY() {
        return y;
    }

    //setY method
    public void setY(float y) {
        this.y = y;
    }
}
