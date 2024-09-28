class MyCircularDeque {
    Node tail;
    Node head;
    int k;
    int count = 0;
    public MyCircularDeque(int k) {
        this.k = k;
    }
    
    public boolean insertFront(int value) {
        if(tail == null && head == null) {
            tail = new Node(value);
            head = tail;
            count++;
            return true;
        }
        if(count < k) {
            Node toInsert = new Node(value);
            toInsert.next = head;
            head.prev = toInsert;
            head = toInsert;
            count++;
            return true;
        }else return false;


    }
    
    public boolean insertLast(int value) {
        if(tail == null && head == null) {
            tail = new Node(value);
            head = tail;
            count++;
            return true;
        }
        if(count < k) {
            Node toInsert = new Node(value);
            toInsert.prev = tail;
            tail.next = toInsert;
            tail = toInsert;
            count++;
            return true;
        }else return false;
    }
    
    public boolean deleteFront() {
        if(count == 0) {
            return false;
        }
        if(count == 1) {
            head = null;
            tail = null;
            count = 0;
            return true;
        }
        head = head.next;
        head.prev = null;
        count--;
        return true;
    }
    
    public boolean deleteLast() {
        if(count == 0) {
            return false;
        }
        if(count == 1) {
            head = null;
            tail = null;
            count = 0;
            return true;
        }
        tail = tail.prev;
        tail.next = null;
        count--;
        return true;
    }
    
    public int getFront() {
        if(count == 0) {
            return -1;
        }
        return head.val;
    }
    
    public int getRear() {
        if(count == 0) {
            return -1;
        }
        return tail.val;
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == k;
    }
}
class Node {
    int val;
    Node next;
    Node prev;

    public Node(int val) {
        this.val = val;
    }
}