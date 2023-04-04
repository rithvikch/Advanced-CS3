import java.util.Scanner;
public class Play {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int testcases = scan.nextInt();

        int[]nums = new int[10];
        int i = 0;
        while (scan.hasNext()){
            nums[i] = scan.nextInt();
            i++;

        }
        for (int j = 0; j < nums.length; j++){
            if (nums[i]%2*2==0){
                System.out.println(nums[i]/3);
            }
        }
        


    }
}
