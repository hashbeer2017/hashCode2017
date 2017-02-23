package models;

import java.util.HashMap;

public class EndPoint {
	private int id;
	private int latencyDC;
	private HashMap<Integer, Integer> latenciesCS;
	
	public EndPoint(int id){
		this.id = id;
	}

	public int getLatencyDC() {
		return latencyDC;
	}

	public void setLatencyDC(int latencyDC) {
		this.latencyDC = latencyDC;
	}

	public HashMap<Integer, Integer> getLatenciesCS() {
		return latenciesCS;
	}

	public void setLatenciesCS(HashMap<Integer, Integer> latenciesCS) {
		this.latenciesCS = latenciesCS;
	}

	
}
