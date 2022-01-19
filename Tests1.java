import java.util.Scanner;

public class Tests1 {
    public static void main (String args[]){
        Scanner input = new Scanner(System.in);
        class2 c2object = new class2();
        
        System.out.println("Enter your name here: ");
        String name = input.nextLine();
        // System.out.println(name);
        c2object.simpleMessage(name);

        // int num1 = 1;
        // switch (num1){
        //     case 1:
        //         System.out.println("num1 is equal to 1");
        //         break;
        //     case 2:
        //         System.out.println("num1 is equal to 2");
        //         break;
        // default:
        //     System.out.println("num1 is equal to "+num1);
        // break;
        // }
    }
}
