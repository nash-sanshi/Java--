package src.main.java.day9.one;

public class Nine6_NodeTest {
	public static void main(String[] args) {
		Node node = new Node("node1");
		Node node2 = new Node("node2");
		Node node3 = new Node("node3");
		node.next = node2;
		node2.next = node3;
		System.out.println(node.next.next.data);
		
		Node node4 = new Node("node4");
		node.next = node4;
		node4.next = node2;
		System.out.println(node.next.next.next.data);
		
		node.next = node2;
		node4.next = null;
		System.out.println(node.data);
		System.out.println(node2.data);
		System.out.println(node3.data);
		System.out.println(node4.data);
	}

	static class Node {
		String data;//存放数据
		Node next;//存放指向下一个节点的引用
		public Node(String data)
		{
			this.data = data;
		}
	}
}

