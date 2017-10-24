package Estructuras;

/**
* Implementation of the method for the List class.
*
* @version 2.0
* @author
* <b> Profesores DP </b><br>
* Program Development<br/>
* 16/17 Course
*/
public class List <T extends Comparable<T>> {
	/** Reference to the first element in the list*/
	private Node first;
	
	/** Reference to the last element in the list*/
	private Node last;
	
	/** List size*/
	Integer size=0;
	
    public class Node {
    	/** Data stored in each node */
        private T Data;
    	/** Reference to the next node */
        private Node next;
    	/** Reference to the previous node */
        private Node prev;

        /**
    	 * Parametrized Constructor for the Node class
    	 */
        public Node(Node prev, T Data, Node next) {
            this.Data = Data;
            this.next = next;
            this.prev = prev;
        }
    	/**
    	 * Method that returns the next node in the list (for traversing the list)
    	 *
    	 * @return the next node in the list
    	 */
        public Node next() {
        		return next;
        }
    	/**
    	 * Method that returns the previous node in the list (for traversing the list)
    	 *
    	 * @return the previous node
    	 */
        public Node prev() {
        		return prev;
        }

    	/**
    	 * Method to obtain a data
    	 *
    	 * @return the data contained in the current node
    	 */        
        public T get() {
        		return Data;
        }
    }//class Node

		
	/**
	 * Default Constructor for the List class
	 */
	public List() {
		first = last = null;
		size = 0;
	}

	
	/**
	 * Parametrized method for the List class
	 *
	 * @param data the data that the List will store
	 */
	public List(T data) {
		addLast(data);
	}
	
	/**
	 * Method that returns the element that is stored at the beginning of the list
	 *
	 * @return the first element
	 */
	public T getFirst() {
		return first.Data;
	}

	/**
	 * Method that returns the data that is stored at the end of the list
	 *
	 * @return the last data
	 */
	public T getLast() {
		return last.Data;
	}
	/**
	 * Method that returns the first node 
	 *
	 * @return first node
	 */
	public Node first() {
		return first;
	}

	/**
	 * Method that returns the node at the end of the list
	 *
	 * @return last node
	 */
	public Node last() {
		return last;
	}
	/**
	 *  Method to check whether the list is empty
	 *
	 * @return true if the list is empty and otherwise false 
	 */
	public boolean estaVacia (){
		return (size == 0);
	}
	
	/**
	 * Method that returns the size of the list
	 *
	 * @return the size of the list
	 */
	public Integer size (){
		return size;
	}
	
	/**
	 * Method that returns the data contained in the position passed as parameter
	 * @param pos the position of the element to be returned 
	 * @return the data contained in the position passed as parameter
	 */
	public T get (Integer pos){
		T d = null; 
		Node iter=first;
		Integer i=0; 
		boolean encontrado = false;
		while(i<=pos && !encontrado && iter!= null) {
			if(i==pos) {
				encontrado = true;
				d=iter.Data;
			}
			i++;
			iter=iter.next;
		}
		return d;
	}
	
	
	/**
	 * Method to add a data by the end of the list
	 *
	 * @param Data value that is going to be added to the list
	 */
	public void addLast(T Data) {
        Node l = last;
        Node nodo = new Node(l, Data, null);
        last = nodo;
        if (l == null)
            first = nodo;
        else
            l.next = nodo;
        size++;
	}
	
	/**
	 * It removes the last data in the list
	 *
	 */
	public void removeLast() {
		if (last != null){
			last = last.prev();
		}	
		//there are not elements
		if (last == null) 	first = null;
		else last.next=null;
		size --;
	}

	// ************************************************************************************
	// ***** Additional exercises for the students ****************************************
 	// ************************************************************************************
	/**
	 * It removes the first element in the list
	 *
	 */
	public void removeFirst() {
		if (first != null){
			first = first.next();
		}	
		//there are not elements
		if (first == null) 	last = null;
		else first.prev = null;
		size --;
	}
	
	
	/**
	 * It removes the data passed as parameter (if it is stored in the list)
	 *
	 * 
	 */
	public void removeDato(T dato) {
		Node aux;
		
		if (first.get() == dato) removeFirst();
		else if (last.get() == dato) removeLast();
		else {
			aux = first.next();
			while (aux != last) {
				if (aux.get() == dato) {
					aux.next().prev = aux.prev();
					aux.prev().next = aux.next();
					size--;
				} else aux = aux.next();
			}
		}
	}
	
	
	/**
	* It adds an elmement to the list in a sorted way
	*
	*/
	public void sortedAdd(T Data) {
		Node aux = first;
		boolean added = false;
		
		while (!added && aux != null) {
			if (aux.get().compareTo(Data) < 0) {
				Node newData = new Node (aux, Data, aux.next());
				aux.next().prev = newData;
				aux.next = newData;
				added = true;
				size++;
			} else aux = aux.next();
		}
	}
	
	/**
	 * It adds an element to the list by the beginning
	 *
	 * @param Data valor que se va a insertar
	 */
	public void addFirst(T Data) {
		Node f = first;
        Node nodo = new Node(null, Data, f);
        
        first = nodo;
        if (f == null) last = nodo;
        else f.prev = nodo;
        size++;
	}

	
	/**
	 * Checks whether a data is contained in the list
	 *
	 */
	public boolean contains(T Data) {
		boolean contained = false;
		Node aux = first;
		
		while (!contained && aux != null) {
			if (aux.get() == Data) contained = true;
			else aux = aux.next();
		}
		return contained;
   }
   
