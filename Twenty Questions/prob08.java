import java.util.Scanner;
import java.util.Stack;

public class prob08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
       
        int x = scan.nextInt();
        scan.nextLine();
       
        int totalsec = 0;
        for (int i = 0; i < x; i++){
            String[] WAOW = scan.nextLine().split(":");
            totalsec += Integer.valueOf(WAOW[0])*60;
            totalsec += Integer.valueOf(WAOW[1]);
            


        }
        int min = totalsec/60;
        int sec = totalsec%60;
        if (sec < 10){
            System.out.println(min + ":" + "0" + sec);
        }
        else{
            System.out.println(min + ":" + sec);
        }
       
        
    }
}
