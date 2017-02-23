package input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import models.CacheServer;
import models.EndPoint;
import models.Request;
import models.Video;

public class Input {

	private int v, e, r, x, c = 0;
	private ArrayList<Video> videos = new ArrayList<Video>();
	private ArrayList<CacheServer> cacheServers = new ArrayList<CacheServer>();
	private ArrayList<EndPoint> endpoints = new ArrayList<EndPoint>();
	private ArrayList<Request> requests = new ArrayList<Request>();

	public void getData(String path) throws IOException {
		File file = new File(path);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = br.readLine();
		String[] values = line.split(" ");
		this.v = Integer.parseInt(values[0]);
		this.e = Integer.parseInt(values[1]);
		this.r = Integer.parseInt(values[2]);
		this.c = Integer.parseInt(values[3]);
		this.x = Integer.parseInt(values[4]);

		// Videos
		line = br.readLine();
		String[] splitted = line.split(" ");
		int i = 0;
		for (i = 0; i < splitted.length; i++) {
			Video v = new Video(i);
			v.setDim(Integer.parseInt(splitted[i]));
			videos.add(v);
		}

		// Endpoints
		int endpoint = 0;
		while (br.ready() && endpoint < this.getE()) {
			line = br.readLine();
			String[] endp = line.split(" ");
			EndPoint e = new EndPoint(endpoint);
			e.setLatencyDC(Integer.parseInt(endp[0]));
			int numCaches = Integer.parseInt(endp[1]);
			HashMap<CacheServer, Integer> map = new HashMap<>();
			for (int k = 0; k < numCaches; k++) {
				line = br.readLine();
				String[] cache = line.split(" ");
				CacheServer cs = new CacheServer(Integer.parseInt(cache[0]), this.getX());
				cacheServers.add(cs);
				map.put(cs, Integer.parseInt(cache[1]));
				e.setLatenciesCS(map);
			}
			endpoints.add(e);
			endpoint++;
		}

		// Requests
		int request = 0;
		while (br.ready() && request < this.getR()) {
			line = br.readLine();
			String[] req = line.split(" ");

			for (int f = 0; f < this.getR(); f++) {
				Request r = new Request(new Video(Integer.parseInt(req[0])), new EndPoint(Integer.parseInt(req[1])),
						Integer.parseInt(req[2]));
			}

			Request r = new Request(new Video(Integer.parseInt(req[0])), new EndPoint(Integer.parseInt(req[1])),
					Integer.parseInt(req[2]));
			requests.add(r);
			request++;
		}

		br.close();
	}

	public ArrayList<Video> getVideos() {
		return this.videos;
	}

	public ArrayList<CacheServer> getCacheServers() {
		return this.cacheServers;
	}

	public ArrayList<EndPoint> getEndpoints() {
		return this.endpoints;
	}

	public ArrayList<Request> getRequests() {
		return this.requests;
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
			i.getData("me_at_the_zoo.in");

			//
			// System.out.println("Videos"); ArrayList<Video> vi =
			// i.getVideos(); for (Video v : vi)
			// System.out.println(v.toString());
			//
			//
			// System.out.println("CacheServers"); ArrayList<CacheServer> cs =
			// i.getCacheServers(); for (CacheServer c : cs)
			// System.out.println(c.toString());
			//
			//
			// System.out.println("Endpoints");
			// ArrayList<EndPoint> en = i.getEndpoints();
			// for (EndPoint e : en)
			// System.out.println(e.toString());
			//
			// System.out.println("Requests");
			// ArrayList<Request> re = i.getRequests();
			// for (Request r : re)
			// System.out.println(r.toString());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
