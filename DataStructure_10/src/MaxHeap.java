public class MaxHeap implements Heap {
	private int[] heap; // heap �迭 ���� ����
	private int size; // ������ ���� ����
	// Don't add field!!!!!!!
	// Don't add field!!!!!!!
	// Don't add field!!!!!!!
	// Don't add field!!!!!!!

	public MaxHeap() { // �ʱ� ������
		this.heap = new int[10]; // 10�������� �迭 ��ü ����
		this.size = 0; // ������ 0���� �ʱ�ȭ
	}

	private MaxHeap(int[] array, int size) { // �Ű������� ������ ������
		this.heap = array; // �Ű������� �������� ���Ͻ�
		this.size = size; // ����� ���� ����
	}

	@Override
	public boolean isEmpty() { // ����ִ��� Ȯ�� �޼ҵ�
		return size == 0; // ������ 0�̸� true
	}

	@Override
	public boolean isFull() { // ���� á���� Ȯ�� �޼ҵ�
		return size == heap.length; // ����� heap�� ���̰� ���ٸ� true
	}

	@Override
	public void add(int element) { // ���� �߰��ϴ� �޼ҵ�
		if (isFull()) // �������ִٸ�
			resize(); // ������ �ι�� ����
		else { // �������� �ʾҴٸ�
			this.size++; // ����� ���� ����
			this.heap[this.size - 1] = element; // ������-1�� �ε����� ���� �߰�
			int current = this.size - 1; // �߰��� ���� �ε����� ������ ����
			while (current != 0) { // �ε����� 0�� �ƴ� ���� �ݺ�
				if (current % 2 == 0 && heap[current] > heap[current / 2 - 1]) { // �ε����� ¦���̸鼭 ���� �ε����� �θ��� �ε������� ũ�ٸ�
					// �ε����� ¦���̸� �θ�� ���� �ε����� 2�� ������ 1�� ������
					swap(heap, current, current / 2 - 1); // ���� �ε����� �θ��� �ε����� swap
					current = current / 2 - 1; // ���� �ε����� �θ�� ����
				} else if (current % 2 == 1 && heap[current] > heap[current / 2]) { // �ε����� Ȧ���̸鼭 ���� �ε����� �θ��� �ε������� ũ�ٸ�
					// �ε����� Ȧ���̸� �θ�� ���� �ε����� 2�� ����
					swap(heap, current, current / 2); // ���� �ε����� �θ��� �ε����� swap
					current = current / 2; // ���� �ε����� �θ�� ����
				} else // �̿� => swap�� �ʿ䰡 ����.
					break;
			}
		}
	}

	@Override
	public int max() { // �ִ밪 ���ϴ� �޼ҵ�
		if (isEmpty()) // ����ִٸ�
			return 201401703; // �й� ����
		else { // ������� �ʴٸ�
			return this.heap[0]; // ù��° �ε��� �� ���� => �߰��� �� max���� �ε��� 0���� �̹� ������
		}
	}

	@Override
	public int removeMax() { // �ִ밪�� �����ϴ� �޼ҵ�
		int removeValue; // ������ ���� ���� ���� ����
		if (isEmpty()) { // ����ִٸ�
			return 201401703; // �й� ����
		} else { // ������� �ʴٸ�
			swap(heap, 0, this.size - 1); // 0�� �ε����� ������ �ε��� swap => max���� ���� �������ε����� �̵�
			removeValue = heap[this.size - 1]; // ������ �ε����� ���� ������ ����
			heap[this.size - 1] = 0; // ������ �ε��� ���� 0���� ����
			this.size--; // ������ �ٿ���
			heapify(0); // 0��° �ε����� heap����
		}
		return removeValue; // ������ �� ����
	}

	@Override
	public int size() { // ������ �޼ҵ�
		return size; // ���� ������ ����
	}

	public void heapify(int index) { // �Ű����� �ε����� heap���� �ϴ� �޼ҵ�

		if (this.size < index * 2 + 2) // �ڽĵ��� ����� ���� ���
			this.resize(); // ����� �÷��ش�.

		int largeIndex; // ���� ū �ε����� ������ ���� ����
		largeIndex = index; // ó���� �ڱ� �ε����� ����
		if (largeIndex < this.size) { // �ε����� ����� �ȳѾ�ٸ�
			if (heap[index] > heap[index * 2 + 1]) // ���� �ε����� ���� �ڽ� �ε������� ũ�ٸ�
				largeIndex = index; // ���� �ε����� ������ ����
			else
				largeIndex = index * 2 + 1; // ���� �ڽ� �ε����� �� ũ�ٸ� �ڽ� �ε����� ������ ����
			if (heap[largeIndex] < heap[index * 2 + 2]) // ����� �ε������� ������ �ڽ� �ε����� ��ũ�ٸ�
				largeIndex = index * 2 + 2; // ������ �ڽ� �ε����� ������ ����
			if (index != largeIndex) { // ���� �ε����� ����� �ε����� �ٸ��ٸ�
				swap(heap, index, largeIndex); // �ΰ��� swap
				heapify(largeIndex); // �ٲ� �ε����� �ٽ� heap���� => ����Լ�
			}
		}

	} // �ݺ����� ���� �Ʒ����� ���� ���� ���� ���� �ö� //�θ��ε��� ���� 0���� �ݺ�

	public void buildHeap() { // �迭 ��� heap������ �ϼ��ϴ� �޼ҵ�
		for (int i = this.size / 2; i >= 0; i--) { // �߰����� �ݺ� => �ε��� 0���� �ö�
			heapify(i); // �ε������� heap������ ���� => ����Լ��̹Ƿ� �ڽĵ���� �� heap�������ش�.
		}
	}

	public boolean increaseKey(int target, int num) { // target���� �ٲ��ִ� �޼ҵ� �ٲٴ°ͺ��͸� ������ �� ���� �ؿ������� ���� //index�� ã�Ƽ�
														// heapfy�ϸ��
		for (int index = 0; index < this.size; index++) { // �����ŭ �ݺ��ϸ鼭
			if (heap[index] == target) { // target���� �ε����� ã����
				heap[index] = num; // �ε����� �迭���� num���� ��ü
				buildHeap(); // ��� �迭 heap����
				return true; // true����
			}
		}
		return false; // target�� ��ã�Ҵٸ� false����
	}

	public static int[] heapSort(int[] array, int size) { // �迭�� heap�����ϴ� �޼ҵ�
		MaxHeap heap = new MaxHeap(array, size); // MaxHeap������ �迭 ������ �迭�� ����� �Է�
		heap.buildHeap(); // �迭 heap ����
		int[] temp = new int[size]; // �ӽ� �迭 �ϳ� ���� => ������� �����ϱ� ����
		for (int i = 0; i < size; i++) { // �����ŭ �ݺ��ϸ鼭
			temp[i] = heap.removeMax(); // heap�迭 �� max���� �����ϸ鼭 ������� �ӽù迭�� ����
		}
		return temp; // �ӽ� �迭 ����
	}

	@Override
	public String toString() { // String��ü ������ => ��ü ����Ҷ� ������ ������
		StringBuilder stringBuilder = new StringBuilder(); // Stringbuilder ��ü ����
		stringBuilder.append("{ "); // ó���� "{" �̾����
		for (int i = 0; i < size; ++i) { // ��������� �ݺ��ϸ鼭
			stringBuilder.append(heap[i]).append(" "); // heap �迭 �ε��� ó������ ������ ��ĭ�� ���鼭 �̾����
		}
		stringBuilder.append("}"); // �������� "}" �̾����

		return stringBuilder.toString(); // StringBuilder ����
	}

	private void resize() { // ������ �ٲ��ִ� �޼ҵ�
		int[] newHeap = new int[this.heap.length * 2]; // ���ο� heap ����, ������� heap���� �ι踸ŭ
		System.arraycopy(this.heap, 0, newHeap, 0, this.heap.length); // heap�� 0��°���� ������ ���ο� heap�� ����
		this.heap = newHeap; // newheap�� �������� heap�� ���Ͻ�
	}

	private static void swap(int[] array, int i, int j) { // �ε��� �ΰ��� ����� ���� �ٲ��ִ� �޼ҵ�
		int temp = array[i]; // i��° �ε����� ���� ������ ����
		array[i] = array[j]; // i��°���� j��° ���� ����
		array[j] = temp; // ����(i��° ���� �������)���� j��° �ε����� ����
	} // ���� ���� swap�ǹ���
}
