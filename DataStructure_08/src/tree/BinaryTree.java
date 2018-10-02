package tree;

public class BinaryTree { //트리 클래스 생성
	private BinaryNode root; //BinaryNode형식의 root 생성
	private String order; //String형식의 order 생성

	public BinaryTree(String value, String order) { //매개변수 두개인 생성자
		// Don't save the value.
		this.order = order; //매개변수(order)와 전역변수 동일시
		parse(value); //parse메소드의 매개변수로 이동
	}

	private void parse(String value) { //4가지 형식으로 바꿔주는 메소드
		if ("preOrder".equals(this.order)) { //preorder의 경우
			parseToPreOrder(value); // preorder로 바꿔주는 메소드에 매개변수 입력
		} else if ("postOrder".equals(this.order)) { //postorder의 경우
			parseToPostOrder(value); //postorder로 바꿔주는 메소드에 매개변수 입력
		} else if ("levelOrder".equals(this.order)) { //levelorder의 경우
			parseToLevelOrder(value); //levelorder로 바꿔주는 메소드에 매개변수 입력
		} else {// 해당사항 없는 경우 
			parseToInorder(value); //모두 inorder로 바꿔주는 메소드에 매개변수 입력
		}
	}

	private void parseToInorder(String value) { //inorder로 바꿔주는 메소드
		if ("".equals(value)) { //값이 아무것도 없다면
			this.root = new BinaryNode(); //root에 BinaryNode 생성
		} else { //값이 존재한다면
			this.root = makeInorderTree(value); //root에 inorder트리를 만드는 메소드에 매개변수를 입력한 결과를 저장
		}
	}

	private BinaryNode makeInorderTree(String value) { //inorder를 만들어주는 메소드
		if ("".equals(value)) //값이 비어있다면
			return null; //null 리턴
		BinaryNode node = new BinaryNode(value.charAt(value.length() / 2) + " "); //node값에 value의 중간 글자를 넣음

		node.setLeft(makeInorderTree(value.substring(0, value.length() / 2))); //node의 왼쪽 자식에 재귀함수를 입력, 매개변수는 문자열의 처음부터 중간까지
		node.setRight(makeInorderTree(value.substring(value.length() / 2 + 1, value.length()))); //node의 오른쪽 자식에 재귀함수를 입력, 매개변수는 문자열의 중간 다음글자부터 끝까지

		return node; //node값 리턴 => inorder트리 형태
	}

	private void parseToPreOrder(String value) { //preorder로 바꿔주는 메소드
		if ("".equals(value)) { //값이 비어있다면
			this.root = new BinaryNode(); //root에 BinaryNode 생성
		} else { // 값이 존재한다면
			this.root = makePreOrderTree(value); //root에 preorder트리를 만드는 메소드에 매개변수를 입력한 결과 저장
		}
	}

	private BinaryNode makePreOrderTree(String value) { //preorder를 만들어주는 메소드
		if ("".equals(value)) //값이 비어있다면
			return null; //null 리턴
		BinaryNode node = new BinaryNode("" + value.charAt(0)); //node값에 value의 첫번째 글자를 넣음
		node.setLeft(makePreOrderTree(value.substring(1, value.length() / 2 + 1))); //node의 왼쪽 자식에 재귀함수를 입력, 매개변수는 문자열의 두번째 글자부터 중간 다음글자까지
		node.setRight(makePreOrderTree(value.substring(value.length() / 2 + 1, value.length()))); //node의 오른쪽 자식에 재귀함수를 입력, 매개변수는 문자열의 중간 다음글자부터 끝까지

		return node; //node값 리턴 => preorder트리 형태
	}

	private void parseToPostOrder(String value) { //postorder로 바꿔주는 메소드
		if ("".equals(value)) { //값이 비어있다면
			this.root = new BinaryNode(); //root에 BinaryNode 생성
		} else { // 값이 존재한다면
			this.root = makePostOrderTree(value); //root에 postorder트리를 만드는 메소드에 매개변수를 입력한 결과 저장
		}
	}

