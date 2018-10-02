
public class BinarySearchTree { 
    BinaryNode root; // ���� ���� root���� ����

    BinarySearchTree() { //������
        this.root = null; //root�� �ʱ�ȭ
    }

    BinaryNode findNode(BinaryNode x, int value, boolean toDelete) { //�����ϸ鼭 ã�� ���� toDelete �Ű����� �Է�
    	
    	if(x != null && x.getValue() != value) { //x�� �ܸ����ų� ���� ã�Ҵٸ� ���� �ȵ�
    		if(x.getValue() < value) //�Ű����� ���� x�� �� ���� ũ�ٸ� => �����ʿ��� ã�ƾ� ��
    			return findNode(x.getRight(), value, toDelete); //x�� ������ �ڽĿ� �Ű����� �ְ� ����Լ� ���� 
    		else //�Ű����� ���� x�� �� ���� �۴ٸ� => ���ʿ��� ã�ƾ� ��
    			return findNode(x.getLeft(), value, toDelete); //x�� ���� �ڽĿ� �Ű����� �ְ� ����Լ� ����
    	}
    	else if(x != null && x.getValue() == value) { //x�� null�� �ƴϰ�, ã���� ��
    		if(toDelete) { //toDelete�� true��� ���� �����ϸ鼭 ����ڴٴ� ��
    			deleteNode(x); //�����ϴ� �޼ҵ忡 x �Է�
    			return x; //������ �� ����
    		}
    		else //�������� �����Ƿ� �ٷ� ����
    			return x; //ã�� �� ����
    	}
    	
    	return null;//��ã���� ��
    }

    void insertNode(BinaryNode root, BinaryNode node) { //��带 �����ϴ� �޼ҵ�
    	if(this.root == null) { //root�� ������� ��
    		this.root = node; //��Ʈ�� node �Է�
    		return; //����
    	}
    	if(root.getValue() < node.getValue()) { //node�� ���� root�� �� ���� ũ�ٸ� => root�� ����������
    		if(root.hasRight()) { //������ �ڽ��� �ִٸ� => �� �ڸ��� �ִ��� ������ Ȯ��
    			insertNode(root.getRight(), node); //root�� ������ �ڽİ� node�� �Ű������� ����Լ� ����
    		} else { //������ �ڽ��� ���ٸ�
    			root.setRight(node); //root�� ������ �ڽĿ� node����
    			node.setParent(root); //node�� �θ� root����
    		}
    	}
    	else { //node�� ���� root�� �� ���� �۰ų� ���ٸ�
    		if(root.hasLeft()) { //���� �ڽ��� �ִٸ�
    			insertNode(root.getLeft(), node); //root�� ���� �ڽİ� node�� �Ű������� ����Լ� ����
    		} else { //���� �ڽ��� ���ٸ�
    			root.setLeft(node); //root�� ���� �ڽĿ� node����
    			node.setParent(root); //node�� �θ� root����
    		}
    	}
    }

    BinaryNode treeMinimum(BinaryNode node) { //���� ���� ��带 ��ȯ�ϴ� �Լ�
        while(node.hasLeft()) { //node�� ���� �ڽ��� ���� �ִ� ���� �ݺ�
        	return treeMinimum(node.getLeft()); //node�� �����ڽ��� �޼ҵ忡 �Է� => ����Լ� 
        } //��� �ݺ��ϸ鼭 ���� �ִ� ���� �ڽ��� ã��
        return node; //ã�� ��� ��ȯ
    }

