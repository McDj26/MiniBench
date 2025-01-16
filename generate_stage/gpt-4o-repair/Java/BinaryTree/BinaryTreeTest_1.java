package com.thealgorithms.datastructures.trees;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    @Test
    public void removeTest() {
        BinaryTree tree = new BinaryTree();
        
        // Insert nodes into the tree
        tree.put(5);
        tree.put(3);
        tree.put(7);
        tree.put(2);
        tree.put(4);
        tree.put(6);
        tree.put(8);
        
        // Test removing a leaf node
        assertTrue(tree.remove(2));
        assertNull(tree.find(2));
        
        // Test removing a node with one child
        assertTrue(tree.remove(3));
        assertNull(tree.find(3));
        assertEquals(4, tree.find(4).data);  // 4 should now be the child of root
        
        // Test removing a node with two children
        assertTrue(tree.remove(5));
        assertNull(tree.find(5));
        assertEquals(6, tree.getRoot().data);  // 6 should be the new root
        
        // Test removing root node until tree is empty
        assertTrue(tree.remove(6));
        assertTrue(tree.remove(7));
        assertTrue(tree.remove(4));
        assertTrue(tree.remove(8));
        
        // Now the tree should be empty
        assertNull(tree.getRoot());
        
        // Test removing from an empty tree
        assertFalse(tree.remove(10));
    }
}