	private BinaryNode makePostOrderTree(String value) { //postorder를 만들어주는 메소드
		if ("".equals(value)) //값이 비어있다면
			return null; //null 리턴

		BinaryNode node = new BinaryNode(value.charAt(value.length() - 1) + ""); //node값에 value의 마지막 글자를 입력

		node.setLeft(makePostOrderTree(value.substring(0, value.length() / 2))); //node의 왼쪽 자식에 재귀함수를 입력, 매개변수는 문자열의 첫번째 글자부터 중간글자까지
		node.setRight(makePostOrderTree(value.substring(value.length() / 2, value.length() - 1))); //node의 오른쪽 자식에 재귀함수를 입력, 매개변수는 문자열의 중간글자부터 마지막글자까지
 
		return node; //node값 => postorder트리 형태
	}

	private void parseToLevelOrder(String value) { //levelorder로 바꾸고 구현하는 메소드
		String s[] = value.split(""); //value값을 한글자씩 배열로 만들어준 후 저장
		LinkedQueue q = new LinkedQueue(); //linkedQueue 인스턴스화 생성

		int index = 0; //인덱스 변수 생성 0부터
		this.root = new BinaryNode(s[index++]);//s[0]을 root에 지정 후  인덱스 증가

		if (this.root == null) //root에 값이 비어있다면
			return; //리턴
		
		q.add(this.root); //root값을 queue에 추가

		BinaryNode current_node = q.remove();//queue에 값을 꺼내서 변수에 저장 => root가 변수에 저장됨
		while (current_node != null) { //변수 node가 비어있지 않을 동안 반복
			if (index < s.length) { //index가 배열의 길이보다 작다면 
				current_node.setLeft(new BinaryNode(s[index++]));//node의 왼쪽 자식에 노드형태의 배열 다음값 입력, 입력 후 인덱스값 증가
				q.add(current_node.getLeft()); //queue에 node의 왼쪽자식을 추가
			}
			if (index < s.length) { //index가 배열의 길이보다 작다면 => 오른쪽 값을 넣어주기 위한 조건
				current_node.setRight(new BinaryNode(s[index++])); //node의 오른쪽 자식에 노드형태의 배열 다음값 입력 , 입력 후 인덱스 값 증가 => 배열의 다음값들이 하나씩 입력되는 원리
				q.add(current_node.getRight()); //queue에 node의 오른쪽 자식을 추가
			}
			current_node = q.remove(); //queue에 값을 빼서 node에 입력 => 왼쪽 자식 / 오른쪽 자식이 번갈아가며 나옴
		}
	}

	private String inorder(BinaryNode node) { //inorder 탐색 메소드
		String string = ""; //string 변수 생성
		if (node == null) //node가 비어있으면
			return ""; //리턴

		string += inorder(node.getLeft()); //변수에 왼쪽 자식부터 재귀함수 구현, 변수에 저장
		string += node.getValue(); //변수에 node값 저장 => root값
		string += inorder(node.getRight()); //변수에 오른쪽 자식 재귀함수 구현, 변수에 저장

		return string; //변수 리턴
	}

	private String preOrder(BinaryNode node) { //preorder 탐색 메소드
		String string = ""; //string 변수 생성
		if (node == null) //node가 비어있으면
			return ""; //리턴

		string += node.getValue(); //변수에 node값 저장 => root값
		string += preOrder(node.getLeft()); //변수에 왼쪽 자식 재귀함수 구현, 변수에 저장
		string += preOrder(node.getRight()); //변수에 오른쪽 자식 재귀함수 구현, 변수에 저장
		return string; //변수 리턴
	}

	private String postOrder(BinaryNode node) { //postorder 탐색 메소드
		String string = ""; //string 변수 생성
		if (node == null) //node가 비어있으면
			return ""; //리턴
		string += postOrder(node.getLeft()); //변수에 왼쪽 자식 재귀함수 구현, 변수에 저장
		string += postOrder(node.getRight()); //변수에 오른쪽 자식 재귀함수 구현, 변수에 저장
		string += node.getValue(); //변수에 node값 저장 => root값
		return string; //변수 리턴
	}
	
