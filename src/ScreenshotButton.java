//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: ScreenshotButton.java
///////////////////////////////////////////////////////////////////////////////

import processing.core.PApplet;

/**
 * This class models a screenshot game button in the cs300 spring 2022 p05 Treasure Hunt adventure
 * style game application
 * 
 * @author Marin Suzuki Xingzhen cai
 */
public class ScreenshotButton extends Button {

  /**
   * Creates a new ScreenshotButton object labeled "Take a screenshot" at a specific position on the
   * screen
   * 
   * @param x - x-position to be assigned to this screenshot button
   * @param y - y-position to be assigned to this screenshot button
   * 
   */
  public ScreenshotButton(int xPosition, int yPosition) {
    super("Take a screenshot", xPosition, yPosition);
  }

  /**
   * Defines the behavior of this button when the mouse is pressed. When it is clicked, this button
   * takes a screenshot of the game screen. This method calls the PApplet.save() method to save the
   * screenshot with the filename "screenshot.png"
   */
  @Override
  public void mousePressed() {
    if (isMouseOver()) {
      processing.save("screenshot.png");
    }
  }
}
