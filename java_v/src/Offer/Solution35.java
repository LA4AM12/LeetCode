package Offer;

import Offer.struct.Node;

import java.util.HashMap;
import java.util.Map;

public class Solution35 {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Map<Node,Node> map = new HashMap<>();
        Node _head = new Node(head.val);
        map.put(head,_head);
        for (Node pt1 = head.next,pt2 = _head; pt1 != null; pt1 = pt1.next,pt2 = pt2.next){
            pt2.next = new Node(pt1.val);
            map.put(pt1,pt2.next);
        }
        for (Node pt1 = head,pt2 = _head; pt1 != null; pt1 = pt1.next,pt2 = pt2.next){
            pt2.random = map.get(pt1.random);
        }
        return _head;
    }
}
