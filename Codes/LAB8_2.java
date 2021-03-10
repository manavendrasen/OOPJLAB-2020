import java.io.*;
import java.util.Scanner;

class LinkedList {
  Node head; // head of list

  // Linked list Node.
  // This inner class is made static
  // so that main() can access it
  static class Node {

    int data;
    Node next;

    // Constructor
    Node(int d) {
      data = d;
      next = null;
    }
  }

  // Method to insert a new node
  public static LinkedList insert(LinkedList list, int data) {
    // Create a new node with given data
    Node new_node = new Node(data);
    new_node.next = null;

    // If the Linked List is empty,
    // then make the new node as head
    if (list.head == null) {
      list.head = new_node;
    } else {
      // Else traverse till the last node
      // and insert the new_node there
      Node last = list.head;
      while (last.next != null) {
        last = last.next;
      }

      // Insert the new_node at last node
      last.next = new_node;
    }

    // Return the list by head
    return list;
  }

  // Method to print the LinkedList.
  public static void printList(LinkedList list) {
    Node currNode = list.head;

    // Traverse through the LinkedList
    while (currNode != null) {
      // Print the data at current node
      System.out.print(currNode.data + "->");

      // Go to next node
      currNode = currNode.next;
    }
  }

  public static LinkedList reverseList(LinkedList list) {

    LinkedList reversedList = new LinkedList();
    reversedList = list;
    Node prev = null;
    Node next = null;
    Node curr = list.head;

    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;

    }
    reversedList.head = prev;
    return reversedList;
  }

  public static LinkedList rotateList(LinkedList list, int k) {
    int length = 0;
    LinkedList rotatedList = new LinkedList();
    rotatedList = list;
    Node kth = null;
    Node kth1 = null;
    Node curr = list.head;
    Node last = null;
    while (curr != null) {
      length++;
      if (length == k) {
        kth = curr;
        kth1 = curr.next;
      }
      if (curr.next == null) {
        last = curr;
      }
      curr = curr.next;
    }

    last.next = list.head;
    kth.next = null;
    rotatedList.head = kth1;

    return rotatedList;
  }
}

class Main {
  // Driver code
  public static void main(String[] args) {
    /* Start with the empty list. */
    LinkedList list = new LinkedList();
    LinkedList LL1 = new LinkedList();
    LinkedList LL2 = new LinkedList();

    Scanner sc = new Scanner(System.in);
    int inp = 0;

    System.out.println("Enter values into Linked List: ");
    while (true) {
      System.out.print("--- Enter value: (-1 to stop) ");
      inp = sc.nextInt();
      if (inp == -1)
        break;
      list = LinkedList.insert(list, inp);
    }

    LL1 = list;
    LL2 = list;

    System.out.println("\nLinked List");
    LinkedList.printList(list);

    LL1 = LinkedList.reverseList(LL1);
    System.out.println("\nReversed Linked List: ");
    LinkedList.printList(LL1);

    LL2 = LinkedList.rotateList(LL2, 2);
    System.out.println("\nRotated Linked List: ");
    LinkedList.printList(LL2);

    sc.close();
  }
}