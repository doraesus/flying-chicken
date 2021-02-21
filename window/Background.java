
package chickengame.window;


import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Background {
    
    public static final int IMG_WIDTH = 500;
    public static final int IMG_HEIGHT = 700;
    private double ny1 = 0;
    private double ny2 = IMG_HEIGHT;
    private double dy;
    public int timer = 1;
    private int level;
    private BufferedImage background;
    protected BufferedImage cloud1, level_label;
    
    public double cloudx1 = -50, cloudx2 = 200, cloudx3 = 50, cloudx4 = 300, cloudCounter = 0;
    
    public Background(int level) 
    {
        this.level = level;
        
        
        if(level == 0)
        {
            try
            {
                background = ImageIO.read(getClass().getResource("/level0.jpg"));
            } 
            
            catch (IOException ex)
            {
                Logger.getLogger(Background.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        
    }

    public void moveBackground()
    {
        if(level != 0 && level != -1 && level != 4)
        {
            if (ny1 > IMG_HEIGHT ) 
            {
                ny1 = 0 ;
                ny2 = IMG_HEIGHT;
                
                
            } 
            
            else 
            {
                ny1 += dy;
                ny2 += dy;
            }
 
        }

    }
    
    public void moveCloud()
    {
        cloudCounter++;
        
        if(cloudCounter < 700)
        {
            cloudx1 = cloudx1 + 0.3;
            cloudx2 = cloudx2 - 0.3;
            cloudx3 = cloudx3 + 0.3;
            cloudx4 = cloudx4 - 0.3;
        }
            
        
        if(cloudCounter == 700)
        {
            cloudCounter = 1400;
        }
            
        
        if(cloudCounter > 1400)
        {
            cloudx1 = cloudx1 - 0.3;
            cloudx2 = cloudx2 + 0.3;
            cloudx3 = cloudx3 - 0.3;
            cloudx4 = cloudx4 + 0.3;
        }
            
        
        if(cloudCounter == 2100)
            cloudCounter = 0;
        
    }
    

    
    public void setLevel(int level)
    {
        this.level = level;
        
        if(level >= 1 && level <= 3)
        {
            try
            {
                background = ImageIO.read(getClass().getResource("/wallpaper.jpg"));
                cloud1 = ImageIO.read(getClass().getResource("/cloud.png"));
                
                if(level == 1)
                {
                    level_label = ImageIO.read(getClass().getResource("/level1logo.png"));
                    dy = 0.1;
                }
                    
                
                if(level == 2)
                {
                    level_label = ImageIO.read(getClass().getResource("/level2logo.png"));
                    timer = 1;
                    dy = 0.2;
                }
                    
                
                if(level == 3)
                {
                    level_label = ImageIO.read(getClass().getResource("/level3logo.png"));
                    timer = 1;
                    dy = 0.3;
                }
            
            } 
            
            catch (IOException ex)
            {
                Logger.getLogger(Background.class.getName()).log(Level.SEVERE, null, ex);
            }
            
          
        }

        
        if(level == -1)
        {
            try
            {
                background = ImageIO.read(getClass().getResource("/level-1.jpg"));
            } 
            
            catch (IOException ex)
            {
                Logger.getLogger(Background.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            cloud1 = null;

        }
        
        if(level == 4)
        {
            try
            {
                background = ImageIO.read(getClass().getResource("/level4.png"));
            } 
            
            catch (IOException ex)
            {
                Logger.getLogger(Background.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            timer = 0;
            cloud1 = null;
        }
        

    }
    
    public int getLevel()
    {
        return this.level;
    }
    
        
    public BufferedImage getImage()
    {
        return background;
    }
    
    public double getNY1()
    {
        return ny1;
    }
    
    public double getNY2()
    {
        return ny2;
    }    
        
    public double getDY()
    {
        return dy;
    }   
    
    public void setDY(double dy)
    {
        this.dy = dy;
    }  
    
    public void setNY1(double ny1)
    {
        this.ny1 = ny1;
    }  
    
    public void setNY2(double ny2)
    {
        this.ny2 = ny2;
    }  
    
    
}
