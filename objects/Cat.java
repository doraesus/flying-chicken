
package chickengame.objects;

import chickengame.framework.GameObject;
import chickengame.framework.ObjectId;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


public class Cat extends GameObject
{
    private int width, height;
    private BufferedImage catleft, catright;

    public Cat(int x, int y, ObjectId id)
    {
        super(x, y, id);
        
        this.velX = 1;
        
        try
        {
            catleft = ImageIO.read(getClass().getResource("/cat.png"));
        } 
        
        catch (IOException ex)
        {
            Logger.getLogger(Chicken.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try
        {
            catright = ImageIO.read(getClass().getResource("/catright.png"));
        } 
        
        catch (IOException ex)
        {
            Logger.getLogger(Chicken.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        width = catleft.getWidth();
        height = catleft.getHeight();
        
    }

    @Override
    public void tick(LinkedList<GameObject> object)
    {
        if(face == 1)
        {
            x += velX;
        }
           
        
        if(face == -1)
        {
            x -= velX; 
        }
    
        y--;
    }

    @Override
    public void render(Graphics g)
    {

        Graphics2D g2d = (Graphics2D) g;

        
        if(face == 1)
            g2d.drawImage(catright, x, y, null);
        
        else
            g2d.drawImage(catleft, x, y, null);
        
        
    }

    @Override
    public Rectangle getBounds()
    {
        return (new Rectangle(x, y + (height/2) - 10, width, height/2));
    }

}
