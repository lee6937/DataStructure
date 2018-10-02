
public class Node { 
	private String element; //String 형태의 변수 생성
	private Node leftChild; //Node 형태의 왼쪽 자식을 가리키는 변수 생성 
	private Node rightChild; //Node 형태의 오른쪽 자식을 가리키는 변수 생성

	public Node(String string) { //매개변수 1개인 생성자
		this.element = string; //매개변수를 변수로 지정
		this.leftChild = null; 
		this.rightChild = null; //자식을 가리키는 변수 초기화 
	}
	
	public Node(String element, Node leftChild, Node rightChild) {
		super(); //부모클래스 디폴드 생성자
		this.element = element;      
		this.leftChild = leftChild;
		this.rightChild = rightChild; //매개변수와 전역변수 일치 
	}

	public String getElement() { //getter
		return element;
	}

	public void setElement(String element) { //setter
		this.element = element;
	}

	public Node getLeftChild() { //getter
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {//setter
		this.leftChild = leftChild;
	}

	public Node getRightChild() {//getter
		return rightChild;
	}

	public void setRightChild(Node rightChild) {//setter
		this.rightChild = rightChild;
	}

	public boolean hasLeftChild() { // 왼쪽 자식을 가지고 있는지 확인 메소드
		return (this.leftChild != null); // 왼쪽 자식이 비어있지 않으면 true 반환
	}
	
	public boolean hasRightChild() { // 오른쪽 자식을 가지고 있는지 확인 메소드
		return (this.rightChild != null); // 오른쪽 자식이 비어있지 않으면 true 반환
	}
	
	public boolean isLeaf() { //Leaf인지 확인하는 메소드
		return (this.leftChild == null) && (this.rightChild == null); //왼쪽 자식과 오른쪽 자식이 둘다 비어있으면 true 반환
	}
	
	public int height() { //높이가 얼마인지 확인 메소드
		int leftHeight = 0; //왼쪽 높이 0으로 지정
		if(this.hasLeftChild()) { //왼쪽 자식을 가지고 있으면
			leftHeight = this.leftChild.height(); // 왼쪽 높이는 왼쪽자식의 높이 확인하는 메소드 => 재귀함수
		}
		int rightHeight = 0; // 오른쪽 높이 0으로 지정
		if(this.hasRightChild()) { //오른쪽 자식을 가지고 있으면
			rightHeight = this.rightChild.height(); // 오른쪽 높이는 오른쪽 자식의 높이를 확인하는 메소드 => 재귀함수
		}
		if(leftHeight > rightHeight) //왼쪽 높이가 오른쪽 높이보다 크다면
			return leftHeight+1; // 왼쪽 높이 +1 => 자기까지 더해줌
		else
			return rightHeight+1; // 그렇지 않으면 오른쪽 높이 + 1 
	}
	
	public int numberOfNodes() { // 노드의 개수가 몇개인지 확인 메소드
		int numberOfLeftNodes = 0; // 왼쪽 노드 개수 0으로 지정
		if(this.hasLeftChild()) { //왼쪽 자식을 가지고 있으면
			numberOfLeftNodes = this.leftChild.numberOfNodes(); // 왼쪽 노드 개수는 왼쪽 자식노드의 노드 개수 확인 메소드 => 재귀함수
		}
		int numberOfRightNodes = 0; // 오른쪽 노드 개수 0으로 지정
		if(this.hasRightChild()) { // 오른쪽 자식을 가지고 있으면
			numberOfRightNodes = this.rightChild.numberOfNodes(); // 오른쪽 노드 개수는 오른쪽 자식노드의 노드 개수 확인 메소드 => 재귀함수
		}
		return 1+numberOfLeftNodes+numberOfRightNodes; // 총 개수는 왼쪽노드 개수 + 오른쪽 노드 개수 + 뿌리 1개
	}
	
	public void inorder (Node root) { //중위 탐색 방법 => root를 중간에 탐색
		if(root != null) { //root가 비어있지 않다면
			inorder(root.getLeftChild()); //root의 왼쪽자식부터 중위탐색 시작=> 재귀함수
			System.out.println(root.getElement()); //왼쪽을 다 탐색 후 root를 탐색
			inorder(root.getRightChild()); //root의 오른쪽 자식 중위탐색 시작 => 재귀함수
		}
	}
	
	public void preorder (Node root) { //전위 탐색 방법 => root를 먼저 탐색
		if(root != null) { //root가 비어있지 않다면
		System.out.println(root.getElement()); //root를 먼저 탐색
		preorder(root.getLeftChild()); //root의 왼쪽자식부터 전위탐색 시작 => 재귀함수
		preorder(root.getRightChild()); //root의 오른쪽자식부터 전위탐색 시작 => 재귀함수
		}
	}
	
	public void postorder (Node root) { //후위 탐색 방법 => root를 나중에 탐색
		if(root != null) { //root가 비어있지 않다면
		postorder(root.getLeftChild()); //root의 왼쪽자식부터 후위탐색 시작 => 재귀함수
		postorder(root.getRightChild()); //root의 오른쪽자식부터 후위탐색 시작 => 재귀함수
		System.out.println(root.getElement()); //root를 마지막에 탐색
		}
	}
	
}
