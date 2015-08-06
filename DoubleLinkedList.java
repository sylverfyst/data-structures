/*
* Author: Bryan Metzger
* Structure: DoublyLinkedList
* Last Updated: March 17 2015
* Version: 0.01
* Description: Java implementation of a doubly linked list.
* 
*/

public class DoubleLinkedList<T> {
	
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	public DoubleLinkedList(){
		head = null;
		tail = null;
		size = 0;
	}
	public int getSize(){
		return size;
	}
	public boolean isEmpty(){
		if(size == 0){
			return true;
		}
		else
			return false;
	}
	public void add(T d){
		Node<T> n = new Node<T>(d);
		if(this.isEmpty()){
			head = n;
		}
		else {
			tail.setNext(n);
			n.setPrev(tail);
		}
			tail = n;
	}
}

/* Node Class for doubly linked list, differs from singly linked list because of the reference
* to the previous node.
*/
private class Node<T> {
	private Node<T> next;
	private Node<T> prev
	private T data;
	
	//constructor
	public Node(T d, Node<T> n, Node<T> p) {
		data = d;
		next = n;
		prev = p;
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
	public Node<T> getPrev(){
		return prev;
	}
	public void setPrev(Node<T> p){
		prev = p;
	}
}