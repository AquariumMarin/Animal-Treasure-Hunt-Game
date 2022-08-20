//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: DraggableObject.java
// Course: CS 300 Spring 2022
//
// Author: Marin Suzuki
// Email: msuzuki9@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Xingzhen Cai
// Partner Email: xcai79@wisc.edu
// Partner Lecturer's Name: Hobbes LeGault
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X__ Write-up states that pair programming is allowed for this assignment.
// _X__ We have both read and understand the course Pair Programming Policy.
// _X__ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: None
// Online Sources: None
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class models interactive objects which can be dragged in the screen.
 * 
 * @author Marin Suzuki & Xingzhen Cai
 */
public class DraggableObject extends InteractiveObject {

  private boolean isDragging; // indicates whether this object is being dragged or not
  private int oldMouseX; // old x-position of the mouse
  private int oldMouseY; // old y-position of the mouse
  protected int marin = 1;

  /**
   * Creates a new Draggable object with a given name, x and y position, and "Drag Me!" as a default
   * message. When created a new draggable object is NOT dragging.
   * 
   * @param name - name to be assigned to this draggable object
   * @param x    - x-position of this draggable object in the display window
   * @param y    - y-position of this draggable object in the display window
   */
  public DraggableObject(java.lang.String name, int x, int y) {

    super(name, x, y, "Drag Me!");
    this.isDragging = false;

  }

  /**
   * Creates a new Draggable object with a given name, x and y position, and a specific message.
   * When created a new draggable object is NOT dragging.
   * 
   * @param name    - name to be assigned to this draggable object
   * @param x       - x-position of this draggable object in the display window
   * @param y       - y-position of this draggable object in the display window
   * @param message - message to be displayed when this draggable object is clicked. We assume that
   *                message is VALID (meaning it is NOT null and NOT an empty string).
   */
  public DraggableObject(java.lang.String name, int x, int y, java.lang.String message) {

    super(name, x, y, message);
    this.isDragging = false;

  }

  /**
   * Checks whether this draggable object is being dragged.
   * 
   * @return true if this object is being dragged, false otherwise
   */
  public boolean isDragging() {
    return isDragging;
 
  }

  /**
   * Starts dragging this draggable object and updates the oldMouseX and oldMouseY positions to the
   * current position of the mouse.
   * 
   */
  public void startDragging() {
    isDragging = true;
    this.oldMouseX = processing.mouseX; // update position
    this.oldMouseY = processing.mouseY; // update position

  }

  /**
   * Stops dragging this draggable object
   * 
   */
  public void stopDragging() {
    isDragging = false;
  }

  /**
   * Draws this draggable object to the display window. If this object is dragging, this method sets
   * its position to follow the mouse moves. Then, it draws its image to the its current position.
   * 
   */
  @Override
  public void draw() {
    if (this.isDragging == true) {
      
      // old positions updated
      this.move​(processing.mouseX - this.oldMouseX, processing.mouseY - this.oldMouseY);
      
      this.startDragging();
      
    }
    super.draw(); // it draws its image to the its current position.

  }

  /**
   * Starts dragging this object when it is clicked (meaning when the mouse is over it).
   * 
   */
  @Override
  public void mousePressed() {
    if (isMouseOver() == true) { // when it is clicked
      this.startDragging();
    }
  }

  /**
   * Stops dragging this object if the mouse is released
   * 
   */
  @Override
  public void mouseReleased() {

    this.stopDragging();

  }

}

