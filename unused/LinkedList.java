package unused;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> {

	private Node<E> head;
	private Node<E> tail;
	private Node<E> currentNode;
	
	private class LinkedListIterator implements Iterator<E> {				// The way to declare an inner class which implements an interface is provided by chatgpt.
																			// url: https://chat.openai.com/share/463e57e7-331e-46dc-b4d6-2a99d5923f66
		private Node<E> currentNode = null;

		public boolean hasNext() {
			return (this.currentNode.getNext() != null) ? true : false;
		}

		public E next() {
			if (this.currentNode == null) {
				this.currentNode = LinkedList.this.head;
				return this.currentNode.getContent();
			}
			this.currentNode = this.currentNode.getNext();
			return this.currentNode.getContent();
		}

	}

	public LinkedList(Node<E> initialNode) {
		this.head = initialNode;
		this.tail = initialNode;
		this.currentNode = initialNode;
	}

	public Iterator<E> getIterator() {
		return new LinkedListIterator();
	}

	public boolean hasNext() {
		return (currentNode.getNext() != null) ? true : false;
	}

	public boolean hasPrevious() {
		return (currentNode.getPrevious() != null) ? true : false;
	}

	public void next() {
		if (!hasNext()) {
			throw new NoSuchElementException("next node does not exist");
		}

		currentNode = currentNode.getNext();

		if (!hasNext()) {
			this.tail = currentNode;
		}
	}

	public void previous() {
		if (!hasPrevious()) {
			throw new NoSuchElementException("previous node does not exist");
		}

		currentNode = currentNode.getPrevious();

		if (!hasPrevious()) {
			this.head = currentNode;
		}
	}

	public Node<E> getHead() {
		return this.head;
	}

	public Node<E> getTail() {
		return this.tail;
	}

	public E getContent() {
		return currentNode.getContent();
	}

	public void set(E content) {
		currentNode.setContent(content);
	}

	public void add(E content) {
		Node<E> newNode = new Node<E>(currentNode.getPrevious(), 
									  content, 
									  currentNode.getNext());
		
		currentNode.setNext(newNode);

		Node<E> nextNode = newNode.getNext();

		if (nextNode == null) {
			this.tail = newNode;
			return;
		}

		newNode.getNext()
			   .setPrevious(newNode);
	}

	public E[] getList() {
		Iterator<E> iterator = getIterator();
		ArrayList<E> output = new ArrayList<E>();

		while(iterator.hasNext()) {
			output.add(iterator.next());
		}

		return (E[]) output.toArray();		// Doesn't have a better solution due to language limitation as far as I know.
											// The ArrayList should only ever be able to contain elements of type E so this should be safe.
	}
}