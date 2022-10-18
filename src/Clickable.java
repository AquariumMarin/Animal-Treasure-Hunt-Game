//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Clickable.java
///////////////////////////////////////////////////////////////////////////////

/**
 * This class contains abstract method of draw(), mousePressed(), mouseReleased(), isMouseOver(). A
 * clickable object responds to the mouse being pressed (while it is over the object) and released.
 * All these objects are repeatedly drawn to the display window in different ways, and respond
 * differently to the mouse events (when the mouse is over them, pressed, or released).
 * 
 * @author Marin Suzuki & Xingzhen Cai
 */
public interface Clickable {

  /**
   * draws this Clickable object to the screen
   */
  public void draw();

  /**
   * defines the behavior of this Clickable object each time the mouse is pressed
   */
  public void mousePressed();

  /**
   * defines the behavior of this Clickable object each time the mouse is released
   */
  public void mouseReleased();

  /**
   * returns true if the mouse is over this clickable object, or false otherwise
   * 
   * @return returns true if the mouse is over this clickable object
   */
  public boolean isMouseOver();

}
