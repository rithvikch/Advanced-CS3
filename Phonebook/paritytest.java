public class paritytest {
    public static void main(String[] args) {
        int x = 2;
        boolean parity1 = false;
        int y = x ^ (x >> 1);
        y = y ^ (y >> 2);
        y = y ^ (y >> 4);
        y = y ^ (y >> 8);
        y = y ^ (y >> 16);
 
    

        
        System.out.println(y);
    }
}
