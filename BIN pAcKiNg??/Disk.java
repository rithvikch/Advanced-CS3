import java.util.ArrayList;

public class Disk implements Comparable<Disk>{

    private int numberoffiles;
    private ArrayList<Integer> files;
    private int occupied;
    private static int id = 0;
    private int idd;

    public Disk(){
        numberoffiles = 0; 
        files = new ArrayList<>();
        idd = id;
        id++;
    }
    public String toString(){
        String bruh = "";
        for (int i = 0; i < files.size(); i++){
            bruh += files.get(i) + " ";
        }
        return "      " + idd + " " + spaceLeft() + ": " + bruh;
    }

    @Override
    public int compareTo(Disk o) {
        if (occupied < o.getOccupied()){
            return -1;
        }
        else if (occupied > o.getOccupied()){
            return 1;
        }
        
        return 0;
    }

    public void addFile(int x){
        files.add(x);
        occupied += x;
        numberoffiles++;
    }

    public int spaceLeft(){
        return 1000000-occupied;
    }
    public int numberOfFiles(){
        return numberoffiles;
    }

    public int getOccupied(){
        return occupied;
    }


    
}