package hashcode2017;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class PriorityList<K> implements Iterable<K>{
	private ArrayList<Pair<K, Integer>> list = new ArrayList<Pair<K,Integer>>();
	HashSet<Pair<K, Integer>>[] array = new HashSet[1000];
	
	public void orderedInsert(K key, Integer value){
		if(list.isEmpty()){
			list.add(new Pair<K, Integer>(key,value));
		} else {
			boolean ok = false;
			int i = 0;
			
			while(!ok){
				if(value < list.get(i).value){
					list.add(i, new Pair<K, Integer>(key, value));
					ok = true;
				} else {
					if(i == list.size()-1){
						list.add(new Pair<K, Integer>(key, value));
						ok = true;
					} else {
						i++;
					}
				}
			}
			
		}
	}
	
	public void insert(K key, Integer value){
		list.add(new Pair<K, Integer>(key, value));
	}
	
	public void hashInsert(K key, Integer value){
		if(array[value] == null){
			array[value] = new HashSet<Pair<K, Integer>>();
		}
		array[value].add(new Pair<K, Integer>(key, value));
	}
	
	public void hashSort(){
		for(int i = 0; i < array.length; i++){
			HashSet<Pair<K, Integer>> set = array[i];
			if(set != null){
				for(Pair<K, Integer> pair : set){
					list.add(pair);
				}
			}
		}
	}
	
	public Integer get(K key){
		for(Pair<K, Integer> pair : list){
			if(pair.key.equals(key))
				return pair.value;
		}
		
		return -1;
	}
	
	public void sort(){
		list.sort(new Comparator<Pair<K, Integer>>() {

			@Override
			public int compare(PriorityList<K>.Pair<K, java.lang.Integer> o1,
					PriorityList<K>.Pair<K, java.lang.Integer> o2) {
				if(o1.value > o2.value)
					return +1;
				else if (o1.value < o2.value)
					return -1;
				else
					return 0;
			}
		});
	}
	
	public void sortDesc(){
		list.sort(new Comparator<Pair<K, Integer>>() {

			@Override
			public int compare(PriorityList<K>.Pair<K, java.lang.Integer> o1,
					PriorityList<K>.Pair<K, java.lang.Integer> o2) {
				if(o1.value < o2.value)
					return +1;
				else if (o1.value > o2.value)
					return -1;
				else
					return 0;
			}
		});
	}

	public boolean isEmpty(){
		return this.list.isEmpty();
	}
	
	@Override
	public Iterator<K> iterator() {		
		return new Iterator<K>() {
			int i = 0;
			
			@Override
			public boolean hasNext() {
				return i < list.size();
			}

			@Override
			public K next() {
				return list.get(i++).key;
				
			}
		};
	}
	
	@SuppressWarnings("hiding")
	class Pair<K, Integer> {
		K key;
		Integer value;
		
		public Pair(K key, Integer value) {
			this.key = key;
			this.value = value;
		}
		
		@Override
		public String toString() {
			return key + " " + value;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("BENCHMARK-----------");
		
		// Generate dataset
		long startTime = System.currentTimeMillis();
		PriorityList<String> dataInsert = new PriorityList<String>();
		for(int i = 0; i < 10000; i++){
			dataInsert.insert("a", new Random().nextInt(10000));
		}
		dataInsert.sort();
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Insert + sort: " + totalTime);
		
		
		
		startTime = System.currentTimeMillis();
		dataInsert = new PriorityList<String>();
		for(int i = 0; i < 1000; i++){
			dataInsert.orderedInsert("a", new Random().nextInt(1000));
		}
		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("Ordered insert: " + totalTime);
		
		
		
		startTime = System.currentTimeMillis();
		dataInsert = new PriorityList<String>();
		for(int i = 0; i < 1000; i++){
			dataInsert.hashInsert("a", new Random().nextInt(1000));
		}
		dataInsert.hashSort();
		endTime   = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("Hash insert: " + totalTime);
		
		
		System.out.println("--------------------");
		
		
		
		
		
		
	}

}
