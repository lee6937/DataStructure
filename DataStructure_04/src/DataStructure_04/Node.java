package DataStructure_04;

public class Node {
	
	private String coin; //string 형식의 코인 변수
    private Node next; // next변수 설정

    public Node() { //기본 생성자
    	this.next = null; //next값 초기화
    }

    public Node(String coin) { //매개변수 있는 생성자
        this.coin = coin; //매개변수와 전역변수 일치
        this.next = null; //next값 초기화
    }

    public void setNext(Node node) { //메소드 생성
        this.next = node; //next값에 매개변수 값 입력
    }
    public String coin() { //coin getter
        return this.coin; //전역변수 리턴
    }

    public Node next() { //next getter
        return this.next; //전역변수 리턴
    }
}
