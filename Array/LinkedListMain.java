class LinkedListMain {
    public static void main(String[] args) {
        
        // Setup the linked list
        LinkedList linkedList = new LinkedList();
        linkedList.add(0);
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);

        System.out.println(linkedList);

    }
}

class LinkedList {
    Node head;
    private Node tail;

    public void add(int value) {
        if(null == head) {
            head = new Node();
            head.value = value;
            head.next = null;

            tail = head;
        } else {
            Node nextNode = new Node();
            nextNode.value = value;
            nextNode.next = null;
            tail.next = nextNode;

            tail = nextNode;
        }
    }

    @Override
    public String toString() {
        String str = "";
        Node currentNode = head;
        while(null != currentNode) {
            str += currentNode.value + (currentNode.next == null ? "" :  " --> ");
            currentNode = currentNode.next;
        }

        return str;
    }
}

class Node {
    int value;
    Node next;
}