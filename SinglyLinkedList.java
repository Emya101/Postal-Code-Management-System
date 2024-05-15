/**
 * A simple implementation of a singly linked list.
 * @param <E> the type of elements stored in the list
 */
public class SinglyLinkedList<E> {
    
    /**
     * A nested static class representing a node in the linked list.
     * @param <E> the type of elements stored in the node
     */
    public static class Node<E> {
        private E element; // The element stored in this node
        private Node<E> next; // Reference to the next node in the list
        
        /**
         * Constructs a node with the given element and next node reference.
         * @param e the element to be stored in the node
         * @param n the next node in the list
         */
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }
        
        /**
         * Retrieves the element stored in this node.
         * @return the element stored in this node
         */
        public E getElement() {
            return element;
        }
        
        /**
         * Retrieves the reference to the next node in the list.
         * @return the reference to the next node
         */
        public Node<E> getNext() {
            return next;
        }
        
        /**
         * Sets the reference to the next node in the list.
         * @param n the node to be set as the next node
         */
        public void setNext(Node<E> n) {
            next = n;
        }
    }
    
    private Node<E> head = null; // Reference to the first node in the list
    private Node<E> tail = null; // Reference to the last node in the list
    private int size = 0; // Number of elements in the list
    
    /**
     * Constructs an empty singly linked list.
     */
    public SinglyLinkedList() {}

    /**
     * Returns the number of elements in the list.
     * @return the number of elements in the list
     */
    public int size() {
        return size;
    }

    /**
     * Returns the reference to the head of the list.
     * @return the reference to the head node
     */
    public Node<E> getHead() {
        return head;
    }

    /**
     * Returns the reference to the tail of the list.
     * @return the reference to the tail node
     */
    public Node<E> getTail() {
        return tail;
    }

    /**
     * Checks if the list is empty.
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Returns the element stored in the first node of the list.
     * @return the element stored in the first node
     */
    public E first() {
        if (isEmpty()) return null;
        return head.getElement();
    }

    /**
     * Returns the element stored in the last node of the list.
     * @return the element stored in the last node
     */
    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    /**
     * Adds an element to the beginning of the list.
     * @param e the element to be added to the beginning of the list
     */
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    /**
     * Adds an element to the end of the list.
     * @param e the element to be added to the end of the list
     */
    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty())
            head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        size++;
    }

    /**
     * Removes and returns the element stored in the first node of the list.
     * @return the element removed from the first node, or null if the list is empty
     */
    public E removeFirst() {
        if (isEmpty()) return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0)
            tail = null;
        return answer;
    }

    /**
     * Returns a string representation of the list.
     * @return a string representation of the list
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> current = head;
        while (current != null) {
            sb.append(current.getElement());
            current = current.getNext();
            if (current != null)
                sb.append("\n");
        }
        sb.append("]");
        return sb.toString();
    }
}
