import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class QueueProbs {



    public static Queue<Integer> evenFirst(Queue<Integer> nums){

        Queue<Integer> odd = new LinkedList<>();
        Queue<Integer> fin = new LinkedList<>();
        int x = nums.size();
        for (int i = 0; i < x; i++){
            if (nums.peek()%2 == 0){
                fin.offer(nums.poll());
            }
            else {
                odd.offer(nums.poll());
            }
        }
        x = odd.size();
        for (int i = 0; i < x; i++){
            fin.offer(odd.poll());
        }



        return fin;

    }

    public static boolean numPalindrome(Queue<Integer> nums){
        int x = nums.size();
        int[] reverse = new int[x];
        Stack<Integer> check = new Stack<Integer>();
        for (int i = 0; i < x; i++){
            int z = nums.poll();
            reverse[i] = z;
            check.push(z);


        }
        for (int i = 0; i < x; i++){
            if (reverse[i] != check.pop()){
                return false;
            }
        }
        return true;





    }

    public static Stack<Integer> allPrime(int n){

        Queue<Integer> ints = new LinkedList<>();

        for (int i = 2; i <= n; i++){
            ints.offer(i);

        }
        Stack<Integer> prime = new Stack<>();
        while (!ints.isEmpty()){
            prime.push(ints.poll());
            int[] into = new int[ints.size()];
            for (int i = 0; i < into.length; i++){
                into[i] = ints.poll();
                if (into[i] % prime.peek() == 0){
                    into[i] = 0;
                }
            }
            for (int i = 0; i < into.length; i++){
                if (into[i] != 0){
                    ints.offer(into[i]);
                }
            }






        }


        return prime;

    }





    






}