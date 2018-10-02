package DataStructure_05;

public class Postfix { 
    private String infix; //infix 변수 생성
    private StringBuilder postfix; //StringBuilder타입 postfix변수 생성

    public Postfix(String string) { //생성자
        infix = string; //infix와 매개변수 동일시
        postfix = new StringBuilder(); //StringBuilder 객체 생성
        infixToPostfix(0); //0값 대입,초기화
    }

    private int infixToPostfix(int index) { //메소드 생성
        StringBuilder num = new StringBuilder(); //StringBuilder객체 생성
        Stack operationStack = new Stack(); //Stack객체 생성
        for (int i = index; i < infix.toCharArray().length; ++i) { //infix를배열로바꾼 길이까지 반복
            char ch = infix.charAt(i); //배열의 i번째 인덱스를 char로 바꿔줌
            String peek = operationStack.peek(); //변수에 operationStack의 가장 나중에 넣은 값 입력
            switch (ch) { //switch문 
                case '(':
                    i = infixToPostfix(i+1); //재귀함수, infixToPostfix 매개변수의 +1 값 입력, 
                    break;
                case ')':
                    makePostfix(num.toString()); //num값을 makePostfix에 입력
                    while (!operationStack.isEmpty()) { //operationStack이 비어있지 않을때 동안
                        makePostfix(operationStack.pop()); // operation 나중값을 빼서 makePostfix에 입력
                    }
                    return i; //i값 부터 다시 for문이 돌게끔
                case '*':
                	makePostfix(num.toString()); //num값을 makePostfix에 입력
                    num = new StringBuilder(); //StringBuilder 객체 생성
                    while (!operationStack.isEmpty()) { //operationStack이 비어있지 않을때 동안
                    	peek = operationStack.peek(); //변수에 operationStack의 가장 나중에 넣은 값 입력 => while문안에서 계속 재정의해줘야함
                    	if(peek.equals("+") || peek.equals("-")) //peak값이 +나 -라면
                    		break; //if문 탈출
                        makePostfix(operationStack.pop()); //그렇지 않으면 operationStack 나중값 makePostfix에 입력
                    }
                    operationStack.push("*"); //"*"를 operationStack에 입력
                    break;
                	
                case '/':
                	makePostfix(num.toString()); //num값을 makePostfix에 입력
                    num = new StringBuilder(); //StringBuilder 객체 생성
                    while (!operationStack.isEmpty()) { //operationStack이 비어있지 않을때 동안
                    	peek = operationStack.peek(); //변수에 operationStack의 가장 나중에 넣은 값 입력 => while문안에서 계속 재정의해줘야함
                    	if(peek.equals("+") || peek.equals("-")) //peak값이 +나 -라면
                    		break; //if문 탈출
                        makePostfix(operationStack.pop()); //그렇지 않으면 operationStack 나중값 makePostfix에 입력
                    }
                    operationStack.push("/"); //"/"를 operationStack에 입력
                    break;
              
                case '+':
                    makePostfix(num.toString()); //num값을 makePostfix에 입력
                    num = new StringBuilder(); //StringBuilder 객체 생성
                    while (!operationStack.isEmpty()) { //operationStack이 비어있지 않을때 동안
                        makePostfix(operationStack.pop()); //operationStack 나중값 makePostfix에 입력
                    }
                    operationStack.push("+");
                    break;
                    
                case '-':
                    makePostfix(num.toString()); //num값을 makePostfix에 입력
                    num = new StringBuilder(); //StringBuilder 객체 생성
                    while (!operationStack.isEmpty()) { //operationStack이 비어있지 않을때 동안
                        makePostfix(operationStack.pop()); //operationStack 나중값 makePostfix에 입력
                    }
                    operationStack.push("-");
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    num.append(ch); //num에 이어 붙이기
                    break;
                case ' ':
                case '\t':
                case '\n':
                    break;
                default:
                    System.out.println("[ 올바르지 않은 입력입니다. : " + ch + " ]");
                    break;
            }
        }
        makePostfix(num.toString());
        while (!operationStack.isEmpty()) {
            makePostfix(operationStack.pop());
        }
        return infix.toCharArray().length;
    }

    private void makePostfix(String string) {
        if (!"".equals(string)) {
            postfix.append(string).append(" "); //append는 계속 붙여주는 메소드
        }
    }

    public double calculate() {
        Stack valueStack = new Stack();
        StringBuilder num = new StringBuilder();

        double result;
        for (int i = 0; i < postfix.toString().toCharArray().length; ++i) {
            char ch = postfix.charAt(i);
            switch (ch) {
                case '*': { 
                	String b = valueStack.pop(); //valueStack의 나중값을 변수 b에 입력
                    String a = valueStack.pop(); //valueStack의 나중값을 변수 a에 입력 
                    a = Double.toString(Double.parseDouble(a) * Double.parseDouble(b));//a에 (가장 처음에 뺀 값 a) 곱하기 (가장 나중에 뺀 값 b)를 계산
                    valueStack.push(a); //a값을 valueStack에 입력
                    break;
                }
                case '/': {
                	String b = valueStack.pop();
                    String a = valueStack.pop();
                    a = Double.toString(Double.parseDouble(a) / Double.parseDouble(b));
                    valueStack.push(a);
                    break;
                }
                case '+': {
                    String b = valueStack.pop();
                    String a = valueStack.pop();
                    a = Double.toString(Double.parseDouble(a) + Double.parseDouble(b));
                    valueStack.push(a);
                    break;
                }
                case '-': {
                    String b = valueStack.pop();
                    String a = valueStack.pop();
                    a = Double.toString(Double.parseDouble(a) - Double.parseDouble(b));
                    valueStack.push(a);
                    break;
                }
                case '0':
                case '1':
                case '2':
                case '3':
                case '4': 
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '.':
                    num.append(ch);
                    break;
                case ' ':
                    if (!num.toString().equals("")) {
                        valueStack.push(num.toString());
                        num = new StringBuilder();
                    }
                    break;
                default:
                    break;
            }
        }

        result = Double.valueOf(valueStack.pop());
        return result;
    }


    public String getInfix() { //getter
        return infix; //infix리턴
    }

    public String getPostfix() { //getter
        return postfix.toString(); //postfix의 string입력
    }

}
