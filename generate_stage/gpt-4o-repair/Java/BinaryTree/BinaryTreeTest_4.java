package com.thealgorithms.datastructures.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    private BinaryTree binaryTree;

    @BeforeEach
    public void setUp() {
        binaryTree = new BinaryTree();
        // Inserting nodes into the BinaryTree
        binaryTree.put(10);
        binaryTree.put(5);
        binaryTree.put(15);
        binaryTree.put(3);
        binaryTree.put(7);
        binaryTree.put(12);
        binaryTree.put(18);
    }

    @Test
    public void removeTestLeafNode() {
        // Test removing a leaf node
        assertTrue(binaryTree.remove(3), "Leaf node 3 should be removed");
        assertNull(binaryTree.find(3), "Node 3 should no longer be in the tree");
    }

    @Test
    public void removeTestNodeWithOneChild() {
        // Test removing a node with one child
        assertTrue(binaryTree.remove(5), "Node 5 with one child should be removed");
        assertNull(binaryTree.find(5), "Node 5 should no longer be in the tree");
    }

    @Test
    public void removeTestNodeWithTwoChildren() {
        // Test removing a node with two children
        assertTrue(binaryTree.remove(10), "Node 10 with two children should be removed");
        assertNull(binaryTree.find(10), "Node 10 should no longer be in the tree");
    }

    @Test
    public void removeTestRootNode() {
        BinaryTree singleNodeTree = new BinaryTree();
        singleNodeTree.put(10);
        // Test removing root node
        assertTrue(singleNodeTree.remove(10), "Root node 10 should be removed");
        assertNull(singleNodeTree.getRoot(), "Root should be null after removal");
    }

    @Test
    public void removeTestNonExistentNode() {
        // Test removing a non-existent node
        assertFalse(binaryTree.remove(20), "Non-existent node 20 should not be removed");
    }
}