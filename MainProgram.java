import java.util.Scanner;
public class MainProgram {

    public static void main(String[]Args){
        Scanner Input = new Scanner(System.in);

        System.out.println("The first Integer is");
        int number1 = Input.nextInt();

        System.out.println("The second integer is");
        int number2 = Input.nextInt();

        int sum = number1 + number2;
        System.out.printf("The sum is %d%n2",sum);
    }
}