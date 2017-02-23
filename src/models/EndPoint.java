package models;

import java.util.HashMap;

public class EndPoint {
	private int id;
	private int latencyDC;
	private HashMap<CacheServer, Integer> latenciesCS;
	
	public EndPoint(int id){
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLatencyDC() {
		return latencyDC;
	}

	public void setLatencyDC(int latencyDC) {
		this.latencyDC = latencyDC;
	}

	public HashMap<CacheServer, Integer> getLatenciesCS() {
		return latenciesCS;
	}

	public void setLatenciesCS(HashMap<CacheServer, Integer> latenciesCS) {
		this.latenciesCS = latenciesCS;
	}

	
}
