package implementation;

import myinterface.BinarySearchTreeADT;

public class MyBinarySearchTree<E extends Comparable<E>> implements BinarySearchTreeADT<E> {
    Node<E> root = null;

    public Node<E> getRoot() {
        return root;
    }

    @Override
    public void insert(E data) {
        Node<E> node = new Node<>(data);
        if (root == null) {
            root = node;
        } else {
            Node<E> temp = root;
            Node<E> parent = null;

            while (temp != null) {
                parent = temp;
                if (data.compareTo(temp.getData()) > 0) {
                    temp = temp.getRight();
                } else {
                    temp = temp.getLeft();
                }
            }
            if (data.compareTo(parent.getData()) <= 0) {
                parent.setLeft(node);
            } else {
                parent.setRight(node);
            }
        }
    }

    @Override
    public boolean search(E searchElement) {
        boolean response = false;
        if (root != null) {
            Node<E> temp = root;
            while (temp != null && !response) {
                if (searchElement == temp.getData()) {
                    response = true;
                } else if (searchElement.compareTo(temp.getData()) < 0) {
                    temp = temp.getLeft();
                } else {
                    temp = temp.getRight();
                }
            }
        }
        return response;
    }

    @Override
    public void inOrder(Node<E> node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.getData() + " ");
            inOrder(node.getRight());
        }
    }

    @Override
    public void preOrder(Node<E> node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    @Override
    public void postOrder(Node<E> node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }

    @Override
    public void reverseInOrder(Node<E> node) {
        if (node != null) {
            inOrder(node.getRight());
            System.out.print(node.getData() + " ");
            inOrder(node.getLeft());
        }
    }

    @Override
    public void delete(E data) {
        Node<E> temp = root;
        Node<E> requiredNode = null;
        Node<E> parentNode = null;

        if (root != null) {
            while (temp != null && requiredNode == null) {
                if (data == temp.getData()) {
                    requiredNode = temp;
                } else {
                    parentNode = temp;
                    if (data.compareTo(temp.getData()) < 0) {
                        temp = temp.getLeft();
                    } else {
                        temp = temp.getRight();
                    }
                }
            }
        }

        if (requiredNode != null) {

            if (requiredNode.getLeft() == null && requiredNode.getRight() == null) {

                if (parentNode == null) root = null;
                else {
                    if (data.compareTo(parentNode.getData()) <= 0) {
                        parentNode.setLeft(null);
                    } else {
                        parentNode.setRight(null);
                    }
                }
            } else if (requiredNode.getLeft() == null || requiredNode.getRight() == null) {

                requiredNode = (requiredNode.getRight() != null) ? requiredNode.getRight() : requiredNode.getLeft();

                if (parentNode == null) root = requiredNode;
                else {
                    if (data.compareTo(parentNode.getData()) <= 0) {
                        parentNode.setLeft(requiredNode);
                    } else {
                        parentNode.setRight(requiredNode);
                    }
                }
            }

            else {

                Node<E> successor = getSuccessor(requiredNode);
                delete(successor.getData());
                successor.setLeft(temp.getLeft());
                successor.setRight(temp.getRight());
                if (parentNode == null) {
                    root = successor;
                } else {
                    if (data.compareTo(parentNode.getData()) < 0) {
                        parentNode.setLeft(successor);
                    } else {
                        parentNode.setRight(successor);
                    }
                }
            }
        } else {
            System.out.println("cannot delete");
        }
    }

    private Node<E> getSuccessor(Node<E> node) {
        Node<E> temp = node.getRight();
        while (temp.getLeft() != null) {
            temp = temp.getLeft();
        }
        return temp;
    }

    @Override
    public int height(Node<E> node) {
        return 0;
    }
}
