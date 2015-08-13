/*
*
* Author: Bryan Metzger
* Structure: Queue
* Last Updated: August 12, 2015
* Version: 0.01
* Description: Java implementation of a Queue.  Built for Reusability with any given object.
* 
*/

public class bfmQueue<T> {
	
	//globals for bfmQueue
	private Node<T> tail, head;
	private int size;
	
	/*
	*  Constructor Method
	*/
	public bfmQueue<T>() {
		head = null;
		tail = null;
		size = 0;
	}
	
	/*
	*  Enqueue Method: Adds an object to the rear of the queue.  
	*/
	public void enqueue(T item) {
		boolean empty = isEmpty();
		Node<T> node = new Node<T> (item, null);
		if(empty == true) {
			head = node;
		}
		else {
			tail.setNext(node);
		}
		tail = node;
		size++;
	}
	
	/*
	*  Dequeue Method: Removes an object from the front of the queue
	*/
	public T dequeue() {
		if(isEmpty() == true) 
			throw new RuntimeException("Queue Empty");
		T dequeued = head.getData();
		
		if (head == tail) 
			tail = null;
		
		head = head.getNext();
		size--;
		return dequeued;
	}
	
	/*
	*  Peek Method:  Return the head element without removing it.  
	*/
	public T peek() {
		if(head == null) {
			throw new RuntimeException("Queue Empty");
		}
		return head.getData()
	}
	
	/*
	*  Check if the queue is empty
	*/
	public boolean isEmpty() {
		if(head == null) {
			return true;
		}
		else
			return false;
	}
	/*
	*  Return the size of the queue
	*/
	public int getSize() {
		return size;
	}
	
	/*
	*  Return the queue as a string
	*/
	
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

}