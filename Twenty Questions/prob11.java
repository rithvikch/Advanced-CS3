import java.util.ArrayList;
import java.util.Scanner;

public class prob11 {

    public static boolean check(String checker){
        if (checker.equals("?") || checker.equals(",") || checker.equals(".") || checker.equals("!")){
            return true;
        }
        return false;
    }

    public static boolean vowelcheck(String checker){
        checker = checker.toLowerCase();
        if (checker.equals("a") || checker.equals("e") || checker.equals("i") || checker.equals("o") || checker.equals("u")){
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String[]> stuff = new ArrayList<>();
        boolean fase = false;
        while (!fase){
            String baba = scan.nextLine();
            if (baba.equals("END")){
                break;
            }
            stuff.add(baba.split(" "));

        }
        String vowels = "aeiou";
        String badstuff = "?,.!";
        String ok = "?";
        for (String[] wow: stuff ){
            for (int i = 0; i < wow.length; i++){

                if (!vowelcheck(wow[i].substring(0,1)) && wow[i].length()==2 || (!vowelcheck(wow[i].substring(0,1)) && wow[i].length()==3 && check(wow[i].substring(wow[i].length()-1)) )){

                }
                else if (!vowelcheck(wow[i].substring(0, 1))){
                    
                    
                    if (check(wow[i].substring(wow[i].length()-1))){
                        wow[i] = wow[i].substring(1,wow[i].length()-1) + wow[i].substring(0,1) + "-squeak" + wow[i].substring(wow[i].length()-1, wow[i].length());
                    }
                    else {
                        wow[i] = wow[i].substring(1) + wow[i].substring(0,1) + "-squeak";
                    }
                }
                else if (vowelcheck(wow[i].substring(0,1))) {
                    wow[i] = wow[i] + "-m";
                }
            }
            
        }
        for (String[] wow : stuff){
            for (int i = 0; i < wow.length; i++){
                System.out.print(wow[i] + " ");
            }
            System.out.println();
        }
        
    }
    
}
