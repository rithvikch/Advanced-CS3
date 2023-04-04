import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class prob07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> scores = new ArrayList<>();
        String[] peoples = new String[5];
        for (int i = 0; i < 5; i++){
            int punt = scan.nextInt()-scan.nextInt();
            if (punt < 0){
                punt = 0;
            }
            int pass = scan.nextInt()-scan.nextInt();
            if (pass < 0){
                pass = 0;
            }
            int kick = scan.nextInt()-scan.nextInt();
            if (kick < 0){
                kick = 0;
            }
            scores.add(punt + pass + kick);
            peoples[i] = scan.nextLine();   
        }
       
        ArrayList<Integer> sco = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            sco.add(scores.get(i));
        }
        Collections.sort(scores);
        
        for (int i = scores.size()-1; i >= 0; i--){
            System.out.println(peoples[sco.indexOf(scores.get(i))] + " " + scores.get(i));
        }
    }
    
}
