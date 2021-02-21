
package chickengame.framework;

import chickengame.objects.Eggs;
import chickengame.window.Background;
import chickengame.window.Handler;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter
{
    
    private Handler handler;
    private Background background;
    
    public KeyInput(Handler handler, Background background)
    {
        this.handler = handler;
        this.background = background;
    }
    
    
    @Override
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        if(background.getLevel() != 0)
        {
            for(int i = 0; i < handler.object.size(); i++)
            {
                GameObject tempObject = handler.object.get(i);

                if(tempObject.getObjectId() == ObjectId.Chicken)
                {
                    if(key == KeyEvent.VK_RIGHT)
                        tempObject.setVelX(5);

                    if(key == KeyEvent.VK_LEFT)
                        tempObject.setVelX(-5);

                    if(key == KeyEvent.VK_SPACE)
                        handler.addObject(new Eggs(tempObject.getX(), tempObject.getY(), ObjectId.Eggs, tempObject.getFace() * 5));

                }
            }            
        }
        
        if(background.getLevel() == 0)
        {
            if(key == KeyEvent.VK_ENTER)
                background.setLevel(1);
        }
        

        
    }
    
    @Override
    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        for(int i = 0; i < handler.object.size(); i++)
        {
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getObjectId() == ObjectId.Chicken)
            {
                if(key == KeyEvent.VK_RIGHT)
                    tempObject.setVelX(0);
                
                if(key == KeyEvent.VK_LEFT)
                    tempObject.setVelX(0);
              
            }
        }
        
    }
}
