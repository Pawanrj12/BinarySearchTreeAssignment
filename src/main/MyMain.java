package main;

import implementation.MyBinarySearchTree;

public class MyMain {
    public static void main(String[] args) {
        MyBinarySearchTree<Integer> myBinarySearchTree = new MyBinarySearchTree<>();
        myBinarySearchTree.insert(80);
        myBinarySearchTree.insert(34);
        myBinarySearchTree.insert(20);
        myBinarySearchTree.insert(1);
        myBinarySearchTree.insert(19);
        myBinarySearchTree.insert(100);
        System.out.println(myBinarySearchTree.search(34));
        System.out.println(myBinarySearchTree.search(102));
        myBinarySearchTree.inOrder(myBinarySearchTree.getRoot());
        System.out.println();
        myBinarySearchTree.preOrder(myBinarySearchTree.getRoot());
        System.out.println();
        myBinarySearchTree.postOrder(myBinarySearchTree.getRoot());
        System.out.println();
        myBinarySearchTree.reverseInOrder(myBinarySearchTree.getRoot());
        System.out.println();
        myBinarySearchTree.delete(20);
        myBinarySearchTree.delete(80);
        myBinarySearchTree.delete(19);
        myBinarySearchTree.inOrder(myBinarySearchTree.getRoot());
    }
}
