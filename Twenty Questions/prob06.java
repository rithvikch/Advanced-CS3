import java.util.Scanner;

public class prob06 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int P = scan.nextInt();
        double rate = scan.nextDouble();
        int y = scan.nextInt();
        double fin = P*rate*y;
        double value = fin * Math.pow(10, 2);
        value = Math.floor(value);
        value = value / Math.pow(10, 2);
        System.out.printf("%.2f\n", value);
    }
    
}
