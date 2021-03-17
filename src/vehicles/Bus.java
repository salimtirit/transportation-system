// separator	Bus.java_0_false.txt
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

// separator	Bus.java_1_true.txt

package vehicles;

/**
 * Child class of PublicTransport @see PublicTransport 
 * 
 * @author Salim Kemal Tirit
 *
 */
public class Bus extends PublicTransport {
	
	/**
	 * Constructor method.
	 *  
	 * @param ID	ID of the vehicle
	 * @param x1	Lower limit in x axis
	 * @param y1	Lower limit in y axis
	 * @param x2	Upper limit in x axis
	 * @param y2	Upper limit in y axis
	 */
	public Bus(int ID, double x1, double x2, double y1, double y2) {
		super(ID, x1, x2, y1, y2);
	}

	/**
	 * Standard price of bus. Does not change as the travel distance changes.
	 * @return	Price of bus.
	 */
	public int getPrice() {
		return 2;
	}
}


// separator	Bus.java_2_false.txt
//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

