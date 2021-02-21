
package chickengame.window;

import chickengame.framework.GameObject;
import chickengame.framework.ObjectId;
import java.awt.Graphics;
import java.util.LinkedList;


public class Handler // This class holds all the object that have been created in the game, so we can keep track of them in an efficient way.
{
    public LinkedList<GameObject> object = new LinkedList<GameObject>(); //We keep GameObjects in a linked list.
    
    private GameObject tempObject;
    
    //Our aim is rendering and ticking the list, so we need tick and render functions.
    
    public void tick()
    {
        for(int i = 0; i < object.size(); i++)
        {
            tempObject = object.get(i); // We initialize the temp object with the i-th element, which is where the current point is, of linked list.
            tempObject.tick(object); // This line calls the GameObject's tick function and updates the current object.
        } // With this for loop, we update every single object in our game.
    }
    
    public void render(Graphics g) // Same idea with the tick function, difference is render function draws every object in the game.
    {
        for(int i = 0; i < object.size(); i++)
        {
            tempObject = object.get(i); 
            tempObject.render(g); 
        } 
    }
    
    public void addObject(GameObject object) // We add new object to list by using this function.
    {
        this.object.add(object); 
    }
    
    public void removeObject(GameObject object) // We delete selected object from list by using this function.
    {
        this.object.remove(object); 
    }
    

}
