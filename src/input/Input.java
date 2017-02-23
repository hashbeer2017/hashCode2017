package input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import models.Video;

public class Input {

	private int v, e, r, x, c = 0;

	public void getData(String path) throws IOException {
		File file = new File(path);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = br.readLine();
		String[] values = line.split(" ");
		this.v = Integer.parseInt(values[0]);
		this.e = Integer.parseInt(values[1]);
		this.r = Character.getNumericValue(line.charAt(4));
		this.c = Character.getNumericValue(line.charAt(6));
		this.x = Character.getNumericValue(line.charAt(8));

		line = br.readLine();
		String[] splitted = line.split(" ");
		int i = 0;
		for (i = 0; i < splitted.length; i++) {
			Video v = new Video(i, Integer.parseInt(splitted[i]));
			System.out.println(i + " " + Integer.parseInt(splitted[i]));
		}

		br.close();
	}

	public int getV() {
		return this.v;
	}

	public int getE() {
		return this.e;
	}

	public int getR() {
		return this.r;
	}

	public int getC() {
		return this.c;
	}

	public int getX() {
		return this.x;
	}

	public static void main(String[] args) {
		Input i = new Input();
		try {
			i.getData("kittens.in");
			System.out.println(i.getV());
			System.out.println(i.getE());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
