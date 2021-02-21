
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


public class Chicken extends GameObject
{
    private int width, height;
    private Handler handler;
    private BufferedImage chickenright, chickenleft;
    private Background background;
    boolean delete_game = false;
    
    public Chicken(int x, int y, Handler handler, ObjectId id, Background background)
    {
        super(x, y, id);
        
        this.handler = handler;
        this.background = background;

        try
        {
            chickenright = ImageIO.read(getClass().getResource("/chicken.png"));
            chickenleft = ImageIO.read(getClass().getResource("/chickenleft.png"));
        } 
        
        catch (IOException ex)
        {
            Logger.getLogger(Chicken.class.getName()).log(Level.SEVERE, null, ex);
        }


        width = chickenright.getWidth();
        height = chickenright.getHeight();

    }

    @Override
    public void tick(LinkedList<GameObject> object)
    {
        if(x > 0 && x < 463)
        {
            x += velX;
        }
        
        else
        {
            if(x <= 0)
                x = 1;


            if(x >= 463)
                x = 462;
               
        }
        
        if(velX < 0)
            face = -1;
        
        else if(velX > 0)
            face = 1;

        collision(object);
    }

    @Override
    public void render(Graphics g)
    {
        
        Graphics2D g2d = (Graphics2D) g;

        if(face == 1)
            g2d.drawImage(chickenright, x, y, null);
        
        else
            g2d.drawImage(chickenleft, x, y, null);

        
    }

    
    @Override
    public Rectangle getBounds()
    {
        return (new Rectangle(x, y + (height/4) - 5, width, height/2 + 20));
    }
    
    
    private void collision(LinkedList<GameObject> object)
    {
        for(int i = 0; i < handler.object.size(); i++)
        {
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getObjectId() == ObjectId.Cat)
            {
                if(getBounds().intersects(tempObject.getBounds()))
                {
                    background.setDY(0);
                    background.setNY1(0);
                    background.setNY2(background.IMG_HEIGHT);
                    velX = 0;
                    background.setLevel(-1);
                    delete_game = true;
                    
                }
               
            }    
        }

    }
    
    public BufferedImage getImage()
    {
        return chickenright;
    }
    
    
    
}
