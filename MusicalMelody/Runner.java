import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Runner {


    public static void main(String[] args) {
        //Queue<Integer> rip= new LinkedList<>();
        //for (int i = 0; i < 3; i++) {
        //    rip.offer(i);
       // }
        //rip.offer(2);
        //rip.offer(1);
        //rip.offer(0);
        //System.out.println(rip);
        //System.out.println(QueueProbs.numPalindrome(rip));


        Stack<Integer> prim = new Stack<>();
        prim = QueueProbs.allPrime(20);
        System.out.println(prim);
    }

}