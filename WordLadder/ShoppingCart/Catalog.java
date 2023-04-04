import java.util.*;
public class Catalog {

    public ArrayList<Item> list;

    public String name;


    public Catalog(String name){
        list = new ArrayList<Item>();
        this.name = name;

    }
    public void add(Item item){
        list.add(item);
    }

    public int size(){
        return list.size();
    }

    public Item get (int index){
        return list.get(index);
    }
    public String getName(){
        return this.name;
    }






}