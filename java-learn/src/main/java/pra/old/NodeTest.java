package src.main.java.pra.old;

public class NodeTest {
    public static void main(String[] args) {
        Node node1 = new Node("node1");
        Node node2 = new Node("node2");
        Node node3 = new Node("node3");
        node1.next = node2;
        node2.next = node3;
        System.out.println(node1.next.next.str);

        Node node4 = new Node("node4");
        node3.next = node4;
        System.out.println(node1.next.next.next.str);
    }

    private static class Node{
        String str;
        Node next;

        public Node(String str) {
            this.str = str;
        }
    }
}
