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
 * The unit test for the storage unit organizer
 * 
 * @author rosaliecarrow
 *
 */
public class StorageUnitTests {
  // ----------------test Box class----------

  /**
   * Checks whether the behavior of equals method is correct
   * 
   * @return the result of the test
   */
  public static boolean testBoxEquals() {
    boolean passed = true;

    // if same object
    if (new Box(1, 1).equals("Wrong"))
      passed = false;
    // if same object and weight & color
    if (!new Box(1, 1).equals(new Box(1, 1)))
      passed = false;

    return passed;
  }

  /**
   * Checks whether the behavior of compareTo method is correctly implemented
   * 
   * @return the result of the test
   */
  public static boolean testBoxCompareTo() {
    boolean passed = true;

    // checks less than, equal to, greater than
    if (!(new Box(1, 3).compareTo(new Box(1, 4)) < 0))
      passed = false;
    if (!(new Box(1, 4).compareTo(new Box(1, 4)) == 0))
      passed = false;
    if (!(new Box(1, 3).compareTo(new Box(1, 1)) > 0))
      passed = false;

    return passed;
  }

  // ----------------test LinkedBoxNode class----------

  /**
   * Checks whether the behavior of getNext() and setNext() method is correctly implemented
   * 
   * @return the result of the test
   */
  public static boolean testGetAndSetNext() {
    boolean passed = true;
    // create nodes
    LinkedBoxNode n1 = new LinkedBoxNode(new Box());
    LinkedBoxNode n2 = new LinkedBoxNode(new Box());
    LinkedBoxNode n3 = new LinkedBoxNode(new Box());
    // linking list
    n1.setNext(n2);
    n2.setNext(n3);
    // check if nodes are linked
    if (!(n1.getNext().getNext() == n3))
      passed = false;
    if (n3.getNext() != null)
      passed = false;

    return passed;
  }



  /**
   * Checks whether the behavior of getBox() and setBox() method is correctly implemented
   * 
   * @return the result of the test
   */
  public static boolean testGetAndSetBox() {
    // create boxes and nodes
    Box b1 = new Box();
    Box b2 = new Box();
    LinkedBoxNode n1 = new LinkedBoxNode(b2);
    LinkedBoxNode n2 = new LinkedBoxNode(b1);

    // link nodes
    n1.setNext(n2);

    // change boxes
    n1.setBox(b1);
    n2.setBox(b2);

    return n1.getBox() == b1 && n1.getNext().getBox() == b2;
  }


  // ----------------test LinkedBoxList class----------
  /**
   * Checks whether the behavior of setBox() method is correctly implemented
   * 
   * @return the result of the test
   */
  public static boolean testExpandCapacity() {
    LinkedBoxList test = new LinkedBoxList(5);
    // test expand
    test.expandCapacity(5);

    return test.getCapacity() == 10;
  }

  /**
   * Checks whether remove method defined in your LinkedBoxList works correctly
   * 
   * @return the result of the test
   */
  public static boolean testLinkedBoxListRemove() {
    boolean passed = true;
    // create list and boxes
    LinkedBoxList test = new LinkedBoxList(5);
    test.add(new Box(1, 1));
    test.add(new Box(2, 2));
    test.add(new Box(3, 3));
    test.add(new Box(4, 4));
    test.add(new Box(5, 5));

    // test remove last box
    if (!(test.remove(4).equals(new Box(1, 1)) && test.get(0).equals(new Box(5, 5)))) {
      passed = false;
    }
    // test remove first box
    if (!(test.remove(0).equals(new Box(5, 5)) && test.get(0).equals(new Box(4, 4)))) {
      passed = false;
    }
    // test remove out-of-bound index
    try {
      test.remove(4);
    } catch (IndexOutOfBoundsException e) {
      // should be catched here if correct
    } catch (RuntimeException e) {
      passed = false;
    }

    return passed;
  }

