
package chickengame.window;


import chickengame.framework.GameObject;
import chickengame.framework.KeyInput;
import chickengame.framework.ObjectId;
import chickengame.objects.Cat;
import chickengame.objects.Chicken;
import chickengame.objects.Points;
import chickengame.objects.Targets;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.Random;


public class Game extends Canvas implements Runnable
{
    public static int game_WIDTH;
    public static int game_HEIGHT;
    private boolean running = false;
    private Thread thread;
    private int cat_counter = 0;
    private int target_counter = 0;
    private int range_y = 600 - 350 + 1;
 
    private Handler handler; // Objects
    private Background back_ground = new Background(0);

    private Random r = new Random();
    private Points points;


    private void init()
    {
        game_WIDTH = getWidth();
        game_HEIGHT = getHeight();

        
        handler = new Handler();
        
        
        back_ground = new Background(0);

        
        handler.addObject(new Chicken(235, 300, handler, ObjectId.Chicken, back_ground));
        

        this.addKeyListener(new KeyInput(handler, back_ground));
  
    }
      
    private void tick()
    {
        if(back_ground.getLevel() == -1 || back_ground.getLevel() == 4)
        {
            for(int j = 0; j < handler.object.size(); j++)
            {
                GameObject tempObject = handler.object.get(j);
                handler.removeObject(tempObject);
            }
        }
          
        if(back_ground.getLevel() != 0 && back_ground.getLevel() != -1 && back_ground.getLevel() != 4)
        {
            if(back_ground.getLevel() == 1)
            {
                if(cat_counter % 557 == 0)
                {
                    Cat cat1 = new Cat(0, r.nextInt(range_y) + 350 , ObjectId.Cat);
                    cat1.setFace(1);
                    handler.addObject(cat1);

                    if(cat1.getY() > 700 || cat1.getY() < 0)
                        handler.removeObject(cat1);

                }

                if(cat_counter % 769 == 0)
                {
                    Cat cat2 = new Cat(500, r.nextInt(range_y) + 350, ObjectId.Cat);
                    cat2.setFace(-1);
                    handler.addObject(cat2);

                    if(cat2.getY() > 700 || cat2.getY() < 0)
                        handler.removeObject(cat2);
                }

                if(target_counter % 317 == 0)
                {
                    Targets target1 = new Targets(50, 800, handler, ObjectId.Targets, back_ground, r.nextInt(3));
                    Targets target2 = new Targets(425, 900, handler, ObjectId.Targets, back_ground, r.nextInt(3));
                    target1.setVelY(1);
                    target2.setVelY(1);
                    handler.addObject(target1);
                    handler.addObject(target2);

                }
            }
            
            if(back_ground.getLevel() == 2)
            {
                
                if(cat_counter % 599 == 0)
                {
                    Cat cat1 = new Cat(0, r.nextInt(range_y) + 350 , ObjectId.Cat);
                    cat1.setFace(1);
                    cat1.setVelX(2);
                    handler.addObject(cat1);

                    if(cat1.getY() > 700 || cat1.getY() < 0)
                        handler.removeObject(cat1);

                }

                if(cat_counter % 787 == 0)
                {
                    Cat cat2 = new Cat(500, r.nextInt(range_y) + 350, ObjectId.Cat);
                    cat2.setFace(-1);
                    cat2.setVelX(2);
                    handler.addObject(cat2);

                    if(cat2.getY() > 700 || cat2.getY() < 0)
                        handler.removeObject(cat2);
                }

                if(target_counter % 421 == 0)
                {
                    Targets target1 = new Targets(50, 800, handler, ObjectId.Targets, back_ground, r.nextInt(3));
                    Targets target2 = new Targets(425, 1000, handler, ObjectId.Targets, back_ground, r.nextInt(3));
                    target1.setVelY(1);
                    target2.setVelY(1);
                    handler.addObject(target1);
                    handler.addObject(target2);
                }                
            }
            
            if(back_ground.getLevel() == 3)
            {

                if(cat_counter % 599 == 0)
                {
                    Cat cat1 = new Cat(0, r.nextInt(range_y) + 350 , ObjectId.Cat);
                    cat1.setFace(1);
                    cat1.setVelX(3);
                    handler.addObject(cat1);

                    if(cat1.getY() > 700 || cat1.getY() < 0)
                        handler.removeObject(cat1);

                }

                if(cat_counter % 691 == 0)
                {
                    Cat cat2 = new Cat(500, r.nextInt(range_y) + 350, ObjectId.Cat);
                    cat2.setFace(-1);
                    cat2.setVelX(3);
                    handler.addObject(cat2);

                    if(cat2.getY() > 700 || cat2.getY() < 0)
                        handler.removeObject(cat2);
                }

                if(target_counter % 421 == 0)
                {
                    Targets target1 = new Targets(50, 900, handler, ObjectId.Targets, back_ground, r.nextInt(3));
                    Targets target2 = new Targets(425, 1200, handler, ObjectId.Targets, back_ground, r.nextInt(3));
                    target1.setVelY(2);
                    target2.setVelY(2);
                    handler.addObject(target1);
                    handler.addObject(target2);

                }

            }


            handler.tick(); // Easily updates all objects in the game.


            cat_counter++;
            target_counter++;
            
            if(back_ground.timer > 0)
            {
                back_ground.timer++;
            }
                
            
            if(back_ground.timer == 100)
            {
                back_ground.timer = 0;
            }
                
        }

    }
    
    private void render()//Graphical stuffs
    {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null)
        {
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) g;
        
        //_________________________________________________________drawing the game
        
        
        g.setColor(Color.black);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        g2d.drawImage(back_ground.getImage(), 0, 0, game_WIDTH, game_HEIGHT, 0, (int)back_ground.getNY1(), game_WIDTH, (int)back_ground.getNY2(), null);

        
        g2d.drawImage(back_ground.cloud1, (int)back_ground.cloudx1, -50, null);
        g2d.drawImage(back_ground.cloud1, (int)back_ground.cloudx2, -50, null);
        g2d.drawImage(back_ground.cloud1, (int)back_ground.cloudx3, -50, null);
        g2d.drawImage(back_ground.cloud1, (int)back_ground.cloudx4, -50, null);
        
        if(back_ground.timer > 0)
            g2d.drawImage(back_ground.level_label,150 ,250, null);
        
        back_ground.moveBackground();
        back_ground.moveCloud();
        
        if(back_ground.getLevel() != 0)
            handler.render(g);

        //_________________________________________________________drawing ends
        
        
        g.dispose();
        
        bs.show();
        
    }
    
    public synchronized void start()
    {
        if(running)
            return;
        
        running = true;
        thread = new Thread(this);
        thread.start();
        
        
    }
    
  
    @Override
    public void run() // This function runs the game and refreshs the scene in every second.
    {
        init();
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        
        while(running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            
            while(delta >= 1)
            {
                tick();
                updates++;
                delta--;
            }
            
            render();
            frames++;
            
            if(System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                frames = 0;
                updates = 0;
            }

        }
    }
  
    
    public static void main(String args[])
    {
        new Window(500, 700, "Chicken Game", new Game());
    }
    
    
}
