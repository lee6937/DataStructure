public class Sort_201401703 {
	private int[] dataSet;
	private int[] bucket;
	private int size;

	void initDataSet(String dataSet) { // �ּ� �ȴ޾Ƶ� �ȴ�.
		String dataset[] = dataSet.split(" ");
		this.size = dataset.length;
		this.dataSet = new int[this.size];
		this.bucket = new int[this.size];
		for (int i = 0; i < this.size; i++) {
			this.dataSet[i] = Integer.parseInt(dataset[i]);
		}
	}

	int getSize() {
		return this.size;
	}

	void bubbleSort() { // BUBBLE SORT
		for (int i = 0; i < size; i++) { // ����� �����Կ� ���� => ū ������ ���� �ڿ� ���δ�.  
			for (int j = size - 1; j > i; j--) { //������ �ε������� �����Ͽ� ���� i���� ���̸� �ݺ� => ���� ������ �տ� ���δ�. 
				if (dataSet[j] < dataSet[j - 1]) // ���� �ε����� ���� �ε������� Ŭ��
					swap(j, j - 1); //�� �ε����� ��ü 
			}
		}
	}

	void insertionSort() { //INSERTION SORT
		for (int i = 1; i < this.size; i++) { //������ ���� �ݺ� => �ε��� 1������ �ε��� ������ �ݺ� 
			int key = dataSet[i]; //�ε��� 1���� ���� ������ ���� 
			int j = i - 1; //���� ���� �ϳ� ���� ������ ����
			while (j >= 0 && dataSet[j] > key) { //���� ���� �ε��� 0�̻��̸鼭 ���� ���� ������ ���� ũ�ٸ�
				dataSet[j + 1] = dataSet[j]; //���� ���� ���� �ε����� ����
				j = j - 1; //���� ���� �ϳ� �ٿ��� => ��� ���ؼ� �������� �۴ٸ� ��� ������
			}
			dataSet[j + 1] = key; //�������� �� ũ�ٸ� => ������ ���� �� ���� �ε����� ����
		}
	}

	void mergeSort(int begin, int end) { //MERGE SORT end�� size�� �ǹ�
		if (end - begin < 2) //���̰� 1�� �Ǹ� => �迭�� �ϳ��� ������ ���� �������� 
			return; //�Լ� ����
		int middle = (end + begin) / 2; //�߰��� ���� => ������ ���� ����
		mergeSort(begin, middle); //���ۺ��� �߰�-1���� ������(���� �Ű������� ������ �ǹ�) => ����Լ�
		mergeSort(middle, end); //�߰����� ������ ������ => ����Լ�
		merge(begin, middle, end); //�����Ͽ� ��ġ�� �Լ�
		copyArray(begin, end); //bucket �迭�� ������ �迭�� �����ϴ� �Լ�
	}

	private void merge(int begin, int middle, int end) { //�����Ͽ� ��ġ�� �Լ�
		int i = begin; //ù��° �� ����
		int j = middle; //�߰� �� ����
		for (int k = begin; k < end; k++) { //�迭�� ��������� �ݺ�
			if (i < middle && (j >= end || dataSet[i] <= dataSet[j])) { 
				//i��° ���� �߰��� ���� �۰� j���� ��������� �����ϰų� j��° ���� i��° ������ ũ�ų� ���� ��
				//i��°�� ���� ���Ұ� j��° ���� i��° ������ ũ�� =>(i��° ���� bucket�� �־�� �Ѵ�.)
				//i��° ���� ���Ұ� j��° ���� ��������� �����ߴٸ� =>(i��° ���� bucket�� �־�� �Ѵ�.)
				bucket[k] = dataSet[i]; //���� bucket�� �־���
				i = i + 1; //i���� �ϳ� ���� => �ݺ��� ����
			} else { //i���� �߰� ���� �����߰� j���� ����� �������� ���� ������ ���
				     //i���� �߰��� �������� �������� j��° ���� i��° ������ ���� ���
				bucket[k] = dataSet[j]; //=>(j��° ���� bucket�� �־�� �Ѵ�.)
				j = j + 1; //j���� �ϳ� ���� => �ݺ��� ����
			}
		}
	}

	private void copyArray(int begin, int end) { //bucket�迭�� �����͹迭�� �����ϴ� �Լ�
		for (int k = begin; k < end; k++) { //���ۺ��� ������ �ݺ� => ���ҵ� ���� �� ����
			dataSet[k] = bucket[k]; //bucket�� �ε��� 0���� ������ => �����͹迭�� ����
		}
	}

	void quickSort(int p, int r) { //QUICK SORT
		if (p < r) { //r�� p���� ū ����
			int q = partition(p, r); //�Ǻ��� ��ġ�� �ε����� �߰�����
			quickSort(p, q - 1); //�� ���� ���� �ٽ� ����Լ�
			quickSort(q + 1, r); //�� ���� ���� �ٽ� ����Լ�
		}
	}

	int partition(int p, int r) { //��Ƽ�� ������ �Լ�
		int x = dataSet[r]; //������ �ε����� ���� x�� ���� => x�� �Ǻ���
		int i = p - 1; //ù��° �ε��� ���� ���� i�� ���� => ���� ���� ��ġ�� ã�� ����
		for (int j = p; j < r; j++) { //ó������ ������ �ݺ��ϸ鼭
			if (dataSet[j] <= x) { //�Ǻ������� �������� ���� ������
				i = i + 1; //i���� �ϳ� ����
				swap(i, j); //j���� ��ü => �Ǻ������� ���� ������ ������ �̵�
			}
		}
		swap(i + 1, r); //������ �ε��� �Ǻ����� i��° ���� ���� ��ü
		//(i��°�� �� ���� ������ �Ǻ������� ����)
		return i + 1; //�Ǻ��� ��ġ�� �ε��� ����
	}

	void swap(int index1, int index2) { 
		int temp = dataSet[index1]; 
		dataSet[index1] = dataSet[index2];
		dataSet[index2] = temp;
	}
}
