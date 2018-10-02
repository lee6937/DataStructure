package DataStructure_04;

public class Node {
	
	private String coin; //string ������ ���� ����
    private Node next; // next���� ����

    public Node() { //�⺻ ������
    	this.next = null; //next�� �ʱ�ȭ
    }

    public Node(String coin) { //�Ű����� �ִ� ������
        this.coin = coin; //�Ű������� �������� ��ġ
        this.next = null; //next�� �ʱ�ȭ
    }

    public void setNext(Node node) { //�޼ҵ� ����
        this.next = node; //next���� �Ű����� �� �Է�
    }
    public String coin() { //coin getter
        return this.coin; //�������� ����
    }

    public Node next() { //next getter
        return this.next; //�������� ����
    }
}
