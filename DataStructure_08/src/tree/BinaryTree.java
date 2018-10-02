package tree;

public class BinaryTree { //Ʈ�� Ŭ���� ����
	private BinaryNode root; //BinaryNode������ root ����
	private String order; //String������ order ����

	public BinaryTree(String value, String order) { //�Ű����� �ΰ��� ������
		// Don't save the value.
		this.order = order; //�Ű�����(order)�� �������� ���Ͻ�
		parse(value); //parse�޼ҵ��� �Ű������� �̵�
	}

	private void parse(String value) { //4���� �������� �ٲ��ִ� �޼ҵ�
		if ("preOrder".equals(this.order)) { //preorder�� ���
			parseToPreOrder(value); // preorder�� �ٲ��ִ� �޼ҵ忡 �Ű����� �Է�
		} else if ("postOrder".equals(this.order)) { //postorder�� ���
			parseToPostOrder(value); //postorder�� �ٲ��ִ� �޼ҵ忡 �Ű����� �Է�
		} else if ("levelOrder".equals(this.order)) { //levelorder�� ���
			parseToLevelOrder(value); //levelorder�� �ٲ��ִ� �޼ҵ忡 �Ű����� �Է�
		} else {// �ش���� ���� ��� 
			parseToInorder(value); //��� inorder�� �ٲ��ִ� �޼ҵ忡 �Ű����� �Է�
		}
	}

	private void parseToInorder(String value) { //inorder�� �ٲ��ִ� �޼ҵ�
		if ("".equals(value)) { //���� �ƹ��͵� ���ٸ�
			this.root = new BinaryNode(); //root�� BinaryNode ����
		} else { //���� �����Ѵٸ�
			this.root = makeInorderTree(value); //root�� inorderƮ���� ����� �޼ҵ忡 �Ű������� �Է��� ����� ����
		}
	}

	private BinaryNode makeInorderTree(String value) { //inorder�� ������ִ� �޼ҵ�
		if ("".equals(value)) //���� ����ִٸ�
			return null; //null ����
		BinaryNode node = new BinaryNode(value.charAt(value.length() / 2) + " "); //node���� value�� �߰� ���ڸ� ����

		node.setLeft(makeInorderTree(value.substring(0, value.length() / 2))); //node�� ���� �ڽĿ� ����Լ��� �Է�, �Ű������� ���ڿ��� ó������ �߰�����
		node.setRight(makeInorderTree(value.substring(value.length() / 2 + 1, value.length()))); //node�� ������ �ڽĿ� ����Լ��� �Է�, �Ű������� ���ڿ��� �߰� �������ں��� ������

		return node; //node�� ���� => inorderƮ�� ����
	}

	private void parseToPreOrder(String value) { //preorder�� �ٲ��ִ� �޼ҵ�
		if ("".equals(value)) { //���� ����ִٸ�
			this.root = new BinaryNode(); //root�� BinaryNode ����
		} else { // ���� �����Ѵٸ�
			this.root = makePreOrderTree(value); //root�� preorderƮ���� ����� �޼ҵ忡 �Ű������� �Է��� ��� ����
		}
	}

	private BinaryNode makePreOrderTree(String value) { //preorder�� ������ִ� �޼ҵ�
		if ("".equals(value)) //���� ����ִٸ�
			return null; //null ����
		BinaryNode node = new BinaryNode("" + value.charAt(0)); //node���� value�� ù��° ���ڸ� ����
		node.setLeft(makePreOrderTree(value.substring(1, value.length() / 2 + 1))); //node�� ���� �ڽĿ� ����Լ��� �Է�, �Ű������� ���ڿ��� �ι�° ���ں��� �߰� �������ڱ���
		node.setRight(makePreOrderTree(value.substring(value.length() / 2 + 1, value.length()))); //node�� ������ �ڽĿ� ����Լ��� �Է�, �Ű������� ���ڿ��� �߰� �������ں��� ������

		return node; //node�� ���� => preorderƮ�� ����
	}

	private void parseToPostOrder(String value) { //postorder�� �ٲ��ִ� �޼ҵ�
		if ("".equals(value)) { //���� ����ִٸ�
			this.root = new BinaryNode(); //root�� BinaryNode ����
		} else { // ���� �����Ѵٸ�
			this.root = makePostOrderTree(value); //root�� postorderƮ���� ����� �޼ҵ忡 �Ű������� �Է��� ��� ����
		}
	}