	private String levelOrder(BinaryNode node) { //levelorder 탐색 메소드
		LinkedQueue Queue = new LinkedQueue(); //LinkedQueue 인스턴스 생성
		Queue.add(node); //queue에 node값 입력
		String string = ""; //string 변수 생성
		
		while (!Queue.isEmpty()) { //큐가 비어있지 않을 동안 반복 
			BinaryNode current_node = Queue.remove(); //큐의 값을 꺼내 node에 지정
			string += current_node.getValue(); //변수에 node의 값 저장
			
			if (current_node.getLeft() != null) //node의 왼쪽 자식이 비어있지 않다면
				Queue.add(current_node.getLeft()); //큐에 node의 왼쪽 값 추가
			if (current_node.getRight() != null) //node의 오른쪽 자식이 비어있지 않다면
				Queue.add(current_node.getRight()); //큐에 node의 오른쪽 값 추가 
		} // 반복하면서 왼쪽, 오른쪽 자식들을 큐에 추가하고 node에 저장해서 그 값을 string 변수에 저장하는 원리
		return string; //string 리턴
	}

	public String getValue() { //order로 탐색해서 문자열의 값을 얻어내는 함수
		String value; //변수 지정
		if ("preOrder".equals(this.order)) { //매개변수 order가 preorder라면
			value = preOrder(this.root);//preorder메소드로 탐색 후 변수에 저장
		} else if ("postOrder".equals(this.order)) { //매개변수 order가 postorder라면
			value = postOrder(this.root); //postorder메소드로 탐색 후 변수에 저장
		} else if ("levelOrder".equals(this.order)) { //매개변수 order가 levelorder라면
			value = levelOrder(this.root); //levelorder메소드로 탐색 후 변수에 저장
		} else { //매개변수 order가 이외의 것이라면
			value = inorder(this.root); //inorder메소드로 탐색 후 변수에 저장
			// System.out.printf("here : \n",this.root);
		}

		return value;
	}

	public void print() { //출력해주는 메소드
		LinkedQueue queue = new LinkedQueue(); //큐를 인스턴스화해서 구현
		queue.add(this.root);// 큐에 root값을 추가
		int level = this.root.level(); //root의 level값을 변수에 지정
		String interval = "%" + (int) Math.pow(2, this.root.height()) + "s"; //간격을 지정 => Math.pow는 제곱 함수(밑=2,지수=height()) 
		//format함수를 통해 값을 문자로 만들어주기 위해 앞에 '%'와 뒤에 's' 사용
		StringBuilder tree = new StringBuilder(); //StringBuilder를 인스턴스화
		while (!queue.isEmpty()) { // 큐가 비어있지 않을 동안 반복
			BinaryNode currentNode = queue.remove(); // 큐에서 뺀 것을 변수에 저장
			if (currentNode != null) { //큐가 비어있지 않는 다면
				if (level < currentNode.level()) { //현재노드의 레벨이 루트의 레벨보다 크다면
					level = currentNode.level(); //현재노드의 레벨을 루트레벨에 지정
					interval = "%" + (int) Math.pow(2, currentNode.height()) + "s"; //간격을 현재 노드의 높이에 맞춰서 지정
					tree.append("\n"); //트리에 줄바꿔서 이어붙이기
				} 
				queue.add(currentNode.getLeft()); //node의 왼쪽자식을 큐에 추가
				queue.add(currentNode.getRight()); //node의 오른쪽자식을 큐에 추가

				tree.append(String.format(interval, currentNode.getValue())).append(String.format(interval, "")); //tree에 이어 붙임 => 2^높이 간격만큼 노드의 값을 붙이고 이어서 간격만큼 띄어쓰기  
			} else { //큐가 비어있다면
				tree.append(String.format(interval, "")).append(String.format(interval, "")); //tree에 이어붙임 => 2^높이 만큼 간격 띄어쓰기
			}
		}
		System.out.println(tree.toString()); //트리 값을 문자열로 만들어서 출력
	}
}

