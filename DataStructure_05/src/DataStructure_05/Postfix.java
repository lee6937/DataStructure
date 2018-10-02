package DataStructure_05;

public class Postfix { 
    private String infix; //infix ���� ����
    private StringBuilder postfix; //StringBuilderŸ�� postfix���� ����

    public Postfix(String string) { //������
        infix = string; //infix�� �Ű����� ���Ͻ�
        postfix = new StringBuilder(); //StringBuilder ��ü ����
        infixToPostfix(0); //0�� ����,�ʱ�ȭ
    }

    private int infixToPostfix(int index) { //�޼ҵ� ����
        StringBuilder num = new StringBuilder(); //StringBuilder��ü ����
        Stack operationStack = new Stack(); //Stack��ü ����
        for (int i = index; i < infix.toCharArray().length; ++i) { //infix���迭�ιٲ� ���̱��� �ݺ�
            char ch = infix.charAt(i); //�迭�� i��° �ε����� char�� �ٲ���
            String peek = operationStack.peek(); //������ operationStack�� ���� ���߿� ���� �� �Է�
            switch (ch) { //switch�� 
                case '(':
                    i = infixToPostfix(i+1); //����Լ�, infixToPostfix �Ű������� +1 �� �Է�, 
                    break;
                case ')':
                    makePostfix(num.toString()); //num���� makePostfix�� �Է�
                    while (!operationStack.isEmpty()) { //operationStack�� ������� ������ ����
                        makePostfix(operationStack.pop()); // operation ���߰��� ���� makePostfix�� �Է�
                    }
                    return i; //i�� ���� �ٽ� for���� ���Բ�
                case '*':
                	makePostfix(num.toString()); //num���� makePostfix�� �Է�
                    num = new StringBuilder(); //StringBuilder ��ü ����
                    while (!operationStack.isEmpty()) { //operationStack�� ������� ������ ����
                    	peek = operationStack.peek(); //������ operationStack�� ���� ���߿� ���� �� �Է� => while���ȿ��� ��� �������������
                    	if(peek.equals("+") || peek.equals("-")) //peak���� +�� -���
                    		break; //if�� Ż��
                        makePostfix(operationStack.pop()); //�׷��� ������ operationStack ���߰� makePostfix�� �Է�
                    }
                    operationStack.push("*"); //"*"�� operationStack�� �Է�
                    break;
                	
                case '/':
                	makePostfix(num.toString()); //num���� makePostfix�� �Է�
                    num = new StringBuilder(); //StringBuilder ��ü ����
                    while (!operationStack.isEmpty()) { //operationStack�� ������� ������ ����
                    	peek = operationStack.peek(); //������ operationStack�� ���� ���߿� ���� �� �Է� => while���ȿ��� ��� �������������
                    	if(peek.equals("+") || peek.equals("-")) //peak���� +�� -���
                    		break; //if�� Ż��
                        makePostfix(operationStack.pop()); //�׷��� ������ operationStack ���߰� makePostfix�� �Է�
                    }
                    operationStack.push("/"); //"/"�� operationStack�� �Է�
                    break;
              
                case '+':
                    makePostfix(num.toString()); //num���� makePostfix�� �Է�
                    num = new StringBuilder(); //StringBuilder ��ü ����
                    while (!operationStack.isEmpty()) { //operationStack�� ������� ������ ����
                        makePostfix(operationStack.pop()); //operationStack ���߰� makePostfix�� �Է�
                    }
                    operationStack.push("+");
                    break;
                    
                case '-':
                    makePostfix(num.toString()); //num���� makePostfix�� �Է�
                    num = new StringBuilder(); //StringBuilder ��ü ����
                    while (!operationStack.isEmpty()) { //operationStack�� ������� ������ ����
                        makePostfix(operationStack.pop()); //operationStack ���߰� makePostfix�� �Է�
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
                    num.append(ch); //num�� �̾� ���̱�
                    break;
                case ' ':
                case '\t':
                case '\n':
                    break;
                default:
                    System.out.println("[ �ùٸ��� ���� �Է��Դϴ�. : " + ch + " ]");
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
            postfix.append(string).append(" "); //append�� ��� �ٿ��ִ� �޼ҵ�
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
                	String b = valueStack.pop(); //valueStack�� ���߰��� ���� b�� �Է�
                    String a = valueStack.pop(); //valueStack�� ���߰��� ���� a�� �Է� 
                    a = Double.toString(Double.parseDouble(a) * Double.parseDouble(b));//a�� (���� ó���� �� �� a) ���ϱ� (���� ���߿� �� �� b)�� ���
                    valueStack.push(a); //a���� valueStack�� �Է�
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
        return infix; //infix����
    }

    public String getPostfix() { //getter
        return postfix.toString(); //postfix�� string�Է�
    }

}
