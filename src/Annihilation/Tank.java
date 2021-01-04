package Annihilation;

// All the libraries that are required
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;

/**
 * @author Asinsa
 */

public class Tank extends GameObject {

    //Calls Manager class
    Manager manager;
    //Calls Game class
    Game game;
    //Calls BufferedImage class
    private BufferedImage tank;
    double mouseX = 1;
    double mouseY = 1;
    private int initialX = 0;
    private int initialY = 0;

    //Tank method
    public Tank(int x, int y, ID id, Manager manager, Game game, SpriteSheet spritesheet) {
        super(x, y, id, spritesheet);
        this.manager = manager;
        this.game = game;
        //Calls getImage method in SpriteSheet class
        tank = spritesheet.getImage(1, 1, 32, 41);
        initialX = x;
        initialY = y;
    }

    //tick method
    public void tick() {
        x += velX;
        y += velY;

        //Calls collision method
        collision();

        //Moving upwards
        if(manager.isUp()){
            velY = -5;
        }
        else if (!manager.isDown()){
            velY = 0;
        }

        //Moving downwards
        if(manager.isDown()){
            velY = 5;
        }
        else if (!manager.isUp()){
            velY = 0;
        }

        //Moving left
        if(manager.isLeft()){
            velX = -5;
        }
        else if (!manager.isRight()){
            velX = 0;
        }

        //Moving right
        if(manager.isRight()){
            velX = 5;
        }
        else if (!manager.isLeft()){
            velX = 0;
        }
    }

    //collision method
    public void collision(){
        for (int i = 0; i < manager.object.size(); i++){
            GameObject tempObject = manager.object.get(i);

            if(tempObject.getId() == ID.Block){
                if (getBounds().intersects(tempObject.getBounds())){
                    x += velX * -1;
                    y += velY * -1;
                }
            }

            // If supply kit touched
            if(tempObject.getId() == ID.SupplyKit){
                if (getBounds().intersects(tempObject.getBounds())){
                    game.ammo = 100;
                    game.health = 100;
                    //Calls removeObejct method in manager class
                    manager.removeObject(tempObject);
                }
            }

            // If enemy ghosts touched by tank
            if(tempObject.getId() == ID.EnemyGhost){
                if (game.health > 0){
                    if (getBounds().intersects(tempObject.getBounds())){
                        game.health -= 1;
                    }
                }
                else{
                    Object[] options = {"Retry", "Exit"};
                    int choice = JOptionPane.showOptionDialog(null,
                            "You ran out of health and got killed by the enemy ghosts",
                            "You died",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.ERROR_MESSAGE,
                            null,
                            options,
                            options[1]);
                    if (choice == 0){
                        game.ammo = 100;
                        game.health = 100;
                        x = initialX;
                        y = initialY;
                        game.kills = 0;
                    }
                    else{
                        System.exit(0);
                    }
                }
            }
            
            // If mission is complete
            if (UserData.Level.equals(1) && Game.kills == 5) {
                Object[] options = {"Next Level", "Exit"};
                int choice = JOptionPane.showOptionDialog(null,
                    "You successfully completed the mission!",
                    "Mission Complete",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.ERROR_MESSAGE,
                    null,
                    options,
                    options[1]);
                    if (choice == 0){
                        UserData.Level += 1;
                        JOptionPane.showMessageDialog(null, "Successfully "
                                + "ranked up to Corporal");
                    }
                    else{
                        System.exit(0);
                    }
            }
        }
    }

    //update method
    public void update(){
        while (mouseX != 0 && mouseY != 0){
            mouseX = MouseInfo.getPointerInfo().getLocation().getX();
            mouseY = MouseInfo.getPointerInfo().getLocation().getY();
            System.out.println(mouseX);
            System.out.println(mouseY);
        }
    }

    //render method
    public void render(Graphics graphics) {
        graphics.drawImage(tank, x, y, null);
    }

    //getBounds method
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 48);
    }
}
