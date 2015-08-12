/*
*
* Author: Bryan Metzger
* Structure: Stack
* Last Updated: August 12, 2015
* Version: 0.01
* Description: Java implementation of a Stack.  Built for Reusability with any given object.
* 
*/

import java.util.*;

public class bfmStack<T> {
	
	/* Global class vars used to keep track of the stack
	*	size : size of the stack
	*	top : top of the stack, sometimes known as first
	*/
	private int size; 
	private Node top;
	
	/*
	*  Private Node class, same one used in other classes
	*/ 
	private class Node<T> {
		private Node<T> next;
		private T data;
	
		//constructor
		public Node(T d, Node<T> n) {
			data = d;
			next = n;
		}
		//getters and setters
		public T getData(){
			return data;
		}
		public void setData(T t){
			data = t;
		}
		public Node<T> getNext(){
			return next;
		}
		public void setNext(Node<T> n){
			next = n;
		}
	}
	//constructor
	public bfmStack() {
		top = null;
		size = 0;
	}
	//Check if the stack is empty
	public boolean isEmpty() {
		if (top == null)
			return true;
		else
			return false
	}
	//get the size of the stack
	public int size() {
		return size;
	}
	//push an item onto the stack
	public void push(T item) {
		Node<T> oldTop = top;
		top = new Node(item, oldTop);
		size++;
	}
	// pop an item off of the stack.  Item is deleted.  Items are popped in LIFO order, throws exception if empty.
	public T pop() {
		if(isEmpty() == true) 
			throw new RuntimeException("Stack Underflow");
		T popped = top.item;
		top = top.getNext();
		size--;
		return popped;
	}
	//Check the top of the stack without removing it from the stack.
	public T peek() {
		if(isEmpty() == true)
			throw new RuntimeException("Stack Underflow");
		return top.getData();
	}
	//turn the stack into a string so that it can be read to the screen.
	public String toString() {
		Node<T> current = top;
		StringBuilder s = new StringBuilder(current.getData());
		for (int i = 0; i < this.size; i++) {
			s.append(current.getNext().getData() + " ");
			current = current.getNext();	
		}	
	}
}