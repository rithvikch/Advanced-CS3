import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class awfulcipher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<String , Integer > roman = new HashMap<>();
        roman.put("I", 1);
        roman.put("V", 5);
        roman.put("X", 10);
        roman.put("L", 50);
        HashMap<String, Character> morse = new HashMap<>();
        morse.put(".-", 'A');
        morse.put("-...", 'B');
        morse.put("-.-.", 'C');
        morse.put("-..", 'D');
        morse.put(".", 'E');
        morse.put("..-.", 'F');
        morse.put("--.", 'G');
        morse.put("....", 'H');
        morse.put("..", 'I');
        morse.put(".---", 'J');
        morse.put("-.-", 'K');
        morse.put(".-..", 'L');
        morse.put("--", 'M');
        morse.put("-.", 'N');
        morse.put("---", 'O');
        morse.put(".--.", 'P');
        morse.put("--.-", 'Q');
        morse.put(".-.", 'R');
        morse.put("...", 'S');
        morse.put("-", 'T');
        morse.put("..-", 'U');
        morse.put("...-", 'V');
        morse.put(".--", 'W');
        morse.put("-..-", 'X');
        morse.put("-.--", 'Y');
        morse.put("--..", 'Z');
        String x = scan.nextLine();
        String[] morsee = scan.nextLine().split(" ");
        int total = 0;
        for (int i = 0; i < x.length(); i++){
            total += roman.get(x.substring(i, i+1));

        }
        ArrayList<Character> alpha = new ArrayList<>();
        for (int i = 0; i < morsee.length; i++){
            alpha.add(morse.get(morsee[i]));
        }
        System.out.println(alpha);
        System.out.println(total);

    }
}
