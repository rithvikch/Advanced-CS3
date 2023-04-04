import java.util.Scanner;

public class prob05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double num = in.nextDouble();
        double answer = num;
        double digit = (num*100)%10;
        if(digit == 7)
            answer += 0.02;
        
        else if (digit % 2!=0)
            answer -= 0.09;
        else if(digit > 7)
            answer -= 4.00;
        else if(digit < 4)
            answer += 6.78;
        
        System.out.printf("%.2f\n",answer);
    }
}