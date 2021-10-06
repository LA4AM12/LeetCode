package medium

// leetcode-0146 2021/3/29

type DNode struct {
	key, val   int
	prev, next *DNode
}

type LRUCache struct {
	capacity   int
	cache      map[int]*DNode
	head, tail *DNode
}

func (*LRUCache) Constructor(capacity int) LRUCache {
	lru := LRUCache{
		head:     &DNode{},
		tail:     &DNode{},
		capacity: capacity,
		cache:    map[int]*DNode{},
	}
	lru.head.next = lru.tail
	lru.tail.prev = lru.head
	return lru
}

func (this *LRUCache) Get(key int) int {
	if _, ok := this.cache[key]; !ok {
		return -1
	}
	this.makeRecently(key)
	return this.cache[key].val
}

func (this *LRUCache) Put(key int, value int) {
	//检查是否存在这个key  if exist
	if _, ok := this.cache[key]; ok {
		this.cache[key].val = value
		this.makeRecently(key)
	} else {
		if this.capacity == 0 {
			delete(this.cache, this.head.next.key)
			this.head.next = this.head.next.next
			this.head.next.prev = this.head
		} else {
			this.capacity--
		}
		node := &DNode{
			key:  key,
			val:  value,
			prev: this.tail.prev,
			next: this.tail,
		}
		this.tail.prev.next = node
		this.tail.prev = node
		this.cache[key] = node
	}
}

func (this *LRUCache) makeRecently(key int) {
	node := this.cache[key]

	//delete node
	node.prev.next = node.next
	node.next.prev = node.prev

	//add to tail
	node.prev = this.tail.prev
	node.next = this.tail
	this.tail.prev.next = node
	this.tail.prev = node
}
