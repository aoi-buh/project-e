package unused;

public class Node<E> {
    
    private Node<E> previous;
    private Node<E> next;
    private E content;

    public Node(E content) {
        this(null, content, null);
    }

    public Node(Node<E> previous, E content) {
        this(previous, content, null);
    }

    public Node(E content, Node<E> next) {
        this(null, content, next);
    }

    public Node(Node<E> previous, E content, Node<E> next) {
        this.previous = previous;
        this.next = next;
        this.content = content;
    }

    public Node<E> getNext() {
        return this.next;
    }

    public Node<E> getPrevious() {
        return this.previous;
    }

    public E getContent() {
        return this.content;
    }

    public void setNext(Node<E> newNext) {
        this.next = newNext;
    }

    public void setPrevious(Node<E> newPrevious) {
        this.previous = newPrevious;
    }

    public void setContent(E newContent) {
        this.content = newContent;
    }

    public Node<E> clone() {
        return new Node<E>(this.previous, this.content, this.next);
    }
}
