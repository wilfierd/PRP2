
// ****************************************************************
// Factorials.java
//
// Reads integers from the user and prints the factorial of each.
//
// ****************************************************************
import java.util.Scanner;
public class Factorials
{
    public static void main(String[] args) throws IllegalArgumentException
    {
        String keepGoing = "y";
        Scanner scan = new Scanner(System.in);
        while (keepGoing.equals("y") || keepGoing.equals("y"))
        {
            System.out.print("Enter an integer: ");
            int val = scan.nextInt();
            if (val<0) {
                throw new IllegalArgumentException("try another number that bigger");
            }else if(val>16) {
                throw new IllegalArgumentException("not greater than 16");
            }
            System.out.println("Factorial(" + val + ") = " + MathUtils.factorial(val));
            System.out.print("Another factorial? (y/n) ");
            keepGoing = scan.next();
        }
    }
}
