//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: InteractiveObject.java
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

import processing.core.PApplet;
import processing.core.PImage;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class represents the base class of all the interactive objects in our Treasure Hunt
 * adventure style game. A clickable interactive object can be displayed (drawn) to the display
 * window of this application and responds to the mouse clicks.
 * 
 * @author Marin Suzuki Xingzhen cai
 */
public class InteractiveObject implements Clickable {

  // reference to the PApplet where this object will be drawn
  protected static TreasureHunt processing;
  private final String NAME; // name of this interactive object
  protected PImage image; // reference to the image of this object
  private int x; // x-position of this interactive object in the screen
  private int y; // y-position of this interactive object in the screen
  // Note that the position (x,y) of the interactive object is the position
  // of the upper-left corner of its image (and NOT the center of the image).

  private boolean isActive; // tells whether or not this object is active
  private boolean wasClicked; // tells whether this object was already clicked
  private String message; // message to be displayed when this object is clicked
  private InteractiveObject nextClue; // Object to be activated when this object is
  // clicked the first time, if any

  /**
   * Creates a new interactive object with no next clue (nextClue == null) and sets its image, name,
   * x and y positions, its message, and activation status. When created, an interactive object must
   * be active, and not clicked yet.
   * 
   * @param name    - name to be assigned to this interactive object. We assume that name is VALID
   *                (not null and not equal to an empty string)
   * @param x       - x-position to be assigned to this interactive object
   * @param y       - y-position to be assigned to this interactive object
   * @param message - message to be displayed on the console each time this interactive object is
   *                clicked. We assume that message is VALID (not null and not equal to an empty
   *                string)
   */
  public InteractiveObject(java.lang.String name, int x, int y, java.lang.String message) {

    this.NAME = name;
    this.image = processing.loadImage("images" + File.separator + name + ".png");
    this.x = x;
    this.y = y;
    this.isActive = true;
    this.wasClicked = false;
    this.nextClue = null;
    this.message = message;

  }

  /**
   * Creates a new interactive object with a next clue (nextClue != null) to be activated when this
   * interactive object is clicked for the first time. This constructor sets the image of the newly
   * created interactive object, its name, x and y positions, its message, and activation status.
   * When created, an interactive object must be active, and not clicked yet. Also, this constructor
   * deactivates the next clue of this interactive object.
   * 
   * @param name     - name to be assigned to this interactive object. We assume that name is VALID
   *                 (not null and not equal to an empty string)
   * @param x        - x-position to be assigned to this interactive object
   * @param y        - y-position to be assigned to this interactive object
   * @param message  - message to be displayed on the console each time this interactive object is
   *                 clicked. We assume that message is VALID (not null and not equal to an empty
   *                 string)
   * @param nextClue - a reference to a non-null InteractiveObject which represents the next clue
   *                 associated to this interactive object.
   */
  public InteractiveObject(java.lang.String name, int x, int y, java.lang.String message,
      InteractiveObject nextClue) {
    this(name, x, y, message);
    if (this.wasClicked == false) { // clicked first time
      this.nextClue = nextClue;
      this.nextClue.deactivate();
    }
  }

  /**
   * Gets the x-position of this interactive object
   * 
   * @return the x-position of this interactive object
   */
  public int getX() {
    return this.x;
  }

  /**
   * Gets the y-position of this interactive object
   * 
   * @return the y-position of this interactive object
   */
  public int getY() {
    return this.y;
  }

  /**
   * Sets the next clue associated to this interactive object
   * 
   * @param nextClue - the next clue to be assigned to this interactive object
   */
  public void setNextClue​(InteractiveObject nextClue) {
    this.nextClue = nextClue;
  }

