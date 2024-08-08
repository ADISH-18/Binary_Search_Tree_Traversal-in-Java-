/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
class Node {

    int data;
    Node left, right;

    //constructor 
    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinaryTree {

    Node root;

    void insert(int data) {
        root = insertrecursion(root, data);
    }

    //Count the number of nodes inthe Tree
    int getcountofnode(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + getcountofnode(root.left) + getcountofnode(root.right);
    }

    // insertion using recursion 
    Node insertrecursion(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        // Count nodes to decide which subtree to insert into
        int leftCount = getcountofnode(root.left);
        int rightCount = getcountofnode(root.right);

        if (leftCount <= rightCount) {
            root.left = insertrecursion(root.left, data);
        } else {
            root.right = insertrecursion(root.right, data);
        }

        return root;
    }

    void inOrder() {
        inOrderrecursion(root);
        System.out.println();
    }

    void inOrderrecursion(Node root) {
        if (root != null) {
            inOrderrecursion(root.left);
            System.out.print(root.data + "  ");
            inOrderrecursion(root.right);
        }
    }

    void preOrder() {
        preOrderrecursion(root);
        System.out.println();
    }

    void preOrderrecursion(Node root) {
        if (root != null) {
            System.out.print(root.data + "  ");
            preOrderrecursion(root.left);
            preOrderrecursion(root.right);
        }
    }

    void PostOrder() {
        PostOrderrecursion(root);
        System.out.println();
    }

    void PostOrderrecursion(Node root) {
        if (root != null) {
            PostOrderrecursion(root.left);
            PostOrderrecursion(root.right);
            System.out.print(root.data + "  ");
        }
    }
}
