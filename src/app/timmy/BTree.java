
package app.timmy;

import java.io.BufferedWriter;
import java.io.IOException;

/* Class BT 
This ends up being a Binary Search Tree because of the orderedInsert Method*/
public class BTree {
    private BTNode root;

    /* Constructor */
    public BTree() {
        root = null;
    }


    public boolean removeMaximum() {
        return removeMaximum(root, root);
    }

    private boolean removeMaximum(BTNode current, BTNode previous) {
        if (current == null) {
            //Null Base Case
            //We can't get rid of a node when the tree is empty!!!
            return false;
        }   else {
            //We need to see if this is the largest node. If it is, then great!
            if (current.getRight()==null) {
                //If the rightmost is the root...
                if (current==previous) {
                    //Root Base Case
                    //The root has to be changed!!
                    root = root.getLeft();
                }   else {
                    //General Base case
                    //This is the rightmost, and we have to set its parent's rightNode to this node's leftNode node
                    previous.right = current.left;
                }
                return true;
            }   else {
                //Recursive Case
                //This is NOT the largest node, and it has a MORE RIGHT NODE
                return removeMaximum(current.right, current);
            }
        }
    }




    /* Function to check if tree is empty */
    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int data) {
        insert(new BTNode(data));
    }

    /* Functions to insert data */
    public void insert(BTNode nodeToInsert) {
        root = orderedInsert(root, nodeToInsert);
    }
    

    //Returns the Node after inserting the Node in order
    //Makes this a binary search tree
    private BTNode orderedInsert(BTNode node, BTNode toInsert) {
        if (node==null) {
            node = toInsert;
        }   else if(toInsert.getStartValues() > node.getStartValues()) { //Must go to the right
            node.right = orderedInsert(node.right, toInsert);
        }   else {
            node.left = orderedInsert(node.left, toInsert);
        }
        return node;
    }

    /* Function to count number of nodes */
    public int countNodes() {
        return countNodes(root);
    }

    /* Function to count number of nodes recursively */
    private int countNodes(BTNode r) {
        if (r == null)
            return 0;
        else {
            int count = 1;
            count += countNodes(r.getLeft());
            count += countNodes(r.getRight());
            return count;
        }
    }

    /* Function to search for an element */
    public BTNode search(int valStart, int valEnd) {
        return search(root, valStart, valEnd);
    }

    /** Function to search for an element recursively
    /*  Assumes a Binary Search Tree
    */
    private BTNode search(BTNode r, int start, int end) {
        if (r==null) {
            return null;
        }
        
        //else if(larger(toInsert, node)) { //Must go to the right
        if (r.getStartValues() == start) {
            return r;
        }
            
        if (start > r.getStartValues()) {
            return search(r.getRight(), start, end);
        }   else {
            return search(r.getLeft(), start, end);
        }
    }

    /* Function for inorder traversal */
    public void inorder() {
        inorder(root);
    }

    private void inorder(BTNode r) {
        if (r != null) {
            inorder(r.getLeft());
            System.out.println(r.getStartValues());
            inorder(r.getRight());
        }
    }

    /* Function for preorder traversal */
    public void preorder() {
        preorder(root);
    }

    private void preorder(BTNode r) {
        if (r != null) {
            System.out.println(r.getStartValues());
            preorder(r.getLeft());
            preorder(r.getRight());
        }
    }

    /* Function for postorder traversal */
    public void postorder() {
        postorder(root);
    }

    private void postorder(BTNode r) {
        if (r != null) {
            postorder(r.getLeft());
            postorder(r.getRight());
            System.out.println(r.getStartValues());
        }
    }
}