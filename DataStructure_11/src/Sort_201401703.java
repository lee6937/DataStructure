public class Sort_201401703 {
	private int[] dataSet;
	private int[] bucket;
	private int size;

	void initDataSet(String dataSet) { // 주석 안달아도 된다.
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
		for (int i = 0; i < size; i++) { // 사이즈가 증가함에 따라 => 큰 값들은 점차 뒤에 쌓인다.  
			for (int j = size - 1; j > i; j--) { //마지막 인덱스부터 시작하여 값을 i까지 줄이며 반복 => 작은 값들이 앞에 쌓인다. 
				if (dataSet[j] < dataSet[j - 1]) // 전자 인덱스가 후자 인덱스보다 클때
					swap(j, j - 1); //두 인덱스를 교체 
			}
		}
	}

	void insertionSort() { //INSERTION SORT
		for (int i = 1; i < this.size; i++) { //사이즈 동안 반복 => 인덱스 1번부터 인덱스 끝까지 반복 
			int key = dataSet[i]; //인덱스 1번의 값을 변수에 저장 
			int j = i - 1; //비교할 값을 하나 작은 값으로 설정
			while (j >= 0 && dataSet[j] > key) { //비교할 값이 인덱스 0이상이면서 비교할 값이 변수값 보다 크다면
				dataSet[j + 1] = dataSet[j]; //비교할 값을 다음 인덱스에 지정
				j = j - 1; //비교할 값을 하나 줄여줌 => 계속 비교해서 변수값이 작다면 계속 내려감
			}
			dataSet[j + 1] = key; //변수값이 더 크다면 => 변수를 비교할 값 다음 인덱스에 지정
		}
	}

	void mergeSort(int begin, int end) { //MERGE SORT end는 size를 의미
		if (end - begin < 2) //길이가 1이 되면 => 배열을 하나씩 나누기 위한 종료조건 
			return; //함수 종료
		int middle = (end + begin) / 2; //중간값 설정 => 나누기 위한 기준
		mergeSort(begin, middle); //시작부터 중간-1까지 나누기(뒤의 매개변수가 사이즈 의미) => 재귀함수
		mergeSort(middle, end); //중간부터 끝까지 나누기 => 재귀함수
		merge(begin, middle, end); //정렬하여 합치는 함수
		copyArray(begin, end); //bucket 배열을 데이터 배열에 복사하는 함수
	}

	private void merge(int begin, int middle, int end) { //정렬하여 합치는 함수
		int i = begin; //첫번째 값 저장
		int j = middle; //중간 값 저장
		for (int k = begin; k < end; k++) { //배열의 사이즈까지 반복
			if (i < middle && (j >= end || dataSet[i] <= dataSet[j])) { 
				//i번째 값이 중간값 보다 작고 j값이 사이즈까지 도달하거나 j번째 값이 i번째 값보다 크거나 같을 때
				//i번째에 값이 남았고 j번째 값이 i번째 값보다 크면 =>(i번째 값을 bucket에 넣어야 한다.)
				//i번째 값이 남았고 j번째 값이 사이즈까지 도달했다면 =>(i번째 값을 bucket에 넣어야 한다.)
				bucket[k] = dataSet[i]; //값을 bucket에 넣어줌
				i = i + 1; //i값을 하나 증가 => 반복을 위한
			} else { //i값이 중간 값에 도달했고 j값이 사이즈에 도달하지 못해 남았을 경우
				     //i값이 중간에 도달하지 못했지만 j번째 값이 i번째 값보다 작을 경우
				bucket[k] = dataSet[j]; //=>(j번째 값을 bucket에 넣어야 한다.)
				j = j + 1; //j값을 하나 증가 => 반복을 위한
			}
		}
	}

	private void copyArray(int begin, int end) { //bucket배열을 데이터배열에 복사하는 함수
		for (int k = begin; k < end; k++) { //시작부터 끝까지 반복 => 원소들 전부 다 복사
			dataSet[k] = bucket[k]; //bucket의 인덱스 0부터 끝까지 => 데이터배열에 저장
		}
	}

	void quickSort(int p, int r) { //QUICK SORT
		if (p < r) { //r이 p보다 큰 조건
			int q = partition(p, r); //피봇값 위치의 인덱스를 중간으로
			quickSort(p, q - 1); //그 이전 값을 다시 재귀함수
			quickSort(q + 1, r); //그 이후 값을 다시 재귀함수
		}
	}

	int partition(int p, int r) { //파티션 나누는 함수
		int x = dataSet[r]; //마지막 인덱스의 값을 x에 저장 => x는 피봇값
		int i = p - 1; //첫번째 인덱스 이전 값을 i에 저장 => 값을 넣을 위치를 찾기 위해
		for (int j = p; j < r; j++) { //처음부터 끝까지 반복하면서
			if (dataSet[j] <= x) { //피봇값보다 데이터의 값이 작으면
				i = i + 1; //i값을 하나 증가
				swap(i, j); //j값과 교체 => 피봇값보다 작은 값들이 앞으로 이동
			}
		}
		swap(i + 1, r); //마지막 인덱스 피봇값과 i번째 다음 값을 교체
		//(i번째와 그 이전 값들은 피봇값보다 작음)
		return i + 1; //피봇값 위치의 인덱스 리턴
	}

	void swap(int index1, int index2) { 
		int temp = dataSet[index1]; 
		dataSet[index1] = dataSet[index2];
		dataSet[index2] = temp;
	}
}
