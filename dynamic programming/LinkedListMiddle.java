// Simple custom linked list programs +
// WAP to find the center item of a linked list
class LinkedListMiddle {
    public static void main(String[] args) {
        
        // Setup the linked list
        LinkedList linkedList = new LinkedList();
        linkedList.add(0);
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);

        System.out.println(linkedList);

        // Find the middle of the linked list
        Node normalNode = new Node(); // This is the normal node, will move 1 node per iteration
        normalNode.value = linkedList.head.value;
        normalNode.next = linkedList.head.next;

        Node fastNode = new Node(); // The fast noce, will iterate 2 nodes per iteration
        fastNode.value = linkedList.head.value;
        fastNode.next = linkedList.head.next;

        while(null != normalNode && null != fastNode) {
            // First check if the faster one is at the end
            fastNode = fastNode.next;
            if(null != fastNode) {
                fastNode = fastNode.next;
            } else {
                break;
            }

            // If the faster one is not at the end, then only move forward
            normalNode = normalNode.next;
        }

        System.out.println(normalNode.value);
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