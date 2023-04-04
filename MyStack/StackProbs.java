import java.util.Stack;

public class StackProbs {
    
    
    
    public static Stack<Integer> doubleUp(Stack<Integer> nums){
        Stack<Integer> neww = new Stack<Integer>();
        Stack<Integer> newww = new Stack<Integer>();
        int x = nums.size();
        for (int i = 0; i < x; i++){
            neww.push(nums.peek());
            nums.pop();


        }
        for (int i = 0; i < x; i++){
            for (int j = 0; j < 2; j++){
                newww.push(neww.peek());
            }
            neww.pop();
        }
        return newww;



    }

    public static Stack<Integer> posAndNeg(Stack<Integer> nums){
        Stack<Integer> full = new Stack<Integer>();
        Stack<Integer> pos = new Stack<Integer>();
        int x = nums.size();
        int cur = 0;
        for (int i = 0; i < x; i++){
            cur = nums.pop();
            if (cur < 0){
                full.push(cur);
            }
            else{
                pos.push(cur);
            }

        }
        int p = pos.size();
        for (int i = 0; i < p; i++){
            full.push(pos.pop());
        }
        return full;
    }

    public static Stack<Integer> shiftByN(Stack<Integer> nums, int n){
        Stack<Integer> shifted = new Stack<Integer>();
        Stack<Integer> first = new Stack<Integer>();
        Stack<Integer> second = new Stack<Integer>();
        int x = nums.size();
        boolean cut = false;
        for (int i = 0; !cut; i++){
            if (nums.size() == n+1){
                shifted.push(nums.pop());
                cut = true;
            }
            else{
                first.push(nums.pop());
            }
        }
        int m = first.size();
        for (int j = 0; j < m; j++){
            shifted.push(first.pop());
        }
        int y = nums.size();
        for (int i = 0; i < y; i++ ){
            second.push(nums.pop());
        }
        int z = second.size();
        for (int i = 0; i < z; i++){
            shifted.push(second.pop());
        }
        
        return shifted;
    }

    public static String reverseVowels(String str){
        Stack<String>vowels = new Stack<String>();
        Stack<String>inside = new Stack<String>();
        String msg = "";
        vowels.push("a");
        vowels.push("e");
        vowels.push("i");
        vowels.push("o");
        vowels.push("u");
        for (int i = 0; i < str.length(); i++){
            if (vowels.contains(str.substring(i, i+1))){
                inside.push(str.substring(i,i+1));
            }

        }
        for (int i = 0; i < str.length(); i++){
            
            if (vowels.contains(str.substring(i,i+1))){

                msg += inside.pop();

            }
            else {
                msg += str.substring(i , i+1);
            }


        }
        return msg;

    }

    public static boolean bracketBalance(String s){


        Stack<String> opening = new Stack<String>();
        Stack<String> closing = new Stack<String>();

        for (int i = 0; i < s.length(); i++){
            
            if (s.substring(i,i+1).equals("(") || s.substring(i,i+1).equals("[")){
                opening.push(s.substring(i, i+1));
            }

            if (s.substring(i,i+1).equals(")") || s.substring(i,i+1).equals("]")){
                closing.push(s.substring(i, i+1));
            }
            if (!opening.empty() && !closing.empty())
            if (opening.peek().equals("(")){
                if (closing.peek().equals(")")){
                    opening.pop();
                    closing.pop();
                }
                
            }
            else if (opening.peek().equals("[")){
                if (closing.peek().equals("]")){
                    opening.pop();
                    closing.pop();
                }
            }

        }
        if (opening.empty() && closing.empty()){
            return true;
        }
        return false;




    }



}
