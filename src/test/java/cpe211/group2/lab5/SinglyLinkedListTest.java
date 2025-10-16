package cpe211.group2.lab5;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SinglyLinkedListTest {
    private SinglyLinkedList list;
    
    @Before
    public void setUp() {
        list = new SinglyLinkedList();
    }
    
    @Test
    public void shouldCreateEmptyList() {
        assertTrue("New list should be empty", list.isEmpty());
        assertEquals("Empty list size should be 0", 0, list.size());
    }
    
    @Test
    public void shouldInsertAtEnd() {
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        
        assertFalse("List should not be empty after insertion", list.isEmpty());
        assertEquals("List size should be 3", 3, list.size());
        assertEquals("Display should show correct order", "10 -> 20 -> 30 -> null", list.display());
    }
    
    @Test
    public void shouldInsertAtStart() {
        list.insertAtStart(10);
        list.insertAtStart(20);
        list.insertAtStart(30);
        
        assertEquals("List size should be 3", 3, list.size());
        assertEquals("Display should show reverse order", "30 -> 20 -> 10 -> null", list.display());
    }
    
    @Test
    public void shouldDeleteExistingValue() {
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        
        boolean deleted = list.delete(20);
        
        assertTrue("Delete should return true for existing value", deleted);
        assertEquals("List size should be 2 after deletion", 2, list.size());
        assertEquals("Display should not contain deleted value", "10 -> 30 -> null", list.display());
    }
    
    @Test
    public void shouldNotDeleteNonExistingValue() {
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        
        boolean deleted = list.delete(99);
        
        assertFalse("Delete should return false for non-existing value", deleted);
        assertEquals("List size should remain unchanged", 2, list.size());
    }
    
    @Test
    public void shouldDeleteFromHead() {
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        
        boolean deleted = list.delete(10);
        
        assertTrue("Delete should return true", deleted);
        assertEquals("Display should show list without head", "20 -> 30 -> null", list.display());
    }
    
    @Test
    public void shouldDisplayEmptyList() {
        assertEquals("Empty list should display message", "List is empty", list.display());
    }
    
    @Test
    public void shouldMixInsertOperations() {
        list.insertAtEnd(20);
        list.insertAtStart(10);
        list.insertAtEnd(30);
        list.insertAtStart(5);
        
        assertEquals("List size should be 4", 4, list.size());
        assertEquals("Display should show correct order", "5 -> 10 -> 20 -> 30 -> null", list.display());
    }
}