  /**
   * Sets the PApplet object of the treasure hunt application where all the interactive objects will
   * be drawn. Note that a graphic application has ONLY one display window of type PApplet where all
   * graphic objects interact. In p05, the TreasureHunt class is of type PApplet.
   * 
   * @param processing - represents the reference to the TreasureHunt PApplet object where all the
   *                   interactive objects will be drawn.
   */
  public static void setProcessing​(TreasureHunt processing) {
    InteractiveObject.processing = processing;
  }

  /**
   * Moves the current x and y positions of this interactive object with dx and dy, respectively
   * 
   * @param dx - move to be added to the x position of this interactive object
   * @param dy - move to be added to the y position of this interactive object
   */
  public void move​(int dx, int dy) {
    this.x = this.x + dx;
    this.y = this.y + dy;
  }

  /**
   * Checks whether the name of this interactive object equals to the name passed as input
   * parameter. We consider a case-sensitive comparison.
   * 
   * @param name - name to compare to
   * @return true if the name of this interactive object equals the provided name, false otherwise.
   */
  public boolean hasName​(java.lang.String name) {
    if (this.NAME.equals(name)) {
      return true; // same name
    }
    return false; // not same name
  }

  /**
   * Checks whether this interactive object is active. This should be a getter of the isActive data
   * field.
   * 
   * @return true if this interactive object is active and false otherwise.
   */
  public boolean isActive() {
    return this.isActive;
  }

  /**
   * Activates this interactive object, meaning setting its isActive data field to true.
   * 
   */
  public void activate() {
    this.isActive = true;
  }

  /**
   * Deactivates this interactive object, meaning setting its isActive data field to false.
   * 
   */
  public void deactivate() {
    this.isActive = false;
  }

  /**
   * Gets the message of this interactive object.
   * 
   * @return the message to be displayed each time this interactive object is clicked.
   */
  public java.lang.String message() {

    return this.message;

  }

  /**
   * Activates the next clue of this interactive object and adds it to the treasure hunt application
   * 
   * @throw java.util.NoSuchElementException - with a descriptive error message if the nextClue of
   *        this interactive object is null
   */
  protected void activateNextClue() throws java.util.NoSuchElementException {

    if (this.nextClue == null) {
      throw new java.util.NoSuchElementException("the nextClue of this interactive object is null");
    }

    this.nextClue.activate(); // Activates the next clue of this interactive object
    processing.add(this.nextClue); // adds it to the treasure hunt application

  }

  /**
   * Draws this interactive object (meaning drawing its image) to the display window at positions x
   * and y.
   * 
   */
  @Override
  public void draw() {

    processing.image(this.image, this.x, this.y);
  }

  /**
   * Checks whether the mouse is over the image of this interactive object
   * 
   * @return true if the mouse is over the image of this interactive object, and false otherwise
   */
  @Override
  public boolean isMouseOver() {

    if (this.getX() < processing.mouseX && processing.mouseX < this.getX() + this.image.width
        && this.getY() + this.image.height > processing.mouseY && processing.mouseY > this.getY()) {
      return true; // mouse position is on the image
    }

    return false; // mouse is not over the object
  }

  /**
   * This method operates each time the mouse is pressed. This interactive object responds to the
   * mouse clicks as follows. If the mouse is clicked (meaning the mouse is over it) two operations
   * will be performed as follows: (1) The message of this interactive object must be displayed to
   * the console. (2) If this interactive object has a next clue and was not clicked, its next clue
   * will be activated and its wasClicked setting will be updated.
   * 
   */
  @Override
  public void mousePressed() {
    
    if (this.isMouseOver() == true && this.isActive()) {
      System.out.println(this.message());  // (1)
      
      if (this.nextClue != null && this.wasClicked == false) { // (2)
        this.activateNextClue();
        this.wasClicked = true;
      }
      
    }
  }

  /**
   * This method operates each time the mouse is released. It implements a default behavior for an
   * interactive object which is DO NOTHING (meaning that the InteractiveObject.mouseReleased has a
   * blank implementation).
   * 
   */
  @Override
  public void mouseReleased() {

  }

}
