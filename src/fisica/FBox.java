package fisica;

import org.jbox2d.common.*;
import org.jbox2d.collision.*;
import org.jbox2d.collision.shapes.*;
import org.jbox2d.dynamics.*;

import processing.core.*;

public class FBox extends FBody {
  float m_height;
  float m_width;

  /**
   * Represents a rectangular body that can be added to an FWorld.  Represents a circular body that can be added to an FWorld.  This body has the same properties as {@link FBody FBody}.
   *
   * {@code
   FBox myBox = new FBox(40, 20);
   world.add(myBox);
   * }
   *
   * @usage Bodies
   * @related FCircle
   * @param width  the width of the rectangle
   * @param height  the height of the rectangle
   */
  public FBox(float width, float height){
    super();
    
    m_height = Fisica.screenToWorld(height);
    m_width = Fisica.screenToWorld(width);
  }

  /**
   * Returns the height of the rectangle.
   *
   * @usage Bodies
   * @related getHeight
   * @returns the height of the rectangle
   */  
  public float getHeight(){ 
    // only for FBox
    return Fisica.worldToScreen(m_height);
  }

  /**
   * Returns the width of the rectangle.
   *
   * @usage Bodies
   * @related getWidth
   * @returns the width of the rectangle
   */  
  public float getWidth(){
    // only for FBox
    return Fisica.worldToScreen(m_width);
  }  

  public ShapeDef getShapeDef() {
    PolygonDef pd = new PolygonDef();
    pd.setAsBox(m_width/2.0f, m_height/2.0f);
    pd.density = m_density;
    pd.friction = m_friction;
    pd.restitution = m_restitution;
    pd.isSensor = m_sensor;
    return pd;
  }
  
  public void draw(PApplet applet) {
    preDraw(applet);

    if (m_image != null ) {
      drawImage(applet);
    } else {
      applet.rect(0, 0, getWidth(), getHeight());
    }
    
    postDraw(applet);
  }
  
}
