package tree;

public class BinaryNode {
    private String value; //String 형태의 값을 저장하는 변수
    private BinaryNode parent; //BinaryNode형태의 부모를 가리키는 변수
    private BinaryNode left; //BinaryNode형태의 왼쪽 값을 가리키는 변수
    private BinaryNode right; //BinaryNode형태의 오른쪽 값을 가리키는 변수

    BinaryNode() { //디폴트 생성자
    }

    BinaryNode(String value) { //매개변수 가지는 생성자
        this.value = value; //전역변수와 매개변수 같게 설정
    }

    public int level() { //level을 알려주는 함수
        if (parent == null) { //부모값이 비어있다면
            return 1; //1을 반환
        } //그렇지 않다면
        return parent.level() + 1; //재귀함수로 부모의 개수 만큼 1을 계속 반환, 거기에 자기자신까지 +1
    }

    public int height() { //높이가 얼마인지 확인 메소드
        int leftHeight = 0; //왼쪽 높이 0으로 지정
        if(this.hasLeft()) { //왼쪽 자식을 가지고 있으면
        	leftHeight = this.left.height(); //왼쪽 높이는 왼쪽 자식의 높이 확인하는 메소드 => 재귀함수
        }
        int rightHeight = 0; //오른쪽 높이 0으로 지정
        if(this.hasRight()) { //오른쪽 자식을 가지고 있으면
        	rightHeight = this.right.height(); //오른쪽 높이는 오른쪽 자식의 높이를 확인하는 메소드 => 재귀함수
        }
        if(leftHeight > rightHeight) //왼쪽 높이가 오른쪽 높이보다 크다면
        	return (leftHeight+1); //왼쪽 높이 +1 => 자기까지 더해줌
        else
        	return (rightHeight+1); //그렇지 않다면 오른쪽 높이 + 1
    }

    public int numberOfNodes() { //노드의 개수가 몇개인지 확인 메소드
        int numberOfLeftNodes = 0; //왼쪽 노드 개수 0으로 지정
        if(this.hasLeft()) { //왼쪽 자식을 가지고 있으면
        	numberOfLeftNodes = this.left.numberOfNodes(); //왼쪽 높이는 왼쪽 자식노드의 노드 개수 확인 메소드 =>재귀
        }
        int numberOfRightNodes = 0; //오른쪽 노드 개수 0으로 지정
        if(this.hasRight()) { //오른쪽 자식을 가지고 있으면
        	numberOfRightNodes = this.right.numberOfNodes(); //오른쪽 노드 개수는 오른쪽 자식노드의 노드 개수 확인 =>재귀
        }
    return (numberOfLeftNodes + numberOfRightNodes + 1); //총 개수는 왼쪽 노드 개수+오른쪽 노드 개수+뿌리 1개
    }

    public String getValue() { //value getter
        return value;
    }

    public void setLeft(BinaryNode left) { //left setter
        if (left != null) { //매개변수가 비어있지 않다면 
            this.left = left; //전역변수와 매개변수 같게 설정
            this.left.parent = this; //left의 부모를 자기자신으로
        }
    }

    public void setRight(BinaryNode right) { //right setter
        if (right != null) { //매개변수가 비어있지 않다면
            this.right = right; //전역변수와 매개변수 같게 설정
            left.parent = this; //right의 부모를 자기자신으로
        }
    }

    public BinaryNode getLeft() { //left getter
        return this.left;
    }

    public BinaryNode getRight() { //right getter
        return this.right;
    }

    public boolean hasLeft() { // 왼쪽 자식을 가지고 있는지 확인 메소드
        return (this.left != null); // 왼쪽 자식이 비어있지 않으면 true 반환
    }

    public boolean hasRight() { // 오른쪽 자식을 가지고 있는지 확인 메소드
        return (this.right != null); // 오른쪽 자식이 비어있지 않으면 true 반환
    }

    public boolean isLeaf() { //Leaf인지 확인하는 메소드
        return (this.left ==null) && (this.right == null); //왼쪽 자식과 오른쪽 자식이 둘다 비어있으면 true 반환
    }

}
