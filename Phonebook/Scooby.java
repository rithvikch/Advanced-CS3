import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Scooby {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numb = scan.nextInt();
        ArrayList<String> all = new ArrayList<>();
        
        
        for (int i = 0; i < numb*2; i++){
            all.add(scan.nextLine());

        }
        Collections.sort(all);
        int i = all.size()-1;
        while (all.size() != 0){
            all.remove(i);
            if (i%2 == 0){
                System.out.println("true");
            
            }
            else{{
                System.out.println("false");
            }
            i--;
        }

        }




    }
}
