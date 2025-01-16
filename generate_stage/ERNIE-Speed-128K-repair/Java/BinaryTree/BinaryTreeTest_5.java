package com.thealgorithms.datastructures.trees;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {
    BinaryTree binaryTree = new BinaryTree(); // Assuming you have initialized the binary tree with some values

    @Test
    public void removeTest() {
        // Insert nodes into the binary tree
        binaryTree.put(5); // Root node
        binaryTree.put(3); // Left child of root
        binaryTree.put(7); // Right child of root
        binaryTree.put(2); // Left child of left child of root
        binaryTree.put(4); // Right child of left child of root
        binaryTree.put(8); // Right child of root has left child 5 as left child and right child 9 as right child
        binaryTree.put(9); // Right child of right child of root
        
        // Remove node and check if it's successful and the remaining tree is correct
        assertTrue(binaryTree.remove(5)); // Root node is removed, should return true
        assertEquals(null, binaryTree.getRoot()); // Root should be null after removing the root node
        assertFalse(binaryTree.remove(valueNotPresent)); // Non-existent value in the tree, should return false
        assertTrue(binaryTree.remove(2)); // Left child of left child of root is removed, should return true
        assertTrue(binaryTree.remove(4)); // Right child of left child of root is removed, should return true
        assertTrue(binaryTree.remove(3)); // Left child of root is removed, should return true and remaining left subtree should be correct
        assertTrue(binaryTree.remove(9)); // Right child of right child of root is removed, should return true and remaining right subtree should be correct (root node is now 7)
        assertFalse(binaryTree.remove(8)); // Cannot remove the root node without removing its children first, should return false (in this case)
    }
}