	private BinaryNode makePostOrderTree(String value) { //postorder�� ������ִ� �޼ҵ�
		if ("".equals(value)) //���� ����ִٸ�
			return null; //null ����

		BinaryNode node = new BinaryNode(value.charAt(value.length() - 1) + ""); //node���� value�� ������ ���ڸ� �Է�

		node.setLeft(makePostOrderTree(value.substring(0, value.length() / 2))); //node�� ���� �ڽĿ� ����Լ��� �Է�, �Ű������� ���ڿ��� ù��° ���ں��� �߰����ڱ���
		node.setRight(makePostOrderTree(value.substring(value.length() / 2, value.length() - 1))); //node�� ������ �ڽĿ� ����Լ��� �Է�, �Ű������� ���ڿ��� �߰����ں��� ���������ڱ���
 
		return node; //node�� => postorderƮ�� ����
	}

	private void parseToLevelOrder(String value) { //levelorder�� �ٲٰ� �����ϴ� �޼ҵ�
		String s[] = value.split(""); //value���� �ѱ��ھ� �迭�� ������� �� ����
		LinkedQueue q = new LinkedQueue(); //linkedQueue �ν��Ͻ�ȭ ����

		int index = 0; //�ε��� ���� ���� 0����
		this.root = new BinaryNode(s[index++]);//s[0]�� root�� ���� ��  �ε��� ����

		if (this.root == null) //root�� ���� ����ִٸ�
			return; //����
		
		q.add(this.root); //root���� queue�� �߰�

		BinaryNode current_node = q.remove();//queue�� ���� ������ ������ ���� => root�� ������ �����
		while (current_node != null) { //���� node�� ������� ���� ���� �ݺ�
			if (index < s.length) { //index�� �迭�� ���̺��� �۴ٸ� 
				current_node.setLeft(new BinaryNode(s[index++]));//node�� ���� �ڽĿ� ��������� �迭 ������ �Է�, �Է� �� �ε����� ����
				q.add(current_node.getLeft()); //queue�� node�� �����ڽ��� �߰�
			}
			if (index < s.length) { //index�� �迭�� ���̺��� �۴ٸ� => ������ ���� �־��ֱ� ���� ����
				current_node.setRight(new BinaryNode(s[index++])); //node�� ������ �ڽĿ� ��������� �迭 ������ �Է� , �Է� �� �ε��� �� ���� => �迭�� ���������� �ϳ��� �ԷµǴ� ����
				q.add(current_node.getRight()); //queue�� node�� ������ �ڽ��� �߰�
			}
			current_node = q.remove(); //queue�� ���� ���� node�� �Է� => ���� �ڽ� / ������ �ڽ��� �����ư��� ����
		}
	}

	private String inorder(BinaryNode node) { //inorder Ž�� �޼ҵ�
		String string = ""; //string ���� ����
		if (node == null) //node�� ���������
			return ""; //����

		string += inorder(node.getLeft()); //������ ���� �ڽĺ��� ����Լ� ����, ������ ����
		string += node.getValue(); //������ node�� ���� => root��
		string += inorder(node.getRight()); //������ ������ �ڽ� ����Լ� ����, ������ ����

		return string; //���� ����
	}

	private String preOrder(BinaryNode node) { //preorder Ž�� �޼ҵ�
		String string = ""; //string ���� ����
		if (node == null) //node�� ���������
			return ""; //����

		string += node.getValue(); //������ node�� ���� => root��
		string += preOrder(node.getLeft()); //������ ���� �ڽ� ����Լ� ����, ������ ����
		string += preOrder(node.getRight()); //������ ������ �ڽ� ����Լ� ����, ������ ����
		return string; //���� ����
	}

	private String postOrder(BinaryNode node) { //postorder Ž�� �޼ҵ�
		String string = ""; //string ���� ����
		if (node == null) //node�� ���������
			return ""; //����
		string += postOrder(node.getLeft()); //������ ���� �ڽ� ����Լ� ����, ������ ����
		string += postOrder(node.getRight()); //������ ������ �ڽ� ����Լ� ����, ������ ����
		string += node.getValue(); //������ node�� ���� => root��
		return string; //���� ����
	}
	
