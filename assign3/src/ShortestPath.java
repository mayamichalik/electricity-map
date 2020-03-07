/**
 /**
 * @author Maya Michalik
 * March 21 2019
 * this program finds the shortest if possible, path to the customer from WPC
 */
import java.io.IOException;

public class ShortestPath {
	Map cityMap;
	// Initializes variable
	
	/**
	 * opens map file and catches exceptions
	 * @param filename
	 */
	public ShortestPath (String filename) {
		try {
			cityMap = new Map(filename);
		} catch (InvalidMapException | IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * creates algorithm for finding the best path
	 * @param args
	 */
	public static void main (String[] args) {
		if(args.length < 1) {
			System.out.println("You must provide the name of the input file.");
			System.exit(0);
			//exits if you don't provide an input file
		}
		
		String mapFile = args[0];
		ShortestPath input = new ShortestPath(mapFile);
		
		DLList<MapCell> list = new DLList<MapCell>();
		// creates new doubly linked list
		MapCell curr = input.cityMap.getStart();
		list.insert(curr, 0);
		MapCell small = curr;
		int distance = 0;
		//Initializes variables
		curr.markInList();
		//marks initial cell
		
		boolean found = false;
		// Initializes boolean
		while( found == false && ! list.isEmpty()){

			small = list.getSmallest();
			small.markOutList();

			//algorithm for finding a path
			if (curr != null) {
				if (small.isCustomer()) {
					found = true;
					System.out.println("The customer has been found.");
					System.out.println("Number of Steps: " + small.getDistanceToStart()+1);
					// if customer is reached, tell the user that the destination has been reached and how many steps were taken
				}
				else {
					while(input.nextCell(small)!=null) {
						curr = input.nextCell(small);
						
						distance = 1 + small.getDistanceToStart();
						int currDist = curr.getDistanceToStart();
						//Initializes distances

						if(currDist > distance) {
							curr.setDistanceToStart(distance);;	
							curr.setPredecessor(small);
							//sets predecessor
						}
						int currDistanceP = curr.getDistanceToStart();
						if (curr.isMarkedInList() && currDistanceP < list.getDataValue(curr)) {
							list.changeValue(curr, currDistanceP);
							//changes value
						}
						if(!curr.isMarkedInList()) {
							list.insert(curr, currDistanceP);
							curr.markInList();
							//inserts new node
						}
					}

				}
			}
		}
	}
	
	/**
	 * finds the next cell to go to
	 * @param cell
	 * @return result
	 */
	private MapCell nextCell(MapCell cell) {
		MapCell currCell = cell;
		MapCell result = null;

		// Initializes variables
		
		for (int i = 0; i <= 3; i++) {
			// for loop to check all possible neighbours
			if (currCell.isHorizontalSwitch()) {
				 i++;
				//check to make sure horizontal doesn't go into a vertical switch
			}
			MapCell neighbour = currCell.getNeighbour(i);
			//Initializes neighbour to current cell
			 try {
				 if (!neighbour.isMarked()) {
					if(neighbour.isCustomer()){
						result = neighbour; 
						break;	 
						//exits loop if current neighbour is customer
					}
					else if(result == null) {
						if (neighbour.isOmniSwitch() || neighbour.isVerticalSwitch()|| neighbour.isHorizontalSwitch()) {
							if (neighbour.isOmniSwitch()) {
								result = neighbour;
							}
							else if(neighbour.isVerticalSwitch() && i % 2 == 0) {
								result = neighbour;
							}
							else if (neighbour.isHorizontalSwitch() && i % 2 != 0) {
								result = neighbour;
							}
						} 
					}
				}
				if(currCell.isVerticalSwitch()) { 
					i++;
					// make sure that the horizontal switch dosen't go to a vertical switch
					}
			
			}
			 catch(NullPointerException e) {
			 }
		}
		return result;
	}
		
}