package BankSystem;

public class Tree<T>{
    Node<T> root;


    public Node<T> find(int key) {
        Node<T> current = root;
        while (current.key != key) {
            if (current.key < key) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }


    public void add(int key, T data) {
        Node<T> current = root;
        Node<T> parent;
        Node<T> newNode = new Node<T>(data, key);
        if (root == null)
            root = newNode;
        else {
            while (true) {
                parent = current;
                if (key < current.getKey()) {
                    current = current.getLeft();
                    if (current == null) {
                        parent.setLeft(newNode);
                        return;
                    }
                }
                else {
                    current = current.getRight();
                    if (current == null) {
                        parent.setRight(newNode);
                        return;
                    }
                }
            }
        }
    }

    public Node<T> getSuccessor(Node<T> deleteNode) {
        Node<T> parentSuccessor = deleteNode;//родитель преемника
        Node<T> successor = deleteNode;//преемник
        Node<T> current = successor.getRight();//просто "пробегающий" узел
        while (current != null) {
            parentSuccessor = successor;
            successor = current;
            current = current.getLeft();
        }
        //на выходе из цикла имеем преемника и родителя преемника
        if (successor != deleteNode.getRight()) {//если преемник не совпадает с правым потомком удаляемого узла
            parentSuccessor.setLeft(successor.getRight());//то его родитель забирает себе потомка преемника, чтобы не потерять его
            successor.setRight(deleteNode.getRight());//связываем преемника с правым потомком удаляемого узла
        }
        return successor;
    }

    public boolean delete(int deleteKey) {
        Node<T> current = root;
        Node<T> parent = current;
        boolean isLeftChild = false;
        while (current.getKey() != deleteKey) {
            parent = current;
            if (deleteKey < current.getKey()) {
                current = current.getLeft();
                isLeftChild = true;
            } else {
                isLeftChild = false;
                current = current.getRight();
            }
            if (current == null)
                return false;
        }

        if (current.getLeft() == null && current.getRight() == null) {//первый случай
            if (current == root)
                current = null;
            else if (isLeftChild)
                parent.setLeft(null);
            else
                parent.setRight(null);
        }
        else if (current.getRight() == null) {//второй случай
            if (current == root)
                root = current.getLeft();
            else if (isLeftChild)
                parent.setLeft(current.getLeft());
            else
                current.setRight(current.getLeft());
        } else if (current.getLeft() == null) {
            if (current == root)
                root = current.getRight();
            else if (isLeftChild)
                parent.setLeft(current.getRight());
            else
                parent.setRight(current.getRight());
        }
        else {//третий случай
            Node<T> successor = getSuccessor(current);
            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.setLeft(successor);
            else
                parent.setRight(successor);

            successor.setLeft(current.getLeft());
        }
        return true;
    }

    public void inOrder(Node<T> current) {
        if (current != null) {
            inOrder(current.getLeft());
            System.out.println(current.getData() + " ");
            inOrder(current.getRight());
        }
    }

    public int size(){
        return size(root);
    }

    private int size(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            int count = 1;
            count += size(node.getLeft());
            count += size(node.getRight());
            return count;
        }
    }

}
