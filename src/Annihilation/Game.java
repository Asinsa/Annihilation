package Annihilation;

// All the libraries that are required
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * @author Asinsa
 */

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;
    private boolean isRunning = false;
    private Thread thread;
    //Calls Manager class
    private Manager manager;
    //Calls SpriteSheet class
    private SpriteSheet spritesheet;
    //Calls BufferedImage class
    private BufferedImage floor = null;
    private BufferedImage map = null;
    private BufferedImage spriteSheet = null;
    //Calls Camera class
    private Camera camera;
    public int ammo = 100;
    public int health = 100;
    public static int kills = 0;

    //Game method
    public Game() {
        //New instance of the class GameWindow is created
        new GameWindow(1378, 734, Missions.Rank, this);
        start();
        //New instance of the class Manager is created
        manager = new Manager();
        //New instance of the class Camera is created
        camera = new Camera(0,0);
        this.addKeyListener(new KeysToMove(manager));
        //New instance of the class ImageLoader is created
        ImageLoader imageLoader = new ImageLoader();
        //Calls loadImage method in imageLoader class
        map = imageLoader.loadImage("/Level1Map.png");
        //Calls loadImage method in imageLoader class
        spriteSheet = imageLoader.loadImage("/SpriteSheet.png");
        //New instance of the class SpriteSheet is created
        spritesheet = new SpriteSheet(spriteSheet);
        //Calls getImage method in SpriteSheet class
        floor = spritesheet.getImage(2, 2, 32, 32);
                
        this.addMouseListener(new KeysToShoot(manager, camera, this, spritesheet));
        //Calls loadMap method
        loadMap(map);    
    }

    //start method
    private void start() {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    //stop method
    private void stop() {
        isRunning = false;
        try{
            thread.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //run method
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frames = 0;
            }
        }
        stop();
    }

    //tick method
    public void tick() {
        for (int i = 0; i < manager.object.size(); i++) {
            if (manager.object.get(i).getId() == ID.Tank) {
                camera.tick(manager.object.get(i));
            }
        }
        manager.tick();
    }

    //render method
    public void render() {
        BufferStrategy bufferStategy = this.getBufferStrategy();
        if (bufferStategy == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics graphics = bufferStategy.getDrawGraphics();
        Graphics2D graphics2D = (Graphics2D) graphics;
        
        graphics2D.translate(-camera.getX(),-camera.getY());
        for (int xx = 0; xx < 2160; xx += 32){
            for (int yy = 0; yy < 2160; yy += 32){
                graphics.drawImage(floor, xx, yy, null);
            }
        }
        
        manager.render(graphics);
        
        graphics2D.translate(camera.getX(),camera.getY());
        
        // Ammo Bar
        graphics.setColor(Color.GRAY);
        graphics.fillRect(5,630,400,25);
        graphics.setColor(Color.YELLOW);
        graphics.fillRect(5,630,ammo*4,25);
        graphics.setColor(Color.BLACK);
        graphics.drawRect(5,630,400,25);
        graphics.drawString("Ammo: " + ammo + "%", 10, 648);
        
        // Health Bar
        graphics.setColor(Color.GRAY);
        graphics.fillRect(5,665,400,25);
        graphics.setColor(Color.GREEN);
        graphics.fillRect(5,665,health*4,25);
        graphics.setColor(Color.BLACK);
        graphics.drawRect(5,665,400,25);
        graphics.drawString("Health: " + health + "%", 10, 683);
        
        // Kill Count
        graphics.setColor(Color.BLACK);
        graphics.fillRect(1259,637,90,50);
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
        graphics.drawString("👻: " + Integer.toString(kills), 1265, 672);
     
        graphics.dispose();
        bufferStategy.show(); 
    }
    
    //Loading the map
    //loadMap method
    private void loadMap(BufferedImage image){
        int width = image.getWidth();
        int height = image.getHeight();
        
        for (int xx = 0; xx < width; xx++){
            for (int yy = 0; yy < height; yy++){
                int pixel = image.getRGB(xx, yy);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;
                
                if (red == 255 && green == 0 && blue == 0){
                    //New instance of Block is created
                    manager.addObject(new Block(xx*32, yy*32, ID.Block, spritesheet));
                }
                
                if (red == 0 && green == 0 && blue == 255){
                    //New instance of Tank is created
                    manager.addObject(new Tank(xx*32, yy*32, ID.Tank, manager, this, spritesheet));
                }
                
                if (red == 0 && green == 255 && blue == 0){
                    //New instance of EnemyGhost is created
                    manager.addObject(new EnemyGhost(xx*32, yy*32, ID.EnemyGhost, manager, spritesheet));
                }
                
                if (red == 255 && green == 0 && blue == 255){
                    //New instance of SupplyKit is created
                    manager.addObject(new SupplyKit(xx*32, yy*32, ID.SupplyKit, spritesheet));
                }
            }
        }
    }

    public static void main(String args[]) {
        new Game();
    }
}
