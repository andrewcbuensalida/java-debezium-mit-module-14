import java.util.Scanner;

public class Q5 {
  public static void main(String args[]) {

    Scanner input = new Scanner(System.in);

    if (input.hasNextInt()) {
      int num = input.nextInt();
      System.out.println(num * 2);

    }
    else {
      System.out.println("Please enter an integer");
    }
    input.close();
  }
}