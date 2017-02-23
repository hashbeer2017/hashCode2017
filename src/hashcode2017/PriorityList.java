package hashcode2017;

import java.util.Iterator;
import java.util.LinkedList;

public class PriorityList<K> implements Iterable<K>{
	LinkedList<Pair<K, Integer>> list = new LinkedList<Pair<K,Integer>>();
	
	public void insert(K key, Integer value){
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
	
	public Integer get(K key){
		for(Pair<K, Integer> pair : list){
			if(pair.key.equals(key))
				return pair.value;
		}
		return -1;
	}
	
	public void reverse(){
		LinkedList<Pair<K, Integer>> result = new LinkedList<Pair<K, Integer>>();
		for(int i = list.size()-1; i >= 0; i--){
			PriorityList<K>.Pair<K, Integer> item = list.get(i);
			result.add(item);
		}
		this.list = result;
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

}
