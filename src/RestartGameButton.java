//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: RestartGameButton.java
///////////////////////////////////////////////////////////////////////////////

/**
 * This class models a restart game button in the cs300 spring 2022 p05 Treasure Hunt adventure
 * style game application
 * 
 * @author Marin Suzuki Xingzhen cai
 */
public class RestartGameButton extends Button {

  /**
   * Creates a new RestartGameButton object labeled "Restart Game" at a specific position on the
   * screen
   * 
   * @param x - x-position to be assigned to this restart game button
   * @param y - y-position to be assigned to this restart game button
   */
  public RestartGameButton(int xPosition, int yPosition) {
    super("Restart Game", xPosition, yPosition);
  }

  /**
   * Defines the behavior of this button when the mouse is pressed. This button initializes the game
   * if it is clicked (meaning if the mouse is over it)
   */
  @Override
  public void mousePressed() {
    if (isMouseOver()) {
      ((TreasureHunt) processing).initGame();
    }
  }
}
