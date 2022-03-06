
import java.util.ArrayList;
import java.util.Random;

public class Point {
	private ArrayList<Point> neighbors;
	private int currentState;
	private int nextState;
	private int numStates = 6;
	
	public Point() {
		currentState = 0;
		nextState = 0;
		neighbors = new ArrayList<Point>();
	}
	public ArrayList<Point> getNeighbors(){
		return neighbors;
	}

	public void clicked() {
		currentState=(++currentState)%numStates;	
	}
	
	public int getState() {
		return currentState;
	}

	public void setState(int s) {
		currentState = s;
	}

	public void calculateNewState(int type) {
		//TODO: insert logic which updates according to currentState and 
		//number of active neighbors
		if (type == 1){
			if (currentState == 0){
				if (calculateNumberOfActiveNeighbors() == 3){
					nextState = 1;
				}
				else{
					nextState = 0;
				}
			}
			if (currentState == 1){
				if (calculateNumberOfActiveNeighbors() != 2 && calculateNumberOfActiveNeighbors() != 3){
					nextState = 0;
				}
				else{
					nextState = 1;
				}
			}
		}
		if (type == 2){
			if (currentState > 0){
				nextState = currentState - 1;
			}
			else if (currentState == 0 && neighbors.size() != 0 && neighbors.get(0).getState() > 0){
				nextState = 6;
			}
		}
	}

	public void changeState() {
		currentState = nextState;
	}
	
	public void addNeighbor(Point nei) {
		neighbors.add(nei);
	}
	
	//TODO: write method counting all active neighbors of THIS point
	public int calculateNumberOfActiveNeighbors(){
		int res = 0;
		for(int i = 0; i < neighbors.size(); i++){
			if (neighbors.get(i).getState() == 1){
				res += 1;
			}
		}
		return res;
	}

	public void drop(){
		Random rand = new Random();
		int x = rand.nextInt(20);
		if (x==5){
			currentState = 6;
		}

	}
}
