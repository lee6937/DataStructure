package tree;

import tree.BinaryNode; 

public class Node { //��� Ŭ���� ����
    private Node next; //������ ����Ű�� ���� ����
    private Node prev; //������ ����Ű�� ���� ����
    private BinaryNode value; //BinaryNode������  �� ���� ����
    
    Node() { //����Ʈ ������
        next = this; //next�� �ڱ��ڽ�(head)�� ����Ŵ
        prev = this; //prev�� �ڱ��ڽ�(head)�� ����Ŵ
    }

    private Node(BinaryNode value) { //�Ű������� ���� ������
        this.value = value; //���������� �������� ���� ����
    }

    public void addLast(BinaryNode value) { //����� ���� ���� �ִ� �Լ�
        Node newNode = new Node(value); //���ο� ��� ���� �� �Ű����� �� �Է�

        this.prev.next = newNode; //head�� prev�� head�� ����, �� head�� next�� newNode����
        newNode.prev = this.prev; //newNode�� prev�� head�� prev�� ����, �ᱹ head�� ����
        newNode.next = this; //newNode�� next�� head�� ����
        this.prev = newNode; //head�� prev�� newNode�� ���� => Doubly LinkedList������ ȯ�� ť�� ������.
    } // = ��� ���� �߰��� ���� newNode�� head�� ���� �ٰ� �� newNode�� next�� head�� �����ϸ鼭 ȯ�� ť�� ����

    public Node removeFirst() { //����� ù���� �����ϸ鼭 return�ϴ� �Լ�
        Node node = this.next; //node�� head�� ������ �Է�
        this.next = node.next; //head�� �������� node�� ������ �Է�
        this.next.prev = this; //head�� �������� prev�� head�� ���� => node�� next�� prev�� �������
        return node; //������ node�� ����
    }

    public Node getNext() { //next getter
        return this.next;
    }

    public BinaryNode getValue() { //value getter
        return this.value;
    }

}
