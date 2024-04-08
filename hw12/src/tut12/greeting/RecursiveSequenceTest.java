package tut12.greeting;
abstract class Sequence {
    abstract int calculateSeq(int n); 
}

class FirstSequence extends Sequence {
    int calculateSeq(int n) {
        if (n == 0)
            return 0;
        else
        return calculateSeq(n - 1) + 2;
   }  
}


class SecondSequence extends Sequence {
    int calculateSeq(int n) {
        if (n == 0)
            return 0;
        else
            return calculateSeq(n - 1) + n;
    }
}

public class RecursiveSequenceTest {
    public static void main(String[] args) {
        
        Sequence firstSeq = new FirstSequence();
        for (int i = 0; i < 10; i++) {
            System.out.print(firstSeq.calculateSeq(i) + " ");
        }
        System.out.println();
        Sequence secondSeq = new SecondSequence();
        for (int i = 0; i < 10; i++) {
            System.out.print(secondSeq.calculateSeq(i) + " ");
        }
    }
}
