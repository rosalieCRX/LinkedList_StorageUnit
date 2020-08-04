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
import java.util.Random;

/**
 * Models a box to be stored
 * 
 * @author rosaliecarrow
 *
 */
public class Box implements Comparable<Box> {
  private static Random randGen = new Random(); // generator of random numbers
  private int color; // color of this box
  private int weight; // weight of this box in lbs between 1 inclusive and 31 exclusive

  /**
   * Constrctor Creates a new Box and initializes its instance fields color and weight to random
   * values
   */
  public Box() {
    color = randGen.nextInt();
    weight = randGen.nextInt(30) + 1;
  }

  /**
   * Creates a new Box and initializes its instance fields color and weight to the specified values
   * Throws IllegalArgumentException if the provided weight value is out of the range of [1..30]
   * 
   * @param color  color of this box
   * @param weight weight of this box
   */
  public Box(int color, int weight) throws IllegalArgumentException {
    this.color = color;

    if (weight > 0 && weight < 31) {
      this.weight = weight;
    } else {
      throw new IllegalArgumentException(
          "Weight of this box is not between 1 inclusive and 31 exclusive");
    }
  }

  /**
   * returns true if the specified other object is a Box and this box and other have the same color
   * and same weight. Otherwise, it returns false.
   * 
   * @param other an object to check
   * @return whether they are same type and same color and weight
   */
  @Override
  public boolean equals(Object other) {
    return (other instanceof Box) && this.color == ((Box) other).getColor()
        && this.weight == ((Box) other).getWeight();

  } // equals method defined in Object class

  /**
   * returns a negative integer, a positive integer, or zero as this box is lighter than, heavier
   * than, or has the same weight as the specified otherBox
   * 
   * @param otherBox an object to compare
   * @return if this box is heavier/same/lighter than otherBox
   */
  @Override
  public int compareTo(Box otherBox) {
    return this.weight - otherBox.getWeight();
  } // compareTo method defined in Comparable<Box>
    // interface

  /**
   * Getter for the instance field color of this box
   * 
   * @return color
   */
  public int getColor() {
    return this.color;
  }

  /**
   * Getter for the instance field weight of this box
   * 
   * @return weight
   */
  public int getWeight() {
    return this.weight;
  }

}
