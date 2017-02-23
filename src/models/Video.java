package models;

public class Video {
	private int id;
	private int dim;
	
	public Video(int id, int dim){
		this.id = id;
		this.dim = dim;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDim() {
		return dim;
	}

	public void setDim(int dim) {
		this.dim = dim;
	}
}