	private String levelOrder(BinaryNode node) { //levelorder Ž�� �޼ҵ�
		LinkedQueue Queue = new LinkedQueue(); //LinkedQueue �ν��Ͻ� ����
		Queue.add(node); //queue�� node�� �Է�
		String string = ""; //string ���� ����
		
		while (!Queue.isEmpty()) { //ť�� ������� ���� ���� �ݺ� 
			BinaryNode current_node = Queue.remove(); //ť�� ���� ���� node�� ����
			string += current_node.getValue(); //������ node�� �� ����
			
			if (current_node.getLeft() != null) //node�� ���� �ڽ��� ������� �ʴٸ�
				Queue.add(current_node.getLeft()); //ť�� node�� ���� �� �߰�
			if (current_node.getRight() != null) //node�� ������ �ڽ��� ������� �ʴٸ�
				Queue.add(current_node.getRight()); //ť�� node�� ������ �� �߰� 
		} // �ݺ��ϸ鼭 ����, ������ �ڽĵ��� ť�� �߰��ϰ� node�� �����ؼ� �� ���� string ������ �����ϴ� ����
		return string; //string ����
	}

	public String getValue() { //order�� Ž���ؼ� ���ڿ��� ���� ���� �Լ�
		String value; //���� ����
		if ("preOrder".equals(this.order)) { //�Ű����� order�� preorder���
			value = preOrder(this.root);//preorder�޼ҵ�� Ž�� �� ������ ����
		} else if ("postOrder".equals(this.order)) { //�Ű����� order�� postorder���
			value = postOrder(this.root); //postorder�޼ҵ�� Ž�� �� ������ ����
		} else if ("levelOrder".equals(this.order)) { //�Ű����� order�� levelorder���
			value = levelOrder(this.root); //levelorder�޼ҵ�� Ž�� �� ������ ����
		} else { //�Ű����� order�� �̿��� ���̶��
			value = inorder(this.root); //inorder�޼ҵ�� Ž�� �� ������ ����
			// System.out.printf("here : \n",this.root);
		}

		return value;
	}

	public void print() { //������ִ� �޼ҵ�
		LinkedQueue queue = new LinkedQueue(); //ť�� �ν��Ͻ�ȭ�ؼ� ����
		queue.add(this.root);// ť�� root���� �߰�
		int level = this.root.level(); //root�� level���� ������ ����
		String interval = "%" + (int) Math.pow(2, this.root.height()) + "s"; //������ ���� => Math.pow�� ���� �Լ�(��=2,����=height()) 
		//format�Լ��� ���� ���� ���ڷ� ������ֱ� ���� �տ� '%'�� �ڿ� 's' ���
		StringBuilder tree = new StringBuilder(); //StringBuilder�� �ν��Ͻ�ȭ
		while (!queue.isEmpty()) { // ť�� ������� ���� ���� �ݺ�
			BinaryNode currentNode = queue.remove(); // ť���� �� ���� ������ ����
			if (currentNode != null) { //ť�� ������� �ʴ� �ٸ�
				if (level < currentNode.level()) { //�������� ������ ��Ʈ�� �������� ũ�ٸ�
					level = currentNode.level(); //�������� ������ ��Ʈ������ ����
					interval = "%" + (int) Math.pow(2, currentNode.height()) + "s"; //������ ���� ����� ���̿� ���缭 ����
					tree.append("\n"); //Ʈ���� �ٹٲ㼭 �̾���̱�
				} 
				queue.add(currentNode.getLeft()); //node�� �����ڽ��� ť�� �߰�
				queue.add(currentNode.getRight()); //node�� �������ڽ��� ť�� �߰�

				tree.append(String.format(interval, currentNode.getValue())).append(String.format(interval, "")); //tree�� �̾� ���� => 2^���� ���ݸ�ŭ ����� ���� ���̰� �̾ ���ݸ�ŭ ����  
			} else { //ť�� ����ִٸ�
				tree.append(String.format(interval, "")).append(String.format(interval, "")); //tree�� �̾���� => 2^���� ��ŭ ���� ����
			}
		}
		System.out.println(tree.toString()); //Ʈ�� ���� ���ڿ��� ���� ���
	}
}

