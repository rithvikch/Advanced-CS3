import java.util.Scanner;

public class prob03 {
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        int PTS = scan.nextInt();
        int FGA = scan.nextInt();
        int FTA = scan.nextInt();
        double TS = 0.44*FTA;
        TS = FGA + TS;
        TS *= 2;
        TS = (100.0*PTS)/TS;
        System.out.printf("%.2f%%\n", TS );
    }
}
