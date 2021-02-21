
package chickengame.objects;

import chickengame.framework.GameObject;
import chickengame.framework.ObjectId;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;



public class Eggs extends GameObject
{

    public Eggs(int x, int y, ObjectId id, int vel)
    {
        super(x, y, id);
        this.velX = vel;
    }

    @Override
    public void tick(LinkedList<GameObject> object)
    {
        x += velX;
    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.yellow);
        
        if(velX > 0)
            g.fillOval(x + 30, y + 12, 20, 15);
        else
            g.fillOval(x - 5, y + 12, 20, 15);
        
       
        Graphics2D g2d = (Graphics2D) g;

    }

    @Override
    public Rectangle getBounds()
    {
        if(velX > 0)
            return (new Rectangle(x + 30, y + 12, 20, 15));
        
        else
            return (new Rectangle(x - 5, y + 12, 20, 15));
    }
    
}
