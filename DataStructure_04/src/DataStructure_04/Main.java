package DataStructure_04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedSet linkedSet = new LinkedSet();
        
        while (true) {
            System.out.println("1: add 2: contains 3: remove");
            System.out.println("4: clear 5: print 9: exit");
            int num = scanner.nextInt();
            
            switch (num) {
                case 1:
                    System.out.print("Add Number :");
                    System.out.println(linkedSet.add(scanner.next()));
                    break;
                case 2:
                    System.out.print("Contain Number :");
                    System.out.println(linkedSet.contains(scanner.next()));
                    break;
                case 3:
                    System.out.print("Remove Number :");
                    System.out.println(linkedSet.remove(scanner.next()));
                    break;
                case 4:
                    linkedSet.clear();
                    System.out.println("Clear");
                    break;
                case 5:
                    linkedSet.print();
                    break;
                case 9:
                	scanner.close();
                    return;  
            }   
        }   
    }
}

