public class BinaryNode { //양방향 Binary노드
    private int value; //노드가 가지고 있는 값
    private BinaryNode parent; // 노드의 부모를 가리키는 변수
    private BinaryNode left; //노드의 왼쪽 자식을 가리키는 변수
    private BinaryNode right; //노드의 오른쪽 자식을 가리키는 변수

    BinaryNode(int value) { //값을 매개변수로 하는 생성자
        this.value = value; //매개변수와 전역변수 일치
        this.left = null; //왼쪽 자식 초기화
        this.right = null; //오른쪽 자식 초기화
        this.parent = null; //부모 초기화
    }

    public int getValue() { //value setter
        return value;
    }
    
    public void setValue(int value) { //value setter
    	this.value = value;
    }

    public void setParent(BinaryNode parent) { //parent setter
        this.parent = parent;
    }

    public void setLeft(BinaryNode left) { //left setter
        this.left = left;
    }

    public void setRight(BinaryNode right) { //right setter
        this.right = right;
    }

    public BinaryNode getParent() { //parent getter
        return this.parent;
    }

    public BinaryNode getLeft() { //left getter
        return this.left;
    }

    public BinaryNode getRight() { //right getter
        return this.right;
    }

    public boolean hasParent() { //부모 확인 메소드
        return this.parent != null; //부모가 있으면 true 리턴
    }

    public boolean hasLeft() { //왼쪽 자식 확인 메소드
        return this.left != null; //왼쪽 자식이 있으면 true 리턴
    }

    public boolean hasRight() { //오른쪽 자식 확인 메소드
        return this.right != null; //오른쪽 자식이 있으면 true 리턴
    }

}
