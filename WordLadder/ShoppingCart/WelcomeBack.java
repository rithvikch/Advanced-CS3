import java.lang.Math;

public class WelcomeBack {



    public static String getMiddle(String str){
        if (str.length() %2 == 0){
            return str.substring((str.length()/2)-1, (str.length()/2)+1);
        }
        return str.substring(str.length()/2, (str.length()/2)+1);
    }

    public static int[] sumNumbers(int n){

        int[] arr = new int[n+1];
        int total = 0;
        for (int i = 0; i < arr.length; i++){
            total = 0;

            for (int j = 0; j < i+1; j++){
                total += j;
            }
            arr[i] = total;

        }
        return arr;

    }

    public static int keepSummingDigits(int n){

        int sum = 0;
        int cur = n;
        while (cur >= 10 ){
            sum = 0;
            while (cur > 0) {
                sum += cur % 10;
                cur /= 10;
            }
            cur = sum;
        }
        return cur;
    }

    public static String getIntersection(int[] a, int[] b){
        String both = "";

        int big = Math.max(a.length, b.length);

        int small  = Math.min(a.length, b.length);

        for (int i = 0; i < small; i++){

            for (int j = 0; j < big; j++){
                if (a[i] == b[j]){

                    if (!(both.indexOf(Integer.toString(a[i])) >= 0)) {

                        both += a[i];
                    }

                }



            }


        }
        return both;



    }

    public static int sumDigitsRecur(int n){

        if (n == 0){
            return n;
        }
        return n%10 + sumDigitsRecur(n/10);




    }

    public static int sumWithoutCarry(int a, int b){
        String numb = "";
        while (a > 0){
            int x = a%10;
            int y = b%10;
            if (x + y < 10){
                numb = x+y + numb;
            }
            else {
                numb = (x+y)%10 + numb;
            }
            a /= 10;
            b /= 10;
        }
        return Integer.valueOf(numb);
    }



    public static int buySell1(int[] stock){
        int max = 0;
        for (int i = 0; i < stock.length; i++){

            int cur = stock[i];


            for (int j = i; j < stock.length; j++){

                if (stock[j] -stock[i] > max){
                    max = stock[j] - stock[i];
                }



            }

        }
        return max;
    }















}