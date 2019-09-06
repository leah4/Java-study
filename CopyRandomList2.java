import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;
}

public class CopyRandomList2 {

    //Map
    public static Node copyRandomList2 (Node head) {
        Node p = head;
        Node result = null;
        Node last = null;
        Map<Node, Node> map = new HashMap<>();

        while (p != null) {
            Node q = new Node();
            q.val = p.val;
            if (result == null) {
                result = q;
            } else {
                last.next = q;
            }
            last = q;
            map.put(p,q);
            p = p.next;
        }
        p = head;
        Node q = result;

        while (p != null){
            q.random = map.get(p.random);
            p = p.next;
            q = q.next;
        }
        return result;
    }
}