
public class BinarySearchTree { 
    BinaryNode root; // 가장 위쪽 root변수 생성

    BinarySearchTree() { //생성자
        this.root = null; //root를 초기화
    }

    BinaryNode findNode(BinaryNode x, int value, boolean toDelete) { //제거하면서 찾기 위한 toDelete 매개변수 입력
    	
    	if(x != null && x.getValue() != value) { //x가 단말노드거나 값을 찾았다면 실행 안됨
    		if(x.getValue() < value) //매개변수 값이 x의 값 보다 크다면 => 오른쪽에서 찾아야 함
    			return findNode(x.getRight(), value, toDelete); //x의 오른쪽 자식에 매개변수 넣고 재귀함수 리턴 
    		else //매개변수 값이 x의 값 보다 작다면 => 왼쪽에서 찾아야 함
    			return findNode(x.getLeft(), value, toDelete); //x의 왼쪽 자식에 매개변수 넣고 재귀함수 리턴
    	}
    	else if(x != null && x.getValue() == value) { //x가 null이 아니고, 찾았을 때
    		if(toDelete) { //toDelete가 true라는 것은 삭제하면서 지우겠다는 뜻
    			deleteNode(x); //삭제하는 메소드에 x 입력
    			return x; //삭제한 값 리턴
    		}
    		else //삭제하지 않으므로 바로 리턴
    			return x; //찾은 값 리턴
    	}
    	
    	return null;//못찾았을 때
    }

    void insertNode(BinaryNode root, BinaryNode node) { //노드를 삽입하는 메소드
    	if(this.root == null) { //root가 비어있을 때
    		this.root = node; //루트에 node 입력
    		return; //리턴
    	}
    	if(root.getValue() < node.getValue()) { //node의 값이 root의 값 보다 크다면 => root의 오른쪽으로
    		if(root.hasRight()) { //오른쪽 자식이 있다면 => 들어갈 자리가 있는지 없는지 확인
    			insertNode(root.getRight(), node); //root의 오른쪽 자식과 node를 매개변수로 재귀함수 리턴
    		} else { //오른쪽 자식이 없다면
    			root.setRight(node); //root의 오른쪽 자식에 node설정
    			node.setParent(root); //node의 부모에 root설정
    		}
    	}
    	else { //node의 값이 root의 값 보다 작거나 같다면
    		if(root.hasLeft()) { //왼쪽 자식이 있다면
    			insertNode(root.getLeft(), node); //root의 왼쪽 자식과 node를 매개변수로 재귀함수 리턴
    		} else { //왼쪽 자식이 없다면
    			root.setLeft(node); //root의 왼쪽 자식에 node설정
    			node.setParent(root); //node의 부모에 root설정
    		}
    	}
    }

    BinaryNode treeMinimum(BinaryNode node) { //가장 작은 노드를 반환하는 함수
        while(node.hasLeft()) { //node가 왼쪽 자식을 갖고 있는 동안 반복
        	return treeMinimum(node.getLeft()); //node의 왼쪽자식을 메소드에 입력 => 재귀함수 
        } //계속 반복하면서 끝에 있는 왼쪽 자식을 찾음
        return node; //찾은 노드 반환
    }

	BinaryNode deleteNode(BinaryNode z) { // 노드를 제거하는 메소드
		BinaryNode MoveNode; //이동할 노드 변수 생성
		if (!z.hasLeft()) //왼쪽 자식이 없다면 
			transplant(z, z.getRight()); //그냥 오른쪽 자식을 옮겨심으면 됨
		else if (!z.hasRight()) // 오른쪽 자식이 없다면 
			transplant(z, z.getLeft()); //그냥 왼쪽 자식을 옮겨심으면 됨
		else { // 둘다 자식이 있는 경우 => 나보다 하나 큰애를 가져와야함
			MoveNode = treeMinimum(z.getRight()); //이동노드에 오른쪽 자식의 가장 작은 노드 입력
			if (MoveNode.hasRight()) { //이동 노드의 오른쪽 자식이 있다면
				transplant(MoveNode, MoveNode.getRight()); //이동노드의 오른쪽 자식을 이동노드 자리로 옮겨 심는다.
				transplant(z, MoveNode); //이동 노드를 삭제할 노드 자리에 옮겨 심는다.
				MoveNode.setLeft(z.getLeft()); //이동 노드의 왼쪽 자식을 삭제할 노드의 왼쪽 자식으로 설정
				MoveNode.setRight(z.getRight()); //이동 노드의 오른쪽 자식0을 삭제할 노드의 오른쪽 자식으로 설정 
				z.getLeft().setParent(MoveNode); //삭제할 노드의 왼쪽 자식의 부모를 이동 노드로 설정
				z.getRight().setParent(MoveNode); //삭제할 노드의 오른쪽 자식의 부모를 이동 노드로 설정 => 양방향 관계 설정 완료
			} else { //이동 노드의 자식이 없다면, 왼쪽 자식은 없어야 함 => 이동 노드가 가장 작은 노드이기 때문
				MoveNode.getParent().setLeft(null); //이동 노드와 부모와의 관계를 먼저 끊음
				transplant(z, MoveNode); //이동노드를 삭제할 노드 자리에 옮겨 심는다.
				MoveNode.setLeft(z.getLeft()); //이동 노드의 왼쪽 자식을 삭제할 노드의 왼쪽 자식으로 설정
				MoveNode.setRight(z.getRight()); //이동 노드의 오른쪽 자식을 삭제할 노드의 오른쪽 자식으로 설정 
				z.getLeft().setParent(MoveNode); //삭제할 노드의 왼쪽 자식의 부모를 이동 노드로 설정
				z.getRight().setParent(MoveNode); //삭제할 노드의 오른쪽 자식의 부모를 이동 노드로 설정 => 양방향 관계 설정 완료
			}
		}
		return z; // 삭제할 값 리턴
	} 

    void transplant(BinaryNode des, BinaryNode source) { //트리 옮겨심는 메소드
        if(!des.hasParent()) //목적지 노드의 부모가 없다면
        	this.root = source; // 루트에 이동할 노드 입력
        else if(des == des.getParent().getLeft()) //목적지 노드가 목적지 부모의 왼쪽 자식이라면
        	des.getParent().setLeft(source); //목적지 노드의 부모의 왼쪽 자식에 이동할 노드 입력
        else //목적지 노드가 목적지 부모의 오른쪽 자식이라면
        	des.getParent().setRight(source); //목적지 노드의 부모의 오른쪽 자식에 이동할 노드 입력
        if(source != null) //이동할 노드가 null이 아니라면
        	source.setParent(des.getParent()); //이동할 노드의 부모를 목적지 노드의 부모로 입력
    }

    void printTree(BinaryNode node, int depth) { //출력해주는 메소드
        if(node != null) { //node가 비어있지 않을 동안
        	for(int i = 0 ; i < depth; i++) { // 깊이 동안 반복하면서
        		System.out.print("\t"); //탭 한번씩 가는것
        	}
        	System.out.println(node.getValue()); //node의 값들을 출력
        	printTree(node.getLeft(), depth+1); //노드의 왼쪽 자식과 깊이+1을 매개변수로 하는 재귀함수
        	printTree(node.getRight(), depth+1); //노드의 오른쪽 자식과 깊이+1을 매개변수로 하는 재귀함수
        }
    }

    BinaryNode getRoot() { //root getter
        return this.root;
    }
}
