
package chickengame.objects;

import chickengame.framework.GameObject;
import chickengame.framework.ObjectId;
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


public class Points extends GameObject
{
    private BufferedImage points;
    private Handler handler;
    private int timer = 0;
    private int total_point = 0;
    private int size;
    
    public Points(int x, int y, Handler handler, ObjectId id, int size)
    {
        super(x, y, id);
        this.handler = handler;
        this.size = size;
        
        try
        {
            if(size == 2)
                points = ImageIO.read(getClass().getResource("/5points.png"));
            
            if(size == 1)
                points = ImageIO.read(getClass().getResource("/10points.png"));
            
            if(size == 0)
                points = ImageIO.read(getClass().getResource("/15points.png"));
            
        } 

        catch (IOException ex)
        {
            Logger.getLogger(Chicken.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public int getPoint()
    {
        return total_point;
    }

    public void addPoint(int p)
    {
        total_point += p;
    }
    
    
    @Override
    public void tick(LinkedList<GameObject> object)
    {
        if(timer != -1)
            timer++;
        
        else
        {
            handler.removeObject(this);
        }

    }

    @Override
    public void render(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        
        if(timer != 100)
            g2d.drawImage(points, x, y, null);
        
        else
        {   
            timer = -1;
        }
    }
    

    @Override
    public Rectangle getBounds()
    {
        return null;
    }
    
}
