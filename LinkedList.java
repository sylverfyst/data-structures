/*
* Author: Bryan Metzger
* Structure: LinkedList
* Last Updated: March 16 2015
* Version: 0.01
* Description: Java implementation of a singly linked list.
* 
*/

public class SingleLinkedList<T> {
	private Node<T> head;
	private int ListCounter;
	
	
	//constructor for singly linked list, we are NOT using the dummy head for this list
	public SingleLinkedList() {
		head = null;
		ListCounter = 0;
	}
	//setters and getters
	public int getSize(){
		return ListCounter;
	}
	public void setSize(int x){
		ListCounter = x;
	}
	/*
	* Recursive add function for singly linked list.  Appends to the end of the list.
	* Creates a new head node if the list is empty.  
	* parameter value: value = data to be stored in new node added to list.  
	*/
	public void add(T value){
		if(head == null){
			head = new Node<T>(value, null);
		}
		else{
			add(head, value);
		}
		ListCounter++;
	}
	public void remove(int index) throws NoNextNodeException {
		if((index < 1) || (index > ListCounter)){
			throw new NoNextNodeException("Invalid index: " + index + "only indexes 1 through " + ListCounter + "are removable");
		}
		else if (index == 1) {
			head = head.getNext();
		}
		else {
			Node<T> n = head;
			for(int i = 2; i < index; i++){
				n = n.getNext();
			}
			n.setNext(n.getNext().getNext());
		}
		ListCounter--;
	}
}

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