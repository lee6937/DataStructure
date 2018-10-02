package DataStructure;

public class SortedLinkedBag {
		
	public Node _head; //node객체의 변수 생성
	int maxsize; //최대사이즈 변수 생성
	int size; //사이즈 변수 생성
	
	SortedLinkedBag() { //디폴트 생성자
		
	}
	
	SortedLinkedBag(int _maxsize) { //생성자
		this.maxsize = _maxsize; //최대 사이즈 입력
		this._head = null; //head값 초기화
		this.size = 0; //사이즈값 초기화
	}
	
	public int getSize() {
		return this.size;
	}
	
	 void max(int cycleSize) { //max 메소드 생성
		 _head = new Node(); //_head라는  node객체 생성
		 Node node = _head.next(); //node에 _head의 다음값 지정
		 cycleSize = Integer.MIN_VALUE; //매개변수에 정수 최소값 입력
		 
		 if(node == null) //node가 비어있다면
			 return; //리턴
		 else { //node가 비어있지 않다면
		while (node.next() == null) { //node의 다음값이 비어있을때 까지
			if(cycleSize < node.coin()); {//매개변수가 node의 coin값 보다 작으면
				cycleSize = node.coin(); // 매개변수에 node의 coin값 입력
			}
			node = node.next(); // node에 node다음값 입력 => 반복을 위해
		}
	 }
	 }
	  /*  boolean add(int coin) { //메소드 생성
	    	
		    if (isFull())  //가득찼다면
		    	return false;  // false 리턴
			else {  //가득차지 않았다면
				Node newNode = null; //newNode값 비어있음
				Node prev = null; //prev값 비어있음
				newNode = new Node(coin); //newNode객체 생성후 매개변수 입력
				
				Node node = this._head; //node와 _head는 같게 설정
				
				if (node == null) { //node값이 비어있을때
					
					this._head = new Node(); //_head를 객체로 생성
					node = this._head; //node와 head가 같다고 지정 
					
					node.setNext(newNode); //node의 next값에 newNode입력 => 첫번째값 입력
					
					this.size++; //사이즈 업
					return true; //함수 종료
				}
				prev = node; //prev변수는 node 값
				node = node.next(); //node는 node의 다음값
				
				while(node != null) { //node값이 비어있지 않을 때까지 반복
					
					if(node.coin() <= newNode.coin() && node.next() == null) { // 새로들어온 코인값이 node코인의 값보다 크거나 같고, node다음값이 없다면
						node.setNext(newNode); // node의 다음값에 새로들어온 코인값 입력
						break; //탈출
					}
					
					else if(node.coin() <= newNode.coin() && node.next() != null) { // 새로들어온 코인값이 node코인의 값보다 크거나 같고, node다음값이 있다면
						prev = node; //prev값에 node값 입력
						node = node.next(); //node값에 node다음값 입력
					}
					
					else if(node.coin() > newNode.coin() ) { // 새로들어온 코인값이  node코인의 값보다 작고, prev값이 head라면
						prev.setNext(newNode); // prev의 다음값에 새로운코인 입력
						newNode.setNext(node); // 새로운 코인의 다음값에 node값 입력
						break; //탈출
					}
					
					else if(node.coin() > newNode.coin() && prev != this._head) { // 새로들어온 코인값이 node코인의 값보다 작고, prev값이 head가 아니라면
						prev.setNext(newNode); //prev의 다음값에 새로운코인 입력
						newNode.setNext(node); //새로운 코인의 다음값에 node값 입력
						break; //탈출
					}
				}
				
				this.size++; //사이즈 업
				return true; //함수 종료
			}
	    } */
	 
	boolean add(int coin) {
		if (isFull()) {
			return false;
		} else {
			Node node = _head;
			Node prev = null;
			Node newNode = new Node(coin);
			if (node == _head) {
				newNode.setNext(null);
				_head = newNode;
			}
			else {
				int index;
				for (index = 0; index < size; index++) {
					if (node.coin() > newNode.coin()) {
						break;
					}
					else {
					prev = node;
					node = node.next();
					
				}
				prev.setNext(newNode);
				newNode.setNext(node);
			}
			}
			this.size++;
		}
		return true;
	}
	

	    boolean isFull() { //메소드 생성
	    	if (getSize() == 5000) //사이즈가 5000이라면
				return true; //true값 리턴
	    	else
	    		return false; 
	    }
	    
	    void printResult() {
	    	Node p = _head;
	    	for(int i=0; i<this.size; i++) {
	    		System.out.println(p.coin());
	    		p = p.next();
	    	}
	    }
	    
}