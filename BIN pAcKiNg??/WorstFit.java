import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class WorstFit {
    public static void main(String[] args)  {
        Scanner scan = null;
        try {
             scan = new Scanner(new File("input20.txt"));
            
        } catch (Exception e) {}
        Queue<Disk> disks = new PriorityQueue<>();
        disks.offer(new Disk());
        Queue<Integer> files = new PriorityQueue<>();
        while (scan.hasNext()){
           files.offer(scan.nextInt());
        }
        Stack<Integer> proper = new Stack<>();
        int filenumbs = 0;
        while (!files.isEmpty()){
            proper.push(files.poll());
            filenumbs++;

        }
        while (!proper.isEmpty()){
            int file = proper.pop();
            if (disks.peek().spaceLeft()>= file){
                Disk cur = disks.poll();
                cur.addFile(file);
                disks.offer(cur);
            }
            else {
                Disk waow = new Disk();
                waow.addFile(file);
                disks.offer(waow);
            }

        }
        String fin = "";
        int total = 0;
        int discs = 0;
        while (!disks.isEmpty()){
            total += disks.peek().getOccupied();
            fin += disks.poll().toString() + "\n";
            discs++;
        }
        

        System.out.println("Total size: = " + ((total)/1000000.0) + " GB");
        System.out.println("Disks req'd = " + discs);
        if (filenumbs < 100){
        System.out.println(fin);
        }
        
        
        
    }
    
}
