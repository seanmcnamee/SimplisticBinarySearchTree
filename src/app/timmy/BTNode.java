
package app.timmy;

//import java.util.Scanner;

/* Class BTNode */
public class BTNode {
    public BTNode left, right;
    private int data;

    /* Constructor */
    public BTNode() {
        left = null;
        right = null;
        data = 0;
    }

    /* Constructor */
    public BTNode(int startV) {
        left = null;
        right = null;
        data = startV;
    }

    /* Function to set left node */
    public void setLeft(BTNode n) {
        left = n;
    }

    /* Function to set right node */
    public void setRight(BTNode n) {
        right = n;
    }

    /* Function to get left node */
    public BTNode getLeft() {
        return left;
    }

    /* Function to get right node */
    public BTNode getRight() {
        return right;
    }

    /* Function to set data to node */
    public void setData(int startV) {
        data = startV;
    }

    /* Function to get data from node */
    public int getStartValues() {
        return data;
    }
}