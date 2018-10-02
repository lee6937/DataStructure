public class MaxHeap implements Heap {
	private int[] heap; // heap 배열 변수 생성
	private int size; // 사이즈 변수 생성
	// Don't add field!!!!!!!
	// Don't add field!!!!!!!
	// Don't add field!!!!!!!
	// Don't add field!!!!!!!

	public MaxHeap() { // 초기 생성자
		this.heap = new int[10]; // 10사이즈의 배열 객체 생성
		this.size = 0; // 사이즈 0으로 초기화
	}

	private MaxHeap(int[] array, int size) { // 매개변수를 가지는 생성자
		this.heap = array; // 매개변수와 전역변수 동일시
		this.size = size; // 사이즈도 같게 설정
	}

	@Override
	public boolean isEmpty() { // 비어있는지 확인 메소드
		return size == 0; // 사이즈 0이면 true
	}

	@Override
	public boolean isFull() { // 가득 찼는지 확인 메소드
		return size == heap.length; // 사이즈가 heap의 길이과 같다면 true
	}

	@Override
	public void add(int element) { // 값을 추가하는 메소드
		if (isFull()) // 가득차있다면
			resize(); // 사이즈 두배로 증가
		else { // 가득차지 않았다면
			this.size++; // 사이즈를 먼저 증가
			this.heap[this.size - 1] = element; // 사이즈-1의 인덱스에 값을 추가
			int current = this.size - 1; // 추가한 값의 인덱스를 변수에 저장
			while (current != 0) { // 인덱스가 0이 아닐 동안 반복
				if (current % 2 == 0 && heap[current] > heap[current / 2 - 1]) { // 인덱스가 짝수이면서 현재 인덱스가 부모의 인덱스보다 크다면
					// 인덱스가 짝수이면 부모는 현재 인덱스에 2를 나누고 1을 빼야함
					swap(heap, current, current / 2 - 1); // 현재 인덱스와 부모의 인덱스를 swap
					current = current / 2 - 1; // 현재 인덱스를 부모로 설정
				} else if (current % 2 == 1 && heap[current] > heap[current / 2]) { // 인덱스가 홀수이면서 현재 인덱스가 부모의 인덱스보다 크다면
					// 인덱스가 홀수이면 부모는 현재 인덱스에 2를 나눔
					swap(heap, current, current / 2); // 현재 인덱스와 부모의 인덱스를 swap
					current = current / 2; // 현재 인덱스를 부모로 설정
				} else // 이외 => swap할 필요가 없다.
					break;
			}
		}
	}

	@Override
	public int max() { // 최대값 구하는 메소드
		if (isEmpty()) // 비어있다면
			return 201401703; // 학번 리턴
		else { // 비어있지 않다면
			return this.heap[0]; // 첫번째 인덱스 값 리턴 => 추가할 때 max값을 인덱스 0으로 이미 보냈음
		}
	}

	@Override
	public int removeMax() { // 최대값을 제거하는 메소드
		int removeValue; // 제거할 값을 담을 변수 생성
		if (isEmpty()) { // 비어있다면
			return 201401703; // 학번 리턴
		} else { // 비어있지 않다면
			swap(heap, 0, this.size - 1); // 0번 인덱스와 마지막 인덱스 swap => max값이 가장 마지막인덱스로 이동
			removeValue = heap[this.size - 1]; // 마지막 인덱스의 값을 변수에 저장
			heap[this.size - 1] = 0; // 마지막 인덱스 값을 0으로 설정
			this.size--; // 사이즈 줄여줌
			heapify(0); // 0번째 인덱스를 heap정렬
		}
		return removeValue; // 제거한 값 리턴
	}

	@Override
	public int size() { // 사이즈 메소드
		return size; // 현재 사이즈 리턴
	}

	public void heapify(int index) { // 매개변수 인덱스를 heap정렬 하는 메소드

		if (this.size < index * 2 + 2) // 자식들이 사이즈를 넘을 경우
			this.resize(); // 사이즈를 늘려준다.

		int largeIndex; // 값이 큰 인덱스를 저장할 변수 생성
		largeIndex = index; // 처음에 자기 인덱스를 설정
		if (largeIndex < this.size) { // 인덱스가 사이즈를 안넘어간다면
			if (heap[index] > heap[index * 2 + 1]) // 현재 인덱스가 왼쪽 자식 인덱스보다 크다면
				largeIndex = index; // 현재 인덱스를 변수에 저장
			else
				largeIndex = index * 2 + 1; // 왼쪽 자식 인덱스가 더 크다면 자식 인덱스를 변수에 저장
			if (heap[largeIndex] < heap[index * 2 + 2]) // 저장된 인덱스보다 오른쪽 자식 인덱스가 더크다면
				largeIndex = index * 2 + 2; // 오른쪽 자식 인덱스를 변수에 저장
			if (index != largeIndex) { // 현재 인덱스와 저장된 인덱스가 다르다면
				swap(heap, index, largeIndex); // 두개를 swap
				heapify(largeIndex); // 바꾼 인덱스를 다시 heap정렬 => 재귀함수
			}
		}

	} // 반복문을 통해 아래에서 위로 돌면 위로 값이 올라감 //부모인덱스 부터 0까지 반복

	public void buildHeap() { // 배열 모두 heap정렬을 완성하는 메소드
		for (int i = this.size / 2; i >= 0; i--) { // 중간부터 반복 => 인덱스 0까지 올라감
			heapify(i); // 인덱스마다 heap정렬을 해줌 => 재귀함수이므로 자식들까지 다 heap정렬해준다.
		}
	}

	public boolean increaseKey(int target, int num) { // target값을 바꿔주는 메소드 바꾸는것부터만 돌리면 됨 굳이 밑에서부터 말고 //index잘 찾아서
														// heapfy하면됨
		for (int index = 0; index < this.size; index++) { // 사이즈만큼 반복하면서
			if (heap[index] == target) { // target값의 인덱스를 찾으면
				heap[index] = num; // 인덱스의 배열값을 num으로 교체
				buildHeap(); // 모든 배열 heap정렬
				return true; // true리턴
			}
		}
		return false; // target을 못찾았다면 false리턴
	}

	public static int[] heapSort(int[] array, int size) { // 배열을 heap정렬하는 메소드
		MaxHeap heap = new MaxHeap(array, size); // MaxHeap형태의 배열 생성후 배열과 사이즈값 입력
		heap.buildHeap(); // 배열 heap 정렬
		int[] temp = new int[size]; // 임시 배열 하나 생성 => 순서대로 저장하기 위해
		for (int i = 0; i < size; i++) { // 사이즈만큼 반복하면서
			temp[i] = heap.removeMax(); // heap배열 중 max값을 제거하면서 순서대로 임시배열에 저장
		}
		return temp; // 임시 배열 리턴
	}

	@Override
	public String toString() { // String객체 재정의 => 객체 출력할때 형식을 정해줌
		StringBuilder stringBuilder = new StringBuilder(); // Stringbuilder 객체 생성
		stringBuilder.append("{ "); // 처음에 "{" 이어붙임
		for (int i = 0; i < size; ++i) { // 사이즈까지 반복하면서
			stringBuilder.append(heap[i]).append(" "); // heap 배열 인덱스 처음부터 끝까지 한칸씩 띄우면서 이어붙임
		}
		stringBuilder.append("}"); // 마지막에 "}" 이어붙임

		return stringBuilder.toString(); // StringBuilder 리턴
	}

	private void resize() { // 사이즈 바꿔주는 메소드
		int[] newHeap = new int[this.heap.length * 2]; // 새로운 heap 생성, 사이즈는 heap길이 두배만큼
		System.arraycopy(this.heap, 0, newHeap, 0, this.heap.length); // heap의 0번째부터 끝까지 새로운 heap에 복사
		this.heap = newHeap; // newheap을 전역변수 heap과 동일시
	}

	private static void swap(int[] array, int i, int j) { // 인덱스 두개의 저장된 값을 바꿔주는 메소드
		int temp = array[i]; // i번째 인덱스의 값을 변수에 저장
		array[i] = array[j]; // i번째값에 j번째 값을 저장
		array[j] = temp; // 변수(i번째 값이 들어있음)값을 j번째 인덱스에 저장
	} // 둘이 서로 swap되버림
}
