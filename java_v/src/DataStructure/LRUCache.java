package DataStructure;


import java.util.HashMap;
import java.util.Map;

/**
 * @author : LA4AM12
 * @create : 2021-10-22 09:49:37
 * @description : LRU Cache
 */

class LRUCache {
	class Entry {
		int key, value;
		Entry before, after;

		public Entry() {}

		public Entry(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	private Map<Integer,Entry> cache;
	private int capacity;
	private Entry head, tail;

	public LRUCache(int capacity) {
		cache = new HashMap<>(capacity);
		this.capacity = capacity;

		//dummy head & tail
		this.head = new Entry();
		this.tail = new Entry();
		head.after = tail;
		tail.before = head;
	}

	public int get(int key) {
		Entry entry = cache.get(key);
		if (entry == null)
			return  -1;

		//move to head
		moveToHead(entry);

		return entry.value;
	}

	public void put(int key, int value) {
		Entry entry = cache.get(key);
		if (entry == null) {
			if (cache.size() == capacity){
				cache.remove(tail.before.key);
				remove(tail.before);
			}

			Entry newEntry = new Entry(key, value);
			cache.put(key,newEntry);
			addToHead(newEntry);
		}else {
			entry.value = value;
			moveToHead(entry);
		}
	}

	private void moveToHead(Entry entry) {
		remove(entry);
		addToHead(entry);
	}

	private void remove(Entry entry) {
		entry.before.after = entry.after;
		entry.after.before = entry.before;
		entry.before = entry.after = null;  //help GC
	}

	private void addToHead(Entry entry) {
		entry.before = head;
		entry.after = head.after;

		head.after.before = entry;
		head.after = entry;
	}
}