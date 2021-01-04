package Annihilation;

// All the libraries that are required
import java.awt.Graphics;
import java.util.LinkedList;

/**
 * @author Asinsa
 */

public class Manager {

    //Makes new linked list called object
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    
    private boolean up = false;
    private boolean down = false;
    private boolean right = false;
    private boolean left = false;

    //tick method
    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.tick();
        }
    }

    //render method
    public void render(Graphics graphics) {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.render(graphics);
        }
    }

    //addObject method
    public void addObject(GameObject tempObject) {
        object.add(tempObject);
    }

    //removeObject method
    public void removeObject(GameObject tempObject) {
        object.remove(tempObject);
    }
    
    //isUp method
    public boolean isUp() {
        return up;
    }

    //setUp method
    public void setUp(boolean up) {
        this.up = up;
    }

    //isDown method
    public boolean isDown() {
        return down;
    }

    //setDown method
    public void setDown(boolean down) {
        this.down = down;
    }

    //isRight method
    public boolean isRight() {
        return right;
    }

    //setRight method
    public void setRight(boolean right) {
        this.right = right;
    }

    //isLeft method
    public boolean isLeft() {
        return left;
    }

    //setLeft method
    public void setLeft(boolean left) {
        this.left = left;
    }
}
