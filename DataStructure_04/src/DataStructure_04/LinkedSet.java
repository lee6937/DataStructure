package DataStructure_04;

public class LinkedSet implements LinkedSetInterface{
		
	private Node head; //�������� head ����
	private int size;  //�������� size ����
	
	public LinkedSet() { //�⺻ ������
		this.head = new Node(); //�������� ��尴ü ����
		this.size = 0; //������ �� �ʱ�ȭ
	}
	
	@Override
	public int size() { //getter ����
		return this.size; //�������� �� ����
	}
	
	@Override
	public boolean add(String string) { //�޼ҵ� ����
			Node newNode; //NodeŬ������ newNode���� ����
			newNode = new Node(string); //newNode�� ��ü ���� �� �Ű����� �Է�
			Node node = head; //node�� ���� ���� ���� ����Ŵ
			for (int i = 0; i < this.size; i++) { //��������� �ݺ�
				if(node.next().coin().equals(string)) { //node���� ���ΰ��� string�� ���ٸ�
					System.out.println("������ ���ڿ��� �־ �߰� �� ��");
					return false; // �߰����� �ʰ� false ����
				}
				else
					node = node.next(); //node�� ���� node�� �ٲٸ鼭
			}
			node.setNext(newNode); //node �������� newNode�� �Է� 
			this.size++; //������ ��
			return true; //true ����
		}
	

	@Override
	public boolean contains(String string) { //�޼ҵ� ����
		for(int i=0; i< this.size; i++) { //��������� �ݺ�
			Node node = this.head; //node�� ���� ���� ���� ����Ŵ
			while (node.next() != null) { //node�� �������� ������� ������ ���� �ݺ�
			if(node.next().coin().equals(string)) //node �������� ������ �Ű������� ������
				return true; //true ����
			else
				node = node.next(); //�׷��� �ʴٸ� node�� ���� node������ ����
			}
		}
		return false; // ��ã�� �� false ����
	}
	

	@Override
	public String remove(String string) { //�޼ҵ� ����
		if(isEmpty()) //������� ��
			return null; //null ����
		else { //������� ���� ��
			Node node = new Node(); //node ������ ��ü ����
			node = head;//node�� ���� ���� ���� ����Ŵ
			while (node.next() != null) { //node�������� ������� ���� ������ �ݺ�
				if(node.next().coin().equals(string)) {//node�� ���� ���� �Ű������� ���� ���
					node.setNext(node.next().next()); //node�� �������� node�� ���� ���� ������ ����
					this.size--; //������ �ٿ���
					return string; //string ����
				}
				else 
					node = node.next(); //node�� ������ �Է� => �ݺ��� ����
			}
			return null; //ã�Ƶ� ���� �� null����
		}
	}
	
	public boolean isEmpty() { // �޼ҵ� ����
		if (this.size == 0) { // ����� 0�̶��
			return true; // true�� ����
		} else // ����� 0�� �ƴ϶��
			return false;// false�� ����
	}

	@Override
	public void clear() { // �޼ҵ� ����
		head.setNext(null); // head�� �������� null�� ���� => ������ �������
		this.size = 0; //����� 0����
	}

	@Override
	public void print() { // �޼ҵ� ����
		System.out.println(this); //LinkedSet��ü�� toString()�޼ҵ� ����
	}
	
	@Override
	public String toString() { // �޼ҵ� ����
		String result; //���� ����
		Node node = head; //head�� ����Ű�� ���� node�� ����Ŵ
		result = "[ "; // result����
		while (node.next() != null){ //node ��������  ������� ���� �� ���� �ݺ�
		node = head.next(); //node�� head������
		result += node.coin() + " "; //������ node���ΰ� �Է�
		}
		result += "]"; //���� �ϳ� �߰�
		return result; //���� �� ���
	}
	
}