	/**
	 * It adds a data into the list before the value passed as parameter (searchedValue) 
	 *
	 * @param Data valor que se va a insertar
	 * @param valorbuscar valor delante del cual se insertará el nuevo dato
	 */
	public void addBefore(T Data, T searchedValue ) {
		boolean contained = false;
		Node aux = first;
		
		while (!contained && aux != null) {
			if (aux.get() == searchedValue) {
				if (first == aux) addFirst(Data);
				else {
					Node N = new Node (aux.prev(), Data, aux);
					aux.prev().next = N;
					aux.prev = N;
					size++;
				}
				contained = true;
			} else aux = aux.next();
		}
	}

	/**
	 * It adds a data into the list after the value passed as parameter (searchedValue) 
	 *
	 */
	public void addAfter(T Data, T searchedValue ) {
		boolean contained = false;
		Node aux = first;
		
		while (!contained && aux != null) {
			if (aux.get() == searchedValue) {
				if (last == aux) addLast(Data);
				else {
					Node N = new Node (aux, Data, aux.next());
					aux.next().prev = N;
					aux.next = N;
					size++;
				}
				contained = true;
			} else aux = aux.next();
		}
	}
	
	/**
	 * It adds a data into the list before the position passed as parameter (index) 
	 *
	 */
	public void addBeforeIndex(T Data, int index) {
		int i = 1;
		boolean contained = false;
		Node aux = first;
		
		while (!contained && aux != null) {
			if (i == index) {
				if (first == aux) addFirst(Data);
				else {
					Node N = new Node (aux.prev(), Data, aux);
					aux.prev().next = N;
					aux.prev = N;
					size++;
				}
				contained = true;
			} else {
				aux = aux.next();
				i++;
			}
		}
	}
   
	/**
	 * It adds a data into the list after the position passed as parameter (index)
	 *
	 */
	public void addAfterIndex(T Data, int index ) {
		int i = 1;
		boolean contained = false;
		Node aux = first;
		
		while (!contained && aux != null) {
			if (i == index) {
				if (last == aux) addLast(Data);
				else {
					Node N = new Node (aux, Data, aux.next());
					aux.next().prev = N;
					aux.next = N;
					size++;
				}
				contained = true;
			} else {
				aux = aux.next();
				i++;
			}
		}
	}

	/**
	 * It adds a data into the list in the position passed as parameter (index)
	 *
	 */
	public void addIndex(T Data, int index ) {
		int i = 1;
		boolean contained = false;
		Node aux = first;
		
		while (!contained && aux != null) {
			if (i == index) {
				if (first == aux) addFirst(Data);
				else {
					Node N = new Node (aux.prev(), Data, aux);
					aux.prev().next = N;
					aux.prev = N;
					size++;
				}
				contained = true;
			} else {
				aux = aux.next();
				i++;
			}
		}
	}

	/**
	 * Permite eliminar el Data almacenado en una posición dada
	 *
	 * @param index posición del Data que se eliminará
	 * @return el dato que está al inicio de la lista
	 */
	public T removeIndex(int index) {
		int i = 1;
		boolean contained = false;
		Node aux = first;
		
		while (!contained && aux != null) {
			if (i == index) {
				aux.next().prev = aux.prev();
				aux.prev().next = aux.next();
				size--;
				contained = true;
			} else {
				aux = aux.next();
				i++;
			}
		}
		return aux.get();
	}

	
	/**
	* Change the value stored in the index position by the data passed as parameter
	*/
	public void set(int index, T Data) {
		int i = 1;
		boolean contained = false;
		Node aux = first;
		
		while (!contained && aux != null) {
			if (i == index) {
				aux.Data = Data;
				contained = true;
			} else {
				aux = aux.next();
				i++;
			}
		}
	}
  
		
 /**
  * Main method. It tests the list and shows the results 
  *
  * @param args An array of String that the main method receives as parameter
  */
	public static void main (String args[]) {
		Integer[] dataSet = {new Integer(2), new Integer(8), 
							new Integer(3), new Integer(1),
							new Integer(4), new Integer(5),
							new Integer(6), new Integer(7),
							new Integer(9), new Integer(0)};
		
		//Testing the addition by the end 
		List <Integer> list = new List <Integer> ();
		for (int i = 0; i < dataSet.length; i++) {
			list.addLast(dataSet[i]);
		}
		
		//Showing the list
        List<Integer>.Node iteratorNode = list.first();
        while (iteratorNode!= null) {
        		System.out.print(iteratorNode.get() + " : ");
        		iteratorNode = iteratorNode.next();
        }
		System.out.println("\n--------------------------");

		//Showing the list
        for (int i=0;i<list.size();i++) {
    			System.out.print(list.get(i)+ " : ");
        }
		System.out.println("\n--------------------------");
        
		for (int i = 0; i < 5; i++)
			list.removeLast();
		
		//Showing the list
        for (int i=0;i<list.size();i++) {
    			System.out.print(list.get(i)+ " : ");
        }
		System.out.println("\n--------------------------");
	}
}



