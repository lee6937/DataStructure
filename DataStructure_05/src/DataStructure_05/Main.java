package DataStructure_05;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" :: ���α׷��� �����մϴ�. :: ");
        System.out.println("[ ���� �Է��� �����մϴ�. ]");
        System.out.println("[ Infix �� postfix �� ]");
        String string;
        while (true) {

            System.out.print(" > ������ �Է��Ͻÿ� : ");
            string = scanner.nextLine();
            if ("!".equals(string))
                break;
            
            Postfix postfix = new Postfix(string);
   
            System.out.println("�Է� : " + postfix.getInfix());
            System.out.println("postfix : " + postfix.getPostfix());
            System.out.println("��� ��� : " + postfix.calculate()+"\n"); 

        }
        System.out.println("[ ���� �Է��� �����մϴ�. ]");
        System.out.println(" :: ���α׷��� �����մϴ�. :: ");
    }
}
