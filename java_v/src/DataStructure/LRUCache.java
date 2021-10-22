package DataStructure;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : LA4AM12
 * @create : 2021-10-22 09:49:37
 * @description : LRU Cache
 */

class LRUCache extends LinkedHashMap<Integer,Integer> {
	private final int capacity;

	@Override
	protected boolean removeEldestEntry(Map.Entry eldest) {
		return size() > this.capacity;
	}

	public LRUCache(int capacity) {
		super(capacity,0.75f,true);
		this.capacity = capacity;
	}

	public int get(int key) {
		return getOrDefault(key,-1);
	}

	public void put(int key, int value) {
		super.put(key,value);
	}
}
