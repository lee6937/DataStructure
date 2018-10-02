package tree;

import tree.BinaryNode;

public class LinkedQueue { //linkedQueue 클래스 구현
    private Node head; //node형태의 head 변수 생성

    public LinkedQueue() { //디폴트 생성자
        this.head = new Node(); //head에 node객체 생성
    }

    public boolean isEmpty() { //비어있는지 확인 메소드
        return head.getNext() == head; //head의 다음값이 head를 가리키고 있으면 비어있음
    }

    public void add(BinaryNode binaryNode) { //추가하는 메소드
        head.addLast(binaryNode); //head의 addLast메소드에 매개변수 입력
    }

    public BinaryNode remove() { //제거하는 메소드
        if (isEmpty()) { //비어있다면
            return null; //null 리턴
        } //비어있지 않다면
        return head.removeFirst().getValue(); //head의 첫값을 제거하면서 값을 return 
    }
}
