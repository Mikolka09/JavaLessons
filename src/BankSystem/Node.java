package BankSystem;


public class Node<T> {
    int key;
    T data;
    Node<T> right;
    Node<T> left;

    public Node(T data, int key) {
        this.data = data;
        this.key = key;
    }
    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    public T getData() {
        return data;
    }

    public int getKey() {
        return key;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public String toString() {
        return "KEY: " + key + "Data: " + data;
    }
}
