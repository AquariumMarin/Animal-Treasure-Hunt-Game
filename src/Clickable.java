//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Clickable.java
// Course: CS 300 Spring 2022
//
// Author: Marin Suzuki
// Email: msuzuki9@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Xingzhen cai
// Partner Email: xcai79@wisc.edu
// Partner Lecturer's Name: Hobbes LeGault
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X_ Write-up states that pair programming is allowed for this assignment.
// _X_ We have both read and understand the course Pair Programming Policy.
// _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: None
// Online Sources: None
//
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
