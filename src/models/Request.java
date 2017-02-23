package models;

public class Request {
	private Video video;
	private Endpoint endpoint;
	private int nrReq;
	
	public Request(Video v, Endpoint ep, int nr){
		this.video = v;
		this.endpoint = ep;
		this.nrReq = nr;
	}
}
