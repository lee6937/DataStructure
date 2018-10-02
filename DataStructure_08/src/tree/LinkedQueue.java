package tree;

import tree.BinaryNode;

public class LinkedQueue { //linkedQueue Ŭ���� ����
    private Node head; //node������ head ���� ����

    public LinkedQueue() { //����Ʈ ������
        this.head = new Node(); //head�� node��ü ����
    }

    public boolean isEmpty() { //����ִ��� Ȯ�� �޼ҵ�
        return head.getNext() == head; //head�� �������� head�� ����Ű�� ������ �������
    }

    public void add(BinaryNode binaryNode) { //�߰��ϴ� �޼ҵ�
        head.addLast(binaryNode); //head�� addLast�޼ҵ忡 �Ű����� �Է�
    }

    public BinaryNode remove() { //�����ϴ� �޼ҵ�
        if (isEmpty()) { //����ִٸ�
            return null; //null ����
        } //������� �ʴٸ�
        return head.removeFirst().getValue(); //head�� ù���� �����ϸ鼭 ���� return 
    }
}
