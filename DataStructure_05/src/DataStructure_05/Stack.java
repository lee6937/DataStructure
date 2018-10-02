package DataStructure_05;

public class Stack {
    private String[] stack; //String�迭 ���� ����
    private int size; //size����
    private int maxSize; //maxSize����
    
    public Stack() { //�⺻ ������
        this.size = 0; //������ �ʱ�ȭ 
        this.maxSize = 5; //maxSize 5�� ����
        stack = new String[this.maxSize]; //�迭 ��ü ����, �迭������� �ִ�������
    }

    public void push(String string) { //push �޼ҵ�
        if (isFull()) //����á�ٸ�
        	return; //�Լ� ����
        else { //�׷��� �ʴٸ�
        	stack[this.size] = string; //stack�� ������� ���� �ε����� �� �Է�
        	this.size++; //������ ��
        }
    }

    public String pop() { //pop �޼ҵ�
        if(isEmpty()) //����ִٸ�
        	return null; //null ����
        else { //�׷��� �ʴٸ�
        	this.size--; //����� ���� �ٿ���
        	String str = stack[this.size]; //������ ���� ������� ���� �ε��� �迭�� ���� �Է�        	 
        	stack[this.size] = null; //�� �迭�� ���� null�� ����
        	return str; //������ ����ִ� �� ����
        }
    }

    public String peek() { //peek �޼ҵ�
    	if(!isEmpty()) //������� �ʴٸ�
    		return stack[this.size-1]; //size���� �ϳ� ���� �ε����� �迭 �� ����
    	else //�׷��� �ʴٸ�
    		return null; //null ����
    }

    public boolean isEmpty() { //isEmpty �޼ҵ�
        return this.size == 0; // ����� 0�϶�  true
    }

    public boolean isFull() { //isFull �޼ҵ�
        return this.size == this.maxSize; //������� �ִ� ����� ���� �� true
    }

    private void resize() { //resize �޼ҵ�
        String[] newStack = new String[maxSize * 2]; //�ִ������ 2�� ũ���� ��ü �迭 ����
        System.arraycopy(stack, 0, newStack, 0, maxSize); // �޸𸮸� �����մϴ�.
        stack = newStack; //���ð� ���ο� ������ ����
        maxSize *= 2; //maxSize�� 2�� ���� �Ǿ���.
    }
}
