package DataStructure_05;

public class Stack {
    private String[] stack; //String배열 변수 생성
    private int size; //size변수
    private int maxSize; //maxSize변수
    
    public Stack() { //기본 생성자
        this.size = 0; //사이즈 초기화 
        this.maxSize = 5; //maxSize 5로 지정
        stack = new String[this.maxSize]; //배열 객체 생성, 배열사이즈는 최대사이즈로
    }

    public void push(String string) { //push 메소드
        if (isFull()) //가득찼다면
        	return; //함수 종료
        else { //그렇지 않다면
        	stack[this.size] = string; //stack의 사이즈와 같은 인덱스에 값 입력
        	this.size++; //사이즈 업
        }
    }

    public String pop() { //pop 메소드
        if(isEmpty()) //비어있다면
        	return null; //null 리턴
        else { //그렇지 않다면
        	this.size--; //사이즈를 먼저 줄여줌
        	String str = stack[this.size]; //변수에 줄인 사이즈와 같은 인덱스 배열의 값을 입력        	 
        	stack[this.size] = null; //그 배열의 값을 null로 삭제
        	return str; //변수에 들어있는 값 리턴
        }
    }

    public String peek() { //peek 메소드
    	if(!isEmpty()) //비어있지 않다면
    		return stack[this.size-1]; //size보다 하나 줄인 인덱스의 배열 값 리턴
    	else //그렇지 않다면
    		return null; //null 리턴
    }

    public boolean isEmpty() { //isEmpty 메소드
        return this.size == 0; // 사이즈가 0일때  true
    }

    public boolean isFull() { //isFull 메소드
        return this.size == this.maxSize; //사이즈와 최대 사이즈가 같을 때 true
    }

    private void resize() { //resize 메소드
        String[] newStack = new String[maxSize * 2]; //최대사이즈 2배 크기의 객체 배열 생성
        System.arraycopy(stack, 0, newStack, 0, maxSize); // 메모리를 복사합니다.
        stack = newStack; //스택과 새로운 스택은 같다
        maxSize *= 2; //maxSize는 2배 증가 되었다.
    }
}
