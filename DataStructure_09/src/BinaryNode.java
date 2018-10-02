public class BinaryNode { //����� Binary���
    private int value; //��尡 ������ �ִ� ��
    private BinaryNode parent; // ����� �θ� ����Ű�� ����
    private BinaryNode left; //����� ���� �ڽ��� ����Ű�� ����
    private BinaryNode right; //����� ������ �ڽ��� ����Ű�� ����

    BinaryNode(int value) { //���� �Ű������� �ϴ� ������
        this.value = value; //�Ű������� �������� ��ġ
        this.left = null; //���� �ڽ� �ʱ�ȭ
        this.right = null; //������ �ڽ� �ʱ�ȭ
        this.parent = null; //�θ� �ʱ�ȭ
    }

    public int getValue() { //value setter
        return value;
    }
    
    public void setValue(int value) { //value setter
    	this.value = value;
    }

    public void setParent(BinaryNode parent) { //parent setter
        this.parent = parent;
    }

    public void setLeft(BinaryNode left) { //left setter
        this.left = left;
    }

    public void setRight(BinaryNode right) { //right setter
        this.right = right;
    }

    public BinaryNode getParent() { //parent getter
        return this.parent;
    }

    public BinaryNode getLeft() { //left getter
        return this.left;
    }

    public BinaryNode getRight() { //right getter
        return this.right;
    }

    public boolean hasParent() { //�θ� Ȯ�� �޼ҵ�
        return this.parent != null; //�θ� ������ true ����
    }

    public boolean hasLeft() { //���� �ڽ� Ȯ�� �޼ҵ�
        return this.left != null; //���� �ڽ��� ������ true ����
    }

    public boolean hasRight() { //������ �ڽ� Ȯ�� �޼ҵ�
        return this.right != null; //������ �ڽ��� ������ true ����
    }

}
