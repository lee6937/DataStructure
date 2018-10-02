public class CircularArrayQueue {
	private int maxSize;
	private int front;
	private int rear;
	private String[] elements;

	CircularArrayQueue() { // 기본 생성자
		this.maxSize = 5; // 최대 사이즈 5로 초기화
		this.front = 0; // front값 0으로 초기화
		this.rear = 0; // rear값 0으로 초기화
		this.elements = new String[maxSize]; // 최대 사이즈 크기의 String배열 생성
	}

	public boolean enQueue(String string) { // 큐에 추가하는 메소드
		if (isFull()) { // 꽉 차있다면
			System.out.println("큐가 꽉차서 삽입이 불가능합니다."); // 삽입 불가하다는 메세지 출력 후
			return false; // false 반환
		}
		this.rear = (rear + 1) % maxSize; // rear에 1을 더하고 최대사이즈로 나누어서 rear위치를 조정
		elements[rear] = string; // 조정한 rear 값에 매개변수 입력
		return true; // true 반환
	}

	public String deQueue() { // 큐에 제거하는 메소드
		String deElement = null; //값을 제거하기 위한 변수
		if (isEmpty()) // 비어있다면
			return "ERROR : 큐에 원소가 없습니다."; // 원소가 없다는 메세지 반환
		this.front = (this.front + 1) % maxSize; // front값을 1 증가시키고 maxSize로 나눠서 값 조정
		deElement = elements[front]; // 변수에 제거할 값을 넣어준다
		elements[front] = null; // front가 가리키는 값을 제거
		return deElement; // 제거한 값 리턴

	}

	public void removes(int i) { // i개 만큼의 값을 제거하는 메소드
		if (isEmpty()) // 비어있다면
			System.out.println("ERROR : 큐에 원소가 없습니다."); // 제거할 원소가 없다는 메소드 출력
		String removedValue; // 제거할 값을 담을 변수 생성
		for (int k = 0; k < i; k++) { // i번 반복
			removedValue = deQueue(); // 
			System.out.println("[Dequeue] 삭제된 원소는 " + removedValue + " 입니다.");
		}
	}

	public String printQueue() { // 저장된 모든 값을 출력하는 메소드
		String queueStr = ""; // 출력할 값을 담을 변수 생성
		if (isEmpty()) // 비어있다면
			return null; // null 반환
		else {
			for (int i = 1; i < size() + 1; i++) //i를 1부터 사이즈 +1까지 반복 => i가 0부터 시작하면 front부터 출력되기 때문에 조정
				queueStr += elements[(this.front + i) % maxSize] + " "; // front + 1부터 사이즈까지 원소들을 변수에 저장
			return queueStr; // 값이 들어있는 변수 리턴
		}
	}

	public String front() { // front원소의 값 출력 메소드
		return elements[front + 1]; // front의 다음값을 리턴 => 가장 첫번째 값
	}

	public int size() { // 사이즈 메소드
		if (rear >= front) {// rear값이 front값 보다 크거나 같을 때
			// System.out.println("size : " + this.rear-this.front);
			return (this.rear - this.front); // rear에서 front를 빼준다.
		} else // front값이 rear값 보다 더 클때
			return this.maxSize - (this.front - this.rear); // front에서 rear값을 빼준것을 다시 최대사이즈에서 빼준다.
	}

	public boolean isEmpty() { // 비어있는지 확인 함수
		return (this.front == this.rear); // front와 rear가 같으면 true 반환
	}

	public boolean isFull() { // 가득차있는지 확인 함수
		return ((this.rear + 1) % maxSize == this.front); // rear에 1을 더하고 최대사이즈로 나누어 front와 같으면 true 반환 => 빈 공간을 하나 만들어
															// 비어있는 함수와 구분
	}
}
