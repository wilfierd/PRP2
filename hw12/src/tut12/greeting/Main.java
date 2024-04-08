package tut12.greeting;


class Fibonaccinum extends Sequence {
    int calculateSeq(int n) {
        if (n <= 1)
            return n;
        else
            return calculateSeq(n - 1) + calculateSeq(n - 2);
    }
}

public class Main {
    public static void main(String[] args) {
        Fibonaccinum fibonacciSequence = new Fibonaccinum();
         //prnt 12 number 
        for (int i = 0; i < 12; i++) {
            System.out.print(fibonacciSequence.calculateSeq(i) + " ");
        }
    }
}


 