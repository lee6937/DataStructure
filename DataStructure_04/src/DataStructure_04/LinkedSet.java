package DataStructure_04;

public class LinkedSet implements LinkedSetInterface{
		
	private Node head; //전역변수 head 생성
	private int size;  //전역변수 size 생성
	
	public LinkedSet() { //기본 생성자
		this.head = new Node(); //전역변수 노드객체 생성
		this.size = 0; //사이즈 값 초기화
	}
	
	@Override
	public int size() { //getter 생성
		return this.size; //전역변수 값 리턴
	}
	
	@Override
	public boolean add(String string) { //메소드 생성
			Node newNode; //Node클래스의 newNode변수 생성
			newNode = new Node(string); //newNode에 객체 생성 후 매개변수 입력
			Node node = head; //node는 헤드와 같은 값을 가리킴
			for (int i = 0; i < this.size; i++) { //사이즈까지 반복
				if(node.next().coin().equals(string)) { //node다음 코인값이 string과 같다면
					System.out.println("동일한 문자열이 있어서 추가 안 됨");
					return false; // 추가하지 않고 false 리턴
				}
				else
					node = node.next(); //node를 다음 node로 바꾸면서
			}
			node.setNext(newNode); //node 다음값에 newNode값 입력 
			this.size++; //사이즈 업
			return true; //true 리턴
		}
	

	@Override
	public boolean contains(String string) { //메소드 생성
		for(int i=0; i< this.size; i++) { //사이즈까지 반복
			Node node = this.head; //node는 헤드와 같은 값을 가리킴
			while (node.next() != null) { //node의 다음값이 비어있지 않을때 까지 반복
			if(node.next().coin().equals(string)) //node 다음값의 코인이 매개변수와 같으면
				return true; //true 리턴
			else
				node = node.next(); //그렇지 않다면 node를 다음 node값으로 변경
			}
		}
		return false; // 못찾을 시 false 리턴
	}
	

	@Override
	public String remove(String string) { //메소드 생성
		if(isEmpty()) //비어있을 시
			return null; //null 리턴
		else { //비어있지 않을 시
			Node node = new Node(); //node 변수에 객체 생성
			node = head;//node는 헤드와 같은 값을 가리킴
			while (node.next() != null) { //node다음값이 비어있지 않을 때까지 반복
				if(node.next().coin().equals(string)) {//node의 다음 값이 매개변수와 같을 경우
					node.setNext(node.next().next()); //node의 다음값을 node의 다음 다음 값으로 설정
					this.size--; //사이즈 줄여줌
					return string; //string 리턴
				}
				else 
					node = node.next(); //node에 다음값 입력 => 반복을 위해
			}
			return null; //찾아도 없을 시 null리턴
		}
	}
	
	public boolean isEmpty() { // 메소드 생성
		if (this.size == 0) { // 사이즈가 0이라면
			return true; // true값 리턴
		} else // 사이즈가 0이 아니라면
			return false;// false값 리턴
	}

	@Override
	public void clear() { // 메소드 생성
		head.setNext(null); // head의 다음값을 null로 지정 => 연결을 끊어버림
		this.size = 0; //사이즈를 0으로
	}

	@Override
	public void print() { // 메소드 생성
		System.out.println(this); //LinkedSet객체의 toString()메소드 실행
	}
	
	@Override
	public String toString() { // 메소드 생성
		String result; //변수 생성
		Node node = head; //head가 가르키는 값을 node도 가리킴
		result = "[ "; // result형식
		while (node.next() != null){ //node 다음값이  비어있지 않을 때 동안 반복
		node = head.next(); //node는 head다음값
		result += node.coin() + " "; //변수에 node코인값 입력
		}
		result += "]"; //형식 하나 추가
		return result; //변수 값 출력
	}
	
}
