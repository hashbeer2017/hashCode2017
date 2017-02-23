package models;

import java.util.HashMap;

public class EndPoint {
	private int id;
	private int latencyDC;
	private HashMap<Integer, Integer> latenciesCS;
	
	public EndPoint(int id){
		this.id = id;
	}
	
	public int getLatDC() {
		return latDC;
	}

	public void setLatDC(int latDC) {
		this.latDC = latDC;
	}

	public HashMap<Integer, Integer> getLatsCS() {
		return latsCS;
	}

	public void setLatsCS(HashMap<Integer, Integer> latsCS) {
		this.latsCS = latsCS;
	}
}
