public class Point {

	public Point nNeighbor;
	public Point wNeighbor;
	public Point eNeighbor;
	public Point sNeighbor;
	public float nVel;
	public float eVel;
	public float wVel;
	public float sVel;
	public float pressure;
	public static Integer []types ={0,1,2};
	int type;
	int sinInput;



	public Point() {
		clear();
		type = 0;
	}

	public void clicked() {
		pressure = 1;
	}
	
	public void clear() {
		// TODO: clear velocity and pressure
		pressure = 0;
		nVel = 0;
		eVel = 0;
		wVel = 0;
		sVel = 0;
	}

	public void updateVelocity() {
		// TODO: velocity update
		if (type == 0){
			nVel = nVel - (nNeighbor.pressure-pressure);
			sVel = sVel - (sNeighbor.pressure-pressure);
			eVel = eVel - (eNeighbor.pressure-pressure);
			wVel = wVel - (wNeighbor.pressure-pressure);
		}
	}

	public void updatePressure() {
		// TODO: pressure update
		if (type == 0){
			pressure = pressure - (float)0.5*(nVel+sVel+eVel+wVel);
		}
		if (type == 2){
			double radians = Math.toRadians(sinInput);
			pressure = (float) (Math.sin(radians));
		}
	}

	public float getPressure() {
		return pressure;
	}
}