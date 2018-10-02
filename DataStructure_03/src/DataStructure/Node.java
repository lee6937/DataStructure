package DataStructure;

public class Node {

	private int coin;
    private Node next;

    public Node() {
    	this.next = null;
    }

    public Node(int coin) {
        this.coin = coin;
    }

    public void setNext(Node node) {
        this.next = node;
    }
    public int coin() {
        return this.coin;
    }

    public Node next() {
        return this.next;
    }
}
