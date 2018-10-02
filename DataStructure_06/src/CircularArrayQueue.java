public class CircularArrayQueue {
	private int maxSize;
	private int front;
	private int rear;
	private String[] elements;

	CircularArrayQueue() { // �⺻ ������
		this.maxSize = 5; // �ִ� ������ 5�� �ʱ�ȭ
		this.front = 0; // front�� 0���� �ʱ�ȭ
		this.rear = 0; // rear�� 0���� �ʱ�ȭ
		this.elements = new String[maxSize]; // �ִ� ������ ũ���� String�迭 ����
	}

	public boolean enQueue(String string) { // ť�� �߰��ϴ� �޼ҵ�
		if (isFull()) { // �� ���ִٸ�
			System.out.println("ť�� ������ ������ �Ұ����մϴ�."); // ���� �Ұ��ϴٴ� �޼��� ��� ��
			return false; // false ��ȯ
		}
		this.rear = (rear + 1) % maxSize; // rear�� 1�� ���ϰ� �ִ������� ����� rear��ġ�� ����
		elements[rear] = string; // ������ rear ���� �Ű����� �Է�
		return true; // true ��ȯ
	}

	public String deQueue() { // ť�� �����ϴ� �޼ҵ�
		String deElement = null; //���� �����ϱ� ���� ����
		if (isEmpty()) // ����ִٸ�
			return "ERROR : ť�� ���Ұ� �����ϴ�."; // ���Ұ� ���ٴ� �޼��� ��ȯ
		this.front = (this.front + 1) % maxSize; // front���� 1 ������Ű�� maxSize�� ������ �� ����
		deElement = elements[front]; // ������ ������ ���� �־��ش�
		elements[front] = null; // front�� ����Ű�� ���� ����
		return deElement; // ������ �� ����

	}

	public void removes(int i) { // i�� ��ŭ�� ���� �����ϴ� �޼ҵ�
		if (isEmpty()) // ����ִٸ�
			System.out.println("ERROR : ť�� ���Ұ� �����ϴ�."); // ������ ���Ұ� ���ٴ� �޼ҵ� ���
		String removedValue; // ������ ���� ���� ���� ����
		for (int k = 0; k < i; k++) { // i�� �ݺ�
			removedValue = deQueue(); // 
			System.out.println("[Dequeue] ������ ���Ҵ� " + removedValue + " �Դϴ�.");
		}
	}

	public String printQueue() { // ����� ��� ���� ����ϴ� �޼ҵ�
		String queueStr = ""; // ����� ���� ���� ���� ����
		if (isEmpty()) // ����ִٸ�
			return null; // null ��ȯ
		else {
			for (int i = 1; i < size() + 1; i++) //i�� 1���� ������ +1���� �ݺ� => i�� 0���� �����ϸ� front���� ��µǱ� ������ ����
				queueStr += elements[(this.front + i) % maxSize] + " "; // front + 1���� ��������� ���ҵ��� ������ ����
			return queueStr; // ���� ����ִ� ���� ����
		}
	}

	public String front() { // front������ �� ��� �޼ҵ�
		return elements[front + 1]; // front�� �������� ���� => ���� ù��° ��
	}

	public int size() { // ������ �޼ҵ�
		if (rear >= front) {// rear���� front�� ���� ũ�ų� ���� ��
			// System.out.println("size : " + this.rear-this.front);
			return (this.rear - this.front); // rear���� front�� ���ش�.
		} else // front���� rear�� ���� �� Ŭ��
			return this.maxSize - (this.front - this.rear); // front���� rear���� ���ذ��� �ٽ� �ִ������� ���ش�.
	}

	public boolean isEmpty() { // ����ִ��� Ȯ�� �Լ�
		return (this.front == this.rear); // front�� rear�� ������ true ��ȯ
	}

	public boolean isFull() { // �������ִ��� Ȯ�� �Լ�
		return ((this.rear + 1) % maxSize == this.front); // rear�� 1�� ���ϰ� �ִ������� ������ front�� ������ true ��ȯ => �� ������ �ϳ� �����
															// ����ִ� �Լ��� ����
	}
}
