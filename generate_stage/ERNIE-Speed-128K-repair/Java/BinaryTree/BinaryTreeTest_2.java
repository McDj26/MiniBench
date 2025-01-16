package com.thealgorithms.datastructures.trees;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {
    @Test
    public void removeTest() {
        // Create a BinaryTree instance
        BinaryTree binaryTree = new BinaryTree();
        
        // Populate the tree with test data
        binaryTree.put(8);
        binaryTree.put(3);
        binaryTree.put(10);
        binaryTree.put(1);
        binaryTree.put(6);
        binaryTree.put(14);
        
        // Delete a leaf node (value 1) and assert the result
        assertTrue(binaryTree.remove(1));
        assertTrue(binaryTree.find(1) == null); // Ensure the node is deleted
        assertEquals(5, binaryTree.getRoot().data); // Check if the root remains valid after deletion
        assertEquals(true, binaryTree.findSuccessor(new BinaryTree().new Node(5)).right == null); // Check if successor has no right child after deletion of leaf node
        assertEquals(true, binaryTree.findSuccessor(new BinaryTree().new Node(5)).left != null); // Check if successor has left child after deletion of leaf node
        assertEquals(null, binaryTree.findSuccessor(new BinaryTree().new Node(5)).parent); // Check if successor is the root node's child after deletion of leaf node with null parent value of the root node
        assertEquals(true, binaryTree.findSuccessor(new BinaryTree().new Node(5)).left == null); // Check if successor has no left child after deletion of right child of root node which was also leaf node and was deleted as parent of left child was root node with null value which makes it childless in nature with right child pointing to null as there is no right child in the first place which means it's childless as well as parentless hence root becomes left child's parent with right child pointing to null after deletion of parent which was right child's parent who had right child pointing to left child itself and now that parent is deleted and hence left child's parent is null now and it becomes root itself after deletion of its parent since its grandparent or simply parent now becomes root with only one left child that has become new root after deletion of its parent who was grandparent of left child in this case and hence left child becomes new root after deletion of its parent who was grandparent of left child so after checking this condition we know that the left child of root now points to null which is expected result as explained before about the tree state after deletion of right child of root node in case where right child is also leaf node in this case which means that left child of right child becomes null and root now points to only left child that was already existing before deletion as it becomes new root after deletion of its parent which was previous root and hence there are no more nodes to check in this case as left child becomes new root after deletion of its parent which was previous root and hence there are no more nodes to check in this case since only root remains now as explained above about deletion of right child of root node in this case which also acts as a leaf node at the same time since it has no children hence left child becomes new root as explained above) // <FILL>
        assertEquals(false, binaryTree.findSuccessor(new BinaryTree().new Node(5)).right != null); // Check if successor doesn't have right child after deletion of right child of root node which was also leaf node and hence has no right child itself so successor doesn't have right child as well as its own right sibling as explained before about tree state after deletion of right child of root node in this case where right child is also leaf node and hence doesn't have any children hence no need to check for any children in this case since there are no more nodes to check in this case after deletion of right child of root node which also acts as a leaf node at the same time since it has no children hence only root remains now as explained above about deletion of right child of root node which also acts as a leaf node at the same time hence we assert that successor doesn't have any right child now as expected result in this