
public class Node { 
	private String element; //String ������ ���� ����
	private Node leftChild; //Node ������ ���� �ڽ��� ����Ű�� ���� ���� 
	private Node rightChild; //Node ������ ������ �ڽ��� ����Ű�� ���� ����

	public Node(String string) { //�Ű����� 1���� ������
		this.element = string; //�Ű������� ������ ����
		this.leftChild = null; 
		this.rightChild = null; //�ڽ��� ����Ű�� ���� �ʱ�ȭ 
	}
	
	public Node(String element, Node leftChild, Node rightChild) {
		super(); //�θ�Ŭ���� ������ ������
		this.element = element;      
		this.leftChild = leftChild;
		this.rightChild = rightChild; //�Ű������� �������� ��ġ 
	}

	public String getElement() { //getter
		return element;
	}

	public void setElement(String element) { //setter
		this.element = element;
	}

	public Node getLeftChild() { //getter
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {//setter
		this.leftChild = leftChild;
	}

	public Node getRightChild() {//getter
		return rightChild;
	}

	public void setRightChild(Node rightChild) {//setter
		this.rightChild = rightChild;
	}

	public boolean hasLeftChild() { // ���� �ڽ��� ������ �ִ��� Ȯ�� �޼ҵ�
		return (this.leftChild != null); // ���� �ڽ��� ������� ������ true ��ȯ
	}
	
	public boolean hasRightChild() { // ������ �ڽ��� ������ �ִ��� Ȯ�� �޼ҵ�
		return (this.rightChild != null); // ������ �ڽ��� ������� ������ true ��ȯ
	}
	
	public boolean isLeaf() { //Leaf���� Ȯ���ϴ� �޼ҵ�
		return (this.leftChild == null) && (this.rightChild == null); //���� �ڽİ� ������ �ڽ��� �Ѵ� ��������� true ��ȯ
	}
	
	public int height() { //���̰� ������ Ȯ�� �޼ҵ�
		int leftHeight = 0; //���� ���� 0���� ����
		if(this.hasLeftChild()) { //���� �ڽ��� ������ ������
			leftHeight = this.leftChild.height(); // ���� ���̴� �����ڽ��� ���� Ȯ���ϴ� �޼ҵ� => ����Լ�
		}
		int rightHeight = 0; // ������ ���� 0���� ����
		if(this.hasRightChild()) { //������ �ڽ��� ������ ������
			rightHeight = this.rightChild.height(); // ������ ���̴� ������ �ڽ��� ���̸� Ȯ���ϴ� �޼ҵ� => ����Լ�
		}
		if(leftHeight > rightHeight) //���� ���̰� ������ ���̺��� ũ�ٸ�
			return leftHeight+1; // ���� ���� +1 => �ڱ���� ������
		else
			return rightHeight+1; // �׷��� ������ ������ ���� + 1 
	}
	
	public int numberOfNodes() { // ����� ������ ����� Ȯ�� �޼ҵ�
		int numberOfLeftNodes = 0; // ���� ��� ���� 0���� ����
		if(this.hasLeftChild()) { //���� �ڽ��� ������ ������
			numberOfLeftNodes = this.leftChild.numberOfNodes(); // ���� ��� ������ ���� �ڽĳ���� ��� ���� Ȯ�� �޼ҵ� => ����Լ�
		}
		int numberOfRightNodes = 0; // ������ ��� ���� 0���� ����
		if(this.hasRightChild()) { // ������ �ڽ��� ������ ������
			numberOfRightNodes = this.rightChild.numberOfNodes(); // ������ ��� ������ ������ �ڽĳ���� ��� ���� Ȯ�� �޼ҵ� => ����Լ�
		}
		return 1+numberOfLeftNodes+numberOfRightNodes; // �� ������ ���ʳ�� ���� + ������ ��� ���� + �Ѹ� 1��
	}
	
	public void inorder (Node root) { //���� Ž�� ��� => root�� �߰��� Ž��
		if(root != null) { //root�� ������� �ʴٸ�
			inorder(root.getLeftChild()); //root�� �����ڽĺ��� ����Ž�� ����=> ����Լ�
			System.out.println(root.getElement()); //������ �� Ž�� �� root�� Ž��
			inorder(root.getRightChild()); //root�� ������ �ڽ� ����Ž�� ���� => ����Լ�
		}
	}
	
	public void preorder (Node root) { //���� Ž�� ��� => root�� ���� Ž��
		if(root != null) { //root�� ������� �ʴٸ�
		System.out.println(root.getElement()); //root�� ���� Ž��
		preorder(root.getLeftChild()); //root�� �����ڽĺ��� ����Ž�� ���� => ����Լ�
		preorder(root.getRightChild()); //root�� �������ڽĺ��� ����Ž�� ���� => ����Լ�
		}
	}
	
	public void postorder (Node root) { //���� Ž�� ��� => root�� ���߿� Ž��
		if(root != null) { //root�� ������� �ʴٸ�
		postorder(root.getLeftChild()); //root�� �����ڽĺ��� ����Ž�� ���� => ����Լ�
		postorder(root.getRightChild()); //root�� �������ڽĺ��� ����Ž�� ���� => ����Լ�
		System.out.println(root.getElement()); //root�� �������� Ž��
		}
	}
	
}
