package DataStructure;

public class SortedArrayBag {

	Coin arrayBag[]; // Coin클래스의 배열 생성
	int size; // 사이즈변수 생성

	public SortedArrayBag(int i) {
		arrayBag = new Coin[i]; // 매개변수를 입력한 코인배열 생성
		size = 0; // 사이즈 0 초기화
	}

	public int getSize() { // 사이즈를 가져오는 메소드
		return size;
	}

	void max(int cycleSize) { // max 메소드생성
		cycleSize = Integer.MIN_VALUE; // 매개변수에 정수 최소값 입력
		for (int i = 0; i < getSize(); i++) { // 0부터 사이즈까지 반복
			if (cycleSize < arrayBag[i].value()) { // 매개변수가 arrayBag의 값보다 작다면
				cycleSize = arrayBag[i].value(); // 매개변수에 arrayBag값 입력 => 사이즈까지 반복하면 최대값이 매개변수에 저장
			}
		}
	}

	void add(int coin) { // add메소드 생성
		int i; // int변수 i 생성
		if (getSize() == 0) { // 사이즈가 0이라면
			arrayBag[getSize()] = new Coin(coin); // 처음 배열에 코인 객체 생성후 코인값 입력
			this.size++; // 사이즈 업
		} else { // 사이즈가 0이 아니라면
			for (i = getSize() - 1; i >= 0; i--) { // 사이즈-1부터시작(인덱스최대값), i를 0까지 줄여나가면서 반복

				if (arrayBag[i].value() > coin) { // 코인이 배열의 값보다 작다면
					arrayBag[i + 1] = new Coin(arrayBag[i].value()); // 코인 배열의 오른쪽칸에 객체를 생성해주고 배열의 값을 넣어준다.
				} else { // 코인이 배열의 값보다 작지 않으면
					break; // for문 탈출
				}
			}
			if (arrayBag[i + 1] == null) { // 배열의 다음값이 없다면 => 객체가 생성안되어있음
				arrayBag[i + 1] = new Coin(coin); // 코인객체를 생성하고 코인값 입력 => 코인값들이 배열 값들보다 가장클때
			} else { // 다음값에 객체가 있다면
				arrayBag[i + 1].setValue(coin); // 다음값에 코인값만 입력
			}
			this.size++; // 사이즈 업
		}
	}


}
