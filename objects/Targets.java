
package chickengame.objects;

import chickengame.framework.GameObject;
import chickengame.framework.ObjectId;
import chickengame.window.Background;
import chickengame.window.Handler;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Targets extends GameObject
{
    private int width, height;
    private Handler handler;
    private int size;
    private Points points;
    private Background background;
    private static int shoot = 0;
    private BufferedImage targets;
    private static int level_tracker = 1;

    public Targets(int x, int y, Handler handler, ObjectId id, Background background, int size)
    {
        super(x, y, id);
        this.handler = handler;
        this.background = background;
        this.size = size;
        
        try
        {
            if(size == 0)
                targets = ImageIO.read(getClass().getResource("/liltarget.png"));
            
            if(size == 1)
                targets = ImageIO.read(getClass().getResource("/targets.png"));
            
            if(size == 2)
                targets = ImageIO.read(getClass().getResource("/bigtarget.png"));
            
        } 
            
        catch (IOException ex)
        {
            Logger.getLogger(Background.class.getName()).log(Level.SEVERE, null, ex);
        }            
        
        this.width = targets.getWidth();
        this.height = targets.getHeight();
        
    }

    @Override
    public void tick(LinkedList<GameObject> object)
    {
        if(shoot >= 200)
            handler.removeObject(this);
        
        
        y -= velY;
       
        
        collision(object);
        

    }
    
    @Override
    public void render(Graphics g)
    {

        Graphics2D g2d = (Graphics2D) g;

        if(size == 0 || size == 1)
            g2d.drawImage(targets, x, y, null);
        
        if(size == 2)
        {
            if(x == 50)
                g2d.drawImage(targets, x, y, null);
            
            if(x == 425)
                g2d.drawImage(targets, x-25, y, null);
        }
            
        
        
    }
    
    
    @Override
    public Rectangle getBounds()
    {
        return (new Rectangle(x , y + (height / 4) + 2, width, height - (height / 4) - 5));
    }

    private void collision(LinkedList<GameObject> object)
    {
        for(int i = 0; i < handler.object.size(); i++)
        {
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getObjectId() == ObjectId.Eggs)
            {
                if(getBounds().intersects(tempObject.getBounds()))
                {
                    points = new Points(x-2, y, handler, ObjectId.Points, size);
                    
                    if(size == 2)
                        shoot += 5;
                    
                    if(size == 1)
                        shoot += 10;
                    
                    if(size == 0)
                        shoot += 15;
                    
                    handler.addObject(points);
                    System.out.println(shoot);
                    handler.removeObject(this);
                    handler.removeObject(tempObject);
                    if(shoot >= 200)
                    {
                        
                        handler.removeObject(points);
                        background.setLevel(++level_tracker);
                        System.out.println(level_tracker);
                        shoot = 0;
                    }
                }
               
            }    
        }
    }
    
    public int getShoot()
    {
        return shoot;
    }

    
   
    
}