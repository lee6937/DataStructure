package tree;

import tree.BinaryNode; 

public class Node { //노드 클래스 생성
    private Node next; //다음을 가리키는 변수 생성
    private Node prev; //이전을 가리키는 변수 생성
    private BinaryNode value; //BinaryNode형태의  값 변수 생성
    
    Node() { //디폴트 생성자
        next = this; //next는 자기자신(head)을 가리킴
        prev = this; //prev는 자기자신(head)을 가리킴
    }

    private Node(BinaryNode value) { //매개변수를 갖는 생성자
        this.value = value; //전역변수와 지역변수 같게 설정
    }

    public void addLast(BinaryNode value) { //노드의 끝에 값을 넣는 함수
        Node newNode = new Node(value); //새로운 노드 생성 후 매개변수 값 입력

        this.prev.next = newNode; //head의 prev는 head를 뜻함, 그 head의 next에 newNode설정
        newNode.prev = this.prev; //newNode의 prev를 head의 prev로 설정, 결국 head에 설정
        newNode.next = this; //newNode의 next를 head로 설정
        this.prev = newNode; //head의 prev를 newNode로 설정 => Doubly LinkedList형태의 환영 큐를 구현함.
    } // = 계속 값이 추가될 수록 newNode가 head의 끝에 붙고 그 newNode의 next를 head로 지정하면서 환영 큐가 가능

    public Node removeFirst() { //노드의 첫값을 제거하면서 return하는 함수
        Node node = this.next; //node는 head의 다음값 입력
        this.next = node.next; //head의 다음값을 node의 다음값 입력
        this.next.prev = this; //head의 다음값의 prev를 head로 설정 => node의 next와 prev를 끊어버림
        return node; //삭제된 node값 리턴
    }

    public Node getNext() { //next getter
        return this.next;
    }

    public BinaryNode getValue() { //value getter
        return this.value;
    }

}
