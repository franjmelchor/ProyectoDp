

/**
 * Implementation of the method for the Stack class.
*
* @version 2.0
* @author
* <b> Profesores DP </b><br>
* Program Development<br/>
* 16/17 Course
 */
public class Stack {
	
	/** Reference to the top of the stack*/
	private Node top;
	
    private class Node {
    	/** Data stored in each node */
        private Integer data;
    	/** Reference to the next node */
        private Node next;
        
        /**
    	 * Parametrized Constructor for the Node class
    	 */
        Node (Integer data) {
            this.data = data;
            this.next = null;
        }
    }//class Node
    
    /**
	 * Default Constructor for the Stack class
	 */
	public Stack() {
		top = null;
	}

	/**
	 * Parametrized method for the List class
	 *
	 * @param data the data that the Stack will store
	 */
	public Stack(Integer data) {
		Node node = new Node(data);
		node.next = top;
		top = node;
	}
	
	/**
	 * Method that returns the data in the top of the Stack
	 *
	 * @return the data in the top of the Stack
	 */
	public Integer getTop(){
		return top.data;
	}
	

	/**
	 * Method to check whether the stack is empty 
	 *
	 * @return true if the stack is empty and otherwise false
	 */
	public boolean isEmpty (){
		return (top==null);
	}
	

	/**
	 * Method that adds a data into the stack
	 *
	 * @param data the value that will be added 
	 */
	public void addData (Integer data) {
		Node node = new Node(data);
		node.next = top;
		top = node;
	}


	/**
	* Removes a data from the stack (the data in the top)
	*/
	public void removeData() {
		if (!isEmpty()){		
			top = top.next;
		}
	}


	/**
	  * Main method. It tests the list and shows the results 
	  *
	  * @param args An array of String that the main method receives as parameter
	  */
	public static void main (String args[]) {
		Integer[] dataSet = {new Integer(2),new Integer(8),new Integer(3),
							new Integer(4),new Integer(1),new Integer(5)};
		
		//Testing the addition in the stack 
		Stack stack = new Stack();		
		for (int i = 0; i < dataSet.length; i++) {
			stack.addData(dataSet[i]);
		}

		//Showing the stack
		while(!stack.isEmpty()){
			System.out.print(stack.getTop() + " : ");
			stack.removeData();
		}
			
		System.out.println();
	}
}
