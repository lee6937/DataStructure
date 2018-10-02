package DataStructure;

public class SortedArrayBag {

	Coin arrayBag[]; // CoinŬ������ �迭 ����
	int size; // ������� ����

	public SortedArrayBag(int i) {
		arrayBag = new Coin[i]; // �Ű������� �Է��� ���ι迭 ����
		size = 0; // ������ 0 �ʱ�ȭ
	}

	public int getSize() { // ����� �������� �޼ҵ�
		return size;
	}

	void max(int cycleSize) { // max �޼ҵ����
		cycleSize = Integer.MIN_VALUE; // �Ű������� ���� �ּҰ� �Է�
		for (int i = 0; i < getSize(); i++) { // 0���� ��������� �ݺ�
			if (cycleSize < arrayBag[i].value()) { // �Ű������� arrayBag�� ������ �۴ٸ�
				cycleSize = arrayBag[i].value(); // �Ű������� arrayBag�� �Է� => ��������� �ݺ��ϸ� �ִ밪�� �Ű������� ����
			}
		}
	}

	void add(int coin) { // add�޼ҵ� ����
		int i; // int���� i ����
		if (getSize() == 0) { // ����� 0�̶��
			arrayBag[getSize()] = new Coin(coin); // ó�� �迭�� ���� ��ü ������ ���ΰ� �Է�
			this.size++; // ������ ��
		} else { // ����� 0�� �ƴ϶��
			for (i = getSize() - 1; i >= 0; i--) { // ������-1���ͽ���(�ε����ִ밪), i�� 0���� �ٿ������鼭 �ݺ�

				if (arrayBag[i].value() > coin) { // ������ �迭�� ������ �۴ٸ�
					arrayBag[i + 1] = new Coin(arrayBag[i].value()); // ���� �迭�� ������ĭ�� ��ü�� �������ְ� �迭�� ���� �־��ش�.
				} else { // ������ �迭�� ������ ���� ������
					break; // for�� Ż��
				}
			}
			if (arrayBag[i + 1] == null) { // �迭�� �������� ���ٸ� => ��ü�� �����ȵǾ�����
				arrayBag[i + 1] = new Coin(coin); // ���ΰ�ü�� �����ϰ� ���ΰ� �Է� => ���ΰ����� �迭 ���麸�� ����Ŭ��
			} else { // �������� ��ü�� �ִٸ�
				arrayBag[i + 1].setValue(coin); // �������� ���ΰ��� �Է�
			}
			this.size++; // ������ ��
		}
	}


}