  /**
   * Checks whether the behavior of isEmpty() method is correctly implemented
   * 
   * @return the result of the test
   */
  public static boolean testIsEmpty() {
    boolean passed = true;

    LinkedBoxList test = new LinkedBoxList(5);
    // test empty list
    if (!test.isEmpty())
      passed = false;

    // test list with elements
    test.add(new Box(1, 1));
    test.add(new Box(2, 2));
    if (test.isEmpty())
      passed = false;

    return passed;
  }

  /**
   * Checks whether the behavior of add() method is correctly implemented
   * 
   * @return the result of the test
   */
  public static boolean testAdd() {
    boolean passed = true;

    // create list and boxes
    LinkedBoxList test = new LinkedBoxList(5);

    Box b1 = new Box(1, 1);
    Box b2 = new Box(2, 2);
    Box b3 = new Box(3, 3);
    Box b4 = new Box(4, 4);
    Box b5 = new Box(5, 5);

    // test adding null
    try {
      test.add(null);
    } catch (IllegalArgumentException e) {
      // should be catched here if correct
    } catch (RuntimeException e) {
      passed = false;
    }

    // test adding to full list
    try {
      test.add(b1);
      test.add(b2);
      test.add(b3);
      test.add(b4);
      test.add(b5);
      test.add(new Box(6, 6));
    } catch (IllegalStateException e) {
      // should be catched here if correct
    } catch (RuntimeException e) {
      passed = false;
    }

    // checks if elements are added correctly
    if (test.get(0) != b5)
      passed = false;

    return passed;
  }

  /**
   * Checks whether the behavior of get() method is correctly implemented
   * 
   * @return the result of the test
   */
  public static boolean testGet() {
    boolean passed = true;
    // create list
    LinkedBoxList test = new LinkedBoxList(5);
    // create boxes
    Box b1 = new Box(1, 1);
    Box b2 = new Box(2, 2);
    Box b3 = new Box(3, 3);
    Box b4 = new Box(4, 4);
    Box b5 = new Box(5, 5);

    // test getting elements in an empty list
    try {
      test.get(5);
    } catch (IndexOutOfBoundsException e) {
      // should be catched here if correct
    } catch (RuntimeException e) {
      passed = false;
    }


    // test getting elements in a list
    try {
      test.add(b1);
      test.add(b2);
      test.add(b3);
      test.add(b4);
      test.add(b5);
      test.get(5);
    } catch (IndexOutOfBoundsException e) {
      // should be catched here if correct
    } catch (RuntimeException e) {
      passed = false;
    }

    // checks if elements are added correctly
    if (test.get(4) != b1)
      passed = false;

    return passed;
  }

  /**
   * Checks whether the behavior of clear() method is correctly implemented
   * 
   * @return the result of the test
   */
  public static boolean testClear() {
    // create list
    LinkedBoxList test = new LinkedBoxList(5);
    // create boxes
    Box b1 = new Box(1, 1);
    Box b2 = new Box(2, 2);
    Box b3 = new Box(3, 3);
    Box b4 = new Box(4, 4);
    Box b5 = new Box(5, 5);

    // add boxes
    test.add(b1);
    test.add(b2);
    test.add(b3);
    test.add(b4);
    test.add(b5);

    // clear list
    test.clear();

    return test.isEmpty() && test.size() == 0;
  }

  /**
   * the main method of the tests
   * 
   * @param args command-line argument
   */
  public static void main(String[] args) {
    System.out.println("----------------test Box class--------------------");
    System.out.println("testBoxEquals(): " + testBoxEquals());
    System.out.println("testBoxCompareTo(): " + testBoxCompareTo());

    System.out.println("----------------test LinkedBoxNode class----------");
    System.out.println("testGetAndSetNext(): " + testGetAndSetNext());
    System.out.println("testGetAndSetBox() : " + testGetAndSetBox());

    System.out.println("----------------test LinkedBoxList class----------");
    System.out.println("testExpandCapacity(): " + testExpandCapacity());
    System.out.println("testLinkedBoxListRemove(): " + testLinkedBoxListRemove());
    System.out.println("testIsEmpty(): " + testIsEmpty());
    System.out.println("testAdd(): " + testAdd());
    System.out.println("testGet(): " + testGet());
    System.out.println("testClear(): " + testClear());

  }
}
