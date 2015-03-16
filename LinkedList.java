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
	/*
	* Add at index function, overloaded. The function inserts a node at the given index. 
	* Throws exception if index is out of bounds.
	* parameter values: value = data to be added to the list, index = place in the list where new node is added.
	*/
	public void add(T value, int index) throws NoNextNodeException{
		if((index < 1) || (index > ListCounter)){
			throw new NoNextNodeException("Invalid index: " + index + "only indexes 1 through " + (ListCounter) + "are valid indexes");
		}
		else {
			Node<T> temp = new Node<T>(value, null);
			Node<T> current = head;
			for (int i = 1; i < index && current.getNext() != null; i++) {
            	current = current.getNext();
        	}
        	temp.setNext(current.getNext());
        	current.setNext(temp);
		}
		ListCounter++;	
	}
	/*
	* Remove function, crawls through to the specified index and sets the next node reference to the next next node,
	* essentially skipping a node, garbage collection then takes care of the skipped node.  Throws and exception if
	* the index is out of bounds.
	* parameter value: index = index of node to be removed
	*/
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
	public String toString() {
        Node current = head;
        String output = "";
        while (current.getNext() != null) {
            output += "[" + current.getData().toString() + "]";
            current = current.getNext();
        }
        return output;
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