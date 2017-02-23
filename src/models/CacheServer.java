package models;

import java.util.ArrayList;

public class CacheServer {
	private int id;
	private int size;
	private ArrayList<Video> videos;
	
	public CacheServer(int id, int size) {
		this.id = id;
		this.size = size;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public ArrayList<Video> getVideos() {
		return videos;
	}

	public void setVideos(ArrayList<Video> videos) {
		this.videos = videos;
	}
	
	
}
