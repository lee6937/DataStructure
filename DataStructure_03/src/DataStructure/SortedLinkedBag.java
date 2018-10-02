package DataStructure;

public class SortedLinkedBag {
		
	public Node _head; //node��ü�� ���� ����
	int maxsize; //�ִ������ ���� ����
	int size; //������ ���� ����
	
	SortedLinkedBag() { //����Ʈ ������
		
	}
	
	SortedLinkedBag(int _maxsize) { //������
		this.maxsize = _maxsize; //�ִ� ������ �Է�
		this._head = null; //head�� �ʱ�ȭ
		this.size = 0; //����� �ʱ�ȭ
	}
	
	public int getSize() {
		return this.size;
	}
	
	 void max(int cycleSize) { //max �޼ҵ� ����
		 _head = new Node(); //_head���  node��ü ����
		 Node node = _head.next(); //node�� _head�� ������ ����
		 cycleSize = Integer.MIN_VALUE; //�Ű������� ���� �ּҰ� �Է�
		 
		 if(node == null) //node�� ����ִٸ�
			 return; //����
		 else { //node�� ������� �ʴٸ�
		while (node.next() == null) { //node�� �������� ��������� ����
			if(cycleSize < node.coin()); {//�Ű������� node�� coin�� ���� ������
				cycleSize = node.coin(); // �Ű������� node�� coin�� �Է�
			}
			node = node.next(); // node�� node������ �Է� => �ݺ��� ����
		}
	 }
	 }
	  /*  boolean add(int coin) { //�޼ҵ� ����
	    	
		    if (isFull())  //����á�ٸ�
		    	return false;  // false ����
			else {  //�������� �ʾҴٸ�
				Node newNode = null; //newNode�� �������
				Node prev = null; //prev�� �������
				newNode = new Node(coin); //newNode��ü ������ �Ű����� �Է�
				
				Node node = this._head; //node�� _head�� ���� ����
				
				if (node == null) { //node���� ���������
					
					this._head = new Node(); //_head�� ��ü�� ����
					node = this._head; //node�� head�� ���ٰ� ���� 
					
					node.setNext(newNode); //node�� next���� newNode�Է� => ù��°�� �Է�
					
					this.size++; //������ ��
					return true; //�Լ� ����
				}
				prev = node; //prev������ node ��
				node = node.next(); //node�� node�� ������
				
				while(node != null) { //node���� ������� ���� ������ �ݺ�
					
					if(node.coin() <= newNode.coin() && node.next() == null) { // ���ε��� ���ΰ��� node������ ������ ũ�ų� ����, node�������� ���ٸ�
						node.setNext(newNode); // node�� �������� ���ε��� ���ΰ� �Է�
						break; //Ż��
					}
					
					else if(node.coin() <= newNode.coin() && node.next() != null) { // ���ε��� ���ΰ��� node������ ������ ũ�ų� ����, node�������� �ִٸ�
						prev = node; //prev���� node�� �Է�
						node = node.next(); //node���� node������ �Է�
					}
					
					else if(node.coin() > newNode.coin() ) { // ���ε��� ���ΰ���  node������ ������ �۰�, prev���� head���
						prev.setNext(newNode); // prev�� �������� ���ο����� �Է�
						newNode.setNext(node); // ���ο� ������ �������� node�� �Է�
						break; //Ż��
					}
					
					else if(node.coin() > newNode.coin() && prev != this._head) { // ���ε��� ���ΰ��� node������ ������ �۰�, prev���� head�� �ƴ϶��
						prev.setNext(newNode); //prev�� �������� ���ο����� �Է�
						newNode.setNext(node); //���ο� ������ �������� node�� �Է�
						break; //Ż��
					}
				}
				
				this.size++; //������ ��
				return true; //�Լ� ����
			}
	    } */
	 
	boolean add(int coin) {
		if (isFull()) {
			return false;
		} else {
			Node node = _head;
			Node prev = null;
			Node newNode = new Node(coin);
			if (node == _head) {
				newNode.setNext(null);
				_head = newNode;
			}
			else {
				int index;
				for (index = 0; index < size; index++) {
					if (node.coin() > newNode.coin()) {
						break;
					}
					else {
					prev = node;
					node = node.next();
					
				}
				prev.setNext(newNode);
				newNode.setNext(node);
			}
			}
			this.size++;
		}
		return true;
	}
	

	    boolean isFull() { //�޼ҵ� ����
	    	if (getSize() == 5000) //����� 5000�̶��
				return true; //true�� ����
	    	else
	    		return false; 
	    }
	    
	    void printResult() {
	    	Node p = _head;
	    	for(int i=0; i<this.size; i++) {
	    		System.out.println(p.coin());
	    		p = p.next();
	    	}
	    }
	    
}