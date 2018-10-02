package tree;

public class BinaryNode {
    private String value; //String ������ ���� �����ϴ� ����
    private BinaryNode parent; //BinaryNode������ �θ� ����Ű�� ����
    private BinaryNode left; //BinaryNode������ ���� ���� ����Ű�� ����
    private BinaryNode right; //BinaryNode������ ������ ���� ����Ű�� ����

    BinaryNode() { //����Ʈ ������
    }

    BinaryNode(String value) { //�Ű����� ������ ������
        this.value = value; //���������� �Ű����� ���� ����
    }

    public int level() { //level�� �˷��ִ� �Լ�
        if (parent == null) { //�θ��� ����ִٸ�
            return 1; //1�� ��ȯ
        } //�׷��� �ʴٸ�
        return parent.level() + 1; //����Լ��� �θ��� ���� ��ŭ 1�� ��� ��ȯ, �ű⿡ �ڱ��ڽű��� +1
    }

    public int height() { //���̰� ������ Ȯ�� �޼ҵ�
        int leftHeight = 0; //���� ���� 0���� ����
        if(this.hasLeft()) { //���� �ڽ��� ������ ������
        	leftHeight = this.left.height(); //���� ���̴� ���� �ڽ��� ���� Ȯ���ϴ� �޼ҵ� => ����Լ�
        }
        int rightHeight = 0; //������ ���� 0���� ����
        if(this.hasRight()) { //������ �ڽ��� ������ ������
        	rightHeight = this.right.height(); //������ ���̴� ������ �ڽ��� ���̸� Ȯ���ϴ� �޼ҵ� => ����Լ�
        }
        if(leftHeight > rightHeight) //���� ���̰� ������ ���̺��� ũ�ٸ�
        	return (leftHeight+1); //���� ���� +1 => �ڱ���� ������
        else
        	return (rightHeight+1); //�׷��� �ʴٸ� ������ ���� + 1
    }

    public int numberOfNodes() { //����� ������ ����� Ȯ�� �޼ҵ�
        int numberOfLeftNodes = 0; //���� ��� ���� 0���� ����
        if(this.hasLeft()) { //���� �ڽ��� ������ ������
        	numberOfLeftNodes = this.left.numberOfNodes(); //���� ���̴� ���� �ڽĳ���� ��� ���� Ȯ�� �޼ҵ� =>���
        }
        int numberOfRightNodes = 0; //������ ��� ���� 0���� ����
        if(this.hasRight()) { //������ �ڽ��� ������ ������
        	numberOfRightNodes = this.right.numberOfNodes(); //������ ��� ������ ������ �ڽĳ���� ��� ���� Ȯ�� =>���
        }
    return (numberOfLeftNodes + numberOfRightNodes + 1); //�� ������ ���� ��� ����+������ ��� ����+�Ѹ� 1��
    }

    public String getValue() { //value getter
        return value;
    }

    public void setLeft(BinaryNode left) { //left setter
        if (left != null) { //�Ű������� ������� �ʴٸ� 
            this.left = left; //���������� �Ű����� ���� ����
            this.left.parent = this; //left�� �θ� �ڱ��ڽ�����
        }
    }

    public void setRight(BinaryNode right) { //right setter
        if (right != null) { //�Ű������� ������� �ʴٸ�
            this.right = right; //���������� �Ű����� ���� ����
            left.parent = this; //right�� �θ� �ڱ��ڽ�����
        }
    }

    public BinaryNode getLeft() { //left getter
        return this.left;
    }

    public BinaryNode getRight() { //right getter
        return this.right;
    }

    public boolean hasLeft() { // ���� �ڽ��� ������ �ִ��� Ȯ�� �޼ҵ�
        return (this.left != null); // ���� �ڽ��� ������� ������ true ��ȯ
    }

    public boolean hasRight() { // ������ �ڽ��� ������ �ִ��� Ȯ�� �޼ҵ�
        return (this.right != null); // ������ �ڽ��� ������� ������ true ��ȯ
    }

    public boolean isLeaf() { //Leaf���� Ȯ���ϴ� �޼ҵ�
        return (this.left ==null) && (this.right == null); //���� �ڽİ� ������ �ڽ��� �Ѵ� ��������� true ��ȯ
    }

}
