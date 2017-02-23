package models;

import java.util.ArrayList;

public class CacheServer {
	private int id;
	private int emptysize;
	private int size;
	private ArrayList<Video> videos;
	
	public CacheServer(int id, int es) {
		this.id = id;
		this.emptysize = es;
		this.videos = new ArrayList<Video>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getEmptysize() {
		return emptysize;
	}

	public void setEmptysize(int emptysize) {
		this.emptysize = emptysize;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public void addVideo(Video v){
		videos.add(v);
		size = size - v.getDim();
	}
	
	public ArrayList<Video> getVideos() {
		return videos;
	}
	
	public void setVideos(ArrayList<Video> videos) {
		this.videos = videos;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this.id == ((CacheServer) obj).getId())
			return true;
		
		return false;
	}

	@Override
	public String toString() {
		String ts = "CacheServer [id=" + id + ", emptysize=" + emptysize + ", size=" + size + ", videos=";
		for(Video v: videos){
			ts = ts + v.toString() + " ";
		}
		
		return ts + "]";
	}
}
