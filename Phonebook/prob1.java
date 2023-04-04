import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class prob1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        ArrayList<Integer> scores = new ArrayList<>();
        for (int i = 0; i < x; i++){
            scores.add(scan.nextInt());
        }
        ArrayList<Integer> original = scores;
        Collections.sort(scores);
        int sus = 0;
        for (int i = 0; i < scores.size(); i++){
            boolean parity1 = false;
            boolean parity2 = false;
            int index = i+1;
            int val = scores.get(i);
            int p1 = index ^ (index >> 1);
            p1 = p1 ^ (p1 >> 2);
            p1 = p1 ^ (p1 >> 4);
            p1 = p1 ^ (p1 >> 8);
            p1 = p1 ^ (p1 >> 16);  
            if (p1%2 == 0){
                parity1 = true;
                
            } 
            else {
                parity1 = false;
            }
            int p2 = val ^ (val >> 1);
            p2 = p2 ^ (p2 >> 2);
            p2 = p2 ^ (p2 >> 4);
            p2 = p2 ^ (p2 >> 8);
            p2 = p2 ^ (p2 >> 16);  
            if (p2%2 == 0){
                parity2 = true;
                
            } 
            else {
                parity2 = false;
            }
            if (parity1 != parity2){
                sus++;
            }
        }

        System.out.println(sus);
        
        
    
        
    }

}
