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
 * models a linked node
 * 
 * @author rosaliecarrow
 *
 */
public class LinkedBoxNode {

  private Box box; // box that represents the data for this Linked node
  private LinkedBoxNode next; // reference to the next Linked Box Node

  /**
   * constructor creates a new LinkedBoxNode object with a given box and without referring to any
   * next LinkedBoxNode
   * 
   * @param box box contained in the node
   */
  public LinkedBoxNode(Box box) {
    this.box = box;
    next = null;
  }

  /**
   * creates a new LinkedBoxNode object and sets its instance fields box and next to the specified
   * ones
   * 
   * @param box  box contained in the node
   * @param next the next node
   */
  public LinkedBoxNode(Box box, LinkedBoxNode next) {
    this.box = box;
    this.next = next;
  }


  /**
   * get next node
   * 
   * @return next node
   */
  public LinkedBoxNode getNext() {
    return next;
  }

  /**
   * set next node
   * 
   * @param next the next node to point to
   */
  public void setNext(LinkedBoxNode next) {
    this.next = next;
  }

  /**
   * get the box it contains
   * 
   * @return the box it contains
   */
  public Box getBox() {
    return box;
  }

  /**
   * set to contain the box
   * 
   * @param box the box to contain
   */
  public void setBox(Box box) {
    this.box = box;
  }

}
