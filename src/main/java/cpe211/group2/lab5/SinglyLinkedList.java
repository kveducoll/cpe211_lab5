package cpe211.group2.lab5;

import static kvx.jcandy.Std.*;

public class SinglyLinkedList {
    private Node head;
    
    public SinglyLinkedList() {
        head = null;
    }

    public void insertAtStart(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
            return;
        }
        
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        
        current.next = newNode;
    }
    
    public boolean delete(int key) {
        Node temp = head;
        Node prev = null;
        
        if (temp != null && temp.data == key) {
            head = temp.next;
            return true;
        }
        
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }
        
        if (temp == null) {
            return false;
        }
        
        prev.next = temp.next;
        return true;
    }

    public String display() {
        if (head == null) {
            return "List is empty";
        }
        
        StringBuilder result = new StringBuilder();
        Node current = head;
        
        while (current != null) {
            result.append(current.data);
            if (current.next != null) {
                result.append(" -> ");
            }
            current = current.next;
        }
        
        result.append(" -> null");
        return result.toString();
    }
    
    public void printList() {
        println(display());
    }
    
    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