	BinaryNode deleteNode(BinaryNode z) { // ��带 �����ϴ� �޼ҵ�
		BinaryNode MoveNode; //�̵��� ��� ���� ����
		if (!z.hasLeft()) //���� �ڽ��� ���ٸ� 
			transplant(z, z.getRight()); //�׳� ������ �ڽ��� �Űܽ����� ��
		else if (!z.hasRight()) // ������ �ڽ��� ���ٸ� 
			transplant(z, z.getLeft()); //�׳� ���� �ڽ��� �Űܽ����� ��
		else { // �Ѵ� �ڽ��� �ִ� ��� => ������ �ϳ� ū�ָ� �����;���
			MoveNode = treeMinimum(z.getRight()); //�̵���忡 ������ �ڽ��� ���� ���� ��� �Է�
			if (MoveNode.hasRight()) { //�̵� ����� ������ �ڽ��� �ִٸ�
				transplant(MoveNode, MoveNode.getRight()); //�̵������ ������ �ڽ��� �̵���� �ڸ��� �Ű� �ɴ´�.
				transplant(z, MoveNode); //�̵� ��带 ������ ��� �ڸ��� �Ű� �ɴ´�.
				MoveNode.setLeft(z.getLeft()); //�̵� ����� ���� �ڽ��� ������ ����� ���� �ڽ����� ����
				MoveNode.setRight(z.getRight()); //�̵� ����� ������ �ڽ�0�� ������ ����� ������ �ڽ����� ���� 
				z.getLeft().setParent(MoveNode); //������ ����� ���� �ڽ��� �θ� �̵� ���� ����
				z.getRight().setParent(MoveNode); //������ ����� ������ �ڽ��� �θ� �̵� ���� ���� => ����� ���� ���� �Ϸ�
			} else { //�̵� ����� �ڽ��� ���ٸ�, ���� �ڽ��� ����� �� => �̵� ��尡 ���� ���� ����̱� ����
				MoveNode.getParent().setLeft(null); //�̵� ���� �θ���� ���踦 ���� ����
				transplant(z, MoveNode); //�̵���带 ������ ��� �ڸ��� �Ű� �ɴ´�.
				MoveNode.setLeft(z.getLeft()); //�̵� ����� ���� �ڽ��� ������ ����� ���� �ڽ����� ����
				MoveNode.setRight(z.getRight()); //�̵� ����� ������ �ڽ��� ������ ����� ������ �ڽ����� ���� 
				z.getLeft().setParent(MoveNode); //������ ����� ���� �ڽ��� �θ� �̵� ���� ����
				z.getRight().setParent(MoveNode); //������ ����� ������ �ڽ��� �θ� �̵� ���� ���� => ����� ���� ���� �Ϸ�
			}
		}
		return z; // ������ �� ����
	} 

    void transplant(BinaryNode des, BinaryNode source) { //Ʈ�� �Űܽɴ� �޼ҵ�
        if(!des.hasParent()) //������ ����� �θ� ���ٸ�
        	this.root = source; // ��Ʈ�� �̵��� ��� �Է�
        else if(des == des.getParent().getLeft()) //������ ��尡 ������ �θ��� ���� �ڽ��̶��
        	des.getParent().setLeft(source); //������ ����� �θ��� ���� �ڽĿ� �̵��� ��� �Է�
        else //������ ��尡 ������ �θ��� ������ �ڽ��̶��
        	des.getParent().setRight(source); //������ ����� �θ��� ������ �ڽĿ� �̵��� ��� �Է�
        if(source != null) //�̵��� ��尡 null�� �ƴ϶��
        	source.setParent(des.getParent()); //�̵��� ����� �θ� ������ ����� �θ�� �Է�
    }

    void printTree(BinaryNode node, int depth) { //������ִ� �޼ҵ�
        if(node != null) { //node�� ������� ���� ����
        	for(int i = 0 ; i < depth; i++) { // ���� ���� �ݺ��ϸ鼭
        		System.out.print("\t"); //�� �ѹ��� ���°�
        	}
        	System.out.println(node.getValue()); //node�� ������ ���
        	printTree(node.getLeft(), depth+1); //����� ���� �ڽİ� ����+1�� �Ű������� �ϴ� ����Լ�
        	printTree(node.getRight(), depth+1); //����� ������ �ڽİ� ����+1�� �Ű������� �ϴ� ����Լ�
        }
    }

    BinaryNode getRoot() { //root getter
        return this.root;
    }
}
