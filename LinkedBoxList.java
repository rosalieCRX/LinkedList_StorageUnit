//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (Storage Unit Orgnizer)
// Files: (Box.java LinkedBoxNode.java LinkedBoxList.java and StorageUnitTests.java)
// Course: (001 SUMMER 2019)
//
// Author: (Rosalie CAI)
// Email: (rcai25@wisc.edu)
// Lecturer's Name: (Mouna KACEM)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (Jiong Chen)
// Partner Email: (jchen672@wisc.edu)
// Partner Lecturer's Name: (Mouna KACEM)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X_ Write-up states that pair programming is allowed for this assignment.
// _X_ We have both read and understand the course Pair Programming Policy.
// _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: (NONE)
// Online Sources: (NONE)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
/**
 * models a dynamic list to store box objects sorted in a descendant order with respect to their
 * weights
 * 
 * @author rosaliecarrow
 *
 */
public class LinkedBoxList {
  private LinkedBoxNode head; // head of this LinkedBoxList (refers to the element
  // stored at index 0 within this list)
  private int size; // number of boxes already stored in this list
  private int capacity; // capacity of this LinkedBoxList
  // maximum number of box elements that this LinkedBoxList
  // can store

  /**
   * The constructor, creates an empty LinkedBoxList with a given initial capacity
   * 
   * @param a maximum number of boxes that it can store
   */
  public LinkedBoxList(int capacity) {
    this.capacity = capacity;
  }

  /**
   * Returns the size of this list
   * 
   * @return size of this list
   */

  public int size() {
    return this.size;
  }

  /**
   * Return the capacity of this list
   * 
   * @return the capacity of this list
   */
  public int getCapacity() {
    return this.capacity;
  }

  /**
   * Expands the capacity of this LinkedBoxList with the specified number a of additional elements
   * 
   * @param a the addition capacity to be expanded
   */
  public void expandCapacity(int a) {
    this.capacity += a;
  }

  /**
   * Checks whether this LinkedBoxList is empty returns true if this LinkedBoxList is empty, false
   * otherwise
   * 
   * @return whether this LinkedBoxList is empty
   */
  public boolean isEmpty() {
    return head == null;
  }

  /**
   * Checks whether this LinkedBoxList is full Returns true if this list is full, false otherwise
   * 
   * @return
   */
  public boolean isFull() {
    return size == capacity;
  }

  /**
   * Adds a new box into this sorted list. Throws IllegalArgumentException if newBox is null. Throws
   * IllegalStateException if this list is full
   * 
   * @param newBox new box to be added
   * @throws IllegalArgumentException
   * @throws IllegalStateException
   */
  public void add(Box newBox) throws IllegalArgumentException, IllegalStateException {
    // Throws IllegalArgumentException if newBox is null
    if (newBox == null) {
      throw new IllegalArgumentException("newBox is null");
    }

    // Throws IllegalStateException if this list is full
    if (this.isFull()) {
      throw new IllegalStateException("list is full");
    }

    // create a new node
    LinkedBoxNode newNode = new LinkedBoxNode(newBox);

    if (this.isEmpty()) {
      // add newNode at the head
      head = newNode;
    } else {
      // add newNode at the end

      // runner to traverse the list
      LinkedBoxNode runner = head;

      // add before head if greater than head
      if (newNode.getBox().compareTo(runner.getBox()) > 0) {
        newNode.setNext(head);
        head = newNode;
      }
      // box is lighter than head, then add in the middle and end
      else {
        // traverse the list
        while (runner.getNext() != null) {
          // box is lighter than runner, checks if greater than runner.next
          if (newNode.getBox().compareTo(runner.getNext().getBox()) > 0) {
            newNode.setNext(runner.getNext());
            runner.setNext(newNode);
            break;
          }
          runner = runner.getNext();// advance runner
        }

        // if box is ligher than all the boxes in the list, add to the end
        runner.setNext(newNode);
      }
    }

    // update size
    size++;

  }

  /**
   * Checks if this list contains a box that matches with (equals) a specific box object. Returns
   * true if this list contains findBox, false otherwise
   * 
   * @param findBox
   * @return whether the list contains the box
   */
  public boolean contains(Box findBox) {
    boolean boxFound = false;

    // checking boxes
    if (!this.isEmpty()) {
      // runner to traverse the list
      LinkedBoxNode runner = head;
      do {
        // compares the box
        if (head.getBox().equals(findBox)) {
          boxFound = true;
        }
        // traverse the list
        runner = runner.getNext();// advance runner
      } while (runner.getNext() != null);
    }

    return boxFound;
  }

  /**
   * Returns a box stored in this list given its index. Throws IndexOutOfBoundsException if index is
   * out of the range 0..size-1
   * 
   * @param index the index of the box to find
   * @return the box at the index
   * @throws IndexOutOfBoundsException
   */
  public Box get(int index) throws IndexOutOfBoundsException {
    // Throws IndexOutOfBoundsException if index is out of the range 0..size-1
    if (index < 0 || index > size - 1) {
      throw new IndexOutOfBoundsException("index is out of bounds");
    }

    // runner to traverse the list
    LinkedBoxNode runner = head;

    // traverse the list
    for (int i = 0; i < index; i++) {
      runner = runner.getNext();// advance runner
    }

    return runner.getBox();
  }

  /**
   * Removes a returns the box stored at index from this LinkedBoxList. Throws
   * IndexOutOfBoundsException if index is out of bounds. index should be in the range of [0..
   * size()-1]
   * 
   * @param index the index of the box to be removed
   * @return the box removed
   * @throws IndexOutOfBoundsException
   */

  public Box remove(int index) throws IndexOutOfBoundsException {
    // Throws IndexOutOfBoundsException if index is out of the range 0..size-1
    if (index < 0 || index > size - 1) {
      throw new IndexOutOfBoundsException("index is out of bounds");
    }

    Box remvBox;
    // removes the head if index is 0
    if (index == 0) {
      remvBox = head.getBox();
      head = head.getNext();
    } else {
      // runner to traverse the list
      LinkedBoxNode runner = head;

      // traverse the list
      for (int i = 0; i < index - 1; i++) {
        runner = runner.getNext();// advance runner
      }

      remvBox = runner.getNext().getBox();
      runner.setNext(runner.getNext().getNext()); // remove box
    }

    // update size
    size--;

    return remvBox;
  }


  /**
   * Removes all the boxes from this list
   */
  public void clear() {
    head = null;
    size = 0;
  }

  /**
   * Returns a String representation for this LinkedBoxList
   */
  @Override
  public String toString() {
    StringBuilder result = new StringBuilder(); // creates a StringBuilder object
    String newLine = System.getProperty("line.separator");
    result.append("------------------------------------------------" + newLine);
    if (!isEmpty()) {
      LinkedBoxNode runner = head;
      int index = 0;
      // traverse the list and add a String representation for each box
      while (runner != null) {
        result.insert(0,
            "Box at index " + index + ": " + runner.getBox().getWeight() + " lbs" + newLine);
        runner = runner.getNext();
        index++;
      }
      result.insert(0, "Box List Content:" + newLine);
    }
    result.insert(0, "List size: " + size + " box(es)." + newLine);
    result.insert(0, "Box List is empty: " + isEmpty() + newLine);
    result.insert(0, "------------------------------------------------" + newLine);
    return result.toString();
  }
}


