// separator	Train.java_0_false.txt
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

// separator	Train.java_1_true.txt

package vehicles;

/**
 * Child class of PublicTransport @see PublicTransport 
 * 
 * @author Salim Kemal Tirit
 *
 */
public class Train extends PublicTransport {
	/**
	 * Constructor method.
	 *  
	 * @param ID	ID of the vehicle
	 * @param x1	Lower limit in x axis
	 * @param y1	Lower limit in y axis
	 * @param x2	Upper limit in x axis
	 * @param y2	Upper limit in y axis
	 */
	public Train(int ID, double x1, double x2, double y1, double y2) {
		super(ID, x1, x2, y1, y2);
	}

	/**
	 * Standard price for Train, changes as the travel distance changes.
	 * @param distance	Travel distance.
	 * @return			Price of train for the distance.
	 */
	public int getPrice(double distance) {
		double remain = distance;
		int numberOfStops = 0;
		while (remain > 7.5) {
			numberOfStops++;
			remain -= 15;
		}
		return 5 * numberOfStops;
	}
}


// separator	Train.java_2_false.txt
//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

