
package chickengame.framework;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;


public abstract class GameObject
{
    protected int x, y;
    protected int velX = 0, velY = 0;
    protected ObjectId id;
    protected int face = 1;
    
    public GameObject(int x, int y, ObjectId id)
    {
        this.x = x;
        this.y = y;
        this.id = id;
    }
    
    public abstract void tick(LinkedList<GameObject> object);
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();
    
    public int getX()
    {
        return this.x;
    }
    
    public int getY()
    {
        return this.y;
    }
    
    public int getVelX()
    {
        return this.velX;
    }
    
    public int getVelY()
    {
        return this.velY;
    }
    
    public int getFace()
    {
        return face;
    }
    
    public void setFace(int f)
    {
        face = f;
    }
    
    public ObjectId getObjectId()
    {
        return this.id;
    }
    
    public void setX(int x)
    {
        this.x = x;
    }
    
    public void setVelX(int velx)
    {
        this.velX = velx;
    }
    
    public void setVelY(int vely)
    {
        this.velY = vely;
    }
    
    
    public void setY(int y)
    {
        this.y = y;
    }
    
    
    
    
